package appli.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RedirectPoliceman")
public class RedirectPoliceman extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RedirectPoliceman() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//HOME
		if (request.getParameter("Home") != null)
			request.getRequestDispatcher("/WEB-INF/JSP/HomePoliceman.jsp").forward(request,response);
		
		if (request.getParameter("CreateFine") != null) {
			response.sendRedirect("CreateFine");
        }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
