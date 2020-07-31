package app.dao.gameStats;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.GameStats;

public interface GameStatsDao extends JpaRepository<GameStats, String>{
	
	GameStats findByGameId(String gameId);
	
//	public GameStats get(String id);
//	public void remove(String gameStatsId);
//	public List<GameStats> getAll();
//	public void save(GameStats entity);
//	public GameStats getByGameId(String gameId);
}
