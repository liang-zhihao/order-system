package application.controllerClass;

import java.io.File;
import java.io.IOException;
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
			String path = "item/" + p.getPictureName();
			NowInf.setPicView(imgChangeItem, path);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void changePic() {
		final FileChooser fc = new FileChooser();
		Stage stage = (Stage) btChangePic.getScene().getWindow();
		File pic = fc.showOpenDialog(stage);
		String pname = pic.getName();
		String pnameatt1 = pname.substring(pname.lastIndexOf(".") + 1);
		try {
			if (pnameatt1.equals(NowInf.getPicAttributeFromFile(p.getPictureName()))) {
				Image t = NowInf.copyPictureToProject(pic, p.getPictureName(), "i");
				imgChangeItem.setImage(t);
			} else {
				String srcPicPath = imgChangeItem.getImage().impl_getUrl();
				srcPicPath = srcPicPath.replace("/bin/", "/src/");
				File pic1 = new File(imgChangeItem.getImage().impl_getUrl());
				File pic2 = new File(srcPicPath);
				Db db = new Db();
				QueryRunner qr = new QueryRunner();
				String pnameatt2 = pname.substring(pname.lastIndexOf(".") + 1);
				String newName = p.getPictureName().substring(0, p.getPictureName().lastIndexOf(".") + 1) + pnameatt2;
				Image t = NowInf.copyPictureToProject(pic, newName, "i");
				System.out.println(newName);
				Object[] para = new Object[2];
				para[0] = newName;
				para[1] = ChangeItemFrame.itemId;
				String sql = "update product set picturename = ? where productid = ?";
				qr.update(db.getConnection(), sql, para);
				imgChangeItem.setImage(t);
				pic1.delete();
				pic2.delete();
				// System.out.println("change picture successfully");
			}
			System.out.println("change picture successfully");

		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changeItem() {
		Object para[] = new Object[6];
		txItemName.setText(p.getName());
		txCost.setText("" + p.getStandardcost());
		txProductNumber.setText(p.getProductnumber());
		txWeight.setText("" + p.getWeight());
		txDetail.setText(p.getDetail());
		Db db = new Db();
		QueryRunner qr = new QueryRunner();
		String sql = "update product set name =?,standardcost=?,detail=?,weight=?,productnumber=? where productid =?";
		para[0] = txItemName.getText();
		para[1] = Integer.valueOf(txCost.getText());
		para[2] = txDetail.getText();
		para[3] = Double.valueOf(txWeight.getText());
		para[4] = txProductNumber.getText();
		para[5] = p.getProductid();

		try {
			qr.update(db.getConnection(), sql, para);
			System.out.println("change item successfully");
			Stage stage = (Stage) btChangeItem.getScene().getWindow();
			stage.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

	}

}
