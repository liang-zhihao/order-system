package application.dataClass;

public class Customer {
	private int customerId;
	private String username;
	private String password;
	private String nickname;
	private int phoneNumber;
	private String email;
	private String bio;
	private String PictureName;

	public void setPictureName(String pictureName) {
		PictureName = pictureName;
	}

	public String getPictureName() {
		return PictureName;
	}

	public String getBio() {
		return bio;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getEmail() {
		return email;
	}

	public String getNickname() {
		return nickname;
	}

	public String getPassword() {
		return password;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
