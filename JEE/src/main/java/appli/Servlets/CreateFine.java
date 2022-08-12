package appli.Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import appli.Javabeans.Policeman;
import appli.Javabeans.Vehicle;
import appli.Javabeans.Violation;

@WebServlet("/CreateFine")
public class CreateFine extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateFine() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
HttpSession session = request.getSession(false);
		
		Policeman policeman = (Policeman) session.getAttribute("ConnectedStaff");
		
		ArrayList<Vehicle> vehicles= Vehicle.findAll();
		ArrayList<Violation> violations= Violation.findAll();

		request.setAttribute("vehicles", vehicles);
		request.setAttribute("violations", violations);
		
		request.getRequestDispatcher("/WEB-INF/JSP/AddFine.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		doGet(request, response);
	}

}
