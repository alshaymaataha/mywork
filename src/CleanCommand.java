import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CleanCommand implements CommandInterface{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response, String command) throws Exception {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		out.println("<!DOCTYPE html>");
        out.println("<html><head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
        out.println("<title>Hello, World</title></head>");
        out.println("<body>");
        out.println("<h1>Hello,i am inside test_2!</h1>");  // says Hello
        out.println("<body style='background-color:#d3d3d3;'>");
        out.println("</body>");
        out.println("</html>");
	}

}
