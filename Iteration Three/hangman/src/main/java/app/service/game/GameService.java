package app.service.game;

public interface GameService {

  public Game createGame();

  public Game getGame(String id);

  public boolean deleteGame(String id, Game game);

  public void enterCharacter(String id, String letter);

  public boolean found(String id);

}
