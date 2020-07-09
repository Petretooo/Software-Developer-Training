package test.hangman.unit;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import app.model.Game;
import app.repository.HangmanRepository;
import app.repository.HangmanRepositoryImpl;

public class HangmanRepositoryTest {
  
  HangmanRepository repo = new HangmanRepositoryImpl();
  
  @Test
  public void getGame_makeGame_ReturnGameNotNull() {
    repo.addGame("1", new Game());
    assertThat(repo.getGame("1")).isNotNull();
  }
  
  @Test
  public void removeGame_makeGame_ReturnTrue() {
    repo.addGame("1", new Game());
    assertThat(repo.removeGame("1", repo.getGame("1"))).isTrue();
  }

}
