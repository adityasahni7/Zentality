import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// Check if the username and password are valid (e.g. compare against a database)
		boolean isValid = true; // replace with your own validation logic
		
		if (isValid) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html><body><h1>Welcome, " + username + "!</h1></body></html>");
		} else {
			response.sendRedirect("index.html");
		}
	}
}
