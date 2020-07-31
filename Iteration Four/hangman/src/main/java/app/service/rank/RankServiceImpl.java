package app.service.rank;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import app.dao.rank.RankDao;
import app.dao.rank.RankSpecification;
import app.dao.rank.SearchCriteria;
import app.dao.rank.SearchOperation;
import app.model.GameStats;
import app.model.Rank;
import app.model.UserStats;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RankServiceImpl implements RankService {
	
	private RankDao rankDao;

	@Override
	public Rank saveRank(UserStats stat, GameStats gameStat) {
		Rank rank = new Rank();
		rank.setUser(stat.getUser());
		rank.setScore(stat.getScore());
		rank.setWord(stat.getWord());
		rank.setDate(gameStat.getGameStart());
		rankDao.save(rank);
		return rankDao.save(rank);
	}

	@Override
	public void removeFromRank(String rankId) {
		Rank rank = rankDao.getOne(rankId);
		rankDao.delete(rank);
	}

	@Override
	public List<Rank> getRankList() {
		List<Rank> rankList = rankDao.findTop10ByOrderByScoreDesc();
		return rankList;
	}

	@Override
	public List<Rank> getRankByMonth() {
		
		RankSpecification rankingByMonth = new RankSpecification();
		LocalDate ld = LocalDate.now();
		LocalDate start = ld.withDayOfMonth(1);
		LocalDate end = ld.withDayOfMonth(ld.lengthOfMonth());

		rankingByMonth.add(new SearchCriteria("date", start, SearchOperation.GREATER_THAN_EQUAL));
		rankingByMonth.add(new SearchCriteria("date", end, SearchOperation.LESS_THAN_EQUAL));
        List<Rank> rankListMonth = rankDao.findAll(rankingByMonth, Sort.by("score")).stream().limit(10).collect(Collectors.toList());
        Collections.reverse(rankListMonth);
        return rankListMonth;

	}

}
