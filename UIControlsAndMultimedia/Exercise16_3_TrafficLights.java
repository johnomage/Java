/*
 * **16.3 (Traffic lights) Write a program that simulates a traffic light. The program lets
the user select one of three lights: red, yellow, or green. When a radio button
is selected, the light is turned on. Only one light can be on at a time (see
Figure 16.37a). No light is on when the program starts
 */

package UIControlsAndMultimedia;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise16_3_TrafficLights extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane border = new BorderPane();
		VBox vBox = new VBox(10);
		HBox hBox = new HBox(20);
		RadioButton redRadioButton = new RadioButton("Red"), yellowRadioButton = new RadioButton("Yellow"), greenRadioButton = new RadioButton("Green"); 
		Circle redCircle = new Circle(100, 120, 30), yellowCircle = new Circle(170, 120, 30), greenCircle = new Circle(240, 120, 30); //circle for lights
		
		vBox.getChildren().addAll(redCircle, yellowCircle, greenCircle);
		vBox.setAlignment(Pos.CENTER);
		vBox.setStyle("-fx-border-width: 2; -fx-border-color: brown; -fx-background-color: grey");
		vBox.resize(70, 230);
		hBox.getChildren().addAll(redRadioButton, yellowRadioButton, greenRadioButton);
		
		border.setBottom(hBox);
		border.setCenter(vBox);
		border.setPadding(new Insets(20, 20, 10, 20));
		
		ToggleGroup group = new ToggleGroup(); //toggle group to select one radio button a time.
		redRadioButton.setToggleGroup(group);
		yellowRadioButton.setToggleGroup(group);
		greenRadioButton.setToggleGroup(group);
		
		EventHandler<ActionEvent> handler = e->{
			if(redRadioButton.isSelected()) {
				redCircle.setFill(Color.RED);
				yellowCircle.setFill(Color.BLACK);
				greenCircle.setFill(Color.BLACK);
			}
			
			else if(yellowRadioButton.isSelected()) {
				yellowCircle.setFill(Color.YELLOW);
				redCircle.setFill(Color.BLACK);
				greenCircle.setFill(Color.BLACK);
			}
			
			else if(greenRadioButton.isSelected()) {
				greenCircle.setFill(Color.LIGHTGREEN);
				redCircle.setFill(Color.BLACK);
				yellowCircle.setFill(Color.BLACK);
			}
		};
		
		redRadioButton.setOnAction(handler);
		yellowRadioButton.setOnAction(handler);
		greenRadioButton.setOnAction(handler);
		
		Scene scene = new Scene(border, 320, 300);
		stage.setScene(scene);
		stage.setTitle("Traffic Light");
		stage.show();
	}

}
