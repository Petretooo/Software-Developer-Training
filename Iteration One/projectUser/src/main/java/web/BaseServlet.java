package web;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.servlet.http.HttpServlet;
import model.User;

@SuppressWarnings("serial")
public class BaseServlet extends HttpServlet {

  private static final String USERS = "users";

  private void checkContextIsNull() {

    if (getServletContext().getAttribute(USERS) == null) {
      synchronized (BaseServlet.class) {
        if (getServletContext().getAttribute(USERS) == null) {
          getServletContext().setAttribute(USERS, new ConcurrentHashMap<>());
        }
      }
    }

  }

  @SuppressWarnings("unchecked")
  public void addUser(User user) {
    checkContextIsNull();

    int size = ((Map<Integer, User>) getServletContext().getAttribute(USERS)).size();
    ((Map<Integer, User>) getServletContext().getAttribute(USERS)).putIfAbsent(++size, user);
  }

  @SuppressWarnings("unchecked")
  public void deleteUser(int key) {

    ((Map<Integer, User>) getServletContext().getAttribute(USERS)).remove(key);

  }

  @SuppressWarnings("unchecked")
  public void editUser(int key, User user) {

    ((Map<Integer, User>) getServletContext().getAttribute(USERS)).replace(key, user);

  }

  @SuppressWarnings("unchecked")
  public void showAllUsers() {
    Map<Integer, User> users = (Map<Integer, User>) getServletContext().getAttribute(USERS);

    getServletContext().setAttribute("show", users.entrySet());
  }


}
