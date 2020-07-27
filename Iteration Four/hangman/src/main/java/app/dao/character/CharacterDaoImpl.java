package app.dao.character;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import app.model.Character;

@Repository
public class CharacterDaoImpl implements CharacterDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	@Override
	public Character get(String id) {
		return entityManager.find(Character.class, id);
	}

	@Transactional
	@Override
	public void remove(String id) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaDelete<Character> criteriaDelete = cb.createCriteriaDelete(Character.class);
		Root<Character> root = criteriaDelete.from(Character.class);
		criteriaDelete.where(cb.equal(root.get("characterId"), id));
		entityManager.createQuery(criteriaDelete).executeUpdate();
	}

	@Transactional
	@Override
	public List<Character> getAll() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Character> cq = cb.createQuery(Character.class);
		Root<Character> rootCharacter = cq.from(Character.class);
		CriteriaQuery<Character> all = cq.select(rootCharacter);
		TypedQuery<Character> allQuery = entityManager.createQuery(all);
		return allQuery.getResultList();
	}

	@Transactional
	@Override
	public void save(Character entity) {
		entityManager.persist(entity);
		
	}

}
