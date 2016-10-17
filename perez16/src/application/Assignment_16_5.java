package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Assignment_16_5 extends Application {

	@Override
	public void start(Stage primaryStage) {
		// Creating pane
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(15, 15, 15, 15));
		pane.setVgap(5.5);
		pane.setHgap(10.0);

		//Creating labels
		pane.add(new Label("Decimal"), 0,0);
		pane.add(new Label("Hex"), 0,1);
		pane.add(new Label("Binary"), 0,2);
		
		//Creating TextFields
		TextField input = new TextField();
		TextField input2 = new TextField();
		TextField input3 = new TextField();
		
		pane.add(input, 1, 0);
		pane.add(input2, 1, 1);
		pane.add(input3, 1, 2);
		
		
		input.setOnAction(e -> 
		{
			input2.setText(input.getText());
			input3.setText(input.getText());
		});
		
		input2.setOnAction(e -> 
		{
			input.setText(input2.getText());
			input3.setText(input2.getText());
		});
		
		input3.setOnAction(e -> 
		{
			input.setText(input3.getText());
			input2.setText(input3.getText());
		});
		

		Scene scene = new Scene(pane, 250, 200);
		primaryStage.setTitle("Assignment 16.5");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
