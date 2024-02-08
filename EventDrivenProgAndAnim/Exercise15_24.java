package EventDrivenProgAndAnim;
/*
 * (Animation: palindrome) Write a program that animates a palindrome swing as
shown in Figure 15.31. Press/release the mouse to pause/resume the animation.
 */

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise15_24 extends Application {
	static int count = 0;
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Pane pane = new Pane();
		Circle ball = new Circle(10);
		Arc arcPath = new Arc(280, 200, 200, 200, 225, 90);
		pane.getChildren().addAll(ball, arcPath);
		arcPath.setType(ArcType.OPEN);
		arcPath.setFill(Color.TRANSPARENT);
		arcPath.setStroke(Color.BLACK);
		
		PathTransition ballTrans = new PathTransition(Duration.millis(1500), arcPath, ball);
		ballTrans.setPath(arcPath);
		ballTrans.setCycleCount(Timeline.INDEFINITE);
		ballTrans.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
		ballTrans.setAutoReverse(true);
		ballTrans.play();
		
		pane.setOnKeyTyped(e->{
				ballTrans.pause();
		});
		pane.setOnMousePressed(e->{
			count++;
			ballTrans.pause();
			System.out.println("Space bar was pressed");
			if(count==6) {
				System.out.println("Really? Pressing mouse upandan?\n\nBYE...");
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				stage.close();
			}
		});
		
		pane.setOnMouseReleased(k->{
			ballTrans.play();
		});
		
		ball.requestFocus();
		
		Scene scene = new Scene(pane, 560, 500);
//		stage.setTitle("Change Circle Color"); // Set the stage title
		stage.setScene(scene); // Place the scene in the stage
		stage.show(); //
	}
}
