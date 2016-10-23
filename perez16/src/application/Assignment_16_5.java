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

		// Creating labels
		pane.add(new Label("Decimal"), 0, 0);
		pane.add(new Label("Hex"), 0, 1);
		pane.add(new Label("Binary"), 0, 2);

		// Creating TextFields
		TextField tfDecimal = new TextField();
		TextField tfHex = new TextField();
		TextField tfBinary = new TextField();

		pane.add(tfDecimal, 1, 0);
		pane.add(tfHex, 1, 1);
		pane.add(tfBinary, 1, 2);

		tfDecimal.setOnAction(e -> {
			decimalMethod(tfDecimal.getText().toString());
			tfHex.setText(myHex);
			tfBinary.setText(myBinary);

		});

		tfHex.setOnAction(e -> {
			hexToDecimal(tfHex.getText().toString().toUpperCase()); // adding to Upper b/c I noticed some hex to decimal conversions were incorrect when using lower case letters
			tfDecimal.setText(myDecimal + "");
			tfBinary.setText(myBinary);
		});

		tfBinary.setOnAction(e -> {
			try {
				binaryToDecimal(tfBinary.getText().toString());
				tfDecimal.setText(myDecimal + "");
				tfHex.setText(myHex);
			} catch (Exception e1) {
				System.out.println("Error occured with binary input/entry");
			}

		});

		Scene scene = new Scene(pane, 275, 150);
		primaryStage.setTitle("Assignment 16.5");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void decimalMethod(String input) {
		// Convert string to decimal, hex and binary conversions right after
		myDecimal = Integer.parseInt(input, 10); // String converted to int
		myHex = Integer.toHexString(myDecimal); // int to Hex
		myBinary = Integer.toBinaryString(myDecimal); // int to Binary
	}

	public void hexToDecimal(String hex) {
		myDecimal = 0;
		for (int i = 0; i < hex.length(); i++) {
			char hexChar = hex.charAt(i);
			myDecimal = myDecimal * 16 + hexCharToDecimal(hexChar);
			myBinary = Integer.toBinaryString(myDecimal);
		}

	}
	
	//Next to methods were copied from samples on page 143 of the textbook
	public static int hexCharToDecimal(char ch) {
		if (ch >= 'A' && ch <= 'F')
			return 10 + ch - 'A';
		else // ch is '0', '1', ..., or '9'
			return ch - '0';
	}

	public void binaryToDecimal(String input) {
		// Convert string to decimal, hex and binary
		myDecimal = Integer.parseInt(input, 2); // String converted to Int
		myHex = Integer.toHexString(myDecimal); // Int to Hex
		myBinary = Integer.parseInt(input, 2) + "";
	}

	public static void main(String[] args) {
		launch(args);
	}
}
