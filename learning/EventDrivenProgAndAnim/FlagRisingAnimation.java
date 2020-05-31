package EventDrivenProgAndAnim;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FlagRisingAnimation extends Application {
 @Override // Override the start method in the Application class
 	public void start(Stage primaryStage) {
	  // Create a pane
	 Pane pane = new Pane();

 // Add an image view and add it to pane
	 ImageView imageView = new ImageView("file:///C:/Users/Honeeks Inc/Pictures/Ultra.HD.Wallpaper.Pack.20/005.jpg");
	 pane.getChildren().add(imageView);
 // Create a path transition
	 PathTransition pt = new PathTransition(Duration.millis(4000), new Line(350,700,350, 50), imageView);
	 pt.setCycleCount(5);
	 pt.play(); // Start animation

 // Create a scene and place it in the stage
	 Scene scene = new Scene(pane, 700, 700);
	 primaryStage.setTitle("FlagRisingAnimation"); // Set the stage title
	 primaryStage.setScene(scene); // Place the scene in the stage
	 primaryStage.show(); // Display the stage
 	}
 
 	public static void main(String[] edus) {
 		Application.launch(edus);
 	}
}