package app.dao.gameStats;

import java.util.List;

import app.model.GameStats;

public interface GameStatsDao {
	public GameStats get(String id);
	public void remove(String gameStatsId);
	public List<GameStats> getAll();
	public void save(GameStats entity);
}
