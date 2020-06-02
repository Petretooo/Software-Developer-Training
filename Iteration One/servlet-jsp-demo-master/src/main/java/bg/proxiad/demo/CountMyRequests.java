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

  public static Integer counter = 0;
  public static Integer countAllReq = 0;
  public static HttpSession session;

  protected static void counter(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    session = req.getSession();

    CountAllRequests.counter(req, resp);

    counter = (Integer) session.getAttribute("myRequest");
    if (counter == null) {
      counter = 0;
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
    getServletContext().setAttribute("counter", counter);
    req.getRequestDispatcher("/counter-my-request.jsp").forward(req, resp);
  }

}
