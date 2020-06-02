package web;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

public class BaseServlet extends HttpServlet implements ContextUser {

  public ServletContext servletContext;

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

  @Override
  public void deleteUser(HttpServletRequest request, HttpServletResponse response) {

    int key = Integer.parseInt(request.getParameter("key"));
    ((Map<Integer, User>) request.getServletContext().getAttribute("users")).remove(key);

  }

  @Override
  public void editUser(int key, User user, HttpServletRequest request,
      HttpServletResponse response) {

    ((Map<Integer, User>) request.getServletContext().getAttribute("users")).replace(key, user);

  }

  @Override
  public Map<String, User> showAllUsers() {
    // TODO Auto-generated method stub
    return null;
  }


}
