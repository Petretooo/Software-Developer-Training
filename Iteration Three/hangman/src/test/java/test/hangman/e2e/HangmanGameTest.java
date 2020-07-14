package test.hangman.e2e;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class HangmanGameTest extends SeleniumTest {
  
  private HangmanGamePage gamePage;
  
  private final static String TITLE_GAME_PAGE = "Hangman Game";
  private final static String CHARACTER_A = "A";
  private final static String URL_HOME_PAGE = "http://localhost:8080/hangman/";
  
  @BeforeEach
  public void init() {
    gamePage = PageFactory.initElements(driver, HangmanGamePage.class);
    gamePage.createGame();
  }
  
  @Test
  public void Should_ReturnCorrectTitleGame_When_GetPageTitle() {
    String name = gamePage.title();
    assertThat(name).isEqualTo(TITLE_GAME_PAGE);
  }
  
  @Test
  public void Should_ReturnCharacterA_When_GetTheCharacter() {
    String character = gamePage.ACharacter();
    assertThat(character).isEqualTo(CHARACTER_A);
  }
  
  @Test
  public void Should_DisappearCharacter_When_ClickOnIt() {
    gamePage.clickACharacter();
  }

  @Test
  public void Should_GetWordGame_When_GetHiddenTag() {
    String name = gamePage.cheatWord();
    assertThat(gamePage.cheatWord()).isEqualTo(name);
  }
  
  @Test
  public void Should_ReturnHomePage_When_ClickOnBack() {
    gamePage.backToIndexPage();
    assertThat(driver.getCurrentUrl()).isEqualTo(URL_HOME_PAGE);
  }
}
