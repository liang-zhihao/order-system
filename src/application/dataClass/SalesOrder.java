package application.dataClass;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SalesOrder {
	private int salesOrderId;
	private int businessId;
	private int productId;
	private int customerId;
	private int deliveryAddressId;
	private IntegerProperty salesOrderNumber;
	private IntegerProperty quantity;
	private StringProperty status;
	private StringProperty orderDate;
	private StringProperty comment;
	private DoubleProperty subTotal = new SimpleDoubleProperty(0);

	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}

	public void setComment(String comment) {
		this.comment = new SimpleStringProperty(comment);
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setDeliveryAddressId(int deliveryAddId) {
		this.deliveryAddressId = deliveryAddId;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = new SimpleStringProperty(orderDate);
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setQuantity(int quantity) {
		this.quantity = new SimpleIntegerProperty(quantity);
	}

	public void setSalesOrderId(int salesOrder) {
		this.salesOrderId = salesOrder;
	}

	public void setSalesOrderNumber(int salesOrderNumber) {
		this.salesOrderNumber = new SimpleIntegerProperty(salesOrderNumber);
	}

	public void setStatus(String status) {
		this.status = new SimpleStringProperty(status);
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = new SimpleDoubleProperty(subTotal);
	}

	public int getBusinessId() {
		return businessId;
	}

	public String getComment() {
		return comment.get();
	}

	public int getCustomerId() {
		return customerId;
	}

	public int getDeliveryAddressId() {
		return deliveryAddressId;
	}

	public String getOrderDate() {
		return orderDate.get();
	}

	public int getProductId() {
		return productId;
	}

	public int getQuantity() {
		return quantity.get();
	}

	public int getSalesOrderId() {
		return salesOrderId;
	}

	public int getSalesOrderNumber() {
		return salesOrderNumber.get();
	}

	public String getStatus() {
		return status.get();
	}

	public Double getSubTotal() {
		return subTotal.get();
	}
}
