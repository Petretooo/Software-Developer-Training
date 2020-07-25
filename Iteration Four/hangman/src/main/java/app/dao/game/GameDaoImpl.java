package app.dao.game;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import app.dao.Dao;
import app.model.Game;

@Repository
public class GameDaoImpl<T> {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Optional<Game> get(String id) {
		return Optional.ofNullable(entityManager.find(Game.class, id));
	}

	public void remove(String id) {
		// TODO Auto-generated method stub
		
	}

	public void update(String id) {
		// TODO Auto-generated method stub
		
	}

	public List<Game> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void save(Game entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);		
		entityManager.getTransaction().commit();
	}

}
