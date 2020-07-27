package app.service.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import app.dao.user.UserDao;
import app.model.Game;
import app.model.User;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	@Override
	public User create(String username) {

		User user = new User();
		user.setUsername(username);
		if(userDao.getByName(user.getUsername()) != null) {
			user = userDao.getByName(user.getUsername());
		}else {
			userDao.save(user);
		}
		return user;

	}

	@Override
	public void remove(String gameId) {
		userDao.remove(gameId);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAll();
	}

	@Override
	public User getUser(String gameId) {
		return userDao.get(gameId);
	}

	@Override
	public void addGame(Game game, String userId) {
		User user = userDao.get(userId);
		user.getGames().add(game);

	}

}
