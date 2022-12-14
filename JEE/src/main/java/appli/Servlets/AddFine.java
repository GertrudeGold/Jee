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
		request.getRequestDispatcher("/WEB-INF/JSP/FineAmount.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		Policeman connected = (Policeman) session.getAttribute("ConnectedStaff");
		
		//Get all parameter
		String[] idViolations = request.getParameterValues("idViolations"); 
		int idVehicle = Integer.valueOf(request.getParameter("vehicleType"));
		String plate = request.getParameter("plateNumber");
		String lastname = request.getParameter("lastname");
		String firstname = request.getParameter("firstname");
		String commentary = request.getParameter("commentary");
		boolean flag = false;
		
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
			for(int i = 0; i<idViolations.length;i++) 
			{
				if(violation.getType().equals(idViolations[i]))
				{
					if(violation.getId() == 1) {
						flag = true;
					}
					violationFine.add(violation);
				}
			}
		}
		
		//verify if lack of insurance has been checked
		if(flag == false){
			//not check
			Plate plateFine = Plate.findIfAPlateExist(plate);
			if(plateFine == null) 
			{
				//if not set by default on undefined
				Plate plateFineUndefined = new Plate(1, "undefined");
				//Add Lack of insurance in the fine violation
				for(Violation violation_ : violations) 
				{
					if(violation_.getId() == 1)
						violationFine.add(violation_);
				}
				
				Fine fine = new Fine(vehicleFine, plateFineUndefined, date, firstname, lastname, commentary, connected, 0, violationFine);
				fine.insert(fine);
				
				//Total Amount
				double totalAmount = 0;
				for(Violation violation : violationFine) {
					totalAmount += violation.getPrice();
				}
				request.setAttribute("Total", totalAmount);
				request.setAttribute("lastname", lastname);
				request.setAttribute("firstname", firstname);
				String message = "This person is in lake of insurance, the violation has been had to the total and to the fine.";
				request.setAttribute("lackInsurance", message);
				
			}
			else{
				Fine fine = new Fine(vehicleFine, plateFine, date, firstname, lastname, commentary, connected, 0, violationFine);
				fine.insert(fine);
				
				//Total Amount
				double totalAmount = 0;
				for(Violation violation : violationFine) {
					totalAmount += violation.getPrice();
				}
				request.setAttribute("Total", totalAmount);
				request.setAttribute("lastname", lastname);
				request.setAttribute("firstname", firstname);
				String message = "This person is in order of insurance";
				request.setAttribute("lackInsurance", message);
				
				}
			}
		else {
			//check
			Plate plateFineUndefined = new Plate(1, "undefined");
			Fine fine = new Fine(vehicleFine, plateFineUndefined, date, firstname, lastname, commentary, connected, 0, violationFine);
			fine.insert(fine);
			
			//Total Amount
			double totalAmount = 0;
			for(Violation violation : violationFine) {
				totalAmount += violation.getPrice();
			}
			request.setAttribute("Total", totalAmount);
			request.setAttribute("lastname", lastname);
			request.setAttribute("firstname", firstname);
			String message = "This person is in lake of insurance.";
			request.setAttribute("lackInsurance", message);
		}

		doGet(request, response);
	}

}
