package application.controllerClass;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import org.apache.commons.dbutils.QueryRunner;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import application.dataClass.Db;
import application.dataClass.NowInf;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AddAItemController {

	@FXML
	private JFXTextField txItemName;

	@FXML
	private JFXTextField txProductNumber;

	@FXML
	private JFXTextField txWeight;

	@FXML
	private JFXTextArea txDetail;

	@FXML
	private ImageView imgAddItem;

	@FXML
	private ImageView imgNick;

	@FXML
	private ImageView imgUser1;

	@FXML
	private ImageView imgUser;

	@FXML
	private JFXTextField txCost;

	@FXML
	private ImageView imgEmail;
	@FXML
	private JFXButton btAddItem;

	@FXML
	private JFXButton btAddPic;
	private static Random randomID = new Random();
	private static int id;
	private static File pic;
	private static String picname;

	public void addPic() throws IOException {
		final FileChooser fc = new FileChooser();
		Stage stage = (Stage) btAddPic.getScene().getWindow();
		pic = fc.showOpenDialog(stage);
		id = randomID.nextInt(99999) - 10;
		picname = "Business-" + NowInf.business.getBusinessId() + "-" + id + "."
				+ NowInf.getPicAttributeFromFile(pic.getName());
		Image t = NowInf.copyPictureToProject(pic, picname, "i");
		imgAddItem.setImage(t);
	}

	public void addItem() {
<<<<<<< HEAD
		String name = txItemName.getText();
		int cost = Integer.valueOf(txCost.getText());
=======
		if (ButtonType.OK == NowInf.showAlert("Do you want to add this item?", "confirmation").get()) {
			return;
		}
		String name = txItemName.getText();
		double cost = 0;
		try {
			cost = Double.valueOf(txCost.getText());
		} catch (Exception e) {
			NowInf.showAlert("Please confirm your cost", "error");
		}
<<<<<<< HEAD
>>>>>>> parent of 4f28f38... 我最后更新了
=======
>>>>>>> parent of 4f28f38... 我最后更新了
		String productnum = txProductNumber.getText();
		double weight = 0;
		if (txWeight.getText() != null) {
			weight = Double.valueOf(txWeight.getText());
		}
		String Detail = txDetail.getText();
		Db db = new Db();
		QueryRunner qr = new QueryRunner();
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> parent of 4f28f38... 我最后更新了
		if (name.equals("") || productnum.equals("") || Detail.equals("")) {
			NowInf.showAlert("Please enter required information", "error");
			return;
		}
<<<<<<< HEAD
>>>>>>> parent of 4f28f38... 我最后更新了
=======
>>>>>>> parent of 4f28f38... 我最后更新了
		try {
			qr.update(db.getConnection(),
					"Insert into product (ProductID, ProductNumber, Name, StandardCost, Detail, Weight, BusinessID,PictureName) "
							+ "values(?, ?, ?, ?, ?, ?, ?,?)",
					id, productnum, name, cost, Detail, weight, NowInf.business.getBusinessId(), picname);
			System.out.println("Successfully");
			Stage stage = (Stage) btAddItem.getScene().getWindow();
			stage.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
