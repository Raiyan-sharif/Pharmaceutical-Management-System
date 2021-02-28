package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserQuery {
	Connection conn;
	
	
	public UserQuery() {
		conn = DBConnector.connect();
	}
	
	public ObservableList<UserModel> getUsers(){
		ObservableList<UserModel> list = FXCollections.observableArrayList();
		try {
			ResultSet resultSet = conn.createStatement().executeQuery("select * from user");
			while(resultSet.next()) {
				UserModel model = new UserModel(resultSet.getInt("id"),resultSet.getString("name"), resultSet.getString("emp_id"),resultSet.getString("gender"),resultSet.getString("roll"),resultSet.getString("status"));
				list.add(model);
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list;
		}
		
		
	}
	
	public int addUsers() {
		return 0;
	}
	public int editUsers() {
		return 0;
	}
	public int deleteUsers() {
		return 0;
	}
	
	
	
	
}
