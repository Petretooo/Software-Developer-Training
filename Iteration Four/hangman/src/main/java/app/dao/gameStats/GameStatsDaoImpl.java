package app.dao.gameStats;

import org.springframework.stereotype.Repository;

@Repository
public class GameStatsDaoImpl{

//	@PersistenceContext
//	private EntityManager entityManager;
//	
//	@Transactional
//	@Override
//	public GameStats get(String id) {
//		return entityManager.find(GameStats.class, id);
//	}
//
//	@Transactional
//	@Override
//	public void remove(String gameStatsId) {
//		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//		CriteriaDelete<GameStats> criteriaDelete = cb.createCriteriaDelete(GameStats.class);
//		Root<GameStats> root = criteriaDelete.from(GameStats.class);
//		criteriaDelete.where(cb.equal(root.get("id"), gameStatsId));
//		entityManager.createQuery(criteriaDelete).executeUpdate();
//		
//	}
//
//	@Transactional
//	@Override
//	public List<GameStats> getAll() {
//		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//		CriteriaQuery<GameStats> cq = cb.createQuery(GameStats.class);
//		Root<GameStats> rootGameStats = cq.from(GameStats.class);
//		CriteriaQuery<GameStats> all = cq.select(rootGameStats);
//		TypedQuery<GameStats> allQuery = entityManager.createQuery(all);
//		return allQuery.getResultList();
//	}
//
//	@Transactional
//	@Override
//	public void save(GameStats entity) {
//		entityManager.persist(entity);
//	}
//
//	@Override
//	public GameStats getByGameId(String gameId) {
//		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//		CriteriaQuery<GameStats> cq = cb.createQuery(GameStats.class);
//		Root<GameStats> rootStats = cq.from(GameStats.class);
//		
//		return entityManager.createQuery(cq.select(rootStats).where(cb.equal(rootStats.get("gameId"), gameId))).getSingleResult();
//		
//	}

}
