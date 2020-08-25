package app.service.rank;

import java.util.List;

import app.model.GameStats;
import app.model.Ranking;
import app.model.UserStats;

public interface RankService {
	
	public Ranking saveRank(UserStats stat, GameStats gameStat);
	public void removeFromRank(String rankId);
	public List<Ranking> getRankList();
	public List<Ranking> getRankByMonth();

}
