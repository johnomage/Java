package EventDrivenProgAndAnim;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class BounceBallControl extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		BallPane ball = new BallPane();
		
		ball.setOnMousePressed(e -> ball.pause());
		ball.setOnMouseReleased(e -> ball.play());
		
		ball.setOnKeyPressed(e ->{
			if(e.getCode() == KeyCode.UP)
				ball.increaseSpeed();
			else if(e.getCode() == KeyCode.DOWN)
				ball.decreseSpeed();
			else if(e.getCode() == KeyCode.SPACE) {
				ball.pause();
			}
		});
		
		Scene scene = new Scene(ball, 250, 150);
		primaryStage.setTitle("BounceBallControl"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
		ball.requestFocus();
		
	}

}
