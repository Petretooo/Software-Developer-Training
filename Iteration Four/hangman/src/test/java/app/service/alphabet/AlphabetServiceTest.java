package app.service.alphabet;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Map;
import org.junit.jupiter.api.Test;
import app.service.alphabet.AlphabetService;
import app.service.alphabet.AlphabetServiceImpl;

public class AlphabetServiceTest {
  private AlphabetService alphabetService = new AlphabetServiceImpl();
  
  
  @Test
  public void Should_ReturnNotNull_When_SetGameWithId() {
    alphabetService.setGameAlphabet("1");
    assertThat(alphabetService.getCurrentGameAlphabet("1")).isNotNull();
  }
  
  @Test
  public void Should_ReturnTrue_When_MakeTry() {
    alphabetService.setGameAlphabet("1");
    alphabetService.setUsedCharacter("1", 'A');
    Map<Character, Boolean> alphabet = alphabetService.getCurrentGameAlphabet("1");
    assertThat(alphabet.get('A')).isTrue();
  }
  
}
