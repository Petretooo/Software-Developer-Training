package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

@SuppressWarnings("serial")
@WebServlet("/create")
public class CreateServlet extends BaseServlet {


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.getRequestDispatcher("create.jsp").forward(req, resp);
  }


  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    User user = new User();
    user.setName(req.getParameter("name").trim());
    user.setUsername(req.getParameter("username").trim());
    user.setPassword(req.getParameter("password").trim());

    if (!user.getName().isBlank() && !user.getPassword().isBlank()
        && !user.getUsername().isBlank()) {
      super.addUser(user, req, resp);
    }


    resp.sendRedirect("all");

  }
}
