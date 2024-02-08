package EventDrivenProgAndAnim;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

/*
 * *15.9 (Draw lines using the arrow keys) Write a program that draws line segments
using the arrow keys. The line starts from the center of the pane and draws
toward east, north, west, or south when the right-arrow key, up-arrow key, leftarrow
key, or down-arrow key is pressed.
 */

public class Exercise15_09 extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Pane pane = new Pane();
		Polyline poly = new Polyline(100, 100);
		ObservableList<Double> list = poly.getPoints();
		pane.setOnKeyPressed(e -> {
			double x=0, y = 0, length = 10;
			switch(e.getCode()) {
				case DOWN: x = list.get(list.size() - 2);
				  		   y = list.get(list.size() - 1) + length; break;
				case UP: x = list.get(list.size() - 2);
						 y = list.get(list.size() - 1) - length; break;
				case RIGHT: x = list.get(list.size() - 2) + length;
						    y = list.get(list.size() - 1); break;
				case LEFT: x = list.get(list.size() - 2) - length;
						   y = list.get(list.size() - 1); break;
				default:   break;
			}
			
			list.add(x);
			list.add(y);
		});
		
		pane.getChildren().add(poly);
		
		Scene scene = new Scene(pane, 360, 300);
//		primaryStage.setTitle("Change Circle Color"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // 
		
		pane.requestFocus();
	}

}