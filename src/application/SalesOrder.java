package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SalesOrder {
	private int salesOrder;
	private int businessId;
	private int productId;
	private int customerId;
	private int deliveryAddId;
	private IntegerProperty salesOrderNumber;
	private IntegerProperty quantity;
	private StringProperty status;
	private StringProperty orderDate;
	private StringProperty comment;
	private IntegerProperty subTotal;
	private StringProperty shippingAdd;

	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}

	public void setComment(String comment) {
		this.comment = new SimpleStringProperty(comment);
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setDeliveryAddId(int deliveryAddId) {
		this.deliveryAddId = deliveryAddId;
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

	public void setSalesOrder(int salesOrder) {
		this.salesOrder = salesOrder;
	}

	public void setSalesOrderNumber(int salesOrderNumber) {
		this.salesOrderNumber = new SimpleIntegerProperty(salesOrderNumber);
	}

	public void setShippingAdd(String shippingAdd) {
		this.shippingAdd = new SimpleStringProperty(shippingAdd);
	}

	public void setStatus(String status) {
		this.status = new SimpleStringProperty(status);
	}

	public void setSubTotal(int subTotal) {
		this.subTotal = new SimpleIntegerProperty(subTotal);
	}

	public int getBusinessId() {
		return businessId;
	}

	public StringProperty getComment() {
		return comment;
	}

	public int getCustomerId() {
		return customerId;
	}

	public int getDeliveryAddId() {
		return deliveryAddId;
	}

	public StringProperty getOrderDate() {
		return orderDate;
	}

	public int getProductId() {
		return productId;
	}

	public IntegerProperty getQuantity() {
		return quantity;
	}

	public int getSalesOrder() {
		return salesOrder;
	}

	public IntegerProperty getSalesOrderNumber() {
		return salesOrderNumber;
	}

	public StringProperty getShippingAdd() {
		return shippingAdd;
	}

	public StringProperty getStatus() {
		return status;
	}

	public IntegerProperty getSubTotal() {
		return subTotal;
	}
}
