package application.controllerClass;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import application.dataClass.Db;
import application.dataClass.NowInf;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class AddAddressController {

    @FXML
    private JFXTextField txCntPhone;

    @FXML
    private JFXTextField txCntPerson;

    @FXML
    private AnchorPane addAdrPane;

    @FXML
    private JFXButton btAddAddress;

    @FXML
    private JFXTextArea txAddress;
    
    public void btAddTOSQL() {
		try {
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
			count = Integer.parseInt(result[0].toString());
			int AddressID = count + 1;
			// System.out.println(count);
			// System.out.println(AddressID);
			qr.update(db.getConnection(),
					"Insert into deliveryaddress (DeliveryAddressID, CustomerID, Consignee, PhoneNumber, Detail) "
							+ "values(?, ?, ?, ?, ?)",
					AddressID, ID, CnP, CnPhone, AddressDetail);
			System.out.println("Adding Successful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}