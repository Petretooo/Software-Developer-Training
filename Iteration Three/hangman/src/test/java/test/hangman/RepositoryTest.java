package test.hangman;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import app.hangman.GameContext;
import app.repository.HangmanRepositoryService;
import app.service.game.GameService;

public class RepositoryTest {

  GameContext context = new GameContext();

  GameService game;
  HangmanRepositoryService repo;

  @BeforeEach
  public void init() {
    game = context.getGame();
    repo = context.getRepo();
    game.createGame();
  }

  @Test
  public void getGame_CorrectlyAdded_NotNull() {
    repo.addGame("1", game);
    assertNotNull(repo.getGame("1"));
  }

  @Test
  public void getGame_CorrectlyRemoved_Null() {
    repo.addGame("1", game);
    repo.removeGame("1", game);
    assertNull(repo.getGame("1"));
  }

}
