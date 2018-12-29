package application.dataClass;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DeliveryAddress {
	private int deliveryAddressId;
	private int customerId;
	private StringProperty consignee;
	private IntegerProperty phoneNumber;
	private StringProperty detail;

	public String getConsignee() {
		return consignee.get();
	}

	public int getCustomerId() {
		return customerId;
	}

	public int getDeliveryAddressId() {
		return deliveryAddressId;
	}

	public String getDetail() {
		return detail.get();
	}

	public int getPhoneNumber() {
		return phoneNumber.get();
	}

	public void setConsignee(String consignee) {
		this.consignee = new SimpleStringProperty(consignee);
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setDeliveryAddressId(int deliveryAddressId) {
		this.deliveryAddressId = deliveryAddressId;
	}

	public void setDetail(String detail) {
		this.detail = new SimpleStringProperty(detail);
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = new SimpleIntegerProperty(phoneNumber);
	}
}