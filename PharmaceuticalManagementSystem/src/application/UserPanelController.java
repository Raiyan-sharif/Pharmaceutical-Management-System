package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class UserPanelController implements Initializable{
	
	@FXML
	private TableView<UserModel> table_view;
	
	@FXML
	private TableColumn<UserModel, Integer> col_id;
	@FXML
	private TableColumn<UserModel, String> col_name;
	@FXML
	private TableColumn<UserModel, String> col_emp_id;
	@FXML
	private TableColumn<UserModel, String> col_gender;
	@FXML
	private TableColumn<UserModel, String> col_roll;
	@FXML
	private TableColumn<UserModel, String> col_status;
	@FXML
	private TextField text_name;
	@FXML
	private TextField text_emp_id;
	@FXML
	private TextField text_gender;
	@FXML
	private TextField text_roll;
	@FXML
	private TextField text_status;
	@FXML
	private Button btn_insert;
	@FXML
	private Button btn_edit;
	@FXML
	private Button btn_select;
	@FXML
	private Button btn_delete;
	@FXML
	private Label msg;
	
	UserQuery query;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		query = new UserQuery();
		col_id.setCellValueFactory(new PropertyValueFactory<UserModel, Integer>("id"));
		col_name.setCellValueFactory(new PropertyValueFactory<UserModel, String>("name"));
		col_emp_id.setCellValueFactory(new PropertyValueFactory<UserModel, String>("emp_id"));
		col_gender.setCellValueFactory(new PropertyValueFactory<UserModel, String>("gender"));
		col_roll.setCellValueFactory(new PropertyValueFactory<UserModel, String>("roll"));
		col_status.setCellValueFactory(new PropertyValueFactory<UserModel, String>("status"));
		
		table_view.setItems(query.getUsers());
	}

}
