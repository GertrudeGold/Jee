package appli.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import appli.Javabeans.Staff;
import appli.Javabeans.Vehicle;
import appli.Javabeans.Violation;

@WebServlet("/RedirectAdministrator")
public class RedirectAdministrator extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RedirectAdministrator() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		//Account Side
		if (request.getParameter("ManageAccount") != null)
			response.sendRedirect("ListAccount");
		
		if (request.getParameter("ModifyAccount") != null) {
			//Staff staff=(Staff) session.getAttribute("ConnectedStaff");
			response.sendRedirect("");
		}
			
		if (request.getParameter("DeleteAccount") != null) {
			response.sendRedirect("");
		}
		
		if (request.getParameter("CreateAccount") != null) {		
			request.getRequestDispatcher("/WEB-INF/JSP/AddAccount.jsp").forward(request,response);
		}
		
		//Vehicle Side
		if (request.getParameter("ManageVehicle") != null)
			response.sendRedirect("ListVehicle");
		
		if (request.getParameter("ModifyVehicle") != null) {
			
			response.sendRedirect("");
		}
			
		if (request.getParameter("DeleteVehicle") != null) {
			response.sendRedirect("");
		}
		
		if (request.getParameter("CreateVehicle") != null) {		
			request.getRequestDispatcher("/WEB-INF/JSP/AddVehicle.jsp").forward(request,response);
		}
		
		
		//Account Side
		if (request.getParameter("ManageViolation") != null)
			response.sendRedirect("ListViolation");
		
		if (request.getParameter("ModifyViolation") != null) {
			
			response.sendRedirect("");
		}
			
		if (request.getParameter("DeleteViolation") != null) {
			response.sendRedirect("");
		}
		
		if (request.getParameter("CreateViolation") != null) {		
			request.getRequestDispatcher("/WEB-INF/JSP/AddViolation.jsp").forward(request,response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
