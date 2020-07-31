package app.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.model.Game;
import app.model.GameStats;
import app.model.User;
import app.model.UserStats;
import app.service.game.GameService;
import app.service.gameStats.GameStatsService;
import app.service.user.UserService;
import app.service.userStats.UserStatsService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private UserService userService;
	@Autowired
	private GameService gameService;
	@Autowired
	private GameStatsService gameStatsService;
	@Autowired
	private UserStatsService userStatsService;
	
	@GetMapping
	public String index() {
		return "index";
	}
	
	@SuppressWarnings("unused")
	@PostMapping
	public String createUser(HttpServletRequest request, Model model) {
		String username = request.getParameter("username").trim();
		
		User user = userService.create(username);
		Game game = gameService.createGame(user);
		UserStats userStats = userStatsService.save(user, game.getCurrentWord());
		GameStats gameStats = gameStatsService.saveGameStats(game);

		return "redirect:/games/" + game.getId();
	}
}
