package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/")
public class IndexServlet extends BaseServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String welcome = "Welcome to my simple User CRUD application";
    req.setAttribute("title", welcome);
    req.getRequestDispatcher("index.jsp").forward(req, resp);
  }
}
