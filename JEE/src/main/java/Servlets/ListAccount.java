package Servlets;

import java.io.IOException;



import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Javabeans.Collector;
import Javabeans.Policeman;
import Javabeans.BrigadeChief;
import Javabeans.Administrator;

@WebServlet("/ListAccount")
public class ListAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		
		Administrator admin = (Administrator) session.getAttribute("ConnectedStaff");
		
		ArrayList<Administrator> adAccounts= admin.getAdministrators();
		ArrayList<Collector> coAccounts= admin.getCollectors();
		ArrayList<Policeman> pmAccounts= admin.getPolicemans();
		ArrayList<BrigadeChief> bcAccounts= admin.getBrigadeChiefs();

		request.setAttribute("adAccounts", adAccounts);
		request.setAttribute("coAccounts", coAccounts);
		request.setAttribute("pmAccounts", pmAccounts);
		request.setAttribute("bcAccounts", bcAccounts);
		
		request.getRequestDispatcher("/WEB-INF/JSP/ListAccount.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
