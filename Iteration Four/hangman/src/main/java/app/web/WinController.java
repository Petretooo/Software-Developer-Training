package app.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.model.Game;
import app.model.User;
import app.service.game.GameService;
import app.service.user.UserService;

@Controller
@RequestMapping("/win")
public class WinController {

	@Autowired
	private UserService userService;
	@Autowired
	private GameService gameService;
	
	
	@GetMapping
	public String win() {
		return "win";
	}
	
	@PostMapping
	public String startGame(HttpServletRequest request, Model model) {
		String username = request.getParameter("username").trim();
		User user = userService.create(username);

		Game game = gameService.createGame(user);
		//user.addGame(game);
		
		return "redirect:/games/" + game.getId();
	}
	
}
