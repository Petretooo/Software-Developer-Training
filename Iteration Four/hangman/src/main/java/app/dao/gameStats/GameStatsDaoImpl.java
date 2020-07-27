package app.dao.gameStats;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.model.GameStats;

@Repository
public class GameStatsDaoImpl implements GameStatsDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	@Override
	public GameStats get(String id) {
		return entityManager.find(GameStats.class, id);
	}

	@Transactional
	@Override
	public void remove(String gameStatsId) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaDelete<GameStats> criteriaDelete = cb.createCriteriaDelete(GameStats.class);
		Root<GameStats> root = criteriaDelete.from(GameStats.class);
		criteriaDelete.where(cb.equal(root.get("id"), gameStatsId));
		entityManager.createQuery(criteriaDelete).executeUpdate();
		
	}

	@Transactional
	@Override
	public List<GameStats> getAll() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<GameStats> cq = cb.createQuery(GameStats.class);
		Root<GameStats> rootGameStats = cq.from(GameStats.class);
		CriteriaQuery<GameStats> all = cq.select(rootGameStats);
		TypedQuery<GameStats> allQuery = entityManager.createQuery(all);
		return allQuery.getResultList();
	}

	@Transactional
	@Override
	public void save(GameStats entity) {
		entityManager.persist(entity);
	}

}
