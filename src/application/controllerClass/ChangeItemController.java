package application.controllerClass;

import java.io.File;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import application.dataClass.Db;
import application.dataClass.NowInf;
import application.dataClass.Product;
import application.frameClass.ChangeItemFrame;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ChangeItemController {
	@FXML
	private JFXTextField txItemName;

	@FXML
	private JFXTextField txProductNumber;

	@FXML
	private JFXTextField txWeight;

	@FXML
	private JFXTextArea txDetail;

	@FXML
	private ImageView imgChangeItem;

	@FXML
	private ImageView imgNick;

	@FXML
	private JFXButton btChangeItem;

	@FXML
	private ImageView imgUser1;

	@FXML
	private JFXButton btChangePic;

	@FXML
	private ImageView imgUser;

	@FXML
	private JFXTextField txCost;

	@FXML
	private ImageView imgEmail;
	private Product p = null;

	public void initialize() {
		Db db = new Db();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from product where productid = " + ChangeItemFrame.itemId;
		try {
			p = qr.query(db.getConnection(), sql, new BeanHandler<Product>(Product.class));
			txItemName.setText(p.getName());
			txCost.setText("" + p.getStandardcost());
			txProductNumber.setText(p.getProductnumber());
			txWeight.setText("" + p.getWeight());
			txDetail.setText(p.getDetail());
			String path = "item/" + p.getPictureName() + "."
					+ p.getPictureName().substring(p.getPictureName().lastIndexOf("-") + 1);
			NowInf.setPicView(imgChangeItem, path);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void changePic() {
		final FileChooser fc = new FileChooser();
		Stage stage = (Stage) btChangePic.getScene().getWindow();
		File pic = fc.showOpenDialog(stage);
		Image t = NowInf.copyPictureToProject(pic, picname, "i");
	}
}
