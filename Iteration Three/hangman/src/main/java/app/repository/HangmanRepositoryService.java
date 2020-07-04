package app.repository;

import app.service.game.Game;

public interface HangmanRepositoryService {

  public void addGame(String id, Game game);

  public boolean removeGame(String id, Game game);

  public Game getGame(String id);
}
