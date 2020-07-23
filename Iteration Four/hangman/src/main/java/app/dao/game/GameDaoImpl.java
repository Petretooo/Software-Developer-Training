package app.dao.game;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

import org.springframework.stereotype.Repository;

import app.model.Game;

@Repository
public class GameDaoImpl implements Dao<Game> {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	@Override
	public Optional<Game> get(String id) {
		return Optional.ofNullable(entityManager.find(Game.class, id));
	}

	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Game> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Game entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();		
	}

}
