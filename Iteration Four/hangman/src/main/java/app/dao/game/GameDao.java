package app.dao.game;

import java.util.List;

import app.model.Game;

public interface GameDao {
	public Game get(String id);
	public void remove(String gameId);
	public List<Game> getAll();
	public void save(Game entity);
	public void updateGame(Game game, String gameId);
}
