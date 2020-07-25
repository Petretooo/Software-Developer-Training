package app.dao.user;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.model.User;

@Repository
public class UserDaoImpl{

	@PersistenceContext
	EntityManager entityManager;
	

	@Transactional
	public void save(User entity) {
		entityManager.persist(entity);
	}


	public Optional<User> get(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	public void remove(String id) {
		// TODO Auto-generated method stub
		
	}

	public void update(String id) {
		// TODO Auto-generated method stub
		
	}

	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
