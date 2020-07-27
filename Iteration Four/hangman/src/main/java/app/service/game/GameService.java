package app.service.game;

import app.model.Game;
import app.model.User;

public interface GameService {

  public Game createGame(User user);

  public Game getGame(String id);

  public void deleteGame(String id);

  public void enterCharacter(String id, String letter);

  public boolean isFound(String id);

  public String getUsedLetters(String id);

}
