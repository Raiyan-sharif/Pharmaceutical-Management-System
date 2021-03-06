package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
				UserModel model = new UserModel(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("password"), resultSet.getString("emp_id"),resultSet.getString("gender"),resultSet.getString("roll"),resultSet.getString("status"));
				list.add(model);
			}
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list;
		}
		
		
	}
	
	public int addUsers(UserModel model) {
		
		String q = "INSERT INTO `user` (`name`,`password`,`emp_id`,`gender`,`roll`,`status`) VALUES(?,?,?,?,?,?)";
		
		try {
			PreparedStatement  statement = conn.prepareStatement(q);
			statement.setString(1, model.getName());
			statement.setString(2, model.getPassword());
			statement.setString(3, model.getEmp_id());
			statement.setString(4, model.getGender());
			statement.setString(5, model.getRoll());
			statement.setString(6, model.getStatus());
			
			int result = statement.executeUpdate();
			
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
	}
	public int editUsers(UserModel model) {
		String q = "UPDATE `user` SET `name`= ?, `password`= ?, `emp_id`= ?, `gender`= ?, `roll`= ?, `status`= ? WHERE `id`= ?";
		
		
		try {
			PreparedStatement  statement = conn.prepareStatement(q);
//			System.out.print("My id is "+model.getId());
			statement.setString(1, model.getName());
			statement.setString(2, model.getPassword());
			statement.setString(3, model.getEmp_id());
			statement.setString(4, model.getGender());
			statement.setString(5, model.getRoll());
			statement.setString(6, model.getStatus());
			statement.setInt(7, model.getId());
			
			int result = statement.executeUpdate();
			System.out.println(result);
			
			return result;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return 0;
		}
	}
	public int deleteUsers(int id) {
		String q = "DELETE FROM `user` WHERE `id`= ?";
		
		
		try {
			PreparedStatement  statement = conn.prepareStatement(q);
			
			statement.setInt(1, id);
			
			int result = statement.executeUpdate();
//			System.out.println(result);
			
			return result;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return 0;
		}
	}
	
	
	
	
}
