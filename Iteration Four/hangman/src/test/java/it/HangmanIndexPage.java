package it;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HangmanIndexPage {
  
  @SuppressWarnings("unused")
  private WebDriver driver;
  
  @FindBy(xpath = "//*[@id=\"buttonGame\"]")
  WebElement buttonNewGame;
  
  public HangmanIndexPage(WebDriver driver) {
    this.driver = driver;
  }
  
  public void createGame() {
    buttonNewGame.click();
  }
  
}