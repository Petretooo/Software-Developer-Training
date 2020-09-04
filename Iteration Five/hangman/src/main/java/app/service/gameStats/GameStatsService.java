package app.service.gameStats;

import app.model.Game;
import app.model.GameStats;

public interface GameStatsService {
	
	public GameStats saveGameStats(Game game);
	public void deleteGameStats(String gameStatsId);
	public GameStats updateGameStats(String gameId);
}
