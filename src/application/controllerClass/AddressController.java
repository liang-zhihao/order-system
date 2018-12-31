package application.controllerClass;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;

import application.dataClass.CheckBoxTCell;
import application.dataClass.Db;
import application.dataClass.DeliveryAddress;
import application.dataClass.NowInf;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class AddressController<AddressTable> {

	@FXML
	private TableColumn<AddressTable, Boolean> ColSelect;

	@FXML
	private TableColumn<AddressTable, Integer> ColDeliveryAddressID;

	@FXML
	private TableColumn<AddressTable, String> ColConsignee;

	@FXML
	private TableColumn<AddressTable, Integer> ColContactPhone;

	@FXML
	private TableColumn<AddressTable, String> ColDetail;

	@FXML
	private TableColumn<AddressTable, Boolean> ColChange;

	@FXML
	private TableView<AddressTable> AddressTable;

	@FXML
	private AnchorPane AddressTablePane;

	@FXML
	private JFXButton btRefurbish;

	@FXML
	private JFXTextField txGreeting;

	public void initialize() throws SQLException {
		txGreeting.setText(NowInf.getGreetingWords());
		ColSelect.setCellValueFactory(new PropertyValueFactory<AddressTable, Boolean>("select"));
		ColDeliveryAddressID.setCellValueFactory(new PropertyValueFactory<AddressTable, Integer>("deliveryAddressID"));
		ColConsignee.setCellValueFactory(new PropertyValueFactory<AddressTable, String>("consignee"));
		ColContactPhone.setCellValueFactory(new PropertyValueFactory<AddressTable, Integer>("contactPhone"));
		ColDetail.setCellValueFactory(new PropertyValueFactory<AddressTable, String>("detail"));
		ColChange.setCellValueFactory(new PropertyValueFactory<AddressTable, Boolean>("change"));

		ColSelect.setCellFactory(new Callback<TableColumn<AddressTable, Boolean>, TableCell<AddressTable, Boolean>>() {
			public TableCell<AddressTable, Boolean> call(TableColumn<AddressTable, Boolean> param) {
				final CheckBoxTCell<AddressTable, Boolean> cell = new CheckBoxTCell<>();
				final JFXCheckBox checkbox = (JFXCheckBox) cell.getGraphic();
				checkbox.setOnAction(e -> {
					if (((application.dataClass.AddressTable) cellData.get(cell.getIndex())).getSelect()
							.booleanValue()) {
						((application.dataClass.AddressTable) cellData.get(cell.getIndex())).setSelect(false);
					} else {
						((application.dataClass.AddressTable) cellData.get(cell.getIndex())).setSelect(true);
					}
				});
				return cell;
			}
		});

	}

	ObservableList<AddressTable> cellData = FXCollections.observableArrayList();

	// public static void main(String[] args) throws SQLException {
	// Db db = new Db();
	// QueryRunner qr = new QueryRunner();
	// String sql = "select * from deliveryAddressID";
	//
	// ArrayList<DeliveryAddress> list = (ArrayList<DeliveryAddress>)
	// qr.query(db.getConnection(), sql,
	// new BeanListHandler<DeliveryAddress>(DeliveryAddress.class));
	//
	// }

	public void Refurbish() {
		try {
			cellData.clear();
			// System.out.println(NowInf.customer.getCustomerId());
			Db db = new Db();
			QueryRunner qr = new QueryRunner();
			Object[] para = new Object[1];
			List<Object[]> tmp = null;
			para[0] = NowInf.customer.getCustomerId();
			String sql1 = "select * from deliveryaddress where CustomerID = ? ";
			ArrayList<DeliveryAddress> l = (ArrayList<DeliveryAddress>) qr.query(db.getConnection(), sql1, para,
					new BeanListHandler<DeliveryAddress>(DeliveryAddress.class));
			application.dataClass.AddressTable[] table = NowInf.convertToAddressTable(l);
			// System.out.println(table[0].getConsignee());

			cellData.addAll((AddressTable[]) table);
			AddressTable.setItems(cellData);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
