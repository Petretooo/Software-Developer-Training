package it;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class HangmanIndexTest extends SeleniumTest {
  
  private HangmanIndexPage indexPage;
  
  private final static String URL_GAME_PAGE = "http://localhost:8080/hangman/games/";
  
  @BeforeEach
  public void init() {
    indexPage = PageFactory.initElements(driver, HangmanIndexPage.class);
  }
  
  @Test
  public void Should_GoGamePage_When_ClickOnNewGame(){
    indexPage.createGame();
    String page = driver.getCurrentUrl().toString().substring(0, 36);
    assertThat(page).isEqualTo(URL_GAME_PAGE);
  }

}
