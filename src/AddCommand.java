import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCommand implements CommandInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception  {
	    
		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    
		out.println("<!DOCTYPE html>");
        out.println("<html><head>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
        out.println("<title>Hello, World</title></head>");
        out.println("<body>");
        out.println("<h1>Hello,i am inside test_1!</h1>");  // says Hello
        out.println("<body style='background-color:#d3d3d3;'>");
        out.println("</body>");
        out.println("</html>");
		
        //return "success";
	}


	


}
