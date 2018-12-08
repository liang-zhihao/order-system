package application.controllerClass;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import application.dataClass.Db;
import application.frameClass.CustomerHomepageFrame;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SignInController {

    @FXML
    private Label lbPsw;

    @FXML
    private RadioButton raCus;

    @FXML
    private RadioButton raBus;

    @FXML
    private Label lbID;

    @FXML
    private Label labError;

    @FXML
    private JFXButton btRegister;

    @FXML
    private JFXButton btSignIn;

    @FXML
    private AnchorPane SignIn;

    @FXML
    private JFXTextField txID;

    @FXML
    private JFXPasswordField txPsw;

    public void selectRaCus() {
		raBus.setSelected(false);
		raCus.setSelected(true);

	}

	public void selectRaBus() {
		raCus.setSelected(false);
		raBus.setSelected(true);
	}

	public void btSign() {
		String name = txID.getText();
		String pwd = txPsw.getText();
		int flag = 0;
		String[] para = new String[2];
		System.out.println(name + " " + pwd);
		para[0] = name;
		para[1] = pwd;
		Db db = new Db();
		Object[] rs = null;
		if (raBus.isSelected()) {
			flag = 1;
			String sql = "Select count(*) from business where UserName =? and Password=?";
			QueryRunner qr = new QueryRunner();
			try {
				rs = qr.query(db.getConnection(), sql, para, new ArrayHandler());

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			flag = 2;
			String sql = "select count(*) from Customer where UserName =? and Password=?";
			QueryRunner qr = new QueryRunner();

			try {
				rs = qr.query(db.getConnection(), sql, para, new ArrayHandler());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// object对象 转成String 用tostring
		int a = Integer.parseInt(rs[0].toString());
		if(flag == 1) {
			if (a == 1) {
				
				new application.frameClass.ShopHomepageFrame();
				SignIn.setVisible(false);
				Stage stage = (Stage) btSignIn.getScene().getWindow();
				stage.close();
				labError.setVisible(false);
			} else {
				labError.setVisible(true);
				
			}
		}else if(flag == 2) {
			if (a == 1) {
				
				new CustomerHomepageFrame();
				SignIn.setVisible(false);
				Stage stage = (Stage) btSignIn.getScene().getWindow();
				stage.close();
				labError.setVisible(false);
			} else {
				labError.setVisible(true);
				
			}
		}
		

	}
	
	public void btRegister() {
		if (raBus.isSelected()) {
			new application.frameClass.BusinessRegisterFrame();
		} else {
			new application.frameClass.CusRegisterFrame();

		}
	}

}

