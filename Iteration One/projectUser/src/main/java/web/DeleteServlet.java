package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteServlet extends BaseServlet {

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int key = Integer.parseInt(request.getParameter("key"));
    super.deleteUser(key);
    response.sendRedirect("all");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    processRequest(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    processRequest(req, resp);

  }
}
