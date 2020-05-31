package EventDrivenProgAndAnim;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

//The FadeTransition class defines an animation for the change of opacity in a node.

public class FadeTransitionDemo extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Ellipse ellipse = new Ellipse(200,200,100,50);
		Pane pane = new Pane();
		Duration key = Duration.ONE;
		ellipse.setFill(Color.RED);
		ellipse.setStroke(Color.YELLOWGREEN);
		ellipse.centerXProperty().bind(pane.widthProperty().divide(2));
		ellipse.centerYProperty().bind(pane.heightProperty().divide(2));
		ellipse.radiusXProperty().bind(pane.widthProperty().multiply(.4));
		ellipse.radiusYProperty().bind(pane.heightProperty().multiply(0.4));
//		pane.getChildren().add(ellipse);
		
		Duration dur = Duration.millis(2000);
		FadeTransition fade = new FadeTransition(dur, ellipse);
		fade.setFromValue(1);
		fade.setToValue(0.1);
		fade.setInterpolator(Interpolator.LINEAR);
//		while(key.toSeconds() < dur.toSeconds()) {
//			ellipse.setFill(Color.color(Math.random(), Math.random(), Math.random(), Math.random()));
//			key.add(key);
//		}
		fade.setCycleCount(Timeline.INDEFINITE);
		fade.setAutoReverse(true);
		fade.play();
		
		pane.getChildren().add(ellipse);
		ellipse.setOnMousePressed(e -> fade.pause());
		ellipse.setOnMousePressed(e -> fade.play());
		
		Scene scene = new Scene(pane, 400, 350);
		primaryStage.setTitle("FadeTransitionDemo"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
		
		
	}

}
