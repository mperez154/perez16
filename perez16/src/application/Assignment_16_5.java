package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Assignment_16_5 extends Application {
	private int myDecimal;
	private String myHex;
	private String myBinary;

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
		TextField tfDecimal = new TextField();
		TextField tfHex = new TextField();
		TextField tfBinary = new TextField();
		
		pane.add(tfDecimal, 1, 0);
		pane.add(tfHex, 1, 1);
		pane.add(tfBinary, 1, 2);
		
		
		tfDecimal.setOnAction(e -> 
		{
			decimalMethod(tfDecimal.getText().toString());
			tfHex.setText(myHex);
			tfBinary.setText(myBinary);
			
		});
		
		tfHex.setOnAction(e -> 
		{
			hexToDecimal(tfHex.getText().toString());
			tfDecimal.setText(myDecimal + "");
			tfBinary.setText(myBinary);
		});
		
		tfBinary.setOnAction(e -> 
		{
			//input.setText(input3.getText());
			//input2.setText(input3.getText());
		});
		

		Scene scene = new Scene(pane, 250, 200);
		primaryStage.setTitle("Assignment 16.5");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public void decimalMethod(String input)
	{
		//Convert string to decimal, hex and binary
		myDecimal = Integer.parseInt(input, 10);	//String converted to Int
		myHex = Integer.toHexString(myDecimal);	//Int to Hex
		myBinary = Integer.toBinaryString(myDecimal);	//Int to Binary
		//System.out.println(myDecimal + " " + myHex + " " + myBinary);
	}
	
	public void hexToDecimal(String input)
	{
		
		// Convert Hex to Decimal (from book sample on page 143		
		char ch = input.toUpperCase().charAt(0);
		if (ch <= 'F' && ch >= 'A') {
			myDecimal = ch - 'A' + 10;
			myBinary = Integer.toBinaryString(myDecimal);	//Int to Binary
			System.out.println("The decimal value for hex digit " 	+ ch + " is " + myDecimal);
		 }
		 else if (Character.isDigit(ch)) {
			 System.out.println("The decimal value for hex digit " + ch + " is " + ch);
			 myDecimal = ch;
			 myBinary = Integer.toBinaryString(myDecimal);	//Int to Binary
		 }
		 else {
		 System.out.println(ch + " is an invalid input");
		 }
		
		 
	}
	
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
