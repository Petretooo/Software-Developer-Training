package app.service.user;

import java.util.List;

import app.model.Game;
import app.model.User;

public interface UserService {
	
	public User create(String username);
	public void remove(String uesrId);
	public List<User> getAllUsers();
	public User getUser(String uesrId);
	public void addGame(Game game, String userId);
	
}
