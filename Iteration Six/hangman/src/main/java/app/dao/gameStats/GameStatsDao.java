package app.dao.gameStats;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.GameStats;

public interface GameStatsDao extends JpaRepository<GameStats, String>{
	
	GameStats findByGameId(String gameId);
	
}
