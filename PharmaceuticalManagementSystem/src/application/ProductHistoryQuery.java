package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductHistoryQuery {
Connection conn;
		
	
	public ProductHistoryQuery() {
		conn = DBConnector.connect();
	}
	
	public ObservableList<ProductHistory> getProducts(){
		ObservableList<ProductHistory> list = FXCollections.observableArrayList();
		try {
		
			ResultSet resultSet = conn.createStatement().executeQuery("select * from product_history");
			while(resultSet.next()) {
//				
				ProductHistory model = new ProductHistory(resultSet.getInt("product_history_id"),resultSet.getInt("product_id"),resultSet.getString("product_name"),resultSet.getInt("product_quantity"),resultSet.getString("customer_name"),resultSet.getString("customer_phone"),resultSet.getInt("total_price"));
				list.add(model);
			}
			System.out.print("ok");
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list;
		}
		
		
	}
	
public int addProductHistory(ProductHistory model) {
		
		String q = "INSERT INTO `product_history` (product_id, `product_name`, product_quantity, `customer_name`, `customer_phone`, total_price) VALUES(?,?,?,?,?,?)";
		
		try {
			PreparedStatement  statement = conn.prepareStatement(q);
			statement.setInt(1, model.getProduct_id());
			statement.setString(2, model.getProduct_name());
			statement.setInt(3, model.getProduct_quantity());
			statement.setString(4, model.getCustomer_name());
			statement.setString(5, model.getCustomer_phone());
			statement.setInt(6, model.getTotal_price());
			
			int result = statement.executeUpdate();
//			System.out.print(result);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			e.printStackTrace();
			return 0;
		}
		
		
	}
}
