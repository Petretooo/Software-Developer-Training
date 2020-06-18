package test.hangman;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import hangman.GameService;

public class HangmanGameTest {


  ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
  GameService game;

  @Before
  public void init() {
    game = context.getBean("hangmanGame", GameService.class);
  }



  @Test(expected = NullPointerException.class)
  public void testWordNull() {
    game.getWord();
  }

  @Test
  public void testWordIsCorrect() {
    game.createGame();
    String word = game.getWord();
    assertEquals(word, game.getWord());
  }

  @Test
  public void enterLetterThatAlreadyContains() {
    game.createGame();
    game.enterCharacter("A");
    game.enterCharacter("A");
    game.enterCharacter("A");
    int length = game.getUsedWords().trim().length();
    assertEquals(2, length);
  }

  @Test
  public void enterLetterThatNotContains() {
    game.createGame();
    game.enterCharacter("A");
    int length = game.getUsedWords().trim().length();
    assertEquals(2, length);
  }

  @Test
  public void enterDifferentLettersContains() {
    game.createGame();
    game.enterCharacter("A");
    game.enterCharacter("B");
    int length = game.getUsedWords().trim().length();
    assertEquals(5, length);
  }

  @Test
  public void numberTries() {
    game.createGame();
    assertEquals(5, game.numberTries());
  }

  @Test
  public void numberTriesAfterInput() {
    game.createGame();
    game.enterCharacter("1");
    assertEquals(4, game.numberTries());
  }

  @Test
  public void foundWord() {
    game.createGame();
    String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
        "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    for (String letter : alphabet) {
      game.enterCharacter(letter);
    }
    assertTrue(game.found());
  }
}
