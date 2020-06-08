package web;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

@SuppressWarnings("serial")
public class BaseServlet extends HttpServlet {

  @SuppressWarnings("unchecked")
  public void addUser(User user, HttpServletRequest request, HttpServletResponse response) {
    if (request.getServletContext().getAttribute("users") == null) {
      synchronized (BaseServlet.class) {
        if (request.getServletContext().getAttribute("users") == null) {
          request.getServletContext().setAttribute("users", new ConcurrentHashMap<>());
        }
      }
    }

    int size = ((Map<Integer, User>) request.getServletContext().getAttribute("users")).size();
    ((Map<Integer, User>) request.getServletContext().getAttribute("users")).putIfAbsent(++size,
        user);
  }

  @SuppressWarnings("unchecked")
  public void deleteUser(HttpServletRequest request, HttpServletResponse response) {

    int key = Integer.parseInt(request.getParameter("key"));
    ((Map<Integer, User>) request.getServletContext().getAttribute("users")).remove(key);

  }

  @SuppressWarnings("unchecked")
  public void editUser(int key, User user, HttpServletRequest request,
      HttpServletResponse response) {

    ((Map<Integer, User>) request.getServletContext().getAttribute("users")).replace(key, user);

  }

  @SuppressWarnings("unchecked")
  public void showAllUsers(HttpServletRequest request, HttpServletResponse response) {
    Map<Integer, User> users =
        (Map<Integer, User>) request.getServletContext().getAttribute("users");

    request.setAttribute("show", users.entrySet());
  }


}
