package application;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.control.PasswordField;

public class LoginController implements Initializable{
	@FXML
	private PasswordField password;
	@FXML
	private TextField name;
	@FXML
	private Label msg;
	
	Connection conn;
	LoginModel model;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model = new LoginModel();
		
	}
	
	public void login(ActionEvent event) {
		if(model.isLogin(name.getText(), password.getText())) {
			msg.setText("Login Successful");
			
			((Node) event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
				try {
//					BorderPane root = new BorderPane();
					Parent root = FXMLLoader.load(getClass().getResource("UserPanel.fxml"));
					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setScene(scene);
					primaryStage.show();
				} catch(Exception e) {
					e.printStackTrace();
				}
			
		}
		else {
			msg.setText("Login Failed");
		}
	}

}
