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
import Javabeans.Vehicle;

@WebServlet("/ListVehicle")
public class ListVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListVehicle() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		
		Administrator admin = (Administrator) session.getAttribute("ConnectedStaff");
		ArrayList<Vehicle> vehicles = admin.getVehicles();
		
		request.setAttribute("vehicles", vehicles);
		
		request.getRequestDispatcher("/WEB-INF/JSP/ListVehicle.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
