package app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.service.game.GameService;
import app.service.user.UserService;

@RestController
@RequestMapping("/api/v1/result")
public class ResultAPI {
	@Autowired
	private UserService userService;
	@Autowired
	private GameService gameService;
	
	
	@GetMapping(value = "/win", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> win() {
		return ResponseEntity.ok("win");
	}
	
	@GetMapping(value = "/gameover", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> gameover() {
		return ResponseEntity.ok("gameover");
	}
}
