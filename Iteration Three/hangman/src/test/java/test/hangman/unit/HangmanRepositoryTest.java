package test.hangman.unit;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import app.model.Game;
import app.repository.HangmanRepository;
import app.repository.HangmanRepositoryImpl;

public class HangmanRepositoryTest {
  
  private HangmanRepository repo = new HangmanRepositoryImpl();
  
  @Test
  public void Should_ReturnNotNull_When_AddNewGameCorrectly() {
    repo.addGame("1", new Game());
    assertThat(repo.getGame("1")).isNotNull();
  }
  
  @Test
  public void Should_ReturnTrue_When_RemoveGameCorrectly() {
    repo.addGame("1", new Game());
    assertThat(repo.removeGame("1", repo.getGame("1"))).isTrue();
  }

}
