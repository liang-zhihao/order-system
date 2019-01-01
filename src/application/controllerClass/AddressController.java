package application.controllerClass;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import application.dataClass.CheckBoxTCell;
import application.dataClass.Db;
import application.dataClass.DeliveryAddress;
import application.dataClass.NowInf;
import application.frameClass.AddAddressFrame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
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
    private TableView<AddressTable> AddressTable;
    

    @FXML
    private JFXButton btChoose;

    @FXML
    private JFXButton btBack;

    @FXML
    private JFXTextField txCntPhone;

    @FXML
    private JFXTextField txGreeting;

    @FXML
    private JFXTextField txCntPerson;

    @FXML
    private JFXButton btChangeAddress;

    @FXML
    private JFXButton btDelete;

    @FXML
    private AnchorPane changeAddressPane;

    @FXML
    private JFXTextArea txAddress;

    @FXML
    private JFXButton AddAddress;

    @FXML
    private AnchorPane AddressTablePane;

    @FXML
    private JFXButton btRefurbish;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private JFXButton ChangeAddress;
    
    

    ObservableList<AddressTable> cellData = FXCollections.observableArrayList();
    
    public void initialize() throws SQLException{
    	mainPane.setVisible(true);
    	Refurbish();
    	System.out.println(cellData.size());
    	//System.out.println(cellData.size());
    	txGreeting.setText(NowInf.getGreetingWords());
    	ColSelect.setCellValueFactory(new PropertyValueFactory<AddressTable, Boolean>("select"));
    	ColDeliveryAddressID.setCellValueFactory(new PropertyValueFactory<AddressTable, Integer>("deliveryAddressID"));
    	//ColConsignee.setCellValueFactory(new PropertyValueFactory<AddressTable, String>("consignee"));
    	ColContactPhone.setCellValueFactory(new PropertyValueFactory<AddressTable, Integer>("contactPhone"));
    	ColDetail.setCellValueFactory(new PropertyValueFactory<AddressTable, String>("detail"));
    	
    	ColSelect.setCellFactory(new Callback<TableColumn<AddressTable, Boolean>, TableCell<AddressTable, Boolean>>() {
			public TableCell<AddressTable, Boolean> call(TableColumn<AddressTable, Boolean> param) {
				final CheckBoxTCell<AddressTable, Boolean> cell = new CheckBoxTCell<>();
				final JFXCheckBox checkbox = (JFXCheckBox) cell.getGraphic();
				checkbox.setOnAction(e -> {
					if (((application.dataClass.AddressTable) cellData.get(cell.getIndex())).getSelect().booleanValue()) {
						((application.dataClass.AddressTable) cellData.get(cell.getIndex())).setSelect(false);
					} else {
						((application.dataClass.AddressTable) cellData.get(cell.getIndex())).setSelect(true);
					}
				});
				return cell;
			}
		});
    	
    	ColConsignee.setCellValueFactory(new PropertyValueFactory<AddressTable, String>("consignee"));
    	ColConsignee.setCellFactory(TextFieldTableCell.forTableColumn());  
    	ColConsignee.setOnEditCommit(  
    	    new EventHandler<CellEditEvent<AddressTable, String>>() {  
    	        @Override  
    	        public void handle(CellEditEvent<AddressTable, String> t) {  
//    	        	((DeliveryAddress) t.getTableView().getItems().
//    	        			get(t.getTablePosition().getRow())).setConsignee(t.getNewValue());
    	        	((DeliveryAddress) t.getTableView().getItems().get(t.getTablePosition().getRow()))
    	        	.setConsignee(t.getNewValue());
    	        }  
    	    }  
    	);  

    }    
   
    
    public void Refurbish() {
		try {
			cellData.clear();
			//System.out.println(NowInf.customer.getCustomerId());			
			Db db = new Db();
			QueryRunner qr = new QueryRunner();
			Object[] para = new Object[1];
			List<Object[]> tmp = null;
			para[0] = NowInf.customer.getCustomerId();				
			String sql1 = "select * from deliveryaddress where CustomerID = ? ";
			ArrayList<DeliveryAddress> l = (ArrayList<DeliveryAddress>) qr.query(db.getConnection(), sql1, para,
					new BeanListHandler<DeliveryAddress>(DeliveryAddress.class));
			
			application.dataClass.AddressTable[] table = NowInf.convertToAddressTable(l);		
			//System.out.println(table[0].getConsignee());
			
			cellData.addAll((AddressTable[]) table);
			AddressTable.setItems(cellData);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public void ChangeAddress() { 
    	System.out.println(cellData.size());
    	showInf();
    	mainPane.setVisible(false);
    	changeAddressPane.setVisible(true);
	}
    
    @FXML
    public void deleteAddress(){    	
    	Db db = new Db();
		QueryRunner qr = new QueryRunner();
		String sql = "delete from deliveryaddress where CustomerID = ? and DeliveryAddressid = ?";
		Object[] para = new Object[2];		
		para[0] = NowInf.customer.getCustomerId();		
		try {
			for(int i = 0; i < cellData.size(); i++) {
				AddressTable t = cellData.get(i);				
				if(((application.dataClass.AddressTable) t).getSelect()) {
					//System.out.println(t.toString() + "%%%%");					
					para[1] = (((application.dataClass.AddressTable) t).getDeliveryAddressID());
					qr.update(db.getConnection(), sql, para);
					System.out.println("delete successfully");
				}
			}				
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
    	Refurbish();
    }
    
    public void AddAddress() {
    	new AddAddressFrame();    	
	}    
    
    public void showInf(){		
    	Db db = new Db();
		QueryRunner qr = new QueryRunner();
		//String sql = "update deliveryaddress set Consignee = ?,PhoneNumber = ? , Detail=? where CustomerID = ? and DeliveryAddressID = ?";
		String sql = "select Consignee, PhoneNumber, Detail from deliveryaddress where CustomerID = ? and DeliveryAddressID = ?";
		Object[] para = new Object[2];		
		para[0] = NowInf.customer.getCustomerId();
		
		try {
			for(int i = 0; i < cellData.size(); i++) {
				AddressTable t = cellData.get(i);				
				if(((application.dataClass.AddressTable) t).getSelect()) {
					//System.out.println(t.toString() + "%%%%");					
					para[1] = (((application.dataClass.AddressTable) t).getDeliveryAddressID());
					Object[] result = qr.query(db.getConnection(), sql, para, new ArrayHandler());
					//System.out.println(result.length + "*****************");
					txCntPerson.setText(result[0].toString());
					txCntPhone.setText(result[1].toString());
					txAddress.setText(result[2].toString());
				}
			}				
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

    public void btChangeTOSQL() {
    	Db db = new Db();
		QueryRunner qr = new QueryRunner();
		String sql = "update deliveryaddress set Consignee = ?,PhoneNumber = ? , Detail=? where CustomerID = ? and DeliveryAddressID = ?";
		Object[] para = new Object[5];		
		try {
			for(int i = 0; i < cellData.size(); i++) {
				AddressTable t = cellData.get(i);				
				if(((application.dataClass.AddressTable) t).getSelect()) {
					//System.out.println(t.toString() + "%%%%");
					para[0] = txCntPerson.getText();
					para[1] = txCntPhone.getText();
					para[2] = txAddress.getText();
					para[3] = NowInf.customer.getCustomerId();
					para[4] = (((application.dataClass.AddressTable) t).getDeliveryAddressID());
					qr.update(db.getConnection(), sql,para);
					System.out.println("update successfully");
				}
			}				
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		changeAddressPane.setVisible(false);
		mainPane.setVisible(true);
		Refurbish();
	}
    
    public void Back() {
    	changeAddressPane.setVisible(false);
		mainPane.setVisible(true);
		Refurbish();
    }
}

