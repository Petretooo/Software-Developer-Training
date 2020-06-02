package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

@WebServlet("/edit")
public class EditServlet extends BaseServlet {



  public User user;
  private int key;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    key = Integer.parseInt(req.getParameter("key"));
    // processRequest(req, resp);
    req.getRequestDispatcher("edit.jsp").forward(req, resp);


  }

  @SuppressWarnings("unchecked")
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    User user = new User();
    user.setName(req.getParameter("name"));
    user.setUsername(req.getParameter("username"));
    user.setPassword(req.getParameter("password"));

    super.editUser(key, user, req, resp);


    resp.sendRedirect("all.jsp");

  }

}
