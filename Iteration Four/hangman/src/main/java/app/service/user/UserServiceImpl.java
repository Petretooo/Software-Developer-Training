package app.service.user;

import java.util.UUID;

import org.springframework.stereotype.Service;

import app.dao.user.UserDaoImpl;
import app.model.User;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	private UserDaoImpl userDao = new UserDaoImpl();

	@Override
	public void create(String username) {
		User user = new User();
		user.setUserId(UUID.randomUUID().toString());
		user.setUsername(username);
		userDao.save(user);
	}
}
