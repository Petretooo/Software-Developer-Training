package app.service.user;

import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.user.UserDao;
import app.model.Game;
import app.model.Role;
import app.model.User;
import app.service.role.RoleService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	private RoleService roleService;

	@Override
	public User create(String username) {//fix

		User user = new User();
		user.setUsername(username);
		
		//TODO
		user.setEmail(String.format("%s@gmail.com",username));
		user.setPassword(username.toLowerCase());
		
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

	@Override
	public User getUserByName(String name) {
		return userDao.getByName(name);
	}

	@Override
	public User create(String username, String email, String password) {
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		Role roleUser = roleService.getRoleByRole("editor");
		user.setRoles(new HashSet<Role>());
		user.getRoles().add(roleUser);
		if(userDao.getByName(user.getUsername()) != null) {
			user = userDao.getByName(user.getUsername());
		}else {
			userDao.save(user);
		}
		
		return user;
	}

}
