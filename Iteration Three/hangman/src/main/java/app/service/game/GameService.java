package app.service.game;

import app.model.Game;

public interface GameService {

  public Game createGame();

  public Game getGame(String id);

  public boolean deleteGame(String id, Game game);

  public void enterCharacter(String id, String letter);

  public boolean isFound(String id);


}
