package application.DataClass;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DeliveryAddress {
	private int addressId;
	private int customerId;
	private StringProperty consignee;
	private IntegerProperty phone;
	private StringProperty detail;

	public int getAddressId() {
		return addressId;
	}

	public StringProperty getConsignee() {
		return consignee;
	}

	public int getCustomerId() {
		return customerId;
	}

	public StringProperty getDetail() {
		return detail;
	}

	public IntegerProperty getPhone() {
		return phone;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public void setConsignee(String consignee) {
		this.consignee = new SimpleStringProperty(consignee);
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setDetail(String detail) {
		this.detail = new SimpleStringProperty(detail);
	}

	public void setPhone(int phone) {
		this.phone = new SimpleIntegerProperty(phone);
	}
}
