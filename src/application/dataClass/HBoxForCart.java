package application.dataClass;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class HBoxForCart extends HBox {
	private JFXCheckBox check = new JFXCheckBox();
	private ImageView img;
	private Label lbItem = new Label();
	private Label lbBus = new Label();
	private Label lbCost = new Label();
	private JFXTextField tfNum = new JFXTextField();
	private JFXButton btDel = new JFXButton("Delete");
	private int cartId;
	private int productId;

	public void setTfNum(JFXTextField tfNum) {
		this.tfNum = tfNum;
	}

	public JFXTextField getTfNum() {
		return tfNum;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductId() {
		return productId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public void setCheck(boolean t) {
		check.setSelected(t);
	}

	public boolean getCheck() {
		return check.isSelected();
	}

	public HBoxForCart(String item, String business, int cost, int num, String picname) {
		this.getStylesheets().add("itemFont");
		this.setStyle(" -fx-border-color:white white #BDC0BA white;");
		this.setAlignment(Pos.CENTER_LEFT);
		this.setSpacing(10);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setPrefSize(830, 100);
		//
		check.setText("");
		check.setPrefSize(12, 78);
		//
		img.setFitWidth(100);
		img.setFitHeight(100);
		NowInf.setPicView(img, "item/" + picname);
		// img.setImage
		//
		lbItem.setAlignment(Pos.CENTER_LEFT);
		lbItem.setPrefSize(170, 106);
		lbItem.setText(item);
		//
		lbBus.setAlignment(Pos.CENTER_LEFT);
		lbBus.setPrefSize(170, 78);
		lbBus.setText(business);
		//
		lbCost.setAlignment(Pos.CENTER_LEFT);
		lbCost.setPrefSize(106, 100);
		lbCost.setText("" + cost);
		//
		tfNum.setPrefSize(88, 25);
		tfNum.setText("" + num);
		//
		btDel.setPrefSize(132, 36);
		btDel.setOnAction(e -> {

		});
	}
}
