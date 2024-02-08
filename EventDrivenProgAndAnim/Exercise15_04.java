package EventDrivenProgAndAnim;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/*
 * (Create a simple calculator) Write a program to perform addition, subtraction,
multiplication, and division.
 */

public class Exercise15_04 extends Application{

	VBox vbox = new VBox(70);
	HBox hboxdown = new HBox(5);
	HBox hboxup = new HBox(5);
	TextField textNum1 = new TextField();
	Label lblNum1 = new Label("Number 1: ");
	TextField textNum2 = new TextField();
	Label lblNum2 = new Label("Number 2: ");
	TextField textResult = new TextField();
	Label lblResult = new Label("Result: ");
	Button add = new Button("Add");
	Button subtract = new Button("Subtract");
	Button multiply = new Button("Multiply");
	Button divide = new Button("Divide");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		textResult.setEditable(false);
		add.setOnAction(e ->{
			add();
		});
		subtract.setOnAction(e ->{
			subtract();
		});
		multiply.setOnAction(e ->{
			multiply();
		});
		divide.setOnAction(e ->{
			divide();
		});
		
		vbox.setPadding(new Insets(5,5,5,5));
		hboxup.getChildren().addAll(lblNum1, textNum1, lblNum2, textNum2, lblResult, textResult);
		hboxdown.getChildren().addAll(add, subtract, multiply, divide);
		vbox.getChildren().addAll(hboxup, hboxdown);
		vbox.setAlignment(Pos.BOTTOM_CENTER);
		hboxdown.setAlignment(Pos.BOTTOM_CENTER);
		
		Scene scene = new Scene(vbox, 800, 150);
		primaryStage.setTitle("SimpleCalculator"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	private void divide() {
		// TODO Auto-generated method stub
		textResult.setText(String.valueOf(Double.parseDouble(textNum1.getText()) / Double.parseDouble(textNum2.getText())));
	}

	private void multiply() {
		// TODO Auto-generated method stub
		textResult.setText(String.valueOf(Double.parseDouble(textNum1.getText()) * Double.parseDouble(textNum2.getText())));
	}

	private void subtract() {
		// TODO Auto-generated method stub
		textResult.setText(String.valueOf(Double.parseDouble(textNum1.getText()) - Double.parseDouble(textNum2.getText())));
	}

	private void add() {
		// TODO Auto-generated method stub
		textResult.setText(String.valueOf(Double.parseDouble(textNum1.getText()) + Double.parseDouble(textNum2.getText())));
	}

}
