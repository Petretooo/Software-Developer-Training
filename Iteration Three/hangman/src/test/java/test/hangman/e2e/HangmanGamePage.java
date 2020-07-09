package test.hangman.e2e;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HangmanGamePage {
  WebDriver driver; //TODO ID XPATH
  
  @FindBy(xpath = "//*[@id=\"buttonGame\"]")
  private WebElement buttonNewGame;
  
  @FindBy(xpath = "//*[@id=\"titleId\"]")
  private WebElement titleGame;
  
  @FindBy(xpath = "//*[@id=\"characterButton\"]")
  private WebElement buttonA;
  
  @FindBy(xpath = "//*[@id=\"backHome\"]")
  private WebElement backButton;
  
  String hiddenWordScript = "return document.getElementById('secret').innerHTML";
  
  public HangmanGamePage(WebDriver driver) {
    this.driver = driver;
  }
  
  public void createGame() {
    buttonNewGame.click();
  }
  
  public String title() {
    return titleGame.getText();
  }
  
  public String ACharacter() {
    return buttonA.getText();
  }
  
  public void clickACharacter() {
    buttonA.click();
  }
  
  public String cheatWord() {
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    return executor.executeScript(hiddenWordScript).toString();
  }
  
  public void backToIndexPage() {
    backButton.click();
  }
}
