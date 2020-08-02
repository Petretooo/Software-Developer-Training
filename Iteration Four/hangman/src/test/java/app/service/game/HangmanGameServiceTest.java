package app.service.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import app.dao.game.GameDao;
import app.model.Game;
import app.model.User;
import app.repository.HangmanRepository;
import app.service.alphabet.AlphabetService;
import app.service.game.HangmanGameServiceImpl;
import app.service.word.WordService;
import app.util.CharacterNotFoundException;

@ExtendWith(MockitoExtension.class)
public class HangmanGameServiceTest {// TODO

	@Mock
	private GameDao gameDao;
	@Mock
	private WordService word;
	@Mock
	private AlphabetService alphabet;

	@InjectMocks
	private HangmanGameServiceImpl gameService;

	Game game = new Game();
	private final static int COUNT_ONE_ELEMENT = 1;
	private final static int COUNT_TWO_ELEMENT = 2;
	private final static int NUMBER_TRIES = 5;
	private final static int ZERO = 0;

	@BeforeEach
	public void init() {
		Mockito.when(word.randomWordGenerator()).thenReturn("WORD");
		Mockito.when(gameDao.get(null)).thenReturn(game);
		User user = new User();
		user.setUserId("12");

		game.setNumberTries(5);
		game.setCurrentWord("WORD");
		char[] hidden = new char[game.getCurrentWord().length()];
		for (int i = 0; i < hidden.length; i++) {
			hidden[i] = '_';
		}
		game.setHiddenWord(hidden);
		game = gameService.createGame(user);
	}

	@Test
	public void Should_ReturnNotNull_When_MakeNewGame() {
		assertThat(game).isNotNull();
	}

	@Test
	public void Should_ReturnExpectedWord_When_GetWord() {
		assertThat(game.getCurrentWord()).isEqualTo("WORD");
	}

	@Test
	public void Should_ReturnOne_When_MakeTryWithCharacter() {
		gameService.enterCharacter(game.getId(), "A");
		long length = gameService.getUsedLetters(game.getId()).chars().filter(e -> e == 'A').count();
		assertThat(COUNT_ONE_ELEMENT).isEqualTo(length);
	}

	@Test
	public void Should_ReturnTwo_When_MakeTryWithTwoDifferentCharacters() {
		gameService.enterCharacter(game.getId(), "A");
		gameService.enterCharacter(game.getId(), "B");
		long length = gameService.getUsedLetters(game.getId()).chars().filter(e -> e == 'A' || e == 'B').count();
		assertThat(COUNT_TWO_ELEMENT).isEqualTo(length);
	}

	@Test
	public void Should_ReturnFive_When_GetNumberTriesAfterStartedGame() {
		assertThat(NUMBER_TRIES).isEqualTo(game.getNumberTries());
	}

	@Test
	public void Should_ReturnZero_When_MakeTryWithNumber() {
		gameService.enterCharacter(game.getId(), "1");
		long length = gameService.getUsedLetters(game.getId()).chars().filter(e -> e == '1').count();
		assertThat(ZERO).isEqualTo(length);
	}

	@Test
	public void Should_ReturnZero_When_MakeTryWithSymbol() {
		gameService.enterCharacter(game.getId(), "1");
		long length = gameService.getUsedLetters(game.getId()).chars().filter(e -> e == '|').count();
		assertThat(ZERO).isEqualTo(length);
	}

	@Test
	public void Should_ReturnZero_When_MakeTryWithZ() {
		gameService.enterCharacter(game.getId(), "Z");
		long length = gameService.getUsedLetters(game.getId()).chars().filter(e -> e == 'Z').count();
		assertThat(COUNT_ONE_ELEMENT).isEqualTo(length);
	}

	@Test
	public void Should_ReturnWin_When_FindCorrectWord() {
		String[] alphabet = { "D", "O", "R", "W" };
		for (String letter : alphabet) {
			gameService.enterCharacter(game.getId(), letter);
		}
		assertThat(gameService.resultWord(game.getId())).isEqualTo("win");
	}

	@Test
	public void Should_ReturnGameover_When_CantFindWord() {
		String[] alphabet = { "A", "B", "C", "E", "F" };
		for (String letter : alphabet) {
			gameService.enterCharacter(game.getId(), letter);
		}
		assertThat(gameService.resultWord(game.getId())).isEqualTo("gameover");
	}

	@Test
	public void Should_ReturnNull_When_MakeTry() {

		gameService.enterCharacter(game.getId(), "A");

		assertThat(gameService.resultWord(game.getId())).isNull();
	}

	@Test
	public void Should_ReturnNotNull_When_GetGameById() {
		assertThat(gameService.getGame(game.getId())).isNotNull();
	}
	
	@Test
	public void Should_Pass_When_GameDelete() {
		gameService.deleteGame("1");
	}

	@Test
	public void Should_ReturnException_When_MakeTryWithEmptyString() {

		assertThatThrownBy(() -> {
			gameService.enterCharacter(game.getId(), null);
		})
		.isInstanceOf(CharacterNotFoundException.class);

	}

}
