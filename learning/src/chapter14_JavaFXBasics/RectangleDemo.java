package chapter14_JavaFXBasics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RectangleDemo extends Application {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Scene scene = new Scene(new RectPane(), 250, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Rectangle Demo");
		primaryStage.show();
	}

}

// CLASS  FOR RECTANGLE WITH RANDOM COLORS GENERATION.32×3=96kwh/N
class RectPane extends Pane{
	public RectPane() {
		Rectangle r1 = new Rectangle(25,10,50,30);
		r1.setFill(Color.SANDYBROWN);
		r1.setStroke(Color.DARKGOLDENROD);
		getChildren().add(new Text(10, 27, "r1"));
		
		Rectangle r2 = new Rectangle(25, 50, 60, 30);
		getChildren().add(new Text(10, 67, "r2"));
		
		Rectangle r3 = new Rectangle(25, 90, 60, 30);
		r3.setArcWidth(15);
		r3.setArcHeight(25);
		getChildren().add(new Text(10, 107, "r3"));
		
		getChildren().addAll(r1, r2, r3);
		
		
		for(int i=0; i<4; i++) {
			Rectangle r = new Rectangle(100, 50, 100, 30);
			r.setRotate(i*360/8);
			r.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
			r.setFill(Color.color(Math.random(), Math.random(), Math.random()));
			getChildren().add(r);
		}
	}
}
