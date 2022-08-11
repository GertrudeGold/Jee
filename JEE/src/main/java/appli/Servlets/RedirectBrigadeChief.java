package appli.Servlets;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import appli.Javabeans.BrigadeChief;
import appli.Javabeans.Fine;

@WebServlet("/RedirectBrigadeChief")
public class RedirectBrigadeChief extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RedirectBrigadeChief() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		HttpSession session = request.getSession(false);
		BrigadeChief connected = (BrigadeChief) session.getAttribute("ConnectedStaff");
		
		
		//Will validate Fine
		if (request.getParameter("Validate") != null) {
			int id = Integer.valueOf(request.getParameter("idFine"));
			ArrayList<Fine> fines = connected.getFines();
			for(Fine fine:fines) {
				if(fine.getId() == id) {
					fine.update(fine);
					fines.remove(fine);
					response.sendRedirect("ListFineByBrigade");
				}
			}
			
        }
		//Will unvalidate Fine
		if (request.getParameter("Unvalidate") != null) {
			int id = Integer.valueOf(request.getParameter("idFine"));
			ArrayList<Fine> fines = connected.getFines();
			for(Fine fine:fines) {
				if(fine.getId() == id) {
					fine.delete(fine);
					fines.remove(fine);
					response.sendRedirect("ListFineByBrigade");
				}
			}	
        }
		
		if (request.getParameter("brigadeFine") != null) {
			response.sendRedirect("ListFineByBrigade");
        }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
