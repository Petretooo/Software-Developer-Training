package app.service.game;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.game.GameDao;
import app.dto.GameDto;
import app.model.Symbol;
import app.model.Game;
import app.model.User;
import app.service.alphabet.AlphabetService;
import app.service.word.WordService;
import app.util.CharacterNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class HangmanGameServiceImpl implements GameService {

	private WordService wordService;
	private AlphabetService alphabetService;
	private GameDao gameDao;

	@Override
	public void enterCharacter(String id, String letter) {

		Game game = gameDao.get(id);
		if (letter.charAt(0) >= 'A' && letter.charAt(0) <= 'Z') {
			Symbol character = new Symbol();
			character.setLetter(letter.charAt(0));
			game.getCharacters().add(character);
			alphabetService.saveCharacter(game.getId(), character);

			checkCharacterInWord(id, letter);

		}
		updateWord(game.getId());

	}

	private void checkCharacterInWord(String gameId, String letter) {
		Game game = gameDao.get(gameId);
		if (game.getCurrentWord().contains(letter)) {
			int index = game.getCurrentWord().indexOf(letter);
			char[] hidden = game.getHiddenWord();
			checkCharacterInRange(index, hidden, gameId, letter);
			game.setHiddenWord(hidden);
		} else {
			int numberRemaining = game.getNumberTries();
			game.setNumberTries(--numberRemaining);
		}
	}

	private void checkCharacterInRange(int index, char[] hidden, String gameId, String letter) {
		Game game = gameDao.get(gameId);
		while (index >= 0) {
			try {
				hidden[index] = letter.charAt(0);
			} catch (Exception ex) {
				throw new CharacterNotFoundException("Character not found");
			}
			index = game.getCurrentWord().indexOf(letter, index + 1);
		}
	}

	public String updateWord(String id) {
		Game game = gameDao.get(id);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < game.getHiddenWord().length; i++) {
			sb.append(game.getHiddenWord()[i] + " ");
		}
		return sb.toString().trim();
	}

	@Override
	public Game createGame(User user) {
		Game game = new Game();
		game.setCharacters(new HashSet<Symbol>());
		game.setNumberTries(5);
		game.setCurrentWord(wordService.randomWordGenerator().getWordName());

		String firstLetter = game.getCurrentWord().substring(0, 1);
		String lastLetter = game.getCurrentWord().substring(game.getCurrentWord().length() - 1);
		char[] hidden = new char[game.getCurrentWord().length()];
		for (int i = 0; i < hidden.length; i++) {
			hidden[i] = '_';
		}
		game.setHiddenWord(hidden);
		game.setUser(user);

		gameDao.save(game);
		alphabetService.setGameAlphabet(game.getId());

		enterCharacter(game.getId(), firstLetter);
		enterCharacter(game.getId(), lastLetter);

		return game;
	}

	@Override
	public String resultWord(String id) {
		Game game = gameDao.get(id);
		if (game.getNumberTries() <= 0) {
			return "gameover";
		}
		if (game.getCurrentWord().contentEquals(new String(game.getHiddenWord()))) {
			return "win";
		}
		return null;
	}

	@Override
	public String getUsedLetters(String id) {
		Game game = gameDao.get(id);
		String words = "";
		for (Symbol letter : game.getCharacters()) {
			words += letter.getLetter() + ", ";
		}
		return words;
	}

	@Override
	public Game getGame(String id) {
		return gameDao.get(id);
	}

	@Override
	public void deleteGame(String id) {
		gameDao.remove(id);
	}

	@Override
	public List<Game> getRunningGame() {
		List<Game> games = gameDao.getRunningGames();
		return games;
	}

}
