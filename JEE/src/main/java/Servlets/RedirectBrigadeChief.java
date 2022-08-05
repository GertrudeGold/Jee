package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Javabeans.BrigadeChief;

@WebServlet("/RedirectBrigadeChief")
public class RedirectBrigadeChief extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RedirectBrigadeChief() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (request.getParameter("button1") != null) {
			BrigadeChief chief = (BrigadeChief)session.getAttribute("ConnectedStaff");
			 chief.
			
			request.getRequestDispatcher("/WEB-INF/JSP/ListFineByBrigade.jsp").forward(request,response);
        } 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
