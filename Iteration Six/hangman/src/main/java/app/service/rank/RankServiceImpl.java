package app.service.rank;

import static org.springframework.data.jpa.domain.Specification.where;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.rank.RankingDao;
import app.dao.rank.RankingSpecification;
import app.dto.RankingDto;
import app.dto.RankingDtoList;
import app.model.GameStats;
import app.model.Ranking;
import app.model.UserStats;


@WebService(endpointInterface = "app.service.rank.RankService")
@Service
@Transactional
public class RankServiceImpl implements RankService {
	
	@Autowired private RankingDao rankDao;

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
	public RankingDtoList getRankList() {
		List<RankingDto> ranking = rankDao.findTop10ByOrderByScoreDesc()
				.stream()
				.map(RankingDto::fromRanking)
				.collect(Collectors.toList());
		
		RankingDtoList dtoList = new RankingDtoList();
		dtoList.setDtoList(ranking);
		return dtoList;
	}

	@Override
	public RankingDtoList getRankByMonth() {
		LocalDate ld = LocalDate.now();
		LocalDate start = ld.withDayOfMonth(1);
		LocalDate end = ld.withDayOfMonth(ld.lengthOfMonth());
		Pageable page = PageRequest.of(0, 10, Sort.by("score").descending());	
		
		List<RankingDto> ranking = rankDao.findAll(where(RankingSpecification.greaterThanEq(start)).and(RankingSpecification.lessThanEq(end)), page)
				.stream()
				.map(RankingDto::fromRanking)
				.collect(Collectors.toList());
		
		RankingDtoList dtoList = new RankingDtoList();
		dtoList.setDtoList(ranking);
		return dtoList;
		
	}

}