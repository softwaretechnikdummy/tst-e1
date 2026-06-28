package application;

public class ShoppingCartEntry {
	Product product;
	int amount;
	
	public ShoppingCartEntry(Product product, int amount) {
		this.product = product;
		this.amount = amount;
	}
}