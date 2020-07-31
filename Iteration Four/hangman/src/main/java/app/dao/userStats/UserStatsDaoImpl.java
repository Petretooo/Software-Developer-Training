package app.dao.userStats;

public class UserStatsDaoImpl {

//	@PersistenceContext
//	private EntityManager entityManager;
//	
//	@Transactional
//	@Override
//	public UserStats get(String id) {
//		return entityManager.find(UserStats.class, id);
//	}
//
//	@Transactional
//	@Override
//	public void remove(String userStatsId) {
//		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//		CriteriaDelete<UserStats> criteriaDelete = cb.createCriteriaDelete(UserStats.class);
//		Root<UserStats> root = criteriaDelete.from(UserStats.class);
//		criteriaDelete.where(cb.equal(root.get("id"), userStatsId));
//		entityManager.createQuery(criteriaDelete).executeUpdate();
//	}
//
//	@Transactional
//	@Override
//	public List<UserStats> getAll() {
//		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//		CriteriaQuery<UserStats> cq = cb.createQuery(UserStats.class);
//		Root<UserStats> rootUserStats = cq.from(UserStats.class);
//		cq.select(rootUserStats);
//		return entityManager.createQuery(cq).getResultList();
//	}
//
//	@Transactional
//	@Override
//	public void save(UserStats entity) {
//		entityManager.persist(entity);
//	}

}
