package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoppingCartTest {
	ShoppingCart cart;
	
	Product[] products = { 
		new Product("Sternburg Export 0,5l", 0.69),
		new Product("Sternburg Export 20x0,5l", 9.99),
		new Product("Erdinger Weissbier alkoholfrei 0,5l", 1.19),
		new Product("Corona Cero Bier alkoholfrei 0,335l", 1.45),
		new Product("Club-Mate 0,5l", 1.09)
	};

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAddProduct() {
		cart = new ShoppingCart();
		Assertions.assertEquals(0, cart.entries.size()); // cart should be empty first
		
		Assertions.assertThrows(IllegalArgumentException.class, 
				() -> { cart.AddProduct(null); }); // null value for product should throw exception
		
		cart.AddProduct(products[0]);
		Assertions.assertEquals(1, cart.entries.size()); // cart should contain 1 entry now
		Assertions.assertEquals(1, cart.entries.get(0).amount); // amount must be 1
		Assertions.assertEquals(products[0], cart.entries.get(0).product); // just added product should match

		cart.AddProduct(products[2]);
		Assertions.assertEquals(2, cart.entries.size()); // cart should contain 2 entries now
		Assertions.assertEquals(1, cart.entries.get(1).amount); // amount must be 1
		Assertions.assertEquals(products[2], cart.entries.get(1).product); // just added product should match

		cart.AddProduct(products[0]);
		Assertions.assertEquals(2, cart.entries.size()); // cart should still contain 2 entries because same product added
		Assertions.assertEquals(2, cart.entries.get(0).amount); // amount must be 2 now for first entry
	}

	@Test
	void testChangeProductAmount() {
		cart = new ShoppingCart();
		Assertions.assertEquals(0, cart.entries.size()); // cart should be empty first
		
		Assertions.assertThrows(IllegalArgumentException.class, 
				() -> { cart.ChangeProductAmount(null, 1); }); // null value for product should throw exception
		
		Assertions.assertThrows(IllegalArgumentException.class, 
				() -> { cart.ChangeProductAmount(products[0], -10); }); // negative values should throw an error
		
		cart.ChangeProductAmount(products[0], 1);
		Assertions.assertEquals(1, cart.entries.size()); // cart should contain 1 entry now
		Assertions.assertEquals(1, cart.entries.get(0).amount); // amount must be 1
		Assertions.assertEquals(products[0], cart.entries.get(0).product); // just added product should match
		
		cart.ChangeProductAmount(products[0], 5);
		Assertions.assertEquals(1, cart.entries.size()); // cart should still contain 1 entry
		Assertions.assertEquals(5, cart.entries.get(0).amount); // amount must be 5
		
		cart.ChangeProductAmount(products[0], 0);
		Assertions.assertEquals(0, cart.entries.size()); // cart should be empty again because removed element
	}

	@Test
	void testGetTotal() {
		cart = new ShoppingCart();
		Assertions.assertEquals(0, cart.entries.size()); // cart should be empty first
		Assertions.assertEquals(0, cart.GetTotal()); // cart total should be 0 first
		
		cart.AddProduct(products[0]);
		Assertions.assertEquals(products[0].price, cart.GetTotal()); // cart total should equal product total
		
		cart.AddProduct(products[0]);
		Assertions.assertEquals(products[0].price * 2, cart.GetTotal()); // cart total should equal double the product total
		
		cart.AddProduct(products[1]);
		Assertions.assertEquals(products[0].price * 2 + products[1].price, cart.GetTotal()); // cart total should equal double the product total + the other product total
	}

	@Test
	void testCheckout() {
		cart = new ShoppingCart();
		Assertions.assertEquals(0, cart.entries.size()); // cart should be empty first
		cart.AddProduct(products[0]);
		Assertions.assertEquals(1, cart.entries.size()); // cart should contain 1 product
		cart.Checkout();
		Assertions.assertEquals(0, cart.entries.size()); // cart should be empty again
	}

}
