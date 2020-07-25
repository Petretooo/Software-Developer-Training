package app.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.model.Game;
import app.service.game.GameService;
import app.service.user.UserService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private UserService userService;
	@Autowired
	private GameService gameService;
	
	
	@GetMapping
	public String index() {
		return "index";
	}
	
	@PostMapping
	public String createUser(HttpServletRequest request, Model model) {
		String username = request.getParameter("username").trim();
		Game game = gameService.createGame();
//		request.setAttribute("id", 1);
//		userService.create(username);
//		return new ModelAndView("redirect:/{id}/games/");
		return "redirect:/games/" + game.getId();
	}
}
