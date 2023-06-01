package dao;

import modele.produit;
import modele.utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UTIL implements IUtilisateur {

	@Override
	public boolean checkUser(utilisateur u) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE  username = ? AND password = ?");

			ps.setString(1, u.getUser());
			ps.setString(2, u.getPw());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("il existe dans database");
				return true;
			} else {
				System.out.println("il  n existe pas dans database");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public utilisateur ajouterUtilisateur(utilisateur u) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO user VALUES(?,?)");

			ps.setNString(1, u.getUser());
			ps.setNString(2, u.getPw());
			ps.executeUpdate();

			ps.close();
			System.out.println("done add taa3 user");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public utilisateur updateUtil(utilisateur u) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE user SET password = ? WHERE username = ?");

			ps.setString(1, u.getPw());
			ps.setString(2, u.getUser());

			int update = ps.executeUpdate();
			if (update > 0)
				System.out.println("Update successful for user: " + u.getUser());
			else
				System.out.println("Failed to update user: " + u.getUser());

			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return u;
	}

	@Override
	public void deleteUtil(String u) {
		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM user  WHERE username = ?");
			ps.setNString(1, u);
			int update = ps.executeUpdate();
			if (update > 0)
				System.out.println("delete avec succès ta3 user");
			else
				System.out.println("failed to delete ta3 user");
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public utilisateur getUtil(String u) {
		Connection conn = SingletonConnection.getConnection();
		utilisateur utilisateur = null;

		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE username=?");
			ps.setString(1, u);
			ResultSet resultSet = ps.executeQuery();

			if (resultSet.next()) {
				utilisateur = new utilisateur(resultSet.getString("username"), resultSet.getString("password"));
			}

			ps.close();
			System.out.println("done getUtil");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return utilisateur;
	}

	@Override
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
