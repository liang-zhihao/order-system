package application.controllerClass;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import application.dataClass.Business;
import application.dataClass.Customer;
import application.dataClass.Db;
import application.dataClass.NowInf;
import application.frameClass.CustomerHomepageFrame;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SignInController {
	@FXML
	private ImageView imgPass;

	@FXML
	private ImageView imgUser;

	@FXML
	private Label lbPsw;

	@FXML
	private JFXRadioButton raCus;

	@FXML
	private JFXRadioButton raBus;

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

	public void initialize() {
		imgPass.setImage(new Image("application/fxml/img/icon/password.png"));

		imgUser.setImage(new Image("application/fxml/img/icon/user.png"));
	}

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
		Object[] para = new Object[2];
		System.out.println(name + " " + pwd);
		para[0] = name;
		para[1] = pwd;
		Db db = new Db();
		Object[] rs = null;
		QueryRunner qr = new QueryRunner();
		int a;
		try {
			if (raBus.isSelected()) {
				String sql2 = "Select * from Business where UserName =? and Password=?";
				String sql = "Select count(*) from business where UserName =? and Password=?";
				rs = qr.query(db.getConnection(), sql, para, new ArrayHandler());
				a = Integer.parseInt(rs[0].toString());
				if (a == 1) {
					NowInf.business = qr.query(db.getConnection(), sql2, para,
							new BeanHandler<Business>(Business.class));
					new application.frameClass.ShopHomepageFrame();
					Stage stage = (Stage) btSignIn.getScene().getWindow();
					stage.close();
					labError.setVisible(false);
				} else {
					labError.setVisible(true);
				}

			} else {
				String sql2 = "Select * from Customer where UserName =? and Password=?";
				String sql = "select count(*) from Customer where UserName =? and Password=?";
				rs = qr.query(db.getConnection(), sql, para, new ArrayHandler());
				a = Integer.parseInt(rs[0].toString());
				if (a == 1) {
					NowInf.customer = qr.query(db.getConnection(), sql2, para,
							new BeanHandler<Customer>(Customer.class));
					new CustomerHomepageFrame();
					Stage stage = (Stage) btSignIn.getScene().getWindow();
					stage.close();
					labError.setVisible(false);
				} else {
					labError.setVisible(true);

				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
