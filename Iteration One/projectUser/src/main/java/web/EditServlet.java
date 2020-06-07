package web;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditServlet extends BaseServlet {

  @SuppressWarnings("unchecked")
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    int key;
    if (req.getParameter("key") == null) {
      key = 0;
    } else {
      key = Integer.parseInt(req.getParameter("key"));
    }
    User user = ((Map<Integer, User>) req.getServletContext().getAttribute("users")).get(key);

    req.setAttribute("name", user.getName());
    req.setAttribute("username", user.getUsername());
    req.setAttribute("password", user.getPassword());



    req.getRequestDispatcher("edit.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    int key = Integer.parseInt(req.getParameter("key"));
    User user = new User();
    user.setName(req.getParameter("name"));
    user.setUsername(req.getParameter("username"));
    user.setPassword(req.getParameter("password"));

    if (!user.getName().isBlank() && !user.getPassword().isBlank()
        && !user.getUsername().isBlank()) {
      super.editUser(key, user, req, resp);
    }

    resp.sendRedirect("all");



  }

}
