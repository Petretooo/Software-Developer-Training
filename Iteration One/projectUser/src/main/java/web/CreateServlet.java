package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/create")
public class CreateServlet extends BaseServlet {


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.getRequestDispatcher("create.jsp").forward(req, resp);
  }

  @SuppressWarnings("unchecked")
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    User user = new User();
    user.setName(req.getParameter("name"));
    user.setUsername(req.getParameter("username"));
    user.setPassword(req.getParameter("password"));

    super.addUser(user, req, resp);

    resp.sendRedirect("create.jsp");

  }
}
