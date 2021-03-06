package app.service.game;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.model.Game;
import app.repository.HangmanRepository;
import app.service.alphabet.AlphabetService;
import app.service.word.WordService;
import app.util.CharacterNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HangmanGameServiceImpl implements GameService {

   private HangmanRepository hangmanRepo;
   private WordService wordService;
   private AlphabetService alphabetService;

  @Override
  public void enterCharacter(String id, String letter) {
    Game game = hangmanRepo.getGame(id);    
    if (!game.getUsedCharacters().contains(letter)) {
      if (game.getCurrentWord().contains(letter)) {
        int index = game.getCurrentWord().indexOf(letter);
        char[] hidden = game.getHiddenWord();
        while (index >= 0) {
          try {
          hidden[index] = letter.charAt(0);
          }catch (StringIndexOutOfBoundsException ex) {
            throw new CharacterNotFoundException("Character not found");
          }
          index = game.getCurrentWord().indexOf(letter, index + 1);
        }
        game.setHiddenWord(hidden);
      } else {
        int numberRemaining = game.getNumberTries();
        game.setNumberTries(--numberRemaining);
      }
      if(letter.charAt(0) >= 'A' && letter.charAt(0) <= 'Z') {
        List<String> letters = game.getUsedCharacters();
        letters.add(letter);
        game.setUsedCharacters(letters);
      }
    }
    updateWord(game.getId());
  }

  public String updateWord(String id) {
    Game game = hangmanRepo.getGame(id);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < game.getHiddenWord().length; i++) {
      sb.append(game.getHiddenWord()[i] + " ");
    }
    return sb.toString().trim();
  }

  @Override
  public Game createGame() {
    Game game = new Game();
    game.setNumberTries(5);
    game.setCurrentWord(wordService.randomWordGenerator());
    game.setUsedCharacters(new ArrayList<String>());
    game.setId(UUID.randomUUID().toString());
    
    alphabetService.setGameAlphabet(game.getId());

    String firstLetter = game.getCurrentWord().substring(0, 1);
    String lastLetter = game.getCurrentWord().substring(game.getCurrentWord().length() - 1);
    char[] hidden = new char[game.getCurrentWord().length()];
    for (int i = 0; i < hidden.length; i++) {
      hidden[i] = '_';
    }
    game.setHiddenWord(hidden);
    hangmanRepo.addGame(game.getId(), game);

    enterCharacter(game.getId(), firstLetter);
    alphabetService.setUsedCharacter(game.getId(), firstLetter.charAt(0));
    enterCharacter(game.getId(), lastLetter);
    alphabetService.setUsedCharacter(game.getId(), lastLetter.charAt(0));
    return game;
  }

  @Override
  public boolean isFound(String id) {
    Game game = hangmanRepo.getGame(id);
    return game.getCurrentWord().contentEquals(new String(game.getHiddenWord()));
  }

  public String getUsedLetters(String id) {
    Game game = hangmanRepo.getGame(id);
    String words = "";
    for (String letter : game.getUsedCharacters()) {
      words += letter + ", ";
    }
    return words;
  }

  @Override
  public Game getGame(String id) {
    return hangmanRepo.getGame(id);
  }

  @Override
  public boolean deleteGame(String id, Game game) {
    return hangmanRepo.removeGame(id, game);
  }

}
