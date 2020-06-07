package web;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/all")
public class ShowServlet extends BaseServlet {

  public ShowServlet() {
    // TODO Auto-generated constructor stub
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    if (req.getServletContext().getAttribute("users") == null) {
      synchronized (CreateServlet.class) {
        if (req.getServletContext().getAttribute("users") == null) {
          req.getServletContext().setAttribute("users", new ConcurrentHashMap<>());
        }
      }
    }
    super.showAllUsers(req, resp);

    req.getRequestDispatcher("all.jsp").forward(req, resp);
  }

}
