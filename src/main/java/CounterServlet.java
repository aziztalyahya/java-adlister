import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CounterServlet", urlPatterns = "/count")
public class CounterServlet extends HttpServlet {
    private int counter = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        counter += 1;
        // setAttribute sends in an object into the view
        request.setAttribute("count", counter);

        // Render the .jsp and give the .jsp access to the set attribute
        request.getRequestDispatcher("WEB-INF/counter.jsp").forward(request, response);

        //response.getWriter().println("<h1>The count is " + counter + ".</h1>");
    }
}
