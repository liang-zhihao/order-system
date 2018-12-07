package application.dataClass;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Product {
	private int id;
	private StringProperty number;// 货号
	private StringProperty name;
	private IntegerProperty cost;
	private StringProperty detail;
	private DoubleProperty weight;
	private StringProperty business;// 通过id连接

	public Product(int idd, String num, String namee, int costt, String detaill, double weightt, String businesss) {
		id = idd;
		number = new SimpleStringProperty(num);
		name = new SimpleStringProperty(namee);
		cost = new SimpleIntegerProperty(costt);
		detail = new SimpleStringProperty(detaill);
		weight = new SimpleDoubleProperty(weightt);
		business = new SimpleStringProperty(businesss);
		// TODO Auto-generated constructor stub
	}

	public void setBusiness(String business) {
		this.business = new SimpleStringProperty(business);
	}

	public void setCost(int cost) {
		this.cost = new SimpleIntegerProperty(cost);
	}

	public void setDetail(String detail) {
		this.detail = new SimpleStringProperty(detail);
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = new SimpleStringProperty(name);
	}

	public void setNumber(String number) {
		this.number = new SimpleStringProperty(number);
	}

	public void setWeight(double weight) {
		this.weight = new SimpleDoubleProperty(weight);
	}

	public StringProperty getBusiness() {
		return business;
	}

	public IntegerProperty getCost() {
		return cost;
	}

	public StringProperty getDetail() {
		return detail;
	}

	public int getId() {
		return id;
	}

	public StringProperty getName() {
		return name;
	}

	public StringProperty getNumber() {
		return number;
	}

	public DoubleProperty getWeight() {
		return weight;
	}
}
