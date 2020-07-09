package test.hangman.e2e;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class HangmanIndexTest extends SeleniumTest {
  
  HangmanIndexPage indexPage;
  
  @BeforeEach
  public void init() {
    indexPage = PageFactory.initElements(driver, HangmanIndexPage.class);
  }
  
  @Test
  public void newGame_buttonClick_creteGame() throws Exception{
    indexPage.createGame();
  }

}
