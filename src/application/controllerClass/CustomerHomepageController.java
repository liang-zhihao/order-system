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
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import application.dataClass.CheckBoxTCell;
import application.dataClass.Customer;
import application.dataClass.Db;
import application.dataClass.NowInf;
import application.dataClass.OrderTable;
import application.dataClass.SalesOrder;
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
    private AnchorPane UserPane;

    @FXML
    private JFXPasswordField txOriPsw;

    @FXML
    private JFXTextArea txAddress;

    @FXML
    private JFXTextField tfSearch;

    @FXML
    private JFXTextField txCntPerson;

    @FXML
    private JFXTextField txMAdd;

    @FXML
    private JFXTextField txGreeting;

    @FXML
    private JFXButton btCart;

    @FXML
    private Label OrderGteeting;

    @FXML
    private Label lbTime;

    @FXML
    private AnchorPane cusItemPane;

    @FXML
    private JFXTextField tfSearchOrder;

    @FXML
    private JFXButton btOrder;

    @FXML
    private JFXPasswordField txConformNewPsw;

    @FXML
    private JFXButton btItem;

    @FXML
    private AnchorPane CustomerHomepagePane;

    @FXML
    private JFXTextField txUserName;

    @FXML
    private JFXButton btAddAdd1;

    @FXML
    private JFXButton btAddAddress;

    @FXML
    private JFXRadioButton orderBusinessRad;

    @FXML
    private JFXButton btAddCart;

    @FXML
    private AnchorPane cusOrderPane;

    @FXML
    private AnchorPane addAdrPane;

    @FXML
    private JFXButton btSearchOrder;

    @FXML
    private JFXButton btConfirmreceipt;

    @FXML
    private JFXTextField txGreeting1;

    @FXML
    private JFXTextField txCntPhone;

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
    private JFXButton btChangeIfo;

    @FXML
    private JFXButton btChangeAvatar;

    @FXML
    private JFXButton btUser;

    @FXML
    private JFXTextField txPhone;

    @FXML
    private JFXRadioButton orderItemRad;

    @FXML
    private JFXTextField txBio;

    @FXML
    private JFXButton btLogout;

    @FXML
    private JFXButton btSearch;



	public void openUserInf() {
		cusItemPane.setVisible(false);
		cusOrderPane.setVisible(false);
		addAdrPane.setVisible(false);
		UserPane.setVisible(true);
	}

	public void openOrder() {
		cusItemPane.setVisible(false);
		cusOrderPane.setVisible(true);
		addAdrPane.setVisible(false);
		UserPane.setVisible(false);
	}

	public void openItem() {
		cusItemPane.setVisible(true);
		cusOrderPane.setVisible(false);
		addAdrPane.setVisible(false);
		UserPane.setVisible(false);
	}

	public void initialize() throws SQLException {
		showUserInf();
		orderNumberCol.setCellValueFactory(new PropertyValueFactory<OrderTable, Integer>("salesOrderNumber"));
		orderQuantityCol.setCellValueFactory(new PropertyValueFactory<OrderTable, Integer>("quantity"));
		orderStatusCol.setCellValueFactory(new PropertyValueFactory<OrderTable, String>("status"));
		orderDateCol.setCellValueFactory(new PropertyValueFactory<OrderTable, String>("orderDate"));
		orderCommentCol.setCellValueFactory(new PropertyValueFactory<OrderTable, String>("comment"));
		orderSubCol.setCellValueFactory(new PropertyValueFactory<OrderTable, Integer>("subTotal"));
		orderItemCol.setCellValueFactory(new PropertyValueFactory<OrderTable, String>("itemName"));
		orderBusinessCol.setCellValueFactory(new PropertyValueFactory<OrderTable, String>("Business"));
		// btOrderCol.setCellFactory(CheckBoxTableCell.forTableColumn(btOrderCol));
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
		// initOrderSearch();
	}

	ObservableList<OrderTable> cellData = FXCollections.observableArrayList();

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
			OrderTable[] t = convertToOrderTable(orderlist);

			cellData.addAll(t);
			orderTable.setItems(cellData);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
			OrderTable[] t = convertToOrderTable(orderlist);
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
		//showAvatar();
		//btChangeAvatar();
		
		Customer t = NowInf.customer;
		txUserName.setText(t.getUsername());
		txNickName.setText(t.getNickname());
		txPhone.setText("" + t.getPhoneNumber());
		txEmail.setText(t.getEmail());
		txBio.setText(t.getBio());
		txMAdd.setText(null);
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
	
//	public void showAvatar() {		
//		String name = "Customer" + NowInf.customer.getCustomerId();
//		String n = "/src/application/fxml/img/item" + name;	
//		avatar.setImage(new Image(n));
//	}
	
	public void btChangeAvatar() throws IOException {
		FileChooser fileChooser = new FileChooser();
		Stage mainStage = (Stage) btChangeAvatar.getScene().getWindow();		
		File selectedFile = fileChooser.showOpenDialog(mainStage);
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("*.jpg", "*.jpeg","*.png"));
		String name = "Customer" + NowInf.customer.getCustomerId();
		Image n = NowInf.copyPictureToProject(selectedFile, name, "a");		
		avatar.setImage(n);
	}
	
	public void btAddAddress() {
		addAdrPane.setVisible(true);
		UserPane.setVisible(false);
	}
	
	public void btAdd() throws SQLException {
		int ID = NowInf.customer.getCustomerId();
		String CnP = txCntPerson.getText();
		int CnPhone = Integer.parseInt(txCntPhone.getText());
		String AddressDetail = txAddress.getText();
		Db db = new Db();
		Object[] result = null;
		int count;
		QueryRunner qr = new QueryRunner();	
		
		String sql1 = "select count(*) from deliveryaddress where CustomerID = ?";
		result = qr.query(db.getConnection(), sql1, ID, new ArrayHandler());
		count =Integer.parseInt(result[0].toString());
		int AddressID = count + 1;			
		//System.out.println(count);
		//System.out.println(AddressID);
		qr.update(db.getConnection(),
				"Insert into deliveryaddress (DeliveryAddressID, CustomerID, Consignee, PhoneNumber, Detail) "
						+ "values(?, ?, ?, ?, ?)",
						AddressID, ID, CnP, CnPhone, AddressDetail);
		System.out.println("Adding Successful");
	}

}
