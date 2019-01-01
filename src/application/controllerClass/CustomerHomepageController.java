package application.controllerClass;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import application.dataClass.Cart;
import application.dataClass.CartTable;
import application.dataClass.CheckBoxTCell;
import application.dataClass.Customer;
import application.dataClass.Db;
import application.dataClass.HBoxForCart;
import application.dataClass.NowInf;
import application.dataClass.OrderTable;
import application.dataClass.Product;
import application.dataClass.SalesOrder;
import application.frameClass.CusAddressFrame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Callback;

public class CustomerHomepageController {

	@FXML
	private TableColumn<OrderTable, Boolean> btOrderCol;
	@FXML
	private TableColumn<OrderTable, String> orderBusinessCol;

	@FXML
	private TableColumn<OrderTable, String> orderItemCol;
	@FXML
	private TableColumn<OrderTable, String> orderDateCol;
	@FXML
	private TableColumn<OrderTable, Integer> orderSubCol;
	@FXML
	private TableView<OrderTable> orderTable;

	@FXML
	private TableColumn<OrderTable, Integer> orderQuantityCol;
	@FXML
	private TableColumn<OrderTable, Integer> orderNumberCol;
	@FXML
	private TableColumn<OrderTable, String> orderStatusCol;
	@FXML
	private TableColumn<OrderTable, String> orderCommentCol;

	@FXML
	private JFXPasswordField txConformNewPsw;

	@FXML
	private AnchorPane UserPane;

	@FXML
	private JFXButton btItem;

	@FXML
	private JFXPasswordField txOriPsw;

	@FXML
	private AnchorPane CustomerHomepagePane;

	@FXML
	private AnchorPane cartPane;

	@FXML
	private JFXTextField txUserName;

	@FXML
	private JFXButton btShowAddress;

	@FXML
	private JFXRadioButton orderBusinessRad;

	@FXML
	private JFXTextField tfSearch;

	@FXML
	private JFXButton btAddCart;

	@FXML
	private AnchorPane cusOrderPane;

	@FXML
	private JFXButton btSearchOrder;

	@FXML
	private JFXButton btConfirmreceipt;

	@FXML
	private JFXTextField txGreeting1;

	@FXML
	private JFXTextField txGreeting;

	@FXML
	private ImageView avatar;

	@FXML
	private VBox txInformation;

	@FXML
	private JFXPasswordField txNewPsw;

	@FXML
	private JFXTextField txNickName;

	@FXML
	private JFXTextField txEmail;

	@FXML
	private JFXButton btCart;

	@FXML
	private Label OrderGteeting;

	@FXML
	private JFXButton btChangeIfo;

	@FXML
	private JFXButton btChangeAvatar;

	@FXML
	private JFXButton btUser;

	@FXML
	private JFXTextField txPhone;

	@FXML
	private Label lbTime;

	@FXML
	private AnchorPane cusItemPane;

	@FXML
	private JFXRadioButton orderItemRad;

	@FXML
	private JFXTextField tfSearchOrder;

	@FXML
	private JFXTextField txBio;

	@FXML
	private JFXButton btOrder;

	@FXML
	private JFXButton btLogout;

	@FXML
	private JFXButton btSearch;

	@FXML
	private FlowPane fpItem;
	@FXML
	private JFXCheckBox cartSelectAll;
	@FXML
	private VBox cartVBox;

