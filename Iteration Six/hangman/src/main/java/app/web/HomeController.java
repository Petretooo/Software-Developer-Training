
package app.web;

//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.shiro.SecurityUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpRequest;
//import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseStatus;

//import app.model.Game;
//import app.model.User;
//import app.service.game.GameService;
//import app.service.gameStats.GameStatsService;
//import app.service.user.UserService;
//import app.service.userStats.UserStatsService;

@Controller
public class HomeController {

//	@RequestMapping(value = { "/{path:[^\\.]*}", "/{path:[^\\.]*}/{path:[^\\.]*}",
//			"/{path:[^\\.]*}/{path:[^\\.]*}/{path:[^\\.]*}",
//			"/{path:[^\\.]*}/{path:[^\\.]*}/{path:[^\\.]*}/{path:[^\\.]*}" }, method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
//	public String routing() {
//		return "forward:/";
//	}
	
	@RequestMapping(value = "/**/{path:[^\\.]*}", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
	public String routing() {
		return "forward:/";
	}

//	@RequestMapping(value="/**",method = RequestMethod.GET)
//    public String getAnything(){
//        return "forward:/";
//    }

//	@Autowired
//	private UserService userService;
//
//	@Autowired
//	private GameService gameService;
//
//	@Autowired
//	private GameStatsService gameStatsService;
//
//	@Autowired
//	private UserStatsService userStatsService;
//
//	@GetMapping
//	public String index() {
//		return "index";
//	}
//
//	@PostMapping
//	public String createUser(HttpServletRequest request) {
//		String username = request.getParameter("username").trim();
//
//		if (username.isBlank()) {
//			return "redirect:/";
//		}
//
//		User user = userService.create(username);
//		Game game = gameService.createGame(user);
//		userStatsService.save(user, game.getCurrentWord());
//		gameStatsService.saveGameStats(game);
//
//		return "redirect:/games/" + game.getId();
//	}
}
