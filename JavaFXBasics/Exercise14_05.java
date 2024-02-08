/*
 * 14.5 (Characters around circle) Write a program that displays a string Welcome to
Java around the circle, as shown in Figure 14.44b. Hint: You need to display each
character in the right location with appropriate rotation using a loop.
 */

package chapter14_JavaFXBasics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise14_05 extends Application {
	public static final double WIDTH = 400, HEIGHT=400;

	public static void main(String[] edus) {
		// TODO Auto-generated method stub
		Application.launch(edus);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Pane pane = new StackPane();
		
		Circle circle = new Circle(WIDTH/2, HEIGHT/2, 100);
		
		circle.setFill(Color.DARKGREY);
		circle.setStroke(Color.DARKRED);
		circle.setStrokeWidth(10);
		
		Rectangle  rect = new Rectangle(400,400);
		rect.setFill(Color.BLACK);
		
		pane.getChildren().addAll(rect,circle);
		
		for(int i=0; i<15;i++) {
			String txts = "WELCOME TO JAVA";
			Text text = new Text(txts);
			text.setRotate(i*60);
			text.setFill(Color.RED);
			Thread.sleep(100);
			pane.getChildren().add(text);
			System.out.println(txts.charAt(i));
		}
		Character cha[] = {'W', 'E','L','C', 'O', 'M','E',' ', 'T', 'O', ' ', 'J', 'A','V','A'};
		for(char i: cha) {
			System.out.println(i);
			Thread.sleep(500);
		}
		
		Scene scene = new Scene(pane, WIDTH, HEIGHT);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}
