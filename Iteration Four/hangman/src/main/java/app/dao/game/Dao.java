package app.dao.game;

import java.util.List;
import java.util.Optional;


public interface Dao<T> {
	
	public void save(T entity);
	public Optional<T> get(String id);
	public void remove(String id);
	public void update(String id);
	public List<T> getAll();
	
}