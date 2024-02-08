package EventDrivenProgAndAnim;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/*
 **15.25 (Animation: ball on curve) Write a program that animates a ball moving along
a sine curve, as shown in Figure 15.32. When the ball gets to the right border,
it starts over from the left. Enable the user to resume/pause the animation with
a click on the left/right mouse button.
 */

public class Exercise15_25 extends Application {
	static Text text, x_axis, y_axis,txt0, txt1,txt2,txt3,txt4;
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Line vLine = new Line(300, 360, 300, 0), hLine = new Line(20, 200, 580, 200);
		Polyline poly = new Polyline();
		Circle ball = new Circle(40, 40, 10);
		Label lbl = null;
		ball.setFill(Color.RED);
		text = new Text();
		Pane pane = new Pane();
		
		x_axis = new Text(570, 220, "X");
		y_axis = new Text(310, 10, "Y");
		txt0 = new Text(300,215, "0");
		txt1 = new Text(210, 215, "-n");
		txt2 = new Text(120, 215, "-2n");
		txt3 = new Text(388, 215, "n");
		txt4 = new Text(480, 215, "2n");

		PathTransition ballPath = new PathTransition(Duration.millis(6000), ball);
		ballPath.setOrientation(PathTransition.OrientationType.NONE);
		ballPath.setCycleCount(Timeline.INDEFINITE);
		
		//draw sine wave
		for(double angle=-360; angle<=720; angle++) {
			poly.getPoints().addAll(angle, Math.sin(Math.toRadians(angle)));
		}
		
		poly.setTranslateX(120);
		poly.setTranslateY(200);
		poly.setScaleX(.5);
		poly.setScaleY(50);
		poly.setStrokeWidth(1.0/25);
		ballPath.setAutoReverse(false);
		ballPath.play();
		ballPath.setPath(poly);
		ballPath.setNode(ball);
		ballPath.setRate(1);
//		ball.setEffect(new DropShadow(1.5, 1.5, 2, Color.color(Math.random(), Math.random(), Math.random())));
		
		pane.setOnMouseClicked(e->{
			ballPath.play();
			double x,y;
			x = e.getSceneX();
			y = e.getSceneY();
			String loc = "(" + String.valueOf(x) + ", " + String.valueOf(y) + ")";
			text.setText(loc);
			text.setX(x);
			text.setY(y);
//			lbl.setText(loc);
//			pane.getChildren().add(lbl);
		});
		
		pane.setOnMousePressed(e->{
			ballPath.pause();
		});
		pane.getChildren().addAll(x_axis, y_axis,txt0, txt1, txt2, txt3, txt4, poly, vLine, hLine, ball);
		
//		Pane pane = new Pane(arcPath, vLine, hLine, ball);
		
		Scene scene = new Scene(pane, 600, 400);
		stage.setScene(scene);
		stage.show();
	}

}
