/*
 * *16.2 (Select geometric figures) Write a program that draws various figures, as shown
in Figure 16.36b. The user selects a figure from a radio button and uses a check
box to specify whether it is filled.
 */

package UIControlsAndMultimedia;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise16_2_SelectGeometricFigures extends Application {

	static Rectangle rectangle;
	static Circle circle;
	static Ellipse ellipse;
	static Text text = new Text("Choose a shape");
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
//		StackPane stack = new StackPane();
		HBox hBox = new HBox(15);
		RadioButton rbEllipse = new RadioButton("Ellipse"), rbCircle = new RadioButton("Circle"), rbRectangle = new RadioButton("Rectangle");
		CheckBox cbFill = new CheckBox("Fill");
		StackPane stack = new StackPane(hBox, text);
		
		hBox.setAlignment(Pos.BOTTOM_CENTER);
		hBox.getChildren().addAll(rbCircle, rbRectangle, rbEllipse, cbFill);
		stack.setPadding(new Insets(20));
		
		ToggleGroup group = new ToggleGroup();
		rbEllipse.setToggleGroup(group);
		rbCircle.setToggleGroup(group);
		rbRectangle.setToggleGroup(group);
		
		EventHandler<ActionEvent> handler = e->{
			if(rbCircle.isSelected()) {
				stack.getChildren().removeAll(ellipse, rectangle, text);
				stack.getChildren().add(circle = new Circle(100, 75, 50));
				circle.setFill(null);
				circle.setStroke(Color.BLACK);
				if(cbFill.isSelected()) {
					circle.setFill(Color.CHARTREUSE);
				}
			}
			
			else if(rbRectangle.isSelected()) {
				stack.getChildren().removeAll(ellipse, circle, text);
				stack.getChildren().add(rectangle = new Rectangle(100, 75, 120, 90));
				rectangle.setFill(null);
				rectangle.setStroke(Color.BLACK);
				if(cbFill.isSelected()) {
					rectangle.setFill(Color.GOLD);
				}
			}
			
			else if(rbEllipse.isSelected()) {
				stack.getChildren().removeAll(rectangle, circle, text);
				stack.getChildren().add(ellipse = new Ellipse(100, 75, 60, 40));
				ellipse.setFill(null);
				ellipse.setStroke(Color.BLACK);
				if(cbFill.isSelected()) {
					ellipse.setFill(Color.DEEPSKYBLUE);
				}
			}
		};
		
		rbCircle.setOnAction(handler);
		rbRectangle.setOnAction(handler);
		rbEllipse.setOnAction(handler);
		
		Scene scene = new Scene(stack, 395, 250);
		stage.setScene(scene);
		stage.show();
	}
	
}
