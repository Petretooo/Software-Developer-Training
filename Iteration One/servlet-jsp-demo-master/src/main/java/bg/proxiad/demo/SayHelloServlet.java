package bg.proxiad.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/say-hello")
public class SayHelloServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // req.getRequestDispatcher("say-hello.jsp").forward(req, resp);
    CountAllRequests.counter(req, resp);

    resp.getWriter().write("<h1>Hello from Servlet!</h1>");
  }

}
