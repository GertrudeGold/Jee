package appli.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import appli.Javabeans.Vehicle;


@WebServlet("/AddVehicle")
public class AddVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddVehicle() {
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
		Vehicle vehicle = new Vehicle(type);
		vehicle.update(vehicle);
		
		doGet(request, response);
	}

}
