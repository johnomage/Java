package EventDrivenProgAndAnim;

import java.io.File;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PathTransitionDemo extends Application {
	
	static Circle earth, uranus, earthOrbit, sun, uranusOrbit, test;
	static PathTransition earthPath, uranusPath;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("user.home") + File.separator + "Documents" + File.separator + "Meter");
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane pane = new BorderPane();
		Rectangle rect = new Rectangle(0,0,25,50);
		rect.setFill(Color.ORANGE);
		test = new Circle(150,150,30);
		
		sun = new Circle(400,400, 35);
		earthOrbit = new Circle(400, 400, 130);
		uranusOrbit = new Circle(400,400,350);
		earth = new Circle(0,0,20);
		uranus = new Circle(0,0,15);
		
		earthOrbit.setFill(null);
		earthOrbit.setStroke(Color.BLUE);
		uranusOrbit.setFill(null);
		uranusOrbit.setStroke(Color.RED);
		uranus.setFill(Color.RED);
		sun.setFill(Color.GOLD);
		earth.setFill(Color.LIGHTSKYBLUE);
		
		// Add all nodes to the pane
		pane.getChildren().addAll(sun, earthOrbit, uranusOrbit, earth, uranus);
		
//		create path transition objects
		earthPath = new PathTransition();
		uranusPath = new PathTransition();
		
		earthPath.setDuration(Duration.millis(4000));
		earthPath.setRate(-1);
		earthPath.setPath(earthOrbit);
		earthPath.setNode(earth);
		earthPath.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		earthPath.setCycleCount(Timeline.INDEFINITE);
		earthPath.setAutoReverse(false);
		earthPath.play();
		
		uranusPath.setDuration(Duration.millis(13000));
		uranusPath.setPath(uranusOrbit);
		uranusPath.setNode(uranus);
		uranusPath.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		uranusPath.setCycleCount(Timeline.INDEFINITE);
		uranusPath.setAutoReverse(false);
		uranusPath.play();
		
		pane.setOnMousePressed(e -> {
			earthPath.pause();
			uranusPath.pause();
		});
		pane.setOnMouseReleased(e -> {
			earthPath.play();
			uranusPath.play();
		});
		
		Scene scene = new Scene(pane, 800, 800);
//		scene.setCamera();
		stage.setTitle("Planetary System"); // Set the stage title
		stage.setScene(scene); // Place the scene in the stage
		stage.show(); // Display scene
	}

}
