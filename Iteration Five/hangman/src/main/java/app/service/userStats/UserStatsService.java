package app.service.userStats;

import app.model.Game;
import app.model.User;
import app.model.UserStats;

public interface UserStatsService {
	
	public UserStats get(String gameStatsId);
	public UserStats save(User user, String word);
	public UserStats update(Game game);
	public void remove(String gameStatsId);

}
