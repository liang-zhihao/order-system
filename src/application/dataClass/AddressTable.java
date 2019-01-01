package application.dataClass;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AddressTable {
	private BooleanProperty select;
	//private JFXCheckBox select = new JFXCheckBox();
	private IntegerProperty deliveryAddressID;
	private StringProperty consignee;
	private IntegerProperty contactPhone;
	private StringProperty detail;
	
	
	public void setDeliveryAddressID(int deliveryAddressID) {
		this.deliveryAddressID = new SimpleIntegerProperty(deliveryAddressID);
	}
	
	public void setConsignee(String consignee) {
		this.consignee = new SimpleStringProperty(consignee);
	}
	
	public void setContactPhone(int contactPhone) {
		this.contactPhone = new SimpleIntegerProperty(contactPhone);
	}
	
	public void setDetail(String detail) {
		this.detail = new SimpleStringProperty(detail);
	}
	
	public void setSelect(Boolean select) {
		this.select = new SimpleBooleanProperty(select);
	}
	
	public Boolean getSelect() {
		return select.getValue();
	}
	
//	public void setSelect(JFXCheckBox select) {
//		this.select = select;
//	}
//
//	public Boolean getSelect() {
//		return select.?
//	}
	
	public int getDeliveryAddressID() {
		return deliveryAddressID.get();
	}
	
	public String getConsignee() {
		return consignee.get();
	}
	
	public int getContactPhone() {
		return contactPhone.get();
	}
	
	public String getDetail() {
		return detail.get();
	}
		
}
