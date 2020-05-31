package EventDrivenProgAndAnim;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/*
 * *15.11 (Move a circle using keys) Write a program that moves a circle up, down, left,
or right using the arrow keys.
 */

public class Exercise15_11 extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		MoveBall ball = new MoveBall();
		StackPane stack = new StackPane(ball);
		
		ball.setOnKeyPressed(e ->{
			switch(e.getCode()) {
			case UP: ball.moveUp(); break;
			case DOWN: ball.moveDown(); break;
			case LEFT: ball.moveLeft(); break;
			case RIGHT: ball.moveRight(); break;
			default: break;
			}
		});
		
		Scene scene = new Scene(stack, 360, 300);
//		primaryStage.setTitle("Change Circle Color"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // 
		
		ball.requestFocus();
	}

}
