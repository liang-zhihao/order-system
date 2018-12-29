package application.dataClass;

public class Business {
	private int businessId;
	private String businessName;
	private String username;
	private String password;
	private String phoneNumber;
	private String email;
	private String shippingAddress;
	private String PictureName;

	public void setPictureName(String pictureName) {
		PictureName = pictureName;
	}

	public String getPictureName() {
		return PictureName;
	}

	public int getBusinessId() {
		return businessId;
	}

	public String getBusinessName() {
		return businessName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public String getUsername() {
		return username;
	}

	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
