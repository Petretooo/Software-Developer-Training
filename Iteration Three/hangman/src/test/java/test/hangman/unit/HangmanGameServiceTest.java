package test.hangman.unit;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import app.model.Game;
import app.repository.HangmanRepository;
import app.service.alphabet.AlphabetService;
import app.service.game.HangmanGameServiceImpl;
import app.service.word.WordService;


@ExtendWith(MockitoExtension.class)
public class HangmanGameServiceTest {//TODO

  @Mock
  HangmanRepository repo;
  @Mock
  WordService word;
  @Mock
  AlphabetService alphabet;
  
  @InjectMocks
  HangmanGameServiceImpl gameService;
  
  Game game = new Game();
  final static int COUNT_ONE_ELEMENT = 1;
  final static int COUNT_TWO_ELEMENT = 2;
  final static int NUMBER_TRIES = 5;
  final static int ZERO = 0;
  
  
  @BeforeEach
  public void init() {
    Mockito.when(word.randomWordGenerator()).thenReturn("WORD");
    Mockito.when(repo.getGame(Mockito.anyString())).thenReturn(game);
    

    game.setNumberTries(5);
    game.setCurrentWord("WORD");
    game.setUsedCharacters(new ArrayList<String>());
    game.setId("1");
    char[] hidden = new char[game.getCurrentWord().length()];
    for (int i = 0; i < hidden.length; i++) {
      hidden[i] = '_';
    }
    game.setHiddenWord(hidden);
    
    game = gameService.createGame();
  }
  
  @Test
  public void createGame() {
    assertThat(game).isNotNull();
  }

  @Test
  public void getWord_CorrectWord_ExpectedWord() {
    assertThat(game.getCurrentWord()).isEqualTo("WORD");
  }

  @Test
  public void getUsedWords_MultipleSameLetter_ShouldContainsOnlyOne() {
    gameService.enterCharacter(game.getId(), "A");
    gameService.enterCharacter(game.getId(), "A");
    gameService.enterCharacter(game.getId(), "A");
    long length = gameService.getUsedLetters(game.getId()).chars().filter(e -> e == 'A').count();
    assertThat(COUNT_ONE_ELEMENT).isEqualTo(length);
  }

  @Test
  public void getUsedWords_CorrectlyAddedLetter_ReturnLengthOne() {
    gameService.enterCharacter(game.getId(), "A");
    long length = gameService.getUsedLetters(game.getId()).chars().filter(e -> e == 'A').count();
    assertThat(COUNT_ONE_ELEMENT).isEqualTo(length);
  }

  @Test
  public void getUsedWords_CorrectlyAddedDifferentLetters_ReturnLengthTwo() {
    gameService.enterCharacter(game.getId(), "A");
    gameService.enterCharacter(game.getId(), "B");
    long length = gameService.getUsedLetters(game.getId()).chars().filter(e -> e == 'A' || e == 'B').count();
    assertThat(COUNT_TWO_ELEMENT).isEqualTo(length);
  }

  @Test
  public void numberTries_CorrectlyStartedTries_ShouldReturnFive() {
    assertThat(NUMBER_TRIES).isEqualTo(game.getNumberTries());
  }

  @Test
  public void numberTries_AfterOneTry_ShouldReturnZero() {
    gameService.enterCharacter(game.getId(), "1");
    long length = gameService.getUsedLetters(game.getId()).chars().filter(e -> e == '1').count();
    assertThat(ZERO).isEqualTo(length);
  }

  @Test
  public void found_InputAllLetters_ShouldFindTheHiddenWord() {
    String[] alphabet = {"D", "O", "R", "W"};
    for (String letter : alphabet) {
      gameService.enterCharacter(game.getId(), letter);
    }
    assertThat(gameService.isFound(game.getId())).isTrue();
  }
  
  @Test
  public void deleteGame_checkDelete_ShouldReturnFalse() {
    Mockito.when(repo.removeGame(Mockito.anyString(), Mockito.any())).thenReturn(true);
    assertThat(gameService.deleteGame(game.getId(), game)).isTrue();
  }

  @Test
  public void getGame_checkCorrect_ShouldReturnNotNull() {
    assertThat(gameService.getGame(game.getId())).isNotNull();
  }
  
  @Test
  public void getAlphabet_checkCorrect_ShouldReturnNotNull() {
    Map<Character, Boolean> alpha = new HashMap<Character, Boolean>();
    Mockito.when(alphabet.getCurrentGameAlphabet(Mockito.anyString())).thenReturn(alpha);
    assertThat(gameService.getAlphabet(game.getId())).isNotNull();
  }
  
  @Test
  public void setCharacter_useCharacter_ShouldPass() {
    gameService.setCharacter(game.getId(), 'A');
  }
}
