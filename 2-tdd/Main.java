package application;
	

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	Label lblArticles = new Label();
	Label lblShoppingCart = new Label();
	
	Product[] products = { 
		new Product("Sternburg Export 0,5l", 0.69),
		new Product("Sternburg Export 20x0,5l", 9.99),
		new Product("Erdinger Weissbier alkoholfrei 0,5l", 1.19),
		new Product("Corona Cero Bier alkoholfrei 0,335l", 1.45),
		new Product("Club-Mate 0,5l", 1.09)
	};
	
	ShoppingCart shoppingCart = new ShoppingCart();
	
	VBox shoppingCartBox = new VBox(5);
	
	Scene CreateScene() {
		// Use a BorderPane to be able to add more layout elements in the future
		BorderPane root = new BorderPane();
			
        GridPane grid = new GridPane();
        //grid.setGridLinesVisible(true);
        grid.setMinSize(1500, 400);
        grid.setPadding(new Insets(10, 10, 10, 10));       
        grid.setVgap(5); 
        grid.setHgap(5); 
        grid.setAlignment(Pos.CENTER);
        
        lblArticles.setText("Artikel:");
        lblShoppingCart.setText("Warenkorb:");
        

        // position UI elements along the grid
        grid.add(lblArticles, 		0, 0);
        grid.add(lblShoppingCart, 	1, 0);

        VBox productCatalogue = new VBox(5);
        productCatalogue.setAlignment(Pos.CENTER_LEFT);
    	grid.add(productCatalogue, 0, 1);
    	
    	shoppingCartBox.setAlignment(Pos.CENTER_LEFT);
    	grid.add(shoppingCartBox, 1, 1);
        
		for (Product product : products) {
			Label label = new Label(product.name + " - " + product.price);
			Button addToCartButton = new Button("In den Warenkorb");
			
			addToCartButton.setOnAction(event -> {
				shoppingCart.AddProduct(product);
				redrawShoppingCart();
		    });
			
			HBox row = new HBox(5); // spacing between button-label-button
		    row.setAlignment(Pos.CENTER_LEFT);
		    row.getChildren().addAll(label, addToCartButton);
			productCatalogue.getChildren().add(row);
		}
        
        root.setCenter(grid); // Center the grid
		Scene scene = new Scene(root,1500,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		return scene;
	}
	
	public void redrawShoppingCart() {
		for (ShoppingCartEntry entry : shoppingCart.entries) {
			Label label = new Label(entry.product.name + " - " + entry.product.price);
			Button removeButton = new Button("Entfernen");
			Button subtractButton = new Button("-");
			Button addButton = new Button("+");
			Label currentAmountLabel = new Label(Integer.toString(entry.amount));

			removeButton.setOnAction(event -> {
				shoppingCart.ChangeProductAmount(entry.product, 0);
				redrawShoppingCart();
		    });
			subtractButton.setOnAction(event -> {
				shoppingCart.ChangeProductAmount(entry.product, entry.amount - 1);
				redrawShoppingCart();
		    });
			subtractButton.setOnAction(event -> {
				shoppingCart.ChangeProductAmount(entry.product, entry.amount + 1);
				redrawShoppingCart();
		    });
			
			HBox row = new HBox(5); // spacing between button-label-button
		    row.setAlignment(Pos.CENTER_LEFT);
		    row.getChildren().addAll(label, removeButton, subtractButton, currentAmountLabel, addButton);
		    shoppingCartBox.getChildren().clear();
		    shoppingCartBox.getChildren().add(row);
		}
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {		
			primaryStage.setMinWidth(1500);
			primaryStage.setMinHeight(400);
			primaryStage.setScene(CreateScene());
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}