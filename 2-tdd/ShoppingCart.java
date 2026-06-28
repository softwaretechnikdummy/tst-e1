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
    	if (product == null) {
    		throw new IllegalArgumentException("Product cannot be null");
    	}
    	if (newAmount < 0) {
    		throw new IllegalArgumentException("amount cannot be less than zero");
    	}

		int foundIndex = -1;
		for(int i = 0; i < entries.size(); i++) {
			if (entries.get(i).product.name == product.name) {
				foundIndex = i;
				break;
			}
		}
    	
    	if (newAmount == 0) {
    		if (foundIndex != -1) { // Product is found and needs to be actively removed
    			entries.remove(foundIndex);
    		}
    	} else {
    		if (foundIndex != -1) { // Product is found and needs to be amount adjusted
    			entries.get(foundIndex).amount = newAmount;
    		} else { // Product needs to be added
    			ShoppingCartEntry entry = new ShoppingCartEntry(product, newAmount);
    			entries.add(entry);
    		}
    	}
	}
    
    public double GetTotal() {
    	double total = 0;
    	for(int i = 0; i < entries.size(); i++) {
			total += entries.get(i).amount * entries.get(i).product.price;
		}
		return total;
    }
    
    public void Checkout() {
    	entries.clear();
    }
}