package application.dataClass;

public class Product {
	private int Productid;
	private String Productnumber;// 货号
	private String Name;
	private int Standardcost;
	private String Detail;
	private String PictureName;
	private Double Weight;
	private int businessiD;// 通过id连接

	public int getBusinessiD() {
		return businessiD;
	}

	public String getPictureName() {
		return PictureName;
	}

	public void setBusinessiD(int businessiD) {
		this.businessiD = businessiD;
	}

	public void setPictureName(String pictureName) {
		PictureName = pictureName;
	}

	public void setDetail(String detail) {
		Detail = detail;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setProductid(int productid) {
		Productid = productid;
	}

	public void setProductnumber(String productnumber) {
		Productnumber = productnumber;
	}

	public void setStandardcost(int standardcost) {
		Standardcost = standardcost;
	}

	public void setWeight(Double weight) {
		Weight = weight;
	}

	public String getDetail() {
		return Detail;
	}

	public String getName() {
		return Name;
	}

	public int getProductid() {
		return Productid;
	}

	public String getProductnumber() {
		return Productnumber;
	}

	public int getStandardcost() {
		return Standardcost;
	}

	public Double getWeight() {
		return Weight;
	}
}
