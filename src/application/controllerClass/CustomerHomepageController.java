package application.controllerClass;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import application.dataClass.Db;
import application.dataClass.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CustomerHomepageController {

	@FXML
	private TableColumn<?, ?> btItem;

	@FXML
	private TableView<?> btTableItem;

	@FXML
	private JFXButton btUser;

	@FXML
	private JFXTextField tfSearch;

	@FXML
	private JFXButton btAddCart;

	@FXML
	private JFXButton btOrder;

	@FXML
	private JFXButton btCart;

	@FXML
	private JFXButton btLogout;

	@FXML
	private JFXButton btSearch;

	@FXML
	void fcfcfc(ActionEvent event) {

	}

	@FXML
	void fcf9f9(ActionEvent event) {

	}

	public static void initialize() throws SQLException {

	}

	public static void main(String[] args) throws SQLException {
		Db db = new Db();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from Product";
		ArrayList<Product> list = (ArrayList<Product>) qr.query(db.getConnection(), sql,
				new BeanListHandler<Product>(Product.class));
		System.out.println(list.get(0).getBusinessID());
	}

}
