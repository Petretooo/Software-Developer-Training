package test.hangman.e2e;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class HangmanGameTest extends SeleniumTest {
  
  HangmanGamePage gamePage;
  
  @BeforeEach
  public void init() {
    gamePage = PageFactory.initElements(driver, HangmanGamePage.class);
    gamePage.createGame();
  }
  
  @Test
  public void getTitle_check_returnHangmanGame() {
    String name = gamePage.title();
    assertThat(name).isEqualTo("Hangman Game");
  }
  
  @Test
  public void getACharacter_check_returnA() {
    String character = gamePage.ACharacter();
    assertThat(character).isEqualTo("A");
  }
  
  @Test
  public void onClick_ACharacter_makeTry() {
    gamePage.clickACharacter();
  }

  @Test
  public void cheat_getWord_returnCorrectWord() {
    String name = gamePage.cheatWord();
    assertThat(gamePage.cheatWord()).isEqualTo(name);
  }
  
  @Test
  public void onClick_backButton_returnIndexPage() {
    gamePage.backToIndexPage();
    assertThat(driver.getCurrentUrl()).isEqualTo("http://localhost:8080/hangman/");
  }
}
