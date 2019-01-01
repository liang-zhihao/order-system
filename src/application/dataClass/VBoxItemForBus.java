package application.dataClass;

import java.io.File;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.jfoenix.controls.JFXButton;

import application.frameClass.ChangeItemFrame;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class VBoxItemForBus extends VBox {

	private ImageView im = new ImageView();
	private Label lbItem = new Label();
	private Label lbBusiness = new Label();
	private JFXButton btUpdate = new JFXButton("Update");
	private JFXButton btDel = new JFXButton("Delete");
	private HBox hb1 = new HBox();
	private HBox hb2 = new HBox();
	private Label lbPrice = new Label();
	private int itemId;

	public VBoxItemForBus() {
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getItemId() {
		return itemId;
	}

	public VBoxItemForBus(String path, String name, String business, double price) {
		DropShadow ds1 = new DropShadow();
		ds1.setOffsetY(4.0f);
		ds1.setOffsetX(4.0f);
		ds1.setColor(Color.web("#f2e3e3"));
		this.setAlignment(Pos.TOP_CENTER);
		this.setEffect(ds1);
		this.setPrefHeight(270);
		this.setMaxHeight(270);
		this.setPrefWidth(190);
		this.setMaxWidth(190);
		this.setSpacing(10);
		this.getStyleClass().add("itemFont");
		// this.setMargin(getParent(), new Insets(0, 10, 0, 10));
		this.setStyle("-fx-background-color:white;");
		im.setFitWidth(190);
		im.setFitHeight(184);
		NowInf.setPicView(im, "item/" + path);
		// lbItem.setFont(Font.font("Verdana", 15));
		lbItem.setAlignment(Pos.CENTER_LEFT);
		lbItem.setPrefWidth(191);
		lbItem.setPrefHeight(44);
		lbItem.setText(name);
		hb1.setStyle("-fx-border-color:#BFBFBF white  white  white");
		lbBusiness.setText(business);
		lbBusiness.setAlignment(Pos.CENTER_LEFT);
		lbBusiness.setPrefSize(139, 44);
		lbPrice.setPrefSize(86, 17);
		lbPrice.setText("$" + price);
		btDel.setPrefSize(95, 33);
		btDel.setStyle("-fx-background-color:#39C164");
		btUpdate.setStyle("-fx-background-color:#39C164");
		btUpdate.setPrefSize(95, 33);
		hb1.getChildren().addAll(lbBusiness, lbPrice);
		hb2.getChildren().addAll(btUpdate, btDel);
		this.getChildren().addAll(im, lbItem, hb1, hb2);
		btUpdate.setOnAction(e -> {
			new ChangeItemFrame(itemId);
		});
		btDel.setOnAction(e -> {
			// del picture
			String srcPicPath = im.getImage().impl_getUrl();
			srcPicPath = srcPicPath.replace("/bin/", "/src/");
			File pic1 = new File(im.getImage().impl_getUrl());
			File pic2 = new File(srcPicPath);
			pic1.delete();
			pic2.delete();
			// del data
			Db db = new Db();
			QueryRunner qr = new QueryRunner();
			String sql = "delete from product where productid=" + itemId;
			try {
				qr.update(db.getConnection(), sql);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			// del vbox
			FlowPane t = (FlowPane) this.getParent();
			t.getChildren().remove(this);
			System.out.println("Del Successfully");
		});

	}

}
