package servlet;

import model.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Login extends HttpServlet{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,
                        HttpServletResponse response)
                        throws IOException, ServletException {
        //response.setContentType("text/html");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        User u = new User(username,password);
        String name=u.login();

        request.setAttribute("firstname", name);
        RequestDispatcher view = request.getRequestDispatcher("home.jsp");
        view.forward(request, response);
        
    }
}