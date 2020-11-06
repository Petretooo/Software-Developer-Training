package app.service.gameStats;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.gameStats.GameStatsDao;
import app.model.Game;
import app.model.GameStats;
import app.service.game.GameService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class GameStatsServiceImpl implements GameStatsService {

	private GameStatsDao gameStatsDao;
	private GameService gameService;
	
	@Override
	public GameStats saveGameStats(Game game) {
		GameStats stats = new GameStats();
		stats.setGameStart(LocalDate.now());
		stats.setGame(game);
		gameStatsDao.save(stats);
		return stats;
	}

	@Override
	public void deleteGameStats(String gameStatsId) {
		GameStats stat = gameStatsDao.getOne(gameStatsId);
		gameStatsDao.delete(stat);
	}

	@Override
	public GameStats updateGameStats(String gameId) {
		GameStats gameStat = gameStatsDao.findByGameId(gameId);
		Game game = gameService.getGame(gameId);
		gameStat.setGameEnd(LocalDate.now());
		gameStat.setWrongTries(5 - game.getNumberTries());
		gameStat.setWordFound(gameService.resultWord(gameId).equals("win"));
		
		return gameStat;
	}

}
