package app.service.rank;

import static org.springframework.data.jpa.domain.Specification.where;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.rank.RankingDao;
import app.dao.rank.RankingSpecification;
import app.model.GameStats;
import app.model.Ranking;
import app.model.UserStats;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class RankServiceImpl implements RankService {
	
	private RankingDao rankDao;

	@Override
	public Ranking saveRank(UserStats stat, GameStats gameStat) {
		Ranking rank = new Ranking();
		rank.setUser(stat.getUser());
		rank.setScore(stat.getScore());
		rank.setWord(stat.getWord());
		rank.setDate(gameStat.getGameStart());
		rankDao.save(rank);
		return rankDao.save(rank);
	}

	@Override
	public void removeFromRank(String rankId) {
		Ranking rank = rankDao.getOne(rankId);
		rankDao.delete(rank);
	}

	@Override
	public List<Ranking> getRankList() {
		return rankDao.findTop10ByOrderByScoreDesc();
	}

	@Override
	public List<Ranking> getRankByMonth() {
		
		LocalDate ld = LocalDate.now();
		LocalDate start = ld.withDayOfMonth(1);
		LocalDate end = ld.withDayOfMonth(ld.lengthOfMonth());
		
		Pageable page = PageRequest.of(0, 10, Sort.by("score").descending());	
		return rankDao.findAll(where(RankingSpecification.greaterThanEq(start)).and(RankingSpecification.lessThanEq(end)), page).toList();
	}

}
