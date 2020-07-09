package test.hangman.unit;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import app.service.word.WordService;
import app.service.word.WordServiceImpl;

public class WordServiceTest {

  WordService word = new WordServiceImpl();
  
  @Test
  public void randomWordGenerator_generateWord_shoudReturnNotNull() {
    String randomWord = word.randomWordGenerator();
    assertThat(randomWord).isNotNull();
  }
}
