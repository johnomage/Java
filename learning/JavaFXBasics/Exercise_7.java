/*
 * 14.7 (Display random 0 or 1) Write a program that displays a 10-by-10 square matrix,
as shown in Figure 14.45a. Each element in the matrix is 0 or 1, randomly generated.
Display each number centered in a text field. Use TextField’s setText
method to set value 0 or 1 as a string.
 */

package chapter14_JavaFXBasics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
//import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Exercise_7 extends Application {
	
	private static final double HEIGHT = 312;
	private static final int WIDTH = 350;
	

	public static void main (String[] edus) {
		Application.launch(edus);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		GridPane grid = new GridPane();
		for(int i=0; i<10; i++) {
			for(int k=0; k<10; k++)
				{
					Integer j = (Math.random()<0.5)?0:1;
					String string = j.toString(j);
					TextField text = new TextField(string);
//					text.setBackground(Color.color(Math.random(), Math.random(), Math.random()));
					text.setEditable(false);
					grid.add(text, k,i);
					//Integer j = (Math.random()<0.5)?0:1;//rand.nextInt(2);//(int) (Math.random()*10);
			}
		}
		
		stage.setScene(new Scene(grid, WIDTH, HEIGHT));
		stage.show();
	}
}