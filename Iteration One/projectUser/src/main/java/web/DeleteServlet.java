package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet extends BaseServlet {



  private void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    super.deleteUser(request, response);
    response.sendRedirect("all.jsp");
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
