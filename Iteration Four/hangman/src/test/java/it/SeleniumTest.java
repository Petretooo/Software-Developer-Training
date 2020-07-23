package it;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
  
  public WebDriver driver = null;
  private final static String PATH_CHROME_DRIVE = "D:\\\\Programming\\\\Java Proxiad\\\\Iteration Three\\\\webDriver\\\\chromedriver.exe";
  private final static String URL = "http://localhost:8080/hangman/";
  @BeforeEach
  public void before() {
    System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVE);
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    driver.get(URL);
  }
  
}