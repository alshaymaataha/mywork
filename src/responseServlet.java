import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * This is a simple example of an HTTP Servlet.  It responds to the GET
 * method of the HTTP protocol.
 */
@WebServlet("/hello/response")
public class responseServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        // then write the data of the response
        String addedContent = request.getParameter("addedContent");

        if ((addedContent != null) && (addedContent.length() > 0)) {
            out.println("<h2>" + addedContent + " added to the content!</h2>");
        }
    }

    @Override
    public String getServletInfo() {
        return "The Response servlet says hello.";
    }
}
