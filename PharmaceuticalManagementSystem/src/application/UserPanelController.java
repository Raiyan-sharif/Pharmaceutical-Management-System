package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
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
	private TableColumn<UserModel, String> col_password;
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
	private TextField text_password;
	@FXML
	private TextField text_emp_id;
	@FXML
	private TextField text_gender;
	@FXML
	private TextField text_roll;
	@FXML
	private TextField text_status;
	@FXML
	private TextField text_id;
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
		col_password.setCellValueFactory(new PropertyValueFactory<UserModel, String>("password"));
		col_emp_id.setCellValueFactory(new PropertyValueFactory<UserModel, String>("emp_id"));
		col_gender.setCellValueFactory(new PropertyValueFactory<UserModel, String>("gender"));
		col_roll.setCellValueFactory(new PropertyValueFactory<UserModel, String>("roll"));
		col_status.setCellValueFactory(new PropertyValueFactory<UserModel, String>("status"));
		
		table_view.setItems(query.getUsers());
	}
	
	public void insertUser(ActionEvent e) {
		UserModel model = new UserModel(0,text_name.getText(), text_password.getText(),text_emp_id.getText(),text_gender.getText(),text_roll.getText(),text_status.getText());
		int count = query.addUsers(model);
		msg.setText("New User Added");
		refreshTable();
		
	}
	public void selectUser(ActionEvent e) {
		UserModel model = table_view.getSelectionModel().getSelectedItem();
		text_id.setText(Integer.toString(model.getId()));
		text_name.setText(model.getName());
		text_password.setText(model.getPassword());
		text_emp_id.setText(model.getEmp_id());
		text_gender.setText(model.getGender());
		text_roll.setText(model.getRoll());
		text_status.setText(model.getStatus());
		
	}
	public void editUser(ActionEvent e) {
//		System.out.print(Integer.parseInt(text_id.getText()));
		UserModel model = new UserModel(Integer.parseInt(text_id.getText()),text_name.getText(), text_password.getText(),text_emp_id.getText(),text_gender.getText(),text_roll.getText(),text_status.getText());
		int count = query.editUsers(model);
		msg.setText(text_name.getText()+" User Updated"+count);
		refreshTable();
		
	}
	public void deleteUser(ActionEvent e) {
		int id = table_view.getSelectionModel().getSelectedItem().getId();
//		System.out.print(id);
		int count = query.deleteUsers(id);
		msg.setText(" User Deleted "+count);
		refreshTable();
		
	}
	public void refreshTable() {
		table_view.setItems(query.getUsers());
		text_id.clear();
		text_name.clear();
		text_password.clear();
		text_emp_id.clear();
		text_gender.clear();
		text_roll.clear();
		text_status.clear();
	}

}
