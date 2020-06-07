package web;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

@SuppressWarnings("serial")
public class BaseServlet extends HttpServlet implements ContextUser {

  public ServletContext servletContext;

  @SuppressWarnings("unchecked")
  @Override
  public void addUser(User user, HttpServletRequest request, HttpServletResponse response) {
    servletContext = request.getServletContext();
    if (request.getServletContext().getAttribute("users") == null) {
      synchronized (BaseServlet.class) {
        if (request.getServletContext().getAttribute("users") == null) {
          servletContext.setAttribute("users", new ConcurrentHashMap<>());
        }
      }
    }

    int size = ((Map<Integer, User>) servletContext.getAttribute("users")).size();
    ((Map<Integer, User>) servletContext.getAttribute("users")).putIfAbsent(++size, user);
  }

  @SuppressWarnings("unchecked")
  @Override
  public void deleteUser(HttpServletRequest request, HttpServletResponse response) {

    int key = Integer.parseInt(request.getParameter("key"));
    ((Map<Integer, User>) request.getServletContext().getAttribute("users")).remove(key);

  }

  @SuppressWarnings("unchecked")
  @Override
  public void editUser(int key, User user, HttpServletRequest request,
      HttpServletResponse response) {

    ((Map<Integer, User>) request.getServletContext().getAttribute("users")).replace(key, user);

  }

  @SuppressWarnings("unchecked")
  @Override
  public void showAllUsers(HttpServletRequest request, HttpServletResponse response) {
    Map<Integer, User> users =
        (Map<Integer, User>) request.getServletContext().getAttribute("users");

    request.setAttribute("show", users.entrySet());
    // for (Entry<Integer, User> u : users.entrySet()) {
    // request.setAttribute("Id", u.getKey());
    // request.setAttribute("Name", u.getValue().getName());
    // request.setAttribute("Username", u.getValue().getUsername());
    // request.setAttribute("Password", u.getValue().getPassword());
    // }
  }


}
