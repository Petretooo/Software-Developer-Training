package web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

public interface ContextUser {

  public void deleteUser(HttpServletRequest request, HttpServletResponse response);

  public void editUser(int key, User user, HttpServletRequest request,
      HttpServletResponse response);

  void addUser(User user, HttpServletRequest request, HttpServletResponse response);

  void showAllUsers(HttpServletRequest request, HttpServletResponse response);

}
