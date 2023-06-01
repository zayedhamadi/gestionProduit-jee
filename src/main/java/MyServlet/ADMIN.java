package MyServlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import modele.utilisateur;
import dao.SingletonConnection;
import dao.UTIL;
import java.util.*;

/**
 * Servlet implementation class ADMIN
 */
@WebServlet("/ADMIN")
public class ADMIN extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ADMIN() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        List<utilisateur> listUtil = FindAllUtil();


        System.out.println("List of util retrieved: " + listUtil);

        
        request.setAttribute("listUtil", listUtil);



        request.getRequestDispatcher("utilList.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

	public List<utilisateur> FindAllUtil() {
		Connection conn = SingletonConnection.getConnection();

		List<utilisateur> listUtil = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM user");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				utilisateur u = new utilisateur(rs.getString("username"), rs.getString("password"));
				listUtil.add(u);
			}

			ps.close();
			rs.close();
			System.out.println("done find all");
		} catch (SQLException e) {
			System.out.println("probleme ta3 find all ta3 listUtil");
			e.printStackTrace();
		}

		return listUtil;

	}

}
