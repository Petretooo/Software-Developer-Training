package app.service.userStats;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.gameStats.GameStatsDao;
import app.dao.userStats.UserStatsDao;
import app.model.Game;
import app.model.GameStats;
import app.model.User;
import app.model.UserStats;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class UserStatsServiceImpl implements UserStatsService{

	private UserStatsDao userStatsDao;
	private GameStatsDao gameStatsDao;
	
	@Override
	public UserStats get(String gameStatsId) {
		return userStatsDao.getOne(gameStatsId);
	}

	@Override
	public UserStats save(User user, String word) {
		UserStats userStat = new UserStats();
		userStat.setUser(user);
		userStat.setWord(word);
		return userStatsDao.save(userStat);
	}

	@Override
	public UserStats update(Game game) {
		GameStats gameStat = gameStatsDao.findByGameId(game.getId());
		List<UserStats> userStats = userStatsDao.findByIdUserStats(game.getUser().getUserId());
		UserStats stat;
		for (UserStats userStats2 : userStats) {
			if(userStats2.getScore() == 0) {
				stat = userStats2;
				stat.setScore(scoreCalc(gameStat, game.getHiddenWord()));
				
				return stat;
			}
		}
		return null;
	}
	
	private int scoreCalc(GameStats gameStats, char[] hiddenWord) {
		int score = 0;
		for (char c : hiddenWord) {
			if(c == '_') {
				continue;
			}else {
				score+=25;
			}
		}
		switch (gameStats.getWrongTries()) {
		case 0:
			score += 550;
			break;
		case 1:
			score += 450;
			break;
		case 2:
			score += 350;
			break;
		case 3:
			score += 250;
			break;
		case 4:
			score += 150;
			break;
		default:
			break;
		}
		
		score+=hiddenWord.length*3;
		
		return score;
	}

	@Override
	public void remove(String gameStatsId) {
		UserStats userStat = userStatsDao.getOne(gameStatsId);
		userStatsDao.delete(userStat);
		
	}

}
