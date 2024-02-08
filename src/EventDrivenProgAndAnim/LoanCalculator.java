package EventDrivenProgAndAnim;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/*
 * 1. Create the user interface, as shown in Figure 15.9.
a. Create a GridPane. Add labels, text fields, and button to the pane.
b. Set the alignment of the button to the right.
2. Process the event.
 */

public class LoanCalculator extends Application {
	GridPane grid = new GridPane();
	HBox hbox = new HBox();
	TextField txtRate = new TextField("0");
	TextField txtYear = new TextField("0");
	TextField txtLoan = new TextField("0");
	TextField txtMonthly = new TextField("0");
	TextField txtTotal = new TextField("0");
	Button btCalculate = new Button("Calculate");
	Button btExit = new Button("Exit");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		grid.setHgap(10);
		grid.setVgap(10);
		grid.add(new Label("Annual Interest Rate"), 0, 0);
		grid.add(txtRate, 1, 0);
		grid.add(new Label("Number of Years"), 0, 1);
		grid.add(txtYear, 1, 1);
		grid.add(new Label("Loan Amount"), 0, 2);
		grid.add(txtLoan, 1, 2);
		grid.add(new Label("Monthly Payment"), 0, 3);
		grid.add(txtMonthly, 1, 3);
		grid.add(new Label("Total Payment"), 0, 4);
		grid.add(txtTotal, 1, 4);
		grid.add(btCalculate, 1, 5);
		grid.add(btExit, 0, 5);
		
		txtRate.setAlignment(Pos.BOTTOM_RIGHT);
		txtYear.setAlignment(Pos.BOTTOM_RIGHT);
		txtLoan.setAlignment(Pos.BOTTOM_RIGHT);
		txtMonthly.setAlignment(Pos.BOTTOM_RIGHT);
		txtTotal.setAlignment(Pos.BOTTOM_RIGHT);
		txtMonthly.setEditable(false);
		txtTotal.setEditable(false);
		
		grid.setHalignment(btCalculate, HPos.RIGHT );
		grid.setAlignment(Pos.CENTER);
		
		btCalculate.setCursor(Cursor.HAND);
		btCalculate.setOnAction(e -> LoanPayment());
		btExit.setOnAction(e -> System.exit(0));
		
		
		Scene scene = new Scene(grid, 400, 250);
		stage.setScene(scene);
		stage.show();
	}

	TextField LoanPayment() {
		double interest = Double.parseDouble(txtRate.getText());
		double loan = Double.parseDouble(txtLoan.getText());
		int year = Integer.parseInt(txtYear.getText());
		
		double monthInterest = interest/1200;
		double paymonth = loan * monthInterest/(1-1/Math.pow(1 + interest/1200, 12*year));
		double payment = paymonth * year* 12	;
		
		txtMonthly.setText(String.format("$%.2f", paymonth));
		txtTotal.setText(String.format("$%.2f", payment));
		if(interest == 0 || loan == 0 || year == 0) {
			error();
			txtTotal.setText("0");
			txtMonthly.setText("0");
			return txtTotal;
		}
		else return txtTotal;		
	}
	
	public void error() {
		GridPane pane = new GridPane();
		Button btnOk = new Button("OK");
		btnOk.setOnAction(e -> System.exit(1));
		Stage stage1 = new Stage();
		pane.add(new Label("Annual Interest Rate, Number of Years or\nLoan Amount cannot be zero"), 0, 0);
		pane.add(btnOk, 1, 1);
		pane.setPadding(new Insets(5,5,5,5));
		pane.setAlignment(Pos.CENTER);
		Scene scene = new Scene(pane, 350, 100);
		stage1.setScene(scene);
		stage1.setTitle("Caution!");
		stage1.show();
	}
}
