package MyServlet;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.GestionProduit;
import modele.produit;
import modele.utilisateur;
import dao.UTIL;
import dao.IUtilisateur;/**
 
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

       
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("loginn.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String L = request.getParameter("user");
	    System.out.println(L);

	    String p = request.getParameter("pw");
	    System.out.println(p);

	    utilisateur m1 = new utilisateur(L, p);
	    UTIL ut = new UTIL();
	    String result = "";

	    System.out.println(m1);

	    if (!ut.checkUser(m1)) {
	        result = "Please check your password";
	        System.out.println(result);
	        request.setAttribute("result", result);
	        request.getRequestDispatcher("error.html").forward(request, response);
	    } else {
	        utilisateur user = ut.getUtil(L);
	        if (user != null && user.getUser().equals("ameni@gmail.com") && user.getPw().equals("ameni80")) {
	            result = "Welcome " + L;
	            request.setAttribute("result", result);
	            request.setAttribute("user", L);
	            request.getRequestDispatcher("welcome.jsp").forward(request, response);
	        } else {

	            result = "Access denied";
	        	System.out.println(result);
	        	request.setAttribute("result", result);
	            request.getRequestDispatcher("error.html").forward(request, response);
	        }
	    }

	}
}

