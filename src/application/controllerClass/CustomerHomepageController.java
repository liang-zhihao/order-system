package application.controllerClass;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import application.dataClass.CheckBoxTCell;
import application.dataClass.Customer;
import application.dataClass.CustomerOrderTable;
import application.dataClass.Db;
import application.dataClass.NowInf;
import application.dataClass.SalesOrder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class CustomerHomepageController {
	@FXML
	private TableColumn<CustomerOrderTable, Boolean> btOrderCol;
	@FXML
	private TableColumn<CustomerOrderTable, String> orderBusinessCol;

	@FXML
	private TableColumn<CustomerOrderTable, String> orderItemCol;
	@FXML
	private TableColumn<CustomerOrderTable, String> orderDateCol;
	@FXML
	private TableColumn<CustomerOrderTable, Integer> orderSubCol;
	@FXML
	private TableView<CustomerOrderTable> customerOrderTable;

	@FXML
	private TableColumn<CustomerOrderTable, Integer> orderQuantityCol;
	@FXML
	private TableColumn<CustomerOrderTable, Integer> orderNumberCol;
	@FXML
	private TableColumn<CustomerOrderTable, String> orderStatusCol;
	@FXML
	private TableColumn<CustomerOrderTable, String> orderCommentCol;
	@FXML
	private JFXButton btItem;

	@FXML
	private JFXTextField emailtfd;

	@FXML
	private JFXRadioButton orderBusinessRad;

	@FXML
	private Label LabText;

	@FXML
	private AnchorPane cusOrderPane1;

	@FXML
	private JFXTextField nicknametfd;

	@FXML
	private JFXTextField tfSearch;

	@FXML
	private JFXButton btAddCart;

	@FXML
	private AnchorPane cusOrderPane;

	@FXML
	private JFXButton btChangeInf;

	@FXML
	private JFXButton btSearchOrder;

	@FXML
	private JFXTextField originalpwdtfd;

	@FXML
	private JFXTextArea biota;

	@FXML
	private JFXTextField confirmpwdtfd;

	@FXML
	private JFXTextField newpwdtfd;

	@FXML
	private JFXButton btCart;

	@FXML
	private JFXTextField usernametfd;

	@FXML
	private JFXTextField phonetfd;

	@FXML
	private JFXButton btUser;

	@FXML
	private AnchorPane cusItemPane;

	@FXML
	private JFXRadioButton orderItemRad;

	@FXML
	private JFXTextField tfSearchOrder;

	@FXML
	private JFXButton btOrder;

	@FXML
	private JFXButton btLogout;

	@FXML
	private JFXButton btSearch;
	@FXML
	private JFXButton btConfirmreceipt;
	// 创建并初始化数据

	public void initialize() throws SQLException {

		orderNumberCol.setCellValueFactory(new PropertyValueFactory<CustomerOrderTable, Integer>("salesOrderNumber"));
		orderQuantityCol.setCellValueFactory(new PropertyValueFactory<CustomerOrderTable, Integer>("quantity"));
		orderStatusCol.setCellValueFactory(new PropertyValueFactory<CustomerOrderTable, String>("status"));
		orderDateCol.setCellValueFactory(new PropertyValueFactory<CustomerOrderTable, String>("orderDate"));
		orderCommentCol.setCellValueFactory(new PropertyValueFactory<CustomerOrderTable, String>("comment"));
		orderSubCol.setCellValueFactory(new PropertyValueFactory<CustomerOrderTable, Integer>("subTotal"));
		orderItemCol.setCellValueFactory(new PropertyValueFactory<CustomerOrderTable, String>("itemName"));
		orderBusinessCol.setCellValueFactory(new PropertyValueFactory<CustomerOrderTable, String>("Business"));
		// btOrderCol.setCellFactory(CheckBoxTableCell.forTableColumn(btOrderCol));
		btOrderCol.setCellValueFactory(new PropertyValueFactory<CustomerOrderTable, Boolean>("isCheck"));
		btOrderCol.setCellFactory(
				new Callback<TableColumn<CustomerOrderTable, Boolean>, TableCell<CustomerOrderTable, Boolean>>() {
					public TableCell<CustomerOrderTable, Boolean> call(TableColumn<CustomerOrderTable, Boolean> param) {
						final CheckBoxTCell<CustomerOrderTable, Boolean> cell = new CheckBoxTCell<>();
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
		initOrderSearch();
	}

	ObservableList<CustomerOrderTable> cellData = FXCollections.observableArrayList();

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
		Db db = new Db();
		QueryRunner qr = new QueryRunner();
		String sql = "select * from salesorder where customerid =" + NowInf.customer.getCustomerId();
		try {
			cellData.clear();
			ArrayList<SalesOrder> orderlist = (ArrayList<SalesOrder>) qr.query(db.getConnection(), sql,
					new BeanListHandler<SalesOrder>(SalesOrder.class));
			CustomerOrderTable[] t = convertToCustomerOrderTable(orderlist);

			cellData.addAll(t);
			customerOrderTable.setItems(cellData);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private CustomerOrderTable[] convertToCustomerOrderTable(ArrayList<SalesOrder> orderlist) {
		CustomerOrderTable[] t = new CustomerOrderTable[orderlist.size()];
		for (int i = 0; i < orderlist.size(); i++) {
			t[i] = new CustomerOrderTable();
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
			CustomerOrderTable[] t = convertToCustomerOrderTable(orderlist);
			cellData.addAll(t);
			customerOrderTable.setItems(cellData);
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

	public void changeInf() {
		Db db = new Db();
		QueryRunner qr = new QueryRunner();
		String sql = "update customer set NickName = ?,PhoneNumber = ? , Email=? , Bio = ? where CustomerID = ?";
		Object[] para = new Object[5];
		para[0] = nicknametfd.getText();
		para[1] = Integer.parseInt(phonetfd.getText());
		para[2] = emailtfd.getText();
		para[3] = biota.getText();
		para[4] = NowInf.customer.getCustomerId();
		try {
			if (!originalpwdtfd.getText().isEmpty() && !newpwdtfd.getText().isEmpty()
					&& !confirmpwdtfd.getText().isEmpty()) {
				if (!originalpwdtfd.getText().equals(NowInf.customer.getPassword())) {
					System.out.println("Original Password is wrong");
					return;
				}
				if (!newpwdtfd.getText().equals(confirmpwdtfd.getText())) {
					System.out.println("Confirm Password is wrong");
					return;
				}
				String sql2 = "update customer set Password =? where CustomerID=?";
				Object[] para2 = new Object[2];
				para2[0] = newpwdtfd.getText();
				para2[1] = NowInf.customer.getCustomerId();
				try {
					qr.update(db.getConnection(), sql2, para2);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} // 更新信息
			String sql3 = "select * from customer where customerID=" + NowInf.customer.getCustomerId();
			qr.update(db.getConnection(), sql, para);
			System.out.println("Update SUCCESSFUL");
			NowInf.customer = qr.query(db.getConnection(), sql3, new BeanHandler<Customer>(Customer.class));
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void showUserInf() {
		Customer t = NowInf.customer;
		usernametfd.setText(t.getUsername());
		nicknametfd.setText(t.getNickname());
		phonetfd.setText("" + t.getPhoneNumber());
		emailtfd.setText(t.getEmail());
		biota.setText(t.getBio());
	}

	public void confirmReceipt() {
		Db db = new Db();
		QueryRunner qr = new QueryRunner();
		String sql = "update salesorder set status = ? where SalesOrderNumber = ?";
		Object[] para = new Object[2];
		para[0] = "Received";
		try {

			for (int i = 0; i < cellData.size(); i++) {
				CustomerOrderTable t = cellData.get(i);
				if (t.getIsCheck()) {
					t.setStatus("Received");
					para[1] = t.getSalesOrderNumber();
					qr.update(db.getConnection(), sql, para);
					System.out.println("confirm successfully");
				}
			}
			customerOrderTable.refresh();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
