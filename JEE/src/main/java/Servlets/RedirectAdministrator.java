package Servlets;

import java.io.IOException;
import java.util.ArrayList;

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
		Administrator connected = (Administrator) session.getAttribute("ConnectedStaff");
		
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
			Staff accountToDelete = (Staff)request.getAttribute("account");
			
			if(accountToDelete instanceof Administrator) {
				ArrayList<Administrator> admins = connected.getAdministrators();
				for(Administrator admin: admins) {
					if(admin.equals(accountToDelete)) {
						admin.delete(admin);
						admins.remove(admin);	
					}	
				}
			}
				
			if(accountToDelete instanceof Collector) {
				ArrayList<Collector> collectors = connected.getCollectors();
				for(Collector collector: collectors) {
					if(collector.equals(accountToDelete)) {
						collector.delete(collector);
						collectors.remove(collector);	
					}	
				}
			}
				
			if(accountToDelete instanceof Administrator) {
				ArrayList<BrigadeChief> chiefs = connected.getBrigadeChiefs();
				for(BrigadeChief chief: chiefs) {
					if(chief.equals(accountToDelete)) {
						chief.delete(chief);
						chiefs.remove(chief);	
					}	
				}
			}	
			
			if(accountToDelete instanceof Policeman) {
				ArrayList<Policeman> policemans = connected.getPolicemans();
				for(Policeman policeman: policemans) {
					if(policeman.equals(accountToDelete)) {
						policeman.delete(policeman);
						policemans.remove(policeman);	
					}	
				}
			}
					
			response.sendRedirect("ListAccount");
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
			Vehicle vehicleToDelete = (Vehicle) request.getAttribute("vehicle");
			ArrayList<Vehicle> vehicles = connected.getVehicles();
			for(Vehicle vehicle : vehicles) {
				if(vehicle.equals(vehicleToDelete)) {
					vehicle.delete(vehicle);
			    	vehicles.remove(vehicle);	
				}
			}
			response.sendRedirect("ListVehicle");
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
			Violation violationToDelete = (Violation) request.getAttribute("violation");
			ArrayList<Violation> violations = connected.getViolations();
			for(Violation violation : violations) {
				if(violation.equals(violationToDelete)) {
					violation.delete(violation);
					violations.remove(violation);	
				}
			}
			response.sendRedirect("ListViolation");
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
