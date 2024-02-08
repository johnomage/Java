package EventDrivenProgAndAnim;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/*
 * (Create an investment-value calculator) Write a program that calculates the
future value of an investment at a given interest rate for a specified number of
years. The formula for the calculation is:
futureValue = investmentAmount * (1 + monthlyInterestRate)years*12
Use text fields for the investment amount, number of years, and annual interest
rate. Display the future amount in a text field when the user clicks the Calculate
button
 */
public class Exercise15_05 extends Application{
	
	Label lblAmount = new Label("Investment Amount: ");
	Label lblYears = new Label("Number of Years: ");
	Label lblRate = new Label("Annual Interest Rate: ");
	Label lblFuture = new Label("Future Value: ");
	TextField txtAmount = new TextField("0");
	TextField txtYear = new TextField("0");
	TextField txtRate = new TextField("0");
	TextField txtFuture = new TextField();
	Button btnCalc = new Button("Calculate");
	GridPane grid = new GridPane();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		txtAmount.alignmentProperty().set(Pos.CENTER_RIGHT);
		txtYear.alignmentProperty().set(Pos.CENTER_RIGHT);
		txtRate.alignmentProperty().set(Pos.CENTER_RIGHT);
		txtFuture.alignmentProperty().set(Pos.CENTER_RIGHT);
		txtFuture.setEditable(false);
		grid.setHgap(5);
		grid.setVgap(10);
		grid.setPadding(new Insets(10,10,10,10));
		grid.add(lblAmount, 0, 0);
		grid.add(txtAmount, 1, 0);
		grid.add(lblYears, 0, 1);
		grid.add(txtYear, 1, 1);
		grid.add(lblRate, 0, 2);
		grid.add(txtRate, 1, 2);
		grid.add(lblFuture, 0, 3);
		grid.add(txtFuture, 1, 3);
		grid.add(btnCalc, 0, 4);
		btnCalc.alignmentProperty().set(Pos.BOTTOM_RIGHT);
		
		btnCalc.setOnAction(e ->{
			calculate();
		});
		
		Scene scene = new Scene(grid, 370, 210);
		primaryStage.setTitle("Investment Calc"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	private void calculate() {
		// TODO Auto-generated method stub
		double principal = Double.parseDouble(txtAmount.getText());
		double year = Double.parseDouble(txtYear.getText());
		double rate = Double.parseDouble(txtRate.getText());
		double amount = principal * Math.pow((1 + rate/1200), year*12);
		txtFuture.setText(String.format("N %.2f", amount));
	}

}
