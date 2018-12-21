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
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;

import application.dataClass.Business;
import application.dataClass.CheckBoxTCell;
import application.dataClass.Db;
import application.dataClass.NowInf;
import application.dataClass.OrderTable;
import application.dataClass.Product;
import application.dataClass.SalesOrder;
import application.dataClass.VBoxItemForBus;
import application.frameClass.AddAItemFrame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ShopHomepageController {
	@FXML
	private Label lbItemGreeting;
	@FXML
	private Label lbOrderGreeting;

	@FXML
	private FlowPane fpItems;

	@FXML
	private ImageView imgHead;
	@FXML
	private TableColumn<OrderTable, String> orderBusinessCol;
	@FXML
	private TableColumn<OrderTable, Boolean> btOrderCol;
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
	private JFXButton btConfirmshipment;
	@FXML
	private JFXButton btRefresh;
	@FXML
	private TableColumn<?, ?> itemProductnumCol;

	@FXML
	private AnchorPane ShopHomepage;
	@FXML
	private MenuBar mnBar;
	@FXML
	private Menu mnUserName;
	@FXML
	private Menu mnItems;
	@FXML
	private Menu mnOrders;
	@FXML
	private Menu mnLogOut;
	@FXML
	private TextField txPhoneNum;
	@FXML
	private TextField txEmail;
	@FXML
	private Label lbUserName;
	@FXML
	private Label lbPhoneNum;
	@FXML
	private Label lbEmail;
	@FXML
	private TextField txID;
	@FXML
	private Label lbID;
	@FXML
	private JFXTextField tfBusinessname;

	@FXML
	private TableColumn<?, ?> itemNameCol;

	@FXML
	private AnchorPane OrderPane;

	@FXML
	private AnchorPane userInfPane;

	@FXML
	private JFXButton btUser;
	@FXML
	private JFXButton btHead;

	@FXML
	private JFXTextField originalpwd;

	@FXML
	private TableView<?> customerOrderTable;

	@FXML
	private JFXRadioButton orderItemRad;

	@FXML
	private AnchorPane ItemPane;

	@FXML
	private JFXTextField tfSearchOrder;

	@FXML
	private JFXButton btOrder;

	@FXML
	private JFXButton btLogout;
	@FXML
	private ImageView img;

	@FXML
	private JFXButton btSearch;
	ObservableList<OrderTable> cellData = FXCollections.observableArrayList();

	public void openUserInf() {
		ItemPane.setVisible(false);
		OrderPane.setVisible(false);
		userInfPane.setVisible(true);
	}

	public void openOrder() {
		ItemPane.setVisible(false);
		OrderPane.setVisible(true);
		userInfPane.setVisible(false);
		lbOrderGreeting.setText(NowInf.getGreetingWords());
	}

	public void openItem() {
		ItemPane.setVisible(true);
		OrderPane.setVisible(false);
		userInfPane.setVisible(false);
		lbItemGreeting.setText(NowInf.getGreetingWords());
	}

	public void initUserInf() {
		openUserInf();
		Business t = NowInf.business;
		tfUser.setText(t.getUsername());
		tfPhone.setText(t.getPhoneNumber());
		tfEmail.setText(t.getEmail());
		tfShipping.setText(t.getShippingAddress());
		tfBusinessname.setText(t.getBusinessName());
	}

	public void changeInf() {
		Db db = new Db();
		QueryRunner qr = new QueryRunner();
		String sql = "update business set PhoneNumber = ?, Email=? , ShippingAddress = ?,BusinessName =? where BusinessID = ?";
		Object[] para = new Object[5];
		para[0] = Integer.parseInt(tfPhone.getText());
		para[1] = tfEmail.getText();
		para[2] = tfShipping.getText();
		para[3] = tfBusinessname.getText();
		para[4] = NowInf.business.getBusinessId();
		try {
			if (!originalpwd.getText().isEmpty() && !newpwd.getText().isEmpty() && !confirmpwd.getText().isEmpty()) {
				if (!originalpwd.getText().equals(NowInf.business.getPassword())) {
					System.out.println("Original Password is wrong");
					return;
				}
				if (!newpwd.getText().equals(confirmpwd.getText())) {
					System.out.println("Confirm Password is wrong");
					return;
				}
				String sql2 = "update business set Password =? where BusinessID=?";
				Object[] para2 = new Object[2];
				para2[0] = newpwd.getText();
				para2[1] = NowInf.business.getBusinessId();
				qr.update(db.getConnection(), sql2, para2);

			} // Update Information
			String sql3 = "select * from business where BusinessID=" + NowInf.business.getBusinessId();
			qr.update(db.getConnection(), sql, para);
			System.out.println("Update SUCCESSFUL");
			NowInf.business = qr.query(db.getConnection(), sql3, new BeanHandler<Business>(Business.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void initialize() throws SQLException {

		VBoxItemForBus tmp = new VBoxItemForBus("1.jpg", "gakki", "Japan", 10);
		fpItems.getChildren().add(tmp);
		// img.setImage(new Image("application/fxml/img/ga.png"));
		// imgHead.setImage(new Image());
		orderNumberCol.setCellValueFactory(new PropertyValueFactory<OrderTable, Integer>("salesOrderNumber"));
		orderQuantityCol.setCellValueFactory(new PropertyValueFactory<OrderTable, Integer>("quantity"));
		orderStatusCol.setCellValueFactory(new PropertyValueFactory<OrderTable, String>("status"));
		orderDateCol.setCellValueFactory(new PropertyValueFactory<OrderTable, String>("orderDate"));
		orderCommentCol.setCellValueFactory(new PropertyValueFactory<OrderTable, String>("comment"));
		orderSubCol.setCellValueFactory(new PropertyValueFactory<OrderTable, Integer>("subTotal"));
		orderItemCol.setCellValueFactory(new PropertyValueFactory<OrderTable, String>("itemName"));
		btOrderCol.setCellValueFactory(new PropertyValueFactory<OrderTable, Boolean>("isCheck"));
		btOrderCol.setCellFactory(new Callback<TableColumn<OrderTable, Boolean>, TableCell<OrderTable, Boolean>>() {
			public TableCell<OrderTable, Boolean> call(TableColumn<OrderTable, Boolean> param) {
				final CheckBoxTCell<OrderTable, Boolean> cell = new CheckBoxTCell<>();
				final JFXCheckBox checkbox = (JFXCheckBox) cell.getGraphic();
				checkbox.setOnAction(e -> {
					// System.out.println(t.getItemName());
					if (cellData.get(cell.getIndex()).getIsCheck().booleanValue()) {
						cellData.get(cell.getIndex()).setIsCheck(false);
					} else {
						cellData.get(cell.getIndex()).setIsCheck(true);
					}
				});
				return cell;
			}
		});
		// btOrderCol.setCellValueFactory(cellData ->
		// cellData.getValue().cb.getCheckBox());

	}

	public void initOrderSearch() {
		openOrder();
		Db db = new Db();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from salesorder where businessid =" + NowInf.business.getBusinessId();
		try {
			cellData.clear();
			ArrayList<SalesOrder> orderlist = (ArrayList<SalesOrder>) qr.query(db.getConnection(), sql,
					new BeanListHandler<SalesOrder>(SalesOrder.class));
			OrderTable[] t = convertToOrderTable(orderlist);
			cellData.addAll(t);
			orderTable.setItems(cellData);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private OrderTable[] convertToOrderTable(ArrayList<SalesOrder> orderlist) {
		OrderTable[] t = new OrderTable[orderlist.size()];
		for (int i = 0; i < orderlist.size(); i++) {
			t[i] = new OrderTable();
		}
		Db db = new Db();
		QueryRunner qr = new QueryRunner();
		String sql1 = "select BusinessName from business where businessId=?";
		String sql2 = "select Name from Product where ProductId=?";
		Object[] para = new Object[1];
		Object[] tmp = null;
		try {
			for (int i = 0; i < orderlist.size(); i++) {
				para[0] = orderlist.get(i).getBusinessId();
				tmp = qr.query(db.getConnection(), sql1, para, new ArrayHandler());
				t[i].setBusiness(tmp[0].toString());
				para[0] = orderlist.get(i).getProductId();
				tmp = qr.query(db.getConnection(), sql2, para, new ArrayHandler());
				t[i].setItemName(tmp[0].toString());
				t[i].setComment(orderlist.get(i).getComment());
				t[i].setOrderDate(orderlist.get(i).getOrderDate());
				t[i].setQuantity(orderlist.get(i).getQuantity());
				t[i].setSalesOrderNumber(orderlist.get(i).getSalesOrderNumber());
				t[i].setStatus(orderlist.get(i).getStatus());
				t[i].setSubTotal(orderlist.get(i).getSubTotal());
				t[i].setIsCheck(false);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return t;
	}

	public void orderSearch() {
		try {
			cellData.clear();
			String key = tfSearchOrder.getText();
			key = "%" + key + "%";
			Object[] para = new Object[2];
			para[0] = key;
			para[1] = NowInf.business.getBusinessId();
			Db db = new Db();
			QueryRunner qr = new QueryRunner();
			String sql = "";
			if (orderItemRad.isSelected()) {
				sql = "SELECT salesOrderId,product.businessId,product.productId,customerId,deliveryAddressId,salesOrderNumber,quantity ,status,orderDate,comment,subTotal FROM product , salesorder WHERE product.Name LIKE ? AND product.ProductID =salesorder.ProductID and product.BusinessID=?";
			} else {
				sql = "SELECT salesOrderId,salesorder.businessId,salesorder.productId,customer.customerId,deliveryAddressId,salesOrderNumber,quantity ,status,orderDate,comment,subTotal FROM customer , salesorder WHERE customer.UserName LIKE ? AND customer.CustomerID =salesorder.CustomerID and salesorder.BusinessID=?";
			}
			ArrayList<SalesOrder> orderlist;
			orderlist = (ArrayList<SalesOrder>) qr.query(db.getConnection(), sql, para,
					new BeanListHandler<SalesOrder>(SalesOrder.class));
			// System.out.println(orderlist.get(0).getCustomerId());
			OrderTable[] t = convertToOrderTable(orderlist);
			cellData.addAll(t);
			orderTable.setItems(cellData);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void choseHead() throws IOException {
		final FileChooser fc = new FileChooser();
		Stage stage = (Stage) btHead.getScene().getWindow();
		File pic = fc.showOpenDialog(stage);
		String name = "Business" + NowInf.business.getBusinessId();
		Image t = NowInf.copyPictureToProject(pic, name, "a");
		imgHead.setImage(t);
		// TODO:
	}

	public void initItemPane() {
		openItem();
	}

	public void AddItem() {
		new AddAItemFrame();
	}

	public void refresh() {
		Db db = new Db();
		QueryRunner qr = new QueryRunner();

		String sql = "select * from product where businessid =" + NowInf.business.getBusinessId();
		// System.out.println(NowInf.business.getBusinessId());
		fpItems.getChildren().clear();

		ArrayList<Product> productlist = null;
		try {
			productlist = (ArrayList<Product>) qr.query(db.getConnection(), sql,
					new BeanListHandler<Product>(Product.class));

			NowInf.addItemToPane(fpItems, productlist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
