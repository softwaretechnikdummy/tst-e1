package application;
	
import java.util.Collection;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	Label lblInput = new Label();
	Label lblOutput = new Label();
	Label lblLanguage = new Label();
	Label lblError = new Label();
	TextField txtInput = new TextField();
	TextField txtOutput = new TextField();
	ComboBox<String> cmbLanguage = new ComboBox<String>();
	Button btnConvert = new Button();
	
	Collection<Integer> test;
	
	NumberSpeller numberSpeller = new NumberSpeller();
	
	void OnConvertAction() {
		try {
			txtOutput.setText(numberSpeller.getSpelledNumbers(cmbLanguage.getValue(), txtInput.getText()));
			lblError.setText("");
		} catch (IllegalArgumentException e) {
			lblError.setText(e.getMessage());
		}
		
	}
	
	Scene CreateScene() {
		// Use a BorderPane to be able to add more layout elements in the future
		BorderPane root = new BorderPane();
			
        GridPane grid = new GridPane();
        //grid.setGridLinesVisible(true);
        grid.setMinSize(250, 180);
        grid.setPadding(new Insets(10, 10, 10, 10));       
        grid.setVgap(5); 
        grid.setHgap(5); 
        grid.setAlignment(Pos.CENTER);
        
        // UI element styling
        lblError.setTextFill(Color.color(1, 0, 0));

        // UI element content
        lblInput.setText("Input:");
        lblOutput.setText("Output:");
        lblLanguage.setText("Language:");
        btnConvert.setText("Convert");
        
        // add languages to combo box
        cmbLanguage.getItems().addAll(numberSpeller.getLanguages());
        cmbLanguage.getSelectionModel().select(0);
        

        // position UI elements along the grid
        grid.add(lblInput, 		0, 0);
        grid.add(lblOutput, 	0, 1);
        grid.add(lblLanguage, 	0, 2);
        grid.add(txtInput, 		1, 0);
        grid.add(txtOutput, 	1, 1);
        grid.add(cmbLanguage, 	1, 2);
        grid.add(btnConvert, 	0, 3, 2, 1); // span button across two columns
        grid.add(lblError, 		0, 4, 2, 1); // span error label across two columns
        
        
        // Make combo box and button use up all available horizontal space
        cmbLanguage.setMaxWidth(Double.MAX_VALUE);
        btnConvert.setMaxWidth(Double.MAX_VALUE);
        btnConvert.setMinWidth(250);
        
        // Setup Button click handler
        btnConvert.setOnAction((arg0) -> {
        	OnConvertAction();
        });
        
        root.setCenter(grid); // Center the grid
		Scene scene = new Scene(root,280,180);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		return scene;
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {		
			primaryStage.setMinWidth(280);
			primaryStage.setMinHeight(210);
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
