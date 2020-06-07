package bg.proxiad.demo;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

@WebServlet("/say-hello-through-jsp")
public class SayHelloThroughJspServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    CountAllRequests.counter(req, resp);


    req.setAttribute("greeting", "Hello through JSP");
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/say-hello.jsp");
    dispatcher.forward(req, resp);

    // resp.getWriter().write("Say hello through jsp");
  }

}
