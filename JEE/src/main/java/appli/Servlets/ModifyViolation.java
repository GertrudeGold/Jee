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
import appli.Javabeans.Violation;

@WebServlet("/ModifyViolation")
public class ModifyViolation extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModifyViolation() {
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
		Violation oldViolation = (Violation)request.getAttribute("vehicle");
		
		String type = request.getParameter("type");
		double amount = Double.valueOf(request.getParameter("amount"));
		
		ArrayList<Violation> violations = connected.getViolations();
		for(Violation violation : violations) {
			if(violation.getType().equals(oldViolation.getType())) {
				violation.setType(type);
				violation.setPrice(amount);
		    	violation.update(violation);	
			}
		}
		
		doGet(request, response);
	}

}
