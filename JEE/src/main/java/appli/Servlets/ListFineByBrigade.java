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
import appli.Javabeans.Fine;

@WebServlet("/ListFineByBrigade")
public class ListFineByBrigade extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListFineByBrigade() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		
		BrigadeChief connected = (BrigadeChief) session.getAttribute("ConnectedStaff");
		ArrayList<Fine> fines = connected.getFines();
		
		request.setAttribute("fines", fines);
		
		request.getRequestDispatcher("/WEB-INF/JSP/ListFineByBrigade.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
