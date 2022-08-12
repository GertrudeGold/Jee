package appli.Servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import appli.Javabeans.Fine;
import appli.Javabeans.Plate;
import appli.Javabeans.Policeman;
import appli.Javabeans.Vehicle;
import appli.Javabeans.Violation;

@WebServlet("/AddFine")
public class AddFine extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddFine() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/JSP/HomePoliceman.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		Policeman connected = (Policeman) session.getAttribute("ConnectedStaff");
		
		int  idViolation = Integer.valueOf(request.getParameter("violationType"));
		int idVehicle = Integer.valueOf(request.getParameter("vehicleType"));
		String plate = request.getParameter("plateNumber");
		String lastname = request.getParameter("lastname");
		String firstname = request.getParameter("firstname");
		String commentary = request.getParameter("commentary");
		
		//Manage date
		Date date = null;
		String inputDate = request.getParameter("date");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
		try { 
			date = sdf.parse(inputDate);
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}
		
		//Manage vehicle
		Vehicle vehicleFine = new Vehicle();
		ArrayList<Vehicle> vehicles = Vehicle.findAll();
		for(Vehicle vehicle : vehicles) {
			if(vehicle.getId() == idVehicle){
				vehicleFine = vehicle;
			}
		}
		
		//Manage violation
		ArrayList<Violation> violationFine = new ArrayList<Violation>();
		ArrayList<Violation> violations = Violation.findAll();
		for(Violation violation : violations) {
			if(violation.getId() == idViolation){
				violationFine.add(violation);
			}
		}
		
		
		Plate plateFine = Plate.findIfAPlateExist(plate);
		
		
		Fine fine = new Fine(vehicleFine, plateFine, date, firstname, lastname, commentary, connected, 0, violationFine);
		fine.insert(fine);
		
		
		
		
		
		
		
		
		
		
		
		
		doGet(request, response);
	}

}
