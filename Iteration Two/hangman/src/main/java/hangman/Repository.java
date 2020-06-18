package hangman;

import java.util.concurrent.ConcurrentHashMap;

public class Repository {

  private ConcurrentHashMap<String, GameService> games;

  public Repository() {
    games = new ConcurrentHashMap<String, GameService>();
  }

  public void addGame(String id, GameService game) {
    games.put(id, game);
  }

  public boolean removeGame(String String, GameService game) {
    return games.remove(String, game);
  }

  public GameService getGame(String String) {
    return games.get(String);
  }
}
