package test.hangman.e2e;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
  public WebDriver driver = null;
  @BeforeEach
  public void before() {
    System.setProperty("webdriver.chrome.driver", "D:\\Programming\\Java Proxiad\\Iteration Three\\webDriver\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    driver.get("http://localhost:8080/hangman/");
  }
  
}