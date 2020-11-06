package app.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import app.model.Game;
import app.model.User;
import app.service.game.GameService;
import app.service.gameStats.GameStatsService;
import app.service.user.UserService;
import app.service.userStats.UserStatsService;

@Controller
public class ResultController {

	@Autowired
	private UserService userService;
	@Autowired
	private GameService gameService;
	@Autowired
	private GameStatsService gameStatsService;
	@Autowired
	private UserStatsService userStatsService;
	
	@GetMapping("/win")
	public String win() {
		return "win";
	}
	
	@GetMapping("/gameover")
	public String gameover() {
		return "gameover";
	}

	
	@PostMapping(path = {"/win", "/gameover"})
	public String startGame(HttpServletRequest request, Model model) {
		String username = request.getParameter("username").trim();
		
		if(username.isBlank()) {
			return request.getParameter("errorPage");
		}
		
		User user = userService.create(username);
		Game game = gameService.createGame(user);
		
		userStatsService.save(user, game.getCurrentWord());
		gameStatsService.saveGameStats(game);
		
		return "redirect:/games/" + game.getId();
	}
	
}
