package EventDrivenProgAndAnim;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/*
 * *15.7 (Change color using a mouse) Write a program that displays the color of a
circle as black when the mouse button is pressed and as white when the mouse
button is released.
 */
public class Exercise15_07 extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Circle circle = new Circle(50);
		Pane pane = new StackPane();
		
		pane.setOnMousePressed(e->{
			circle.setFill(Color.BLACK);
		});
		
		pane.setOnMouseReleased(e->{ 
			circle.setFill(Color.WHITE);
			});
	
	pane.getChildren().add(circle);
	Scene scene = new Scene(pane, 300, 100);
	primaryStage.setTitle("Change Circle Color"); // Set the stage title
	primaryStage.setScene(scene); // Place the scene in the stage
	primaryStage.show(); // D
	}
}
