package app.web;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
//    model.addAttribute("allLetters",
//        game.getUsedCharacters().toString().replaceAll("([\\[\\]])*", ""));
    model.addAttribute("tries", game.getNumberTries());
    model.addAttribute("alpha", alphabetService.getCurrentGameAlphabet(gameId).entrySet());
    return "games";
  }

//  @PostMapping
//  public ModelAndView createGame(HttpServletResponse response, Model model) throws IOException {
//    Game game = gameService.createGame();
//    return new ModelAndView("redirect:/games/" + game.getId());
//  }

  @PostMapping("/{gameId}")//FIX LOGIC
  public ModelAndView makeTry(@PathVariable String gameId, HttpServletRequest request,
      Model model) {
    Game game = gameService.getGame(gameId);
    gameService.enterCharacter(game.getId(), request.getParameter("letter"));
    alphabetService.setUsedCharacter(gameId, request.getParameter("letter").charAt(0));
    if (game.getNumberTries() <= 0) {
    	request.setAttribute("theWord", game.getCurrentWord());
        gameService.deleteGame(gameId, game);
      return new ModelAndView("gameover");
    } else if (gameService.isFound(gameId)) {
      request.setAttribute("theWord", game.getCurrentWord());
      gameService.deleteGame(gameId, game);
      return new ModelAndView("win");
    }
    return new ModelAndView("redirect:/games/" + gameId);
  }
  
  
  @ExceptionHandler(value = CharacterNotFoundException.class)
  public ResponseEntity<Object> exception(CharacterNotFoundException exception){
    return new ResponseEntity<>("Character not found", HttpStatus.NOT_FOUND);
  }
}
