package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	    Pane paneForInterest = new Pane();
	    paneForInterest.setMinWidth(150);
	    paneForInterest.getChildren().add(tfInterest);    	    
	    pane.setLeft(paneForInterest);
	    
	    //Create a pane setCenter for the monthly payment column
	    Pane paneForPayment = new Pane();
	    paneForPayment.setMinWidth(150);
	    paneForPayment.getChildren().add(tfPayment);	    
	    pane.setCenter(paneForPayment);
	    
	    //Create a pane setRight for the Total payment column
	    Pane paneForTotal = new Pane();
	    paneForTotal.setMinWidth(150);	    
	    paneForTotal.getChildren().add(tfTotal);
	    pane.setRight(paneForTotal);
	    
	    //Show Table button setOnAction event
	    btSubmit.setOnAction(e -> tfInterest.setX(tfInterest.getX() + 10));
	    
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
