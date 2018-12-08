package application.controllerClass;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;

import com.jfoenix.controls.JFXButton;

import application.dataClass.Db;
import application.frameClass.CustomerHomepageFrame;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
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
	private TextField txID;

	@FXML
	private PasswordField txPsw;

	@FXML
	private AnchorPane pane;

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
		// object���� ת��String ��tostring
		int a = Integer.parseInt(rs[0].toString());
		if (flag == 1) {
			if (a == 1) {
				System.out.println("��¼�ɹ�");
				new application.frameClass.ShopHomepageFrame();

				Stage stage = (Stage) btSignIn.getScene().getWindow();
				stage.close();
				labError.setVisible(false);
			} else {
				labError.setVisible(true);
				System.out.println("��¼ʧ��");
			}
		} else if (flag == 2) {
			if (a == 1) {
				System.out.println("��¼�ɹ�");
				new CustomerHomepageFrame();

				Stage stage = (Stage) btSignIn.getScene().getWindow();
				stage.close();
				labError.setVisible(false);
			} else {
				labError.setVisible(true);
				System.out.println("��¼ʧ��");
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
