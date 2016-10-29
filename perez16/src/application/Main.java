package application;
	
import java.text.NumberFormat;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class Main extends Application {
	protected Text tfInterest = new Text(5, 20, "Interest Rate");
	protected Text tfPayment = new Text(5, 20, "Monthly Payment");
	protected Text tfTotal = new Text(5, 20, "Total Payment");
	protected TextArea taResults = new TextArea();
	protected Double[] interestRate = { 5.0, 5.125, 5.25, 5.375, 5.5, 5.625, 5.75, 5.875, 6.00, 6.125, 6.25, .375, 6.5,
			6.625, 6.75, 6.875, 7.00, 7.125, 7.25, 7.375, 7.5, 7.625, 7.75, 7.875, 8.0 };
	protected Double[] goodCredit = { 1.75, 1.87, 2.00, 2.12, 2.25, 2.37, 2.5, 2.62, 2.75, 2.87, 3.00, 3.12, 3.25, 3.37, 3.5};

	protected BorderPane getPane() {

		// Create variables and required fields
		HBox paneForInput = new HBox(20);
		Button btSubmit = new Button("Show Table");
		TextField tfAmount = new TextField();
		TextField tfYears = new TextField();
		Label lbAmount = new Label("Loan Amount");
		Label lbYears = new Label("Number of Years");

		// Initialize and create parameters for fields
		paneForInput.getChildren().addAll(lbAmount, tfAmount, lbYears, tfYears, btSubmit);
		paneForInput.setAlignment(Pos.CENTER_LEFT);
		paneForInput.setPadding(new Insets(5, 3, 5, 3));
		paneForInput.setStyle("-fx-border-color: black");
		tfAmount.setMaxWidth(60);
		tfYears.setMaxWidth(45);
		tfInterest.setTextAlignment(TextAlignment.LEFT);
		tfPayment.setTextAlignment(TextAlignment.LEFT);
		tfTotal.setTextAlignment(TextAlignment.LEFT);

		// Create a main pane
		BorderPane pane = new BorderPane();
		pane.setTop(paneForInput);

		// Create a pane setLeft for the interest rate column
		Pane paneForResults = new Pane();
		// paneForResults.setMinWidth(150);
		paneForResults.getChildren().add(taResults);
		pane.setLeft(paneForResults);

		// Show Table button setOnAction event
		btSubmit.setOnAction(e -> {
			taResults.setText(tfInterest.getText() + "\t\t" + tfPayment.getText() + "\t\t" + tfTotal.getText() + "\n");

			int years = Integer.parseInt(tfYears.getText().toString());
			double amount = Double.parseDouble(tfAmount.getText().toString());
			double down = 500;

			for (int i = 0; i < goodCredit.length; i++) {
				// Create instance of Loan class
				Loan myLoan = new Loan(goodCredit[i].doubleValue(), years, amount, down);
				// Used append option and numberFormat class, information
				// provided in docs.oracle.com site (see collaboration statement for more details
				taResults.appendText(goodCredit[i].doubleValue() + "\t\t\t\t"
						+ NumberFormat.getCurrencyInstance().format(myLoan.getMonthlyPayment()) + "\t\t\t\t"
						+ NumberFormat.getCurrencyInstance().format(myLoan.getTotalPayment()) + "\n");
			
			}

		});

		return pane;
	}

	@Override
	public void start(Stage primaryStage) {
		// Create a scene and place it in the stage
		Scene scene = new Scene(getPane());
		primaryStage.setTitle("Assignment_16_13"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

	}

	public static void main(String[] args) {
		launch(args);
	}
}
