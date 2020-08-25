package app.service.user;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.user.UserDao;
import app.model.Game;
import app.model.User;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
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
	public void remove(String uesrId) {
		userDao.remove(uesrId);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAll();
	}

	@Override
	public User getUser(String uesrId) {
		return userDao.get(uesrId);
	}

	@Override
	public void addGame(Game game, String userId) {
		User user = userDao.get(userId);
		user.getGames().add(game);

	}

}
