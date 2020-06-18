package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hangman.GameContext;
import hangman.GameService;
import hangman.Repository;

@SuppressWarnings("serial")
@WebServlet("/new")
public class CreateGameServlet extends HttpServlet {

  private GameService game;
  private GameContext context;
  private Repository repo;

  @Override
  public void init() throws ServletException {
    context = new GameContext();
    repo = new Repository();
  }


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    game = context.getGame();
    game.createGame();
    repo.addGame(req.getSession().getId(), game);

    req.setAttribute("hiddenWord", game.updateWord());
    req.setAttribute("tries", game.numberTries());
    req.getRequestDispatcher("newGame.jsp").forward(req, resp);
  }


  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    game = repo.getGame(req.getSession().getId());

    String letter = req.getParameter("letter");
    if (!letter.trim().equals("")) {
      game.enterCharacter(letter);
    }
    req.setAttribute("hiddenWord", game.updateWord());
    req.setAttribute("allLetters", game.getUsedWords());
    req.setAttribute("tries", game.numberTries());

    if (game.numberTries() == 0) {
      req.setAttribute("theWord", game.getWord());
      repo.removeGame(req.getSession().getId(), game);
      req.getRequestDispatcher("gameover.jsp").forward(req, resp);
    } else if (game.found()) {
      req.setAttribute("theWord", game.getWord());
      repo.removeGame(req.getSession().getId(), game);
      req.getRequestDispatcher("win.jsp").forward(req, resp);
    } else {
      req.getRequestDispatcher("newGame.jsp").forward(req, resp);
    }

  }
}
