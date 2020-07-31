package app.service.rank;

import java.util.List;

import app.model.GameStats;
import app.model.Rank;
import app.model.UserStats;

public interface RankService {
	
	public Rank saveRank(UserStats stat, GameStats gameStat);
	public void removeFromRank(String rankId);
	public List<Rank> getRankList();
	public List<Rank> getRankByMonth();

}
