package appli.Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import appli.Javabeans.Administrator;
import appli.Javabeans.BrigadeChief;
import appli.Javabeans.Collector;
import appli.Javabeans.Policeman;
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
		Administrator connected = (Administrator) session.getAttribute("ConnectedStaff");
		
		//Account Side
		//SELECT
		if (request.getParameter("ManageAccount") != null)
			response.sendRedirect("ListAccount");
		//UPDATE
		if (request.getParameter("ModifyAccount") != null) {
			String accountMatricule = request.getParameter("accountMatricule");
			if(accountMatricule.substring(0,2).equals("ad")) {
				ArrayList<Administrator> admins = connected.getAdministrators();
				for(Administrator admin: admins) {
					if(admin.getMatricule().equals(accountMatricule)) {
						request.setAttribute("account", admin);
					}	
				}
			}
			if(accountMatricule.substring(0,2).equals("co")) {
				ArrayList<Collector> collectors = connected.getCollectors();
				for(Collector collector: collectors) {
					if(collector.getMatricule().equals(accountMatricule)) {
						request.setAttribute("account", collector);
					}	
				}
			}
			if(accountMatricule.substring(0,2).equals("bc")) {
				ArrayList<BrigadeChief> chiefs = connected.getBrigadeChiefs();
				for(BrigadeChief chief: chiefs) {
					if(chief.getMatricule().equals(accountMatricule)) {
						request.setAttribute("account", chief);
					}	
				}
			}
			if(accountMatricule.substring(0,2).equals("pm")) {
				ArrayList<Policeman> policemans = connected.getPolicemans();
				for(Policeman policeman : policemans) {
					if(policeman.getMatricule().equals(accountMatricule)) {
						request.setAttribute("account", policeman);
					}	
				}
			}
			request.getRequestDispatcher("/WEB-INF/JSP/ModifyAccount.jsp").forward(request,response);
		}
		
		//DELETE
		if (request.getParameter("DeleteAccount") != null) {
			String accountMatricule = request.getParameter("accountMatricule");
			if(accountMatricule.substring(0,2).equals("ad")) {
				ArrayList<Administrator> admins = connected.getAdministrators();
				for(Administrator admin: admins) {
					if(admin.getMatricule().equals(accountMatricule)) {
						admin.delete(admin);
						admins.remove(admin);
						break;
					}	
				}
			}
			if(accountMatricule.substring(0,2).equals("co")) {
				ArrayList<Collector> collectors = connected.getCollectors();
				for(Collector collector: collectors) {
					if(collector.getMatricule().equals(accountMatricule)) {
						collector.delete(collector);
						collectors.remove(collector);
						break;
					}	
				}
			}
			if(accountMatricule.substring(0,2).equals("bc")) {
				ArrayList<BrigadeChief> chiefs = connected.getBrigadeChiefs();
				for(BrigadeChief chief: chiefs) {
					if(chief.getMatricule().equals(accountMatricule)) {
						chief.delete(chief);
						chiefs.remove(chief);
						break;
					}	
				}
			}
			if(accountMatricule.substring(0,2).equals("pm")) {
				ArrayList<Policeman> policemans = connected.getPolicemans();
				for(Policeman policeman : policemans) {
					if(policeman.getMatricule().equals(accountMatricule)) {
						policeman.delete(policeman);
						policemans.remove(policeman);
						break;
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
			String typeVehicle = request.getParameter("typeVehicle");
				ArrayList<Vehicle> vehicles = connected.getVehicles();
				for(Vehicle vehicle: vehicles) {
					if(vehicle.getType().equals(typeVehicle)) {
						request.setAttribute("vehicle", vehicle);
					}	
				}
			
			request.getRequestDispatcher("/WEB-INF/JSP/ModifyVehicle.jsp").forward(request,response);
		}
		
		//DELETE	
		if (request.getParameter("DeleteVehicle") != null) {
			String typeVehicle = request.getParameter("typeVehicle");
			ArrayList<Vehicle> vehicles = connected.getVehicles();
			for(Vehicle vehicle : vehicles) {
				if(vehicle.getType().equals(typeVehicle)) {
					vehicle.delete(vehicle);
			    	vehicles.remove(vehicle);
			    	break;
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
			String typeViolation = request.getParameter("typeViolation");
			ArrayList<Violation> violations = connected.getViolations();
			for(Violation violation : violations) {
				if(violation.getType().equals(typeViolation)) {
					request.setAttribute("violation", violation);
				}	
			}
			request.getRequestDispatcher("/WEB-INF/JSP/ModifyViolation.jsp").forward(request,response);
		}
		
		//DELETE	
		if (request.getParameter("DeleteViolation") != null) {
			String typeViolation = request.getParameter("typeViolation");
			ArrayList<Violation> violations = connected.getViolations();
			for(Violation violation : violations) {
				if(violation.getType().equals(typeViolation)) {
					violation.delete(violation);
					violations.remove(violation);
			    	break;
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
