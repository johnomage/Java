package EventDrivenProgAndAnim;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
 * **15.12 (Geometry: inside a circle?) Write a program that draws a fixed circle centered
at (100, 60) with radius 50. Whenever the mouse is moved, display a message
indicating whether the mouse point is inside the circle at the mouse point or
Check mouse point location outside of it
 */

public class Exercise15_12 extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Circle circle = new Circle(100, 60, 50, Color.WHITE);
		Rectangle rect = new Rectangle(200, 120, 100, 40);
		rect.setFill(Color.CADETBLUE);
		circle.setStroke(Color.BLACK);
		Text text = new Text();
		Pane pane = new Pane(circle, rect, text);
		
		circle.setOnMouseMoved(e->{
			if(Math.pow(e.getSceneX()-100, 2) + Math.pow(e.getSceneY()-60, 2) <= 2500) {//x>=50 && x<=150 && y>=60 && y<=110
				circle.setFill(Color.GREEN);
				text.setX(e.getSceneX());
				text.setY(e.getSceneY());
				text.setText("Mouse inside circle");
			}
		});
		
		rect.setOnMouseMoved(e->{
			if((e.getSceneX()>=150 && e.getSceneX() <=250) && (e.getSceneY()>=100 && e.getSceneY()<=140)) {
				rect.setFill(Color.YELLOWGREEN);
				text.setX(e.getSceneX());
				text.setY(e.getSceneY());
				text.setText("Mouse inside Rectangle");
			}
		});
		
		pane.setOnMouseMoved(e->{
			if(Math.pow(e.getSceneX()-100, 2) + Math.pow(e.getSceneY()-60, 2) > 2500) {
				circle.setFill(Color.RED);
				rect.setFill(Color.RED);
				text.setX(e.getSceneX());
				text.setY(e.getSceneY());
				text.setText("Mouse OUTSIDE circle");
			}
		});
		
		
		Scene scene = new Scene(pane, 560, 500);
//		primaryStage.setTitle("Change Circle Color"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // 
	}

}
