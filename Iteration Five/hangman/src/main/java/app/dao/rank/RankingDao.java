package app.dao.rank;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import app.model.Ranking;

public interface RankingDao extends JpaRepository<Ranking, String>,
CrudRepository<Ranking, String>, JpaSpecificationExecutor<Ranking> {
	
	List<Ranking> findTop10ByOrderByScoreDesc();
	
}
