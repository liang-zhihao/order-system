package application.dataClass;

public class Customer {
	private int id;
	private String username;
	private String password;
	private String nickname;
	private int phone;

	public int getId() {
		return id;
	}

	public String getNickname() {
		return nickname;
	}

	public String getPassword() {
		return password;
	}

	public int getPhone() {
		return phone;
	}

	public String getUsername() {
		return username;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
