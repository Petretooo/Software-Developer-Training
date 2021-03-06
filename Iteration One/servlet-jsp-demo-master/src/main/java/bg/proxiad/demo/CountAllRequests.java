package bg.proxiad.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/count-all-requess")
public class CountAllRequests extends HttpServlet {

  protected static void counter(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    HttpSession session = req.getSession();

    Integer counter = (Integer) session.getAttribute("request");
    if (counter == null) {
      counter = 0;
    }
    if (session.getAttribute("request") == null) {
      counter = 1;
      session.setAttribute("request", counter);
    } else {
      session.setAttribute("request", ++counter);
    }
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Integer counter = (Integer) req.getSession().getAttribute("request");
    if (counter == null) {
      counter = 0;
      req.getSession().setAttribute("request", counter);
    }
    getServletContext().setAttribute("counterAll", req.getSession().getAttribute("request"));
    req.getRequestDispatcher("/counter-all-request.jsp").forward(req, resp);
  }

}
