package application.controllerClass;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;

import application.dataClass.Db;
import application.dataClass.DeliveryAddress;
import application.dataClass.HBoxForCart;
import application.dataClass.NowInf;
import application.dataClass.Product;
import application.frameClass.SelectAddressFrame;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class SelectAddressController {

	@FXML
	private JFXCheckBox cartSelectAll;

	@FXML
	private JFXButton btConfirm;

	@FXML
	private VBox mainVbox;
	private ToggleGroup tg = new ToggleGroup();

	public void initialize() throws SQLException {
		Db db = new Db();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from DeliveryAddress where customerid =" + NowInf.customer.getCustomerId();
		ArrayList<DeliveryAddress> addresslist = (ArrayList<DeliveryAddress>) qr.query(db.getConnection(), sql,
				new BeanListHandler<DeliveryAddress>(DeliveryAddress.class));
		for (int i = 0; i < addresslist.size(); i++) {
			DeliveryAddress t = addresslist.get(i);
			String iinf = t.getConsignee() + " " + t.getPhoneNumber() + " " + t.getDetail();
			HBoxForAddress tmp = new HBoxForAddress(t.getDeliveryAddressId(), iinf);
			tmp.getSelect().setToggleGroup(tg);
			mainVbox.getChildren().add(tmp);
		}
	}

	public void confirm() {
		if (ButtonType.OK != NowInf.showAlert("Do you confirm your address?", "confirmation").get()) {
			return;
		}
		for (int i = 0; i < mainVbox.getChildren().size(); i++) {
			HBoxForAddress t = (HBoxForAddress) mainVbox.getChildren().get(i);
			if (t.getSelect().isSelected()) {
				NowInf.customerAddressid = t.getIid();
				break;
			}

		}
		VBox cartVBox = SelectAddressFrame.t;
		Db db = new Db();
		QueryRunner qr = new QueryRunner();
		for (int i = 1; i < cartVBox.getChildren().size(); i++) {
			try {
				HBoxForCart t = (HBoxForCart) cartVBox.getChildren().get(i);
				if (t.getCheck() == true) {
					String sql = "INSERT into salesorder (BusinessID,ProductID,CustomerID,DeliveryAddressID,SalesOrderNumber,Quantity,`Status`,OrderDate,`Comment`,SubTotal) VALUES(?,?,?,?,?,?,?,?,?,?)";
					Object[] p = new Object[10];
					String sql1 = "select * from product where productid =" + t.getProductId();
					Product ptmp = qr.query(db.getConnection(), sql1, new BeanHandler<Product>(Product.class));
					p[0] = ptmp.getBusinessiD();
					p[1] = t.getProductId();
					p[2] = NowInf.customer.getCustomerId();
					p[3] = NowInf.customerAddressid;
					p[4] = ptmp.getProductnumber();
					p[5] = Integer.valueOf(t.getTfNum().getText());
					p[6] = "Not shipped";
					p[7] = new Date();
					p[8] = " ";
					p[9] = Integer.valueOf(t.getTfNum().getText()) * ptmp.getStandardcost();
					qr.update(db.getConnection(), sql, p);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

class HBoxForAddress extends HBox {
	private JFXRadioButton select = new JFXRadioButton();
	private JFXTextArea tx = new JFXTextArea();
	private int iid = 0;

	public JFXTextArea getTx() {
		return tx;
	}

	public void setTx(JFXTextArea tx) {
		this.tx = tx;
	}

	public JFXRadioButton getSelect() {
		return select;
	}

	public void setSelect(JFXRadioButton select) {
		this.select = select;
	}

	public HBoxForAddress(int id, String inf) {
		this.iid = id;
		this.getChildren().addAll(select, tx);
		this.setStyle("-fx-border-color: white white #BDC0BA white");
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setSpacing(10);
		this.setPrefSize(588, 100);
		select.setPrefSize(12, 78);
		tx.setPrefSize(542, 78);
		tx.setUnFocusColor(Color.WHITE);
		tx.setStyle(" -fx-font-family:Verdana;-fx-font-size:16px;");
		tx.setText(inf);
	}

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

}
