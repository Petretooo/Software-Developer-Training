package app.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.model.Game;
import app.model.User;
import app.service.game.GameService;
import app.service.gameStats.GameStatsService;
import app.service.user.UserService;
import app.service.userStats.UserStatsService;

@RestController
@RequestMapping("/api/v1/games")
public class GameApi {
	@Autowired
	private GameService gameService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserStatsService userStatsService;
	
	@Autowired
	private GameStatsService gameStatsService;
	
	private final static String URL_GAME_SELF_REF = "http://localhost:8080/hangman/api/v1/games/%s";

	@GetMapping(value = "/{gameId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Game> getGame(@PathVariable String gameId) {
		Game game = gameService.getGame(gameId);
		Link link = Link.of(String.format(URL_GAME_SELF_REF, gameId)).withSelfRel();
		game.add(link);
		return ResponseEntity.ok(game);
	}

	@PutMapping(value = "/{gameId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void makeTry(@PathVariable String gameId, @RequestParam("letter") String letter) {
		gameService.enterCharacter(gameId, letter);
		ResponseEntity.noContent();
	}
	
	@PostMapping
	public ResponseEntity<String> createGame(@RequestParam String username) {
		User user = userService.create(username);
		Game game = gameService.createGame(user);
		
		userStatsService.save(user, game.getCurrentWord());
		gameStatsService.saveGameStats(game);
		
		return new ResponseEntity<>(game.getId(), HttpStatus.CREATED);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Game>> getRunningGames() {
		List<Game> games = gameService.getRunningGame();
		games.stream().forEach(e -> e.add(Link.of(String.format(URL_GAME_SELF_REF, e.getId())).withSelfRel()));
		return ResponseEntity.ok(games);
	}


}
