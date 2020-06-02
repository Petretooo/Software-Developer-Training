package bg.proxiad.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/say-hello-my-way?name=Major Tom")
public class SayHelloMyWay extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    CountMyRequests.counter(req, resp);

    String greeting = getInitParameter("greet");
    String name = req.getParameter("name");

    resp.getWriter().write("<h1>" + greeting + " " + name + "</h1>");


    // RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/hello-my-way.jsp");
    // dispatcher.forward(req, resp);
  }

}
