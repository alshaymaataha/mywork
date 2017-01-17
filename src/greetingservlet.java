import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * This is a simple example of an HTTP Servlet.  It responds to the GET
 * method of the HTTP protocol.
 * @WebServlet annotation that specifies the URL pattern, relative to the context root:
 */
@WebServlet("/hello/greeting")
public class greetingservlet extends HttpServlet {
    @Override
    public void doGet (HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        
    	response.setContentType("text/html");
        response.setBufferSize(8192);

        PrintWriter out = response.getWriter();

        // then write the data of the response
        out.println("<html>" + "<head><title>Servlet Hello</title></head>");

        // then write the data of the response
                out.println("<center>");
        		out.println("<body  bgcolor=\"#ffffff\">");
        		out.println("<img src='" + request.getContextPath() + "/web/unnamed.png' alt='image' align='middle'");
        		out.println("<br>");
        		out.println("<h2>Hello, what do you want to add to the content</h2>");
        	    out.println("<form method=\"get\">");
        	    out.println( "<input type=\"text\" name=\"addedContent\" size=\"25\">");
        	    out.println("<p></p>" + "<input type=\"submit\" value=\"Add to the conntent\">");
        	    //out.println("<input type=\"reset\" value=\"Reset\">" );
        	    out.println("</form>");
        	    out.println("</center>");
       
        String addedContent = request.getParameter("addedContent");

        if ((addedContent != null) && (addedContent.length() > 0)) 
        {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/hello/response");

            if (dispatcher != null) {
                dispatcher.include(request, response);
            }
        }

        out.println("</body></html>");
        out.close();
    }

    @Override
    public String getServletInfo() {
        return "The Hello servlet says hello.";
    }
}
