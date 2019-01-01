package application.controllerClass;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import application.dataClass.AddressTable;
import application.dataClass.Db;
import application.dataClass.NowInf;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class ChangeAddressController {
		@FXML
	    private AnchorPane changeAddress;

	    @FXML
	    private JFXTextField txCntPhone;

	    @FXML
	    private JFXTextField txCntPerson;

	    @FXML
	    private JFXButton btChangeAddress;

	    @FXML
	    private JFXTextArea txAddress;
	    
	    @FXML
	    private JFXTextField txGreeting;
	    
	    ObservableList<AddressTable> cellData = FXCollections.observableArrayList();
	    
	    public void initialize() throws SQLException {
	    	//new AddressController<Object>().Refurbish();
			//txGreeting.setText(NowInf.getGreetingWords());
			//showInf();
		}
	    
		public void showInf(){			
			for(int i = 0; i < cellData.size(); i++) {
				AddressTable t = cellData.get(i);
				if(t.getSelect() == true) {
					System.out.println(t.getDeliveryAddressID());
					txCntPerson.setText(t.getConsignee());
					txCntPhone.setText(Integer.toString(t.getContactPhone()));
					txAddress.setText(t.getDetail());
				}
			}	
		}

	    public void btChangeTOSQL() {
	    	Db db = new Db();
			QueryRunner qr = new QueryRunner();
			String sql = "update deliveryaddress set Consignee = ?,PhoneNumber = ? , Detail=? where CustomerID = ? and DeliveryAddressID = ?";
			Object[] para = new Object[4];
			para[0] = txCntPerson.getText();
			para[1] = txCntPhone.getText();
			para[2] = txAddress.getText();
			para[3] = NowInf.customer.getCustomerId();
			try {
				for(int i = 0; i < cellData.size(); i++) {
					AddressTable t = cellData.get(i);
					System.out.println(cellData.get(i));
					if(t.getSelect() == true) {
						para[4] = t.getDeliveryAddressID();
						qr.update(db.getConnection(), sql,para);
						System.out.println("update successfully");
					}
				}				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}	    
}

