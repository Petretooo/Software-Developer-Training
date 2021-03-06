package app.dao.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import app.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public User save(User entity) {
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public User get(String id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public void remove(String id) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaDelete<User> criteriaDelete = cb.createCriteriaDelete(User.class);
		Root<User> root = criteriaDelete.from(User.class);
		criteriaDelete.where(cb.equal(root.get("userId"), id));
		entityManager.createQuery(criteriaDelete).executeUpdate();
	}

	@Override
	public List<User> getAll() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> rootUser = cq.from(User.class);
		cq.select(rootUser);
		return entityManager.createQuery(cq).getResultList();
	}

	@Override
	public User getByName(String username) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);
		try {
			return entityManager.createQuery(cq.select(root).where(cb.equal(root.get("username"), username))).getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}

}