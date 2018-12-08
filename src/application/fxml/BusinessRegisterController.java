package application.fxml;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;

import application.dataClass.Db;
import application.frameClass.CustomerHomepageFrame;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;

import javafx.scene.control.PasswordField;

public class BusinessRegisterController {
	@FXML
	private AnchorPane RegisterAsBusiness;
	@FXML
	private Button btRegister;
	@FXML
	private TextField txUserName;
	@FXML
	private TextField txPhoneNum;
	@FXML
	private TextField txEmail;
	@FXML
	private Label lbUserName;
	@FXML
	private Label lbPsw;
	@FXML
	private Label lbConfirm;
	@FXML
	private Label lbPhoneNum;
	@FXML
	private Label lbEmail;
	@FXML
	private PasswordField txPsw;
	@FXML
	private PasswordField txPswConfirm;
	
	
}
