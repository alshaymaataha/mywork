import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.sun.org.apache.xalan.internal.xsltc.dom.Filter;

public class UrlRewriteFilter implements Filter {

    public void init (FilterConfig config) throws ServletException {
        //
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String requestURI = request.getRequestURI();

        if (requestURI.startsWith("/hello/test_1/")) {
            String toReplace = requestURI.substring(requestURI.indexOf("/test_1"), requestURI.lastIndexOf("/") + 1);
            String newURI = requestURI.replace(toReplace, "?addedContent=");
            req.getRequestDispatcher(newURI).forward(req, res);
        } else {
            chain.doFilter(req, res);
        }
    }
    
    public void destroy() {
        //
    }

	@Override
	public boolean test(int node) {
		// TODO Auto-generated method stub
		return false;
	}
}
