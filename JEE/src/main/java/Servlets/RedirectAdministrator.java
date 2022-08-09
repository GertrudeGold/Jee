package Servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Javabeans.Administrator;
import Javabeans.Collector;
import Javabeans.BrigadeChief;
import Javabeans.Policeman;
import Javabeans.Staff;
import Javabeans.Vehicle;
import Javabeans.Violation;

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
		//SELECT
		if (request.getParameter("ManageAccount") != null)
			response.sendRedirect("ListAccount");
		//UPDATE
		if (request.getParameter("ModifyAccount") != null) {
			Staff account = (Staff)request.getAttribute("account");	
			request.setAttribute("account", account);
			request.getRequestDispatcher("/WEB-INF/JSP/ModifyAccount.jsp").forward(request,response);
		}
		
		//DELETE
		if (request.getParameter("DeleteAccount") != null) {
			Object account = request.getParameter("DeleteAccount");
			if(account instanceof Administrator)
				((Staff) account).delete((Staff) account);
			
			if(account instanceof Collector)
				((Staff) account).delete((Staff) account);
			
			if(account instanceof BrigadeChief)	
				((Staff) account).delete((Staff) account);
			
			if(account instanceof Policeman)
				((Staff) account).delete((Staff) account);
			
			request.getRequestDispatcher("/WEB-INF/JSP/HomeAministrator.jsp").forward(request,response);
		}
		//INSERT
		if (request.getParameter("CreateAccount") != null) {		
			request.getRequestDispatcher("/WEB-INF/JSP/AddAccount.jsp").forward(request,response);
		}
		
		//Vehicle Side
		//SELECT
		if (request.getParameter("ManageVehicle") != null)
			response.sendRedirect("ListVehicle");
		
		//UPDATE
		if (request.getParameter("ModifyVehicle") != null) {
			Vehicle vehicle = (Vehicle)request.getAttribute("vehicle");
			request.setAttribute("vehicle", vehicle);
			request.getRequestDispatcher("/WEB-INF/JSP/ModifyVehicle.jsp").forward(request,response);
		}
		
		//DELETE	
		if (request.getParameter("DeleteVehicle") != null) {
			//Vehicle vehicle = request.getParameter("DeleteVehicle");
			//vehicle.delete(vehicle);
			request.getRequestDispatcher("/WEB-INF/JSP/HomeAministrator.jsp").forward(request,response);
		}
		
		//INSERT
		if (request.getParameter("CreateVehicle") != null) {		
			request.getRequestDispatcher("/WEB-INF/JSP/AddVehicle.jsp").forward(request,response);
		}
		
		
		//Violation Side
		//SELECT
		if (request.getParameter("ManageViolation") != null)
			response.sendRedirect("ListViolation");
		
		//UPDATE
		if (request.getParameter("ModifyViolation") != null) {
			Violation violation = (Violation)request.getAttribute("violation");
			request.setAttribute("violation", violation);
			request.getRequestDispatcher("/WEB-INF/JSP/ModifyViolation.jsp").forward(request,response);
		}
		
		//DELETE	
		if (request.getParameter("DeleteViolation") != null) {
			//Violation violation = request.getParameter("DeleteViolation");
			//violation.delete(violation);
			request.getRequestDispatcher("/WEB-INF/JSP/HomeAministrator.jsp").forward(request,response);
		}
		
		//INSERT
		if (request.getParameter("CreateViolation") != null) {		
			request.getRequestDispatcher("/WEB-INF/JSP/AddViolation.jsp").forward(request,response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
