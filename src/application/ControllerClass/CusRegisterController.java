package application.ControllerClass;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CusRegisterController {
	@FXML
	private AnchorPane RegisterAsCustomer;
	@FXML
	private TextField txEmail;
	@FXML
	private TextField txPhoneNum;
	@FXML
	private PasswordField lbPawConfirm;
	@FXML
	private PasswordField txPsw;
	@FXML
	private TextField txUserName;
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
	private Button btRegister;

}
