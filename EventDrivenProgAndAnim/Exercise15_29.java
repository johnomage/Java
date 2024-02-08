/*
 * **15.29 (Racing car) Write a program that simulates car racing, as shown in
Figure 15.34a. The car moves from left to right. When it hits the right end, it
restarts from the left and continues the same process. You can use a timer to
control animation. Redraw the car with a new base coordinates (x, y), as shown
in Figure 15.34b. Also let the user pause/resume the animation with a button
press/release and increase/decrease the car speed by pressing the UP and
DOWN arrow keys.
 */
package EventDrivenProgAndAnim;

import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise15_29 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Pane pane = new Pane();
		Button drive = new Button("Drive"), stop = new Button("Stop");
		Label eventButton = new Label("Events Appear Here");
		GridPane grid = new GridPane();
		Rectangle body = new Rectangle(10, 300, 110, 30);
		Circle tire1 = new Circle(30, 330, 10), tire2 = new Circle(90, 330, 10);
		Polyline roof = new Polyline(new double[] {
				30,300,
				50,280,
				70,280,
				90,300,
		}), route = new Polyline();
		Line road = new Line(30, 300, 640, 300);
		
		for(double angle=-360; angle<=720; angle++) {
			route.getPoints().addAll(angle, Math.sin(Math.toRadians(angle)));
		}
		
		grid.add(eventButton, 0, 0);
		grid.add(drive, 0, 1);
		grid.add(stop, 0, 2);
		eventButton.setMinWidth(Region.USE_PREF_SIZE);
		eventButton.setStyle("-fx-background-color: #00ee04");
		road.setFill(Color.WHITE);
		road.setStroke(Color.WHITE);
		road.setOpacity(0);
		road.setFill(Color.BROWN);
		body.setFill(Color.SKYBLUE);
		roof.setFill(Color.DEEPSKYBLUE);
		roof.setStroke(Color.DEEPSKYBLUE);
		Group car = new Group(body, roof, tire1, tire2);
		
		PathTransition path = new PathTransition(Duration.millis(10000), road, car);
		path.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
		path.setCycleCount(Timeline.INDEFINITE);
		
		drive.setOnMouseClicked(e->{
			path.play();
			eventButton.setText("Car started");
		});
		
		stop.setOnMouseClicked(e->{
			path.stop();
			eventButton.setText("Car stopped");
		});
		
		pane.setOnKeyPressed(e->{
			if(e.getCode().equals(KeyCode.UP)) {
				path.setRate(2);
				eventButton.setText("Car accelerated");
			}
			
			else if(e.getCode().equals(KeyCode.DOWN)) {
				path.setRate(.5);
				eventButton.setText("Car decelerated");
			}
		});
		
		pane.getChildren().addAll(grid, car, road);
		pane.requestFocus();
		
		Scene scene = new Scene(pane, 700, 350);
		stage.setScene(scene);
		stage.show();
	}

}
