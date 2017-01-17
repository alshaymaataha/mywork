import java.io.*;
import java.util.HashMap;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

 
@WebServlet("/hello/*")
public class HelloWorldServlet extends HttpServlet {
	
private HashMap<String,CommandInterface> CommandMap = new HashMap<String,CommandInterface>();
	
  public HelloWorldServlet()
	{
		CommandMap.put("test_1", new AddCommand());
	}
	
	public void init(ServletConfig config)throws ServletException
	{
		 //CommandMap.put("test_1", new AddCommand());
		 //put("Test_2", new CleanCommand());
	}
	
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
 
      String uri= request.getRequestURI();     // will return myservlet/hello/test_1  or myservlet/hello/test_1/x1
      String pathinfo = request.getPathInfo(); //will return test_1 or test_1/x1  if exist.
      String uriwithoutcontextpath=request.getRequestURI().substring(request.getContextPath().length()); //will return hello/test_1
      
      String CommandKey;
      
      if(pathinfo ==null)
      {
	      // Write the response message, in an HTML page	 
         out.println("<!DOCTYPE html>");
         out.println("<html><head>");
         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
         out.println("<title>Hello, World</title></head>");
         out.println("<body>");
         out.println("<h1>Hello,World!</h1>");  // says Hello
         out.println("<body style='background-color:#d3d3d3;'>");
         out.println("</body>");
         out.println("</html>");
         out.println(uri);
         out.println(pathinfo);
         out.println(uriwithoutcontextpath);
      } 
      else if (uriwithoutcontextpath.equals("/hello/test_1"))
      {
    	  CommandKey = "test_1";
          CommandInterface command = CommandMap.get(CommandKey);
          
          out.println("<!DOCTYPE html>");
          out.println("<html><head>");
          out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
          out.println("<title>Hello, from test_1</title></head>");
          out.println("<body>");
          out.println("<h1>Hello from test_1!</h1>");  // says Hello
          out.println("<body style='background-color:#d3d3d3;'>");
          out.println("</body>");
          out.println("</html>");
          
          for (String name: CommandMap.keySet()){

        	  String key =name.toString();
              String value = CommandMap.get(name).toString();  
              out.println(key + " " + value);  
      } 
          try {
    			/*String result =*/ command.execute(request, response);
    			//out.println(result);
    		 } 
          catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} 
      }
      else if (pathinfo.equals("/test_2"))
      {
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
   
}
