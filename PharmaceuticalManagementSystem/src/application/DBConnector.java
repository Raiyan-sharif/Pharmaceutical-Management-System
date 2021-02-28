package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	//For SQLite
//	public static Connection connect() {
//		try {
//			Class.forName("org.sqlite.JDBC");
//			Connection connection = DriverManager.getConnection("jdbc:sqlite:pharmacy.db");
//			return connection;
//		} catch (ClassNotFoundException |SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//	}
	//For MySQL
	public static Connection connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/pharmacy","root","");
			return connection;
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
