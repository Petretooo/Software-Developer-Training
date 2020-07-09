package app.repository;

import app.model.Game;

public interface HangmanRepository {

  public void addGame(String id, Game game);

  public boolean removeGame(String id, Game game);

  public Game getGame(String id);
}
