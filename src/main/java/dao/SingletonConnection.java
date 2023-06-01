package dao;
import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3305/DB_MVC", "root", "");
            System.out.println("Connection established successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("probleme ta3 connection bin phpmyadmin w eclipse");
        }
    }

    public static Connection getConnection() {
        return connection;
    }


	}

