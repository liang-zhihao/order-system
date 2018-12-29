package application.controllerClass;

import java.sql.SQLException;
import java.util.Random;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import application.dataClass.Db;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class CusRegisterController {

	@FXML
	private Label lbPsw;

	@FXML
	private JFXButton btRegister;

	@FXML
	private AnchorPane RegisterAsCustomer;

	@FXML
	private JFXPasswordField txPswConfirm;

	@FXML
	private Label lbErrorUserName;

	@FXML
	private Label lbEmail;


	public void initialize() {
		// NowInf.setPicView(imgUser, "icon/user.png");
		// NowInf.setPicView(imgNick, "icon/user.png");
		// NowInf.setPicView(imgPass, "icon/password.png");
		// NowInf.setPicView(imgCon, "icon/password.png");
		// NowInf.setPicView(imgEmail, "icon/email.png");
		// NowInf.setPicView(imgPhone, "icon/phone.png");

	}

	public void btRegister() throws SQLException {
		String UserName = txUserName.getText();
		String Psw = txPsw.getText();
		String PswConfirm = txPswConfirm.getText();
		String Nickname = txNickname.getText();
		String PhoneNum = txPhoneNum.getText();
		String Email = txEmail.getText();
		String Bio = txBio.getText();
		Random randomID = new Random();
		int ID = randomID.nextInt(99999) - 10;

		if (UserName.equals(null)) {
			lbErrorUserName.setVisible(true);
		}

		Db db = new Db();
		Object[] result = null;
		String sql1 = "Select count(*) from Customer where UserName = ?";
		QueryRunner qr = new QueryRunner();
		result = qr.query(db.getConnection(), sql1, UserName, new ArrayHandler());
		int a = Integer.parseInt(result[0].toString());
		if (a == 0) {
			if (Psw.equals(PswConfirm)) {
				// result = qr.query(db.getConnection(), sql2, para, new ArrayHandler());
				qr.update(db.getConnection(),
						"Insert into Customer (CustomerID, UserName, Password, Nickname, PhoneNumber, Email, Bio) "
								+ "values(?, ?, ?, ?, ?, ?, ?)",
						ID, UserName, Psw, Nickname, PhoneNum, Email, Bio);

				System.out.println("Registration Successful");
				lbErrorPassword.setVisible(false);
				lbErrorUserName2.setVisible(false);
			} else {
				lbErrorPassword.setVisible(true);
			}
		} else {
			lbErrorUserName2.setVisible(true);
		}
	}

}
