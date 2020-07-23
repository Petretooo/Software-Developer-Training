package app.service.word;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import app.service.word.WordService;
import app.service.word.WordServiceImpl;

public class WordServiceTest {

  private WordService word = new WordServiceImpl();
  
  @Test
  public void Should_ReturnNotNull_When_GenerateRandomWord() {
    String randomWord = word.randomWordGenerator();
    assertThat(randomWord).isNotNull();
  }
}
