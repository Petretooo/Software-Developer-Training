package app.web;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import app.service.game.Game;
import app.service.game.GameService;

@Controller
public class GameController {

  @Autowired
  private GameService gameService;

  @GetMapping("/games/{gameId}")
  public String getGame(@PathVariable String gameId, Model model) {
    Game game = gameService.getGame(gameId);
    String hidden = new String(game.getHiddenWord());
    model.addAttribute("hiddenWord", hidden);
    model.addAttribute("allLetters",
        game.getUsedCharacters().toString().replaceAll("([\\[\\]])*", ""));
    model.addAttribute("tries", game.getNumberTries());
    model.addAttribute("alpha", game.getAlphabet().getAlphabet(gameId).entrySet());
    return "newGame";
  }

  @PostMapping("/newGame")
  public ModelAndView createGame(HttpServletResponse response, Model model) throws IOException {
    Game game = gameService.createGame();
    return new ModelAndView("redirect:/games/" + game.getId());
  }

  @PostMapping("/games/{gameId}")
  public ModelAndView makeTry(@PathVariable String gameId, HttpServletRequest request,
      Model model) {
    Game game = gameService.getGame(gameId);
    gameService.enterCharacter(game.getId(), request.getParameter("letter"));
    game.getAlphabet().setUsedCharacter(gameId, request.getParameter("letter").charAt(0));
    if (game.getNumberTries() <= 0) {
      request.setAttribute("theWord", game.getCurrentWord());
      gameService.deleteGame(gameId, game);
      return new ModelAndView("/gameover");
    } else if (gameService.found(gameId)) {
      request.setAttribute("theWord", game.getCurrentWord());
      gameService.deleteGame(gameId, game);
      return new ModelAndView("/win");
    }
    return new ModelAndView("redirect:/games/" + gameId);
  }
}