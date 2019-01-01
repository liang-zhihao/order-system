package application.controllerClass;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import application.dataClass.Db;
import application.dataClass.NowInf;
import application.dataClass.Product;
import application.frameClass.ShowItemDetailFrame;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class ShowItemDetailController {

	@FXML
	private JFXTextField txItemName;

	@FXML
	private JFXTextField txProductNumber;

	@FXML
	private ImageView imgwei;

	@FXML
	private JFXTextField txWeight;

	@FXML
	private JFXTextArea txDetail;

	@FXML
	private ImageView imgItem = new ImageView();
	@FXML
	private ImageView imgItem2 = new ImageView();

	@FXML
	private ImageView imgCost;

	@FXML
	private ImageView imgPn;

	@FXML
	private JFXTextField txCost;

	public void initialize() {
		NowInf.setPicView(imgItem2, "icon/item.png");
		NowInf.setPicView(imgCost, "icon/price.png");
		NowInf.setPicView(imgPn, "icon/product.png");
		NowInf.setPicView(imgwei, "icon/weight.png");
		Db db = new Db();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from product where productid = " + ShowItemDetailFrame.itemId;
		try {
			Product p = qr.query(db.getConnection(), sql, new BeanHandler<Product>(Product.class));
			txItemName.setText(p.getName());
			txCost.setText("" + p.getStandardcost());
			txProductNumber.setText(p.getProductnumber());
			txWeight.setText("" + p.getWeight());
			txDetail.setText(p.getDetail());
			String path = "item/" + p.getPictureName();
			NowInf.setPicView(imgItem, path);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