	public void initialize() throws SQLException {
		// ToggleGroup t = new ToggleGroup();
		// itemBusiness.setToggleGroup(t);
		// itemName.setToggleGroup(t);

		fpItem.setHgap(10);
		fpItem.setVgap(10);
		// NowInf.setPicView(imgSearch, "icon/search.png");
		// NowInf.setPicView(imgSearch2, "icon/search.png");
		// txGreeting1.setText(NowInf.getGreetingWords());
		// OrderGteeting.setText(NowInf.getGreetingWords());
		// userGreeting.setText(NowInf.getGreetingWords() + " " +
		// userGreeting.getText());
		// OrderTablePane
		orderNumberCol.setCellValueFactory(new PropertyValueFactory<OrderTable, Integer>("salesOrderNumber"));
		orderQuantityCol.setCellValueFactory(new PropertyValueFactory<OrderTable, Integer>("quantity"));
		orderStatusCol.setCellValueFactory(new PropertyValueFactory<OrderTable, String>("status"));
		orderDateCol.setCellValueFactory(new PropertyValueFactory<OrderTable, String>("orderDate"));
		orderCommentCol.setCellValueFactory(new PropertyValueFactory<OrderTable, String>("comment"));
		orderSubCol.setCellValueFactory(new PropertyValueFactory<OrderTable, Integer>("subTotal"));
		orderItemCol.setCellValueFactory(new PropertyValueFactory<OrderTable, String>("itemName"));
		orderBusinessCol.setCellValueFactory(new PropertyValueFactory<OrderTable, String>("Business"));
		btOrderCol.setCellValueFactory(new PropertyValueFactory<OrderTable, Boolean>("isCheck"));
		btOrderCol.setCellFactory(new Callback<TableColumn<OrderTable, Boolean>, TableCell<OrderTable, Boolean>>() {
			public TableCell<OrderTable, Boolean> call(TableColumn<OrderTable, Boolean> param) {
				final CheckBoxTCell<OrderTable, Boolean> cell = new CheckBoxTCell<>();
				final JFXCheckBox checkbox = (JFXCheckBox) cell.getGraphic();
				checkbox.setOnAction(e -> {
					if (cellData.get(cell.getIndex()).getIsCheck().booleanValue()) {
						cellData.get(cell.getIndex()).setIsCheck(false);
					} else {
						cellData.get(cell.getIndex()).setIsCheck(true);
					}
				});
				return cell;
			}
		});
		// CartTablePane

	}

	ObservableList<OrderTable> cellData = FXCollections.observableArrayList();
	ObservableList<CartTable> cellDataCart = FXCollections.observableArrayList();

	public void openUserInf() {
		cusItemPane.setVisible(false);
		cusOrderPane.setVisible(false);
		UserPane.setVisible(true);
		cartPane.setVisible(false);
	}

	public void openOrder() {
		OrderGteeting.setText(NowInf.getGreetingWords());
		cusItemPane.setVisible(false);
		cusOrderPane.setVisible(true);
		UserPane.setVisible(false);
		cartPane.setVisible(false);
	}

	public void openItem() {
		txGreeting1.setText(NowInf.getGreetingWords());
		cusItemPane.setVisible(true);
		cusOrderPane.setVisible(false);
		UserPane.setVisible(false);
		cartPane.setVisible(false);
	}

	public void openCart() {
		cusItemPane.setVisible(false);
		cusOrderPane.setVisible(false);
		UserPane.setVisible(false);
		cartPane.setVisible(true);
		// cartPane.setVisible(false);
		initCartPane();
	}

	public static void main(String[] args) throws SQLException {
		Db db = new Db();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from salesorder";
		ArrayList<SalesOrder> list = (ArrayList<SalesOrder>) qr.query(db.getConnection(), sql,
				new BeanListHandler<SalesOrder>(SalesOrder.class));
		System.out.println(list.get(0).getOrderDate());
		// initOrderSearch();

	}

