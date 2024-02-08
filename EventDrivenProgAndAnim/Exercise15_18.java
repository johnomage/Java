package EventDrivenProgAndAnim;
/*
 * **15.18 (Move a rectangle using mouse) Write a program that displays a rectangle.
You can point the mouse inside the rectangle and drag (i.e., move with mouse
pressed) the rectangle wherever the mouse goes. The mouse point becomes the
center of the rectangle.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise15_18 extends Application{
	Rectangle rect = new Rectangle(100, 80);
	Pane pane = new Pane(rect);

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		pane.setOnMouseDragged(e->{
			pane.getChildren().remove(rect);
			if(rect.contains(e.getX(), e.getY())) {
				rect = new Rectangle(e.getSceneX()-50, e.getSceneY()-40, 100, 80);
				pane.getChildren().add(rect);
			}
		});
		
		Scene scene = new Scene(pane, 560, 500);
//		primaryStage.setTitle("Change Circle Color"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); //
	}

}
