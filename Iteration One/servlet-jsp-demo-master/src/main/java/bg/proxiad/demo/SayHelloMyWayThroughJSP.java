package bg.proxiad.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/say-hello-my-way-through-jsp?name=Major Tom")
public class SayHelloMyWayThroughJSP extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    CountMyRequests.counter(req, resp);
    req.setAttribute("greet", getInitParameter("greet"));

    req.getRequestDispatcher("/hello-my-way.jsp").forward(req, resp);
  }

}
