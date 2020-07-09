package app.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;
import app.model.Game;

@Component
public class HangmanRepositoryImpl implements HangmanRepository {

  private Map<String, Game> games;

  public HangmanRepositoryImpl() {
    games = new ConcurrentHashMap<>();
  }

  public void addGame(String id, Game game) {
    games.put(id, game);
  }

  public boolean removeGame(String id, Game game) {
    return games.remove(id, game);
  }

  public Game getGame(String id) {
    return games.get(id);
  }

}
