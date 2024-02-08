/*
 * **15.31 (Geometry: pendulum) Write a program that animates a pendulum swinging,
as shown in Figure 15.35. Press the UP arrow key to increase the speed and the
DOWN key to decrease it. Press the S key to stop animation and the R key to
resume it.
 */

package EventDrivenProgAndAnim;

import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise15_31 extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Circle dot = new Circle(250, 70, 4), bulb = new Circle(250, 400, 10);
		Line arm = new Line(250, 70, 250, 400);
		
		arm.setFill(Color.RED);
		arm.setStroke(Color.RED);
		bulb.setFill(Color.RED);
		bulb.setStroke(Color.RED);
		
		Arc arc = new Arc(250, 70, 330, 330, 240, 60), arc1 = new Arc(250, 70, 50, 50, 240, 60);
		arc.setType(ArcType.OPEN);
		arc.setFill(null);
		arc.setStroke(Color.BLACK);
		arc1.setType(ArcType.ROUND);
		
		Group group = new Group(arm, bulb);
		
		PathTransition path = new PathTransition(Duration.millis(2500), arc1, group);
		path.setAutoReverse(true);
		path.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
		path.setCycleCount(Timeline.INDEFINITE);
//		path.play();
				
		Pane pane = new Pane(dot, arc1, arc, group);
		
		pane.setOnKeyPressed(e->{
			switch(e.getCode()) {
			case UP: path.setRate(2); break;
			case DOWN: path.setRate(.5); break;
			case S: path.stop(); break;
			case R: path.play(); path.setRate(1); break;
			default: path.pause(); break;
			}
		});
		
		Scene scene = new Scene(pane, 500, 500);
		stage.setScene(scene);
		stage.show();
		
		pane.requestFocus();
	}

}
