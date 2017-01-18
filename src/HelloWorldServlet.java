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
		CommandMap.put("test_2", new CleanCommand());
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
      String pathinfo = request.getPathInfo(); //will return /test_1 or test_1/x1  if exist.
      String uriwithoutcontextpath=uri.substring(request.getContextPath().length()); //will return hello/test_1
      String content= null;   // all what will be after test_1/.......
      String commandkey;
      //CommandInterface command;
      
     
      if (pathinfo==null)
      {
	      // Write the response message, in an HTML page	 
         out.println("<!DOCTYPE html>");
         out.println("<html><head>");
         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
         out.println("<title>Hello, World</title></head>");
         out.println("<body>");
         out.println("<center>");
         out.println("<b>");
         out.println("<font size=20 color= 'red'>Hello Java, Hello Linux!</font>");
         out.println("</b>");
         //out.println("<body style='background-color:#d3d3d3;'>"); 
         out.println("<img src='" + request.getContextPath() + "/web/java-image.jpg' alt='image'");
         out.println("</center>");
         //out.println(pathinfo);
         //out.println(pathinfo.lastIndexOf("/"));
         //out.println(pathinfo.substring(1,pathinfo.lastIndexOf("/")));
         out.println("</body>");
         out.println("</html>");
      }
      else
      {
    	  if (pathinfo.lastIndexOf("/")==0)   //in case of /test_1
    	  {
    		  commandkey = pathinfo.substring(1); 
    		  content=null;
    	  }
    	  else                                    // in case of /test_1/xxxxxxxxxx
    	  {
    		  commandkey=pathinfo.substring(1,pathinfo.lastIndexOf("/"));
    		  content=pathinfo.substring(pathinfo.lastIndexOf("/")+1);
    	  }
	      
	      CommandInterface command = CommandMap.get(commandkey);
	      try {
	    	
			   command.execute(request, response, content);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
    
      
   }
   
}

