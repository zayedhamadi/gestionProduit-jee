package MyServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.utilisateur;
import dao.UTIL;
import dao.IUtilisateur;
/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println(username);
        String password = request.getParameter("password");
        System.out.println(password);
        utilisateur user = new utilisateur(username, password);
        System.out.println(user);

        UTIL utilDao = new UTIL();
        utilDao.ajouterUtilisateur(user);

        response.sendRedirect("loginn.html");
    }
}
