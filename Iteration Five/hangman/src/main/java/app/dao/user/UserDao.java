package app.dao.user;

import java.util.List;

import app.model.User;

public interface UserDao {
	
	public User save(User entity);
	public User get(String id);
	public User getByName(String username);
	public void remove(String id);
	public List<User> getAll();
}
