package appli.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RedirectCollector")
public class RedirectCollector extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RedirectCollector() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//See Violation
		if (request.getParameter("ManageViolationAmount") != null) {
			response.sendRedirect("ListViolationCollector");
        }
		//See validated Fine
		if (request.getParameter("SeeValidatedFine") != null) {
			response.sendRedirect("ListValidatedFine");
        }
		//Modify amount
		if (request.getParameter("ModifyViolation") != null) {
			
			
			request.getRequestDispatcher("/WEB-INF/JSP/ModifyViolationCollector.jsp").forward(request,response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
