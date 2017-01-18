import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandInterface {
	

	public void execute(HttpServletRequest request, HttpServletResponse response, String command) throws Exception;

}
