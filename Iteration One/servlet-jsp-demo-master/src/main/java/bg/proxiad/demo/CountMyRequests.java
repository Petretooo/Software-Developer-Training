package bg.proxiad.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/count-my-requests")
public class CountMyRequests extends HttpServlet {

  public static void counter(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    CountAllRequests.counter(req, resp);

    Integer counter = (Integer) session.getAttribute("myRequest");
    if (counter == null) {
      counter = 0;
      session.setAttribute("myRequest", counter);
    }
    if (session.getAttribute("myRequest") == null) {
      counter = 1;
      session.setAttribute("myRequest", counter);
    } else {
      session.setAttribute("myRequest", ++counter);
    }

  }


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    Integer counter = (Integer) req.getSession().getAttribute("myRequest");
    if (counter == null) {
      counter = 0;
      req.getSession().setAttribute("myRequest", counter);
    }
    getServletContext().setAttribute("counter", req.getSession().getAttribute("myRequest"));
    req.getRequestDispatcher("/counter-my-request.jsp").forward(req, resp);
  }

}
