package app.service.game;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.repository.HangmanRepositoryService;
import app.service.word.WordService;
import app.util.AlphabetGame;

@Service
public class HangmanGameServiceImpl implements GameService {

  @Autowired
  HangmanRepositoryService repo;
  @Autowired
  WordService word;

  @Override
  public void enterCharacter(String id, String letter) {
    Game game = repo.getGame(id);
    if (!game.getUsedCharacters().contains(letter)) {
      if (game.getCurrentWord().contains(letter)) {
        int index = game.getCurrentWord().indexOf(letter);
        char[] hidden = game.getHiddenWord();
        while (index >= 0) {
          hidden[index] = letter.charAt(0);
          index = game.getCurrentWord().indexOf(letter, index + 1);
        }
        game.setHiddenWord(hidden);
      } else {
        int numberRemaining = game.getNumberTries();
        game.setNumberTries(--numberRemaining);
      }
      List<String> letters = game.getUsedCharacters();
      letters.add(letter);
      game.setUsedCharacters(letters);
    }
    updateWord(game.getId());
  }

  public String updateWord(String id) {
    Game game = repo.getGame(id);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < game.getHiddenWord().length; i++) {
      sb.append(game.getHiddenWord()[i] + " ");
    }
    return sb.toString().trim();
  }

  @Override
  public Game createGame() {

    Game game = new Game();
    game.setAlphabet(new AlphabetGame());

    game.setNumberTries(5);
    game.setCurrentWord(word.randomWordGenerator());
    game.setUsedCharacters(new ArrayList<String>());
    game.setId(UUID.randomUUID().toString());

    String firstLetter = game.getCurrentWord().substring(0, 1);
    String lastLetter = game.getCurrentWord().substring(game.getCurrentWord().length() - 1);
    char[] hidden = new char[game.getCurrentWord().length()];
    for (int i = 0; i < hidden.length; i++) {
      hidden[i] = '_';
    }
    game.setHiddenWord(hidden);
    repo.addGame(game.getId(), game);

    enterCharacter(game.getId(), firstLetter);
    game.getAlphabet().setUsedCharacter(game.getId(), firstLetter.charAt(0));
    enterCharacter(game.getId(), lastLetter);
    game.getAlphabet().setUsedCharacter(game.getId(), lastLetter.charAt(0));
    return game;
  }

  @Override
  public boolean found(String id) {
    Game game = repo.getGame(id);
    return game.getCurrentWord().contentEquals(new String(game.getHiddenWord()));
  }

  public String getWord(String id) {
    Game game = repo.getGame(id);
    return game.getCurrentWord();
  }

  public int numberTries(String id) {
    Game game = repo.getGame(id);
    return game.getNumberTries();
  }

  public String getUsedLetters(String id) {
    Game game = repo.getGame(id);
    String words = "";
    for (String letter : game.getUsedCharacters()) {
      words += letter + ", ";
    }
    return words;
  }

  @Override
  public Game getGame(String id) {
    return repo.getGame(id);
  }

  @Override
  public boolean deleteGame(String id, Game game) {
    return repo.removeGame(id, game);
  }

}
