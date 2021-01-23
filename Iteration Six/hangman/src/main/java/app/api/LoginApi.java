package app.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.model.User;
import app.service.user.UserService;

@RestController
@RequestMapping("/api/v1/login")
@CrossOrigin("http://localhost:3000")
public class LoginApi {

	@Autowired
	private UserService userService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> postUser(@RequestParam String username, @RequestParam String password){
		User user = null;
		List<User> users = userService.getAllUsers();
		username = username.trim();
		password = password.trim();
		for (User userDb : users) {
			if(userDb.getUsername().equals(username) && userDb.getPassword().equals(password)) {
				user = userDb;
				break;
			}
		}
		return ResponseEntity.ok(user);
	}
}
