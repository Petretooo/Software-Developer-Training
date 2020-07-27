package app.dao.game;

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

import app.model.Game;

@Repository
public class GameDaoImpl implements GameDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	@Override
	public Game get(String id) {
		return entityManager.find(Game.class, id);
	}

	@Transactional
	@Override
	public void remove(String gameId) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaDelete<Game> criteriaDelete = cb.createCriteriaDelete(Game.class);
		Root<Game> root = criteriaDelete.from(Game.class);
		criteriaDelete.where(cb.equal(root.get("id"), gameId));
		entityManager.createQuery(criteriaDelete).executeUpdate();
	}

	@Transactional
	@Override
	public List<Game> getAll() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Game> cq = cb.createQuery(Game.class);
		Root<Game> rootGame = cq.from(Game.class);
		CriteriaQuery<Game> all = cq.select(rootGame);
		TypedQuery<Game> allQuery = entityManager.createQuery(all);
		return allQuery.getResultList();
	}
	
	@Transactional
	@Override
	public void save(Game entity) {
		entityManager.persist(entity);		
	}
	
	@Transactional
	@Override
	public void updateGame(Game game, String gameId) {
		Game currentGame = entityManager.find(Game.class, gameId);
		currentGame.setHiddenWord(game.getHiddenWord());
		entityManager.persist(currentGame);
	}

}
