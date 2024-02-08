/*
 * (Game: display a checkerboard) Write a program that displays a checkerboard
in which each white and black cell is a Rectangle with a fill color black or
white, as shown in Figure 14.44c.
 */

package chapter14_JavaFXBasics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise_06 extends Application {
	
	private static final int HEIGHT = 400;
	private static final int WIDTH = 400;

	public static void main (String[] edus) {
		Application.launch(edus);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		GridPane grid = new GridPane();
		for(int i=0; i<400; i++) {
			for(int k=0; k<400; k++)
				{
					Rectangle rect = new Rectangle(80, 80);
					if((i+k)%2==0) {
						rect.setFill(Color.color(Math.random(), Math.random(), Math.random()));
					}
					grid.add(rect, k, i);
			}
		}
		
		Scene scene = new Scene(grid, WIDTH, HEIGHT);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