	public void initOrderSearch() {
		openOrder();
		Db db = new Db();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from salesorder where customerid =" + NowInf.customer.getCustomerId();
		try {
			cellData.clear();
			ArrayList<SalesOrder> orderlist = (ArrayList<SalesOrder>) qr.query(db.getConnection(), sql,
					new BeanListHandler<SalesOrder>(SalesOrder.class));
			OrderTable[] t = NowInf.convertToOrderTable(orderlist);

			cellData.addAll(t);
			orderTable.setItems(cellData);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void orderSearch() {
		try {
			cellData.clear();
			String key = tfSearchOrder.getText();
			key = "%" + key + "%";
			Object[] para = new Object[2];
			para[0] = key;
			para[1] = NowInf.customer.getCustomerId();
			Db db = new Db();
			QueryRunner qr = new QueryRunner();
			String sql = "";
			if (orderBusinessRad.isSelected()) {
				sql = "SELECT salesOrderId,business.businessId,productId,customerId,deliveryAddressId,salesOrderNumber,quantity ,status,orderDate,comment,subTotal FROM business , salesorder WHERE businessName LIKE ? AND business.BusinessID =salesorder.BusinessID and CustomerID=?";
			} else {
				sql = "SELECT salesOrderId,salesorder.businessId,salesorder.productId,customerId,deliveryAddressId,salesOrderNumber,quantity ,status,orderDate,comment,subTotal FROM product , salesorder WHERE product.NAME LIKE ? AND product.ProductID =salesorder.ProductID and  CustomerID=?";
			}
			ArrayList<SalesOrder> orderlist;
			orderlist = (ArrayList<SalesOrder>) qr.query(db.getConnection(), sql, para,
					new BeanListHandler<SalesOrder>(SalesOrder.class));
			// System.out.println(orderlist.get(0).getCustomerId());
			OrderTable[] t = NowInf.convertToOrderTable(orderlist);
			cellData.addAll(t);
			orderTable.setItems(cellData);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void OOrderItemRad() {

		orderBusinessRad.setSelected(false);
	}

	public void OOrderBusinessRad() {
		orderItemRad.setSelected(false);
	}

	public void btItems() {
		openItem();
		initItemPane();
		//
	}

	public void changeInf() {
		Db db = new Db();
		QueryRunner qr = new QueryRunner();
		String sql = "update customer set NickName = ?,PhoneNumber = ? , Email=? , Bio = ? where CustomerID = ?";
		Object[] para = new Object[5];
		para[0] = txNickName.getText();
		para[1] = Integer.parseInt(txPhone.getText());
		para[2] = txEmail.getText();
		para[3] = txBio.getText();
		para[4] = NowInf.customer.getCustomerId();
		try {
			if (!txOriPsw.getText().isEmpty() && !txNewPsw.getText().isEmpty()
					&& !txConformNewPsw.getText().isEmpty()) {
				if (!txOriPsw.getText().equals(NowInf.customer.getPassword())) {
					System.out.println("Original Password is wrong");
					return;
				}
				if (!txNewPsw.getText().equals(txConformNewPsw.getText())) {
					System.out.println("Confirm Password is wrong");
					return;
				}
				String sql2 = "update customer set Password =? where CustomerID=?";
				Object[] para2 = new Object[2];
				para2[0] = txNewPsw.getText();
				para2[1] = NowInf.customer.getCustomerId();
				try {
					qr.update(db.getConnection(), sql2, para2);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			String sql3 = "select * from customer where customerID=" + NowInf.customer.getCustomerId();
			qr.update(db.getConnection(), sql, para);
			System.out.println("Update SUCCESSFUL");
			NowInf.customer = qr.query(db.getConnection(), sql3, new BeanHandler<Customer>(Customer.class));
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void showUserInf() throws SQLException {
		openUserInf();
		Customer t = NowInf.customer;
		txUserName.setText(t.getUsername());
		txNickName.setText(t.getNickname());
		txPhone.setText("" + t.getPhoneNumber());
		txEmail.setText(t.getEmail());
		txBio.setText(t.getBio());
	}

	public void confirmReceipt() {
		Db db = new Db();
		QueryRunner qr = new QueryRunner();
		String sql = "update salesorder set status = ? where SalesOrderNumber = ?";
		Object[] para = new Object[2];
		para[0] = "Received";
		try {

			for (int i = 0; i < cellData.size(); i++) {
				OrderTable t = cellData.get(i);
				if (t.getIsCheck()) {
					t.setStatus("Received");
					para[1] = t.getSalesOrderNumber();
					qr.update(db.getConnection(), sql, para);
					System.out.println("confirm successfully");
				}
			}
			orderTable.refresh();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void btLogout() {
		Stage stage = (Stage) btLogout.getScene().getWindow();
		stage.close();
	}

	public void btChangeAvatar() throws IOException {
		FileChooser fileChooser = new FileChooser();
		Stage mainStage = (Stage) btChangeAvatar.getScene().getWindow();
		File selectedFile = fileChooser.showOpenDialog(mainStage);
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("*.jpg", "*.jpeg", "*.png"));
		String name = "Customer" + "-" + NowInf.customer.getCustomerId() + "."
				+ NowInf.getPicAttributeFromFile(selectedFile.getName());
		Image n = NowInf.copyPictureToProject(selectedFile, name, "a");
		avatar.setImage(n);
	}

	public void btAddAddress() {
		//
		UserPane.setVisible(false);
	}

	public void ShowAddress() {
		new CusAddressFrame();
	}

	public void initCartPane() {
		Db db = new Db();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from cart where customerid =" + NowInf.customer.getCustomerId();
		try {
			ArrayList<Cart> cartlist = (ArrayList<Cart>) qr.query(db.getConnection(), sql,
					new BeanListHandler<Cart>(Cart.class));
			for (int i = 0; i < cartlist.size(); i++) {
				String sql1 = "SELECT product.`Name` , business.BusinessName,product.StandardCost,cart.number,product.PictureName FROM product,cart,business WHERE CartID ="
						+ cartlist.get(i).getCartId()
						+ "  AND cart.ProductID=product.ProductID AND business.BusinessID =product.BusinessID";
				// String item, String business, int cost, int num, String picname
				Object[] t = qr.query(db.getConnection(), sql1, new ArrayHandler());
				HBoxForCart ht = new HBoxForCart(t[0].toString(), t[1].toString(), Double.valueOf(t[2].toString()),
						Integer.valueOf(t[3].toString()), t[4].toString());
				ht.setCartId(cartlist.get(i).getCartId());
				ht.setProductId(cartlist.get(i).getProductId());
				cartVBox.getChildren().add(ht);
				System.out.println(cartVBox.getChildren().get(0));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void cartSelectAl() {
		for (int i = 1; i < cartVBox.getChildren().size(); i++) {
			HBoxForCart t = (HBoxForCart) cartVBox.getChildren().get(i);
			t.setCheck(true);
		}

	}

	public void buyBuyBuy() {
		Db db = new Db();
		QueryRunner qr = new QueryRunner();
		for (int i = 1; i < cartVBox.getChildren().size(); i++) {

			HBoxForCart t = (HBoxForCart) cartVBox.getChildren().get(i);
			String sql = "delete from cart where cartid = " + t.getCartId();
			if (t.getCheck() == true) {
				try {
					qr.update(db.getConnection(), sql);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				cartVBox.getChildren().remove(t);
			}

		}

	}

	public void initItemPane() {
		Db db = new Db();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from product";
		try {
			ArrayList<Product> plist = (ArrayList<Product>) qr.query(db.getConnection(), sql,
					new BeanListHandler<Product>(Product.class));
			NowInf.addItemToPane(fpItem, plist, "c");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void searchItem() {

		Db db = new Db();
		QueryRunner qr = new QueryRunner();
		String key = "%" + tfSearch.getText() + "%";

		String sql = "select * from product where  name like ?";
		fpItem.getChildren().clear();
		Object[] p = new Object[1];
		p[0] = key;
		ArrayList<Product> productlist = null;
		try {
			productlist = (ArrayList<Product>) qr.query(db.getConnection(), sql, p,
					new BeanListHandler<Product>(Product.class));
			NowInf.addItemToPane(fpItem, productlist, "c");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
