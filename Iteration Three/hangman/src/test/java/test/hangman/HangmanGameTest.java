package test.hangman;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import app.hangman.GameContext;
import app.service.game.GameService;

public class HangmanGameTest {

  GameContext context = new GameContext();
  GameService game;

  @BeforeEach
  public void init() {
    game = context.getGame();
    game.createGame();
  }

  @Test
  public void getWord_CorrectWord_ExpectedWord() {
    String word = game.getWord();
    assertEquals(word, game.getWord());
  }

  @Test
  public void getUsedWords_MultipleSameLetter_ShouldContainsOnlyOne() {
    game.enterCharacter("A");
    game.enterCharacter("A");
    game.enterCharacter("A");
    int length = game.getUsedLetters().trim().length();
    assertEquals(2, length);
  }

  @Test
  public void getUsedWords_CorrectlyAddedLetter_ReturnLengthTwo() {
    game.enterCharacter("A");
    int length = game.getUsedLetters().trim().length();
    assertEquals(2, length);
  }

  @Test
  public void getUsedWords_CorrectlyAddedDifferentLetters_ReturnLengthFive() {
    game.enterCharacter("A");
    game.enterCharacter("B");
    int length = game.getUsedLetters().trim().length();
    assertEquals(5, length);
  }

  @Test
  public void numberTries_CorrectlyStartedTries_ShouldReturnFive() {
    assertEquals(5, game.numberTries());
  }

  @Test
  public void numberTries_AfterOneTry_ShouldReturnFour() {
    game.enterCharacter("1");
    assertEquals(4, game.numberTries());
  }

  @Test
  public void found_InputAllLetters_ShouldFindTheHiddenWord() {
    String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
        "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    for (String letter : alphabet) {
      game.enterCharacter(letter);
    }
    assertTrue(game.found());
  }

}
