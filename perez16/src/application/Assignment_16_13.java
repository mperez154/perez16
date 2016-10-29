package application;

import java.text.NumberFormat;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.stage.Stage;

public class Assignment_16_13 extends Application {
	protected Text tfInterest = new Text(5, 20, "Interest Rate");
	protected Text tfPayment = new Text(5, 20, "Monthly Payment");
	protected Text tfTotal = new Text(5, 20, "Total Payment");
	protected TextArea taResults = new TextArea();
	protected TextArea taLoanData = new TextArea();
	protected Double[] interestRate = { 1.7, 1.8, 1.9, 2.00, 2.1, 2.2, 2.3, 2.4, 2.5, 2.6, 2.7, 
			2.8, 2.9, 3.00, 3.1, 3.2, 3.3, 3.4, 3.5, 3.6, 3.7, 3.8, 3.9, 4.0};

	protected BorderPane getPane() {

		// Create variables and required fields
		HBox paneForInput = new HBox(20);
		Button btSubmit = new Button("Show Table");
		TextField tfAmount = new TextField();
		TextField tfYears = new TextField();
		Label lbAmount = new Label("Purchase Price");
		Label lbYears = new Label("Years (1-6)");
		Label lbDownPayment = new Label("Downpayment");
		TextField tfDown = new TextField();
		

		// Initialize and create parameters for fields
		paneForInput.getChildren().addAll(lbAmount, tfAmount, lbYears, tfYears, lbDownPayment, tfDown, btSubmit);
		paneForInput.setAlignment(Pos.CENTER_LEFT);
		paneForInput.setPadding(new Insets(5, 3, 5, 3));
		paneForInput.setStyle("-fx-border-color: black");
		tfAmount.setMaxWidth(60);
		tfYears.setMaxWidth(45);
		tfDown.setMaxWidth(60);
		tfInterest.setTextAlignment(TextAlignment.LEFT);
		tfPayment.setTextAlignment(TextAlignment.LEFT);
		tfTotal.setTextAlignment(TextAlignment.LEFT);
		
		// Create a pane for results
		Pane paneForResults = new Pane();
		paneForResults.getChildren().add(taResults);
		taResults.setMinHeight(350);
		taResults.setMaxWidth(350);
		
		//Create a pane for loan details
		Pane paneForLoanDetails = new Pane();
		paneForLoanDetails.getChildren().add(taLoanData);
		taLoanData.setMaxWidth(300);
		taLoanData.setMinHeight(350);

		// Create a main pane holding all children pane
		BorderPane pane = new BorderPane();
		pane.setTop(paneForInput);
		pane.setLeft(paneForResults);
		pane.setRight(paneForLoanDetails);		

		// Show Table button setOnAction event
		btSubmit.setOnAction(e -> {
			taResults.setText(tfInterest.getText() + "\t\t" + tfPayment.getText() + "\t\t" + tfTotal.getText() + "\n");

			int years = Integer.parseInt(tfYears.getText().toString());
			double amount = Double.parseDouble(tfAmount.getText().toString());
			double down = Double.parseDouble(tfDown.getText().toString());

			for (int i = 0; i < interestRate.length; i++) {
				// Create instance of Loan class
				Loan myLoan = new Loan(interestRate[i].doubleValue(), years, amount, down);
				// Used append option and numberFormat class, information
				taResults.appendText(interestRate[i].doubleValue() + " %" + "\t\t\t"
						+ NumberFormat.getCurrencyInstance().format(myLoan.getMonthlyPayment()) + "\t\t\t\t"
						+ NumberFormat.getCurrencyInstance().format(myLoan.getTotalPayment()) + "\n");
			
			}
			
			//Utilize setters for gap insurance, title&tag, dealer fees and down payment to customize monthly payment
			
			taLoanData.setText("\nPrice:\t\t\t" + (NumberFormat.getCurrencyInstance().format(amount)) + "\n");
			taLoanData.appendText("Tax: \t\t\t\t" + (NumberFormat.getCurrencyInstance().format(amount*.07)) + "\n");
			taLoanData.appendText("GAP:\t\t\t\t" + "$500\t\t(Negotiable)\n");
			taLoanData.appendText("Tag & Title:\t\t" + "$500\n");
			taLoanData.appendText("Dealer Fees:\t\t" + "$500\t\t(Negotiable)\n\n");
			taLoanData.appendText("Total Price: \t$" + (amount + (amount*.07) + 1500 + "\n"));
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
