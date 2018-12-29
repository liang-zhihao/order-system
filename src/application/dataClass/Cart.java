package application.dataClass;

public class Cart {
	private int cartId;
	private int customerId;
	private int productId;
	private int number;

	public int getCartId() {
		return cartId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public int getNumber() {
		return number;
	}

	public int getProductId() {
		return productId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
}
