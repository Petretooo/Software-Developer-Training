package app.api;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.dao.rolePermission.PermissionDao;
import app.dao.rolePermission.RoleDao;
import app.model.Game;
import app.model.Permission;
import app.model.Role;
import app.model.User;
import app.model.Word;
import app.service.user.UserService;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("http://localhost:3000")
public class UserApi {
	@Autowired
	private UserService userService;
	
	@GetMapping(value="/{username}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@PathVariable("username") String username) {
		User user = userService.getUserByName(username);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAll() {
		List<User> users = userService.getAllUsers();
		return ResponseEntity.ok(users);
	}
	
	@PutMapping(value = "{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@PathVariable String userId, @RequestParam String username, @RequestParam String email, @RequestParam String password) {
		User user = userService.getUser(userId);
		
		if(username != null || !username.isEmpty()) {
			user.setUsername(username);
		}else if(email != null || !email.isEmpty()) {
			user.setEmail(email);
		}else if(password != null || !password.isEmpty()) {
			user.setPassword(password);
		}
		
		return ResponseEntity.ok(user);
	}
	
	@PostMapping
	public ResponseEntity<String> postUser(@RequestParam String username, @RequestParam String email, @RequestParam String password){
		User user = null;
		username = username.trim();
		email = email.trim();
		password = password.trim();
		List<User> users = userService.getAllUsers();
		for (User userDb : users) {
			if(userDb.getUsername().equals(username)) {
				user = userDb;
				break;
			}
		}
		if(!username.trim().isBlank() || !email.trim().isBlank() || !password.trim().isBlank()) {
			user = userService.create(username, email, password);
		}
		
		return new ResponseEntity<>(user.getUsername(), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> deleteWord(@PathVariable("userId") String userId) {
		userService.remove(userId);
	    return ResponseEntity.noContent().build();
	}
}
