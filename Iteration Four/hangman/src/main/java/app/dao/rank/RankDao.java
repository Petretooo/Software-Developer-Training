package app.dao.rank;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import app.model.Rank;

public interface RankDao extends JpaRepository<Rank, String>,
CrudRepository<Rank, String>, JpaSpecificationExecutor<Rank> {
	
	List<Rank> findTop10ByOrderByScoreDesc();
	
}
