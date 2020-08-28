package app.dao.userStats;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.UserStats;

public interface UserStatsDao extends JpaRepository<UserStats, String> {
	
	List<UserStats> findByIdUserStats(String userId);

}
