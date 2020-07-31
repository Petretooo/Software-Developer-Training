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
import app.model.GameStats;
import app.model.UserStats;
import app.service.alphabet.AlphabetService;
import app.service.game.GameService;
import app.service.gameStats.GameStatsService;
import app.service.rank.RankService;
import app.service.userStats.UserStatsService;
import app.util.CharacterNotFoundException;

@Controller
@RequestMapping(value = "/games")
public class GameController {

	@Autowired
	private GameService gameService;
	@Autowired
	private AlphabetService alphabetService;
	@Autowired
	private GameStatsService gameStatsService;
	@Autowired
	private UserStatsService userStatsService;
	@Autowired
	private RankService rankService;
	

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

	@PostMapping("/{gameId}")
	public ModelAndView makeTry(@PathVariable String gameId, HttpServletRequest request, Model model) {
		Game game = gameService.getGame(gameId);
		gameService.enterCharacter(game.getId(), request.getParameter("letter"));
		
		if(gameService.resultWord(gameId) != null) {
			request.setAttribute("theWord", game.getCurrentWord());
			GameStats gameStat = gameStatsService.updateGameStats(gameId);
			UserStats stat = userStatsService.update(game);
			rankService.saveRank(stat, gameStat);
			return new ModelAndView(gameService.resultWord(gameId));
		}

		return new ModelAndView("redirect:/games/" + gameId);
	}

	@ExceptionHandler(value = CharacterNotFoundException.class)
	public ResponseEntity<Object> exception(CharacterNotFoundException exception) {
		return new ResponseEntity<>("Character not found", HttpStatus.NOT_FOUND);
	}
}
