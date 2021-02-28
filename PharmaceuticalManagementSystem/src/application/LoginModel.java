package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class LoginModel {
	Connection conn;
	
	public LoginModel() {
		conn = DBConnector.connect();
	}
	public boolean isLogin(String username, String password){
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		String query = "select * from user where name = ? and password = ?";
		try {
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			resultset = preparedStatement.executeQuery();
			if(resultset.next()) {
				return true;
			}
			
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				preparedStatement.close();
				resultset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}
}
