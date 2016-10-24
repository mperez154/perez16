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
	protected TextArea taResults =  new TextArea();
	protected Double[] interestRate = {5.0, 5.25, 5.5, 5.75, 6.00, 6.25, 6.5, 6.75, 7.00, 7.25, 7.5, 7.75, 8.0};
	
	protected BorderPane getPane() {
		
		//Create variables and required fields
	    HBox paneForInput = new HBox(20);
	    Button btSubmit = new Button("Show Table"); 
	    TextField tfAmount = new TextField();
	    TextField tfYears = new TextField();
	    Label lbAmount = new Label("Loan Amount");
	    Label lbYears = new Label("Number of Years");
	    
	    //Initialize and create parameters for fields
	    paneForInput.getChildren().addAll(lbAmount, tfAmount, lbYears, tfYears, btSubmit);
	    paneForInput.setAlignment(Pos.CENTER_LEFT);
	    paneForInput.setPadding(new Insets (5,5,5,5));
	    paneForInput.setStyle("-fx-border-color: black");
	    tfAmount.setMaxWidth(80);
	    tfYears.setMaxWidth(45);
	    tfInterest.setTextAlignment(TextAlignment.LEFT);
	    tfPayment.setTextAlignment(TextAlignment.LEFT);
	    tfTotal.setTextAlignment(TextAlignment.LEFT);
	    
	    //Create a main pane
	    BorderPane pane = new BorderPane();
	    pane.setTop(paneForInput);
	    
	    //Create a pane setLeft for the interest rate column
	    Pane paneForResults = new Pane();
	    //paneForResults.setMinWidth(150);
	    paneForResults.getChildren().add(taResults);    	    
	    pane.setLeft(paneForResults);
	    
	    //Show Table button setOnAction event
	    btSubmit.setOnAction(e -> 
	    {
	    	taResults.setText(tfInterest.getText() + "\t\t" + tfPayment.getText() + "\t\t" + tfTotal.getText() + "\n");
	    	
	    	int years = Integer.parseInt(tfYears.getText().toString());
	    	double amount = Double.parseDouble(tfAmount.getText().toString());
	    	
		    for(int i = 0; i < interestRate.length; i++)
		    {
		    	//Create instance of Loan class
			    Loan myLoan = new Loan(interestRate[i].doubleValue(), years, amount);
		    	//Append text for taResults text area
			    taResults.appendText(interestRate[i].doubleValue() + "\t\t\t\t" + myLoan.getMonthlyPayment() + "\t" + myLoan.getTotalPayment() + "\n");
			    i++;
			    
				System.out.printf("Payment is $%7.2f\n",(myLoan.getMonthlyPayment()));
				
				//NumberFormat test = myLoan.getMonthlyPayment().NumberFormat.getCurrencyInstance();

		    	
		    }
		    
		   
	    }
	    );
	    
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
