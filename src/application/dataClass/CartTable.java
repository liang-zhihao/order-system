package application.dataClass;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CartTable {
	private IntegerProperty quantity;
	private StringProperty itemName;
	private StringProperty Business;
	private BooleanProperty isCheck;
	private IntegerProperty cost;

	public void setBusiness(String business) {
		this.Business = new SimpleStringProperty(business);
	}

	public void itemName(String itemName) {
		this.Business = new SimpleStringProperty(itemName);

	}

	public void setQuantity(int quantity) {
		this.quantity = new SimpleIntegerProperty(quantity);

	}

	public String getBusiness() {
		return Business.get();
	}

	public String getItemName() {
		return itemName.get();
	}

	public int getQuantity() {
		return quantity.get();
	}
}
