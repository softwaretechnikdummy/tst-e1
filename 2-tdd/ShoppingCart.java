package application;

import java.util.ArrayList;

public class ShoppingCart {
	ArrayList<ShoppingCartEntry> entries = new ArrayList<>();

	public void AddProduct(Product product) {
    	if (product == null) {
    		throw new IllegalArgumentException("Product cannot be null");
    	}
		
		for(int i = 0; i < entries.size(); i++) {
			if (entries.get(i).product.name == product.name) {
				entries.get(i).amount += 1;
				return;
			}
		}
		
		// add new entry because no already existing entry found
		ShoppingCartEntry entry = new ShoppingCartEntry(product, 1);
		entries.add(entry);
	}
	
	public void ChangeProductAmount(Product product, int newAmount) {
		
	}
    
    public double GetTotal() {
		return 0;
    }
    
    public void Checkout() {
    	
    }
}