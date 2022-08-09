package appli.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import appli.Javabeans.Vehicle;
import  appli.Javabeans.Violation;

@WebServlet("/AddViolation")
public class AddViolation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddViolation() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("ListVehicle");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		double amount = Double.valueOf(request.getParameter("amount"));
		Violation violation = new Violation(type, amount);
		violation.insert(violation);
		
		doGet(request, response);
	}

}
