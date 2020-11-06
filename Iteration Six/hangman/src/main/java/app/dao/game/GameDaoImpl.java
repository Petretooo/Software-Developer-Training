package app.dao.game;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import app.model.Game;
import app.model.GameStats;
import app.model.GameStats_;
import app.model.Game_;

@Repository
public class GameDaoImpl implements GameDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Game get(String id) {
		return entityManager.find(Game.class, id);
	}

	@Override
	public void remove(String gameId) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaDelete<Game> criteriaDelete = cb.createCriteriaDelete(Game.class);
		Root<Game> root = criteriaDelete.from(Game.class);
		criteriaDelete.where(cb.equal(root.get("id"), gameId));
		entityManager.createQuery(criteriaDelete).executeUpdate();
	}

	@Override
	public List<Game> getAll() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Game> cq = cb.createQuery(Game.class);
		Root<Game> rootGame = cq.from(Game.class);
		CriteriaQuery<Game> all = cq.select(rootGame);
		TypedQuery<Game> allQuery = entityManager.createQuery(all);
		return allQuery.getResultList();
	}

	@Override
	public void save(Game entity) {
		entityManager.persist(entity);
	}

	@Override
	public void updateGame(Game game, String gameId) {
		Game currentGame = entityManager.find(Game.class, gameId);
		currentGame.setHiddenWord(game.getHiddenWord());
		entityManager.persist(currentGame);
	}

	@Override
	public List<Game> getRunningGames() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Game> queryCriteria = cb.createQuery(Game.class);
		Root<Game> games = queryCriteria.from(Game.class);
		Join<Game,GameStats> joinStats = games.join(Game_.gameStats);
		queryCriteria.select(games);
		queryCriteria.where(cb.equal(games.get(Game_.id), joinStats.get(GameStats_.gameId)));
		queryCriteria.where(cb.isNull(joinStats.get(GameStats_.gameEnd)));
		TypedQuery<Game> joinedResult = entityManager.createQuery(queryCriteria);
		return joinedResult.getResultList();
	}
	

}
