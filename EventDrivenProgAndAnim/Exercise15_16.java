package EventDrivenProgAndAnim;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
 * (Two movable vertices and their distances) Write a program that displays two
circles with radius 10 at location (40, 40) and (120, 150) with a line connecting
the two circles, as shown in Figure 15.28b. The distance between the circles
is displayed along the line. The user can drag a circle. When that happens, the
circle and its line are moved and the distance between the circles is updated.
 */

public class Exercise15_16 extends Application {

	Text text, textc1, textc2;
	Circle c1 = new Circle(40, 40, 10, Color.RED);
	Circle c2 = new Circle(120, 150, 10, Color.BLUE);
	Pane pane = new Pane();
	static Line line;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		pane.getChildren().addAll(c1, c2, getLine(c1, c2), getText());
		pane.setOnMouseDragged(e->{
			if(c1.contains(e.getX(), e.getY())) {
				pane.getChildren().removeAll(c1, line, text, textc1);
				c1.setCenterX(e.getX());
				c1.setCenterY(e.getY());// = new Circle(e.getX(), e.getY(), 10, c1.getFill());
				textc1 = new Text(c1.getCenterX(), c1.getCenterY(), "C1");
				pane.getChildren().addAll(c1, getLine(c1, c2), getText(), textc1);
			}
			
			else if(c2.contains(e.getX(), e.getY())) {
				pane.getChildren().removeAll(c2, line, text, textc2);
				c2 = new Circle(e.getSceneX(), e.getSceneY(), 10, c2.getFill());
				textc2 = new Text(c2.getCenterX(), c2.getCenterY(), "C2");
				pane.getChildren().addAll(c2, getLine(c1, c2), getText(), textc2);
			}
		});
		
		Scene scene = new Scene(pane, 560, 500);
//		primaryStage.setTitle("Change Circle Color"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); //
	}

	private Text getText() {
		return text = new Text((c1.getCenterX()+c2.getCenterX())/2, (c1.getCenterY()+c2.getCenterY())/2, distance());
	}

	private Line getLine(Circle a, Circle b) {
		return line = new Line(a.getCenterX(), a.getCenterY(), b.getCenterX(), b.getCenterY());
	}

	private String distance() {
		return String.format("%.0f", Math.sqrt((Math.pow(c1.getCenterX() - c2.getCenterX(), 2) + Math.pow(c1.getCenterY() - c2.getCenterY(), 2))));
	}
	
	

}
