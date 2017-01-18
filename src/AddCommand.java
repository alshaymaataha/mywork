import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCommand implements CommandInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, String content) throws Exception  {
	    
		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    
		out.println("<!DOCTYPE html>");
        out.println("<html><head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
        out.println("<title>Hello</title></head>");
        out.println("<body>");
        out.println("<h1>Hello, I am inside test_1!</h1>");  // says Hello
        out.println("<h2> and here is the content:</h2>");  // says Hello
        out.println(content);
        out.println("<body style='background-color:#d3d3d3;'>");
        out.println("</body>");
        out.println("</html>");
		
	}


	


}
