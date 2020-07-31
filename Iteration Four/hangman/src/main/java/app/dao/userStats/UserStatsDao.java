package app.dao.userStats;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.UserStats;

public interface UserStatsDao extends JpaRepository<UserStats, String> {
	
	List<UserStats> findByIdUserStats(String userId);

//	public UserStats get(String id);
//	public void remove(String userStatsId);
//	public List<UserStats> getAll();
//	public void save(UserStats entity);
}
