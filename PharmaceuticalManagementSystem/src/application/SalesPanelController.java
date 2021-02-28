package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class SalesPanelController implements Initializable {
	@FXML
	private TableView<productModel> tableview;
	@FXML
	private TableColumn<productModel, Integer> col_product_id;
	@FXML
	private TableColumn<productModel, String> col_product_name;
	@FXML
	private TableColumn<productModel, Integer> col_product_quantity;
	@FXML
	private TableColumn<productModel, Integer> col_product_price;
	@FXML
	private TextField text_product_id;
	@FXML
	private TextField text_product_name;
	@FXML
	private TextField text_product_quantity;
	@FXML
	private TextField text_total_price;
	@FXML
	private TextField text_customer_name;
	@FXML
	private TextField text_customer_phone;
	@FXML
	private Button btn_place_order;
	
	ProductQuery query;
	ProductHistoryQuery query2;
	int priceOfProduct;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		query = new ProductQuery();
//		col_id.setCellValueFactory(new PropertyValueFactory<UserModel, Integer>("id"));
		col_product_id.setCellValueFactory(new PropertyValueFactory<productModel, Integer>("product_id"));
		col_product_name.setCellValueFactory(new PropertyValueFactory<productModel, String>("product_name"));
		col_product_quantity.setCellValueFactory(new PropertyValueFactory<productModel, Integer>("product_quantity"));
		col_product_price.setCellValueFactory(new PropertyValueFactory<productModel, Integer>("product_price"));
		tableview.setItems(query.getProducts());
	}
	public void selectProduct(ActionEvent e) {
		productModel model = tableview.getSelectionModel().getSelectedItem();
		text_product_id.setText(Integer.toString(model.getProduct_id()));
		text_product_name.setText(model.getProduct_name());
		text_product_quantity.setText(Integer.toString(model.getProduct_quantity()));
		priceOfProduct = model.getProduct_price();
//		refreshTable();
		
	}
	public void calculate(ActionEvent e) {
		int quantity = Integer.parseInt(text_product_quantity.getText());
		int totalcost = quantity * priceOfProduct;
		text_total_price.setText(Integer.toString(totalcost));
	}
	
	public void refreshData(ActionEvent e) {
		tableview.setItems(query.getProducts());
	}
	public void placeOrder(ActionEvent e) {
//		tableview.setItems(query.getProducts());
//		private int product_history_id;	
//		private int product_id;	
//		private String product_name;	
//		private int product_quantity;	
//		private String customer_name;	
//		private String customer_phone;	
//		private int total_price;
		ProductHistory model = new ProductHistory(0,Integer.parseInt(text_product_id.getText()),text_product_name.getText(),Integer.parseInt(text_product_quantity.getText()),text_customer_name.getText(),text_customer_phone.getText(),Integer.parseInt(text_total_price.getText()));
		int count = query2.addProductHistory(model);
//		msg.setText("New User Added");
//		refreshTable();
		refreshTable();
	}
	public void refreshTable() {
		tableview.setItems(query.getProducts());
		text_product_id.clear();
		text_product_name.clear();
		text_product_quantity.clear();
		
	}

}
