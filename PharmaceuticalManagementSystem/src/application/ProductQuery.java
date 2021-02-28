package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductQuery {
	Connection conn;
		
	
	public ProductQuery() {
		conn = DBConnector.connect();
	}
	
	public ObservableList<productModel> getProducts(){
		ObservableList<productModel> list = FXCollections.observableArrayList();
		try {
		
			ResultSet resultSet = conn.createStatement().executeQuery("select * from `product`");
			while(resultSet.next()) {
				productModel model = new productModel(resultSet.getInt("product_id"),resultSet.getString("product_name"),resultSet.getInt("product_quantity"),resultSet.getInt("product_price"));
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
}
