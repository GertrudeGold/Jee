package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RedirectAdministrator")
public class RedirectAdministrator extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RedirectAdministrator() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("button1") != null) {
			response.sendRedirect("ListAccount");
        } 
		else if (request.getParameter("button2") != null) {
			response.sendRedirect("ListVehicle");
        } 
		else if (request.getParameter("button3") != null) {
			response.sendRedirect("ListViolation");
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
