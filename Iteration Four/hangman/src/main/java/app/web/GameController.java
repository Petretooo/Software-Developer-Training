package app.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import app.model.Game;
import app.service.alphabet.AlphabetService;
import app.service.game.GameService;
import app.util.CharacterNotFoundException;

@Controller
@RequestMapping(value = "/games")
public class GameController {

	@Autowired
	private GameService gameService;
	@Autowired
	private AlphabetService alphabetService;
	

	@GetMapping("/{gameId}")
	public String getGame(@PathVariable String gameId, Model model) {
		Game game = gameService.getGame(gameId);
		String hidden = new String(game.getHiddenWord());
		model.addAttribute("hiddenWord", hidden);
		model.addAttribute("word", game.getCurrentWord());
		model.addAttribute("allLetters",
				gameService.getUsedLetters(game.getId()).toString().replaceAll("([\\[\\]])*", ""));
		model.addAttribute("tries", game.getNumberTries());
		model.addAttribute("alpha", alphabetService.getCurrentGameAlphabet(gameId).entrySet());
		return "games";
	}

	@PostMapping("/{gameId}") // FIX LOGIC
	public ModelAndView makeTry(@PathVariable String gameId, HttpServletRequest request, Model model) {
		Game game = gameService.getGame(gameId);
		gameService.enterCharacter(game.getId(), request.getParameter("letter"));
		//TODO FIX BUSSINES LOGIC - NOT IN CONTROLLER, AND ADD GAMESTATS, STOPWATCH, ETC.. MAYBE THREAD
		if (game.getNumberTries() <= 0) {//GAMESTATS TODO NOT HERE
			request.setAttribute("theWord", game.getCurrentWord());
			//gameService.deleteGame(gameId); SERVICE IMPLEMENTATION
			return new ModelAndView("gameover");
		} else if (gameService.isFound(gameId)) {//GAMESTATS TODO NOT HERE
			request.setAttribute("theWord", game.getCurrentWord());
			//gameService.deleteGame(gameId); SERVICE IMPLEMENTATION
			return new ModelAndView("win");
		}
		//TODO FIX BUSSINES LOGIC END HERE - BE COOL, YOU'RE DOING GREA! ;)
		//AFTER THAT YOU COULD RELAX, FIX IT TOMMOROW!
		//1:37 AM 7/28/2020
		return new ModelAndView("redirect:/games/" + gameId);
	}

	@ExceptionHandler(value = CharacterNotFoundException.class)
	public ResponseEntity<Object> exception(CharacterNotFoundException exception) {
		return new ResponseEntity<>("Character not found", HttpStatus.NOT_FOUND);
	}
}
