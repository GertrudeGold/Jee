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
import appli.Javabeans.Vehicle;

@WebServlet("/ModifyVehicle")
public class ModifyVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModifyVehicle() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("ListVehicle");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);
		Administrator connected = (Administrator) session.getAttribute("ConnectedStaff");
		Vehicle oldVehicle = (Vehicle)request.getAttribute("vehicle");
		
		String type = request.getParameter("type");
		
		ArrayList<Vehicle> vehicles = connected.getVehicles();
		for(Vehicle vehicle : vehicles) {
			if(vehicle.getType().equals(oldVehicle.getType())) {
				vehicle.setType(type);
		    	vehicle.update(vehicle);	
			}
		}
		
		doGet(request, response);
	}

}
