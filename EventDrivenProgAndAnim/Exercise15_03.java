package EventDrivenProgAndAnim;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * *15.3 (Move the ball) Write a program that moves the ball in a pane. You should
define a pane class for displaying the ball and provide the methods for moving
the ball left, right, up, and down, as shown in Figure 15.24c. Check the boundary
to prevent the ball from moving out of sight completely.
 */

public class Exercise15_03 extends Application {
	
	static Button btLeft, btRight, btUp, btDown;
//	static double dx, dy;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		MoveBall ball = new MoveBall();
		HBox hbox = new HBox(10);
		BorderPane border = new BorderPane();
		border.setPadding(new Insets(0,5,10,5));
		hbox.setAlignment(Pos.BOTTOM_CENTER);
		btLeft = new Button("Left");
		btRight = new Button("Right");
		btUp = new Button("Up");
		btDown = new Button("Down");
		
		btLeft.setOnMouseClicked(e->{ball.moveLeft();});
		btRight.setOnMouseClicked(e->{ball.moveRight();});
		btUp.setOnMouseClicked(e->{ball.moveUp();});
		btDown.setOnMouseClicked(e->{ ball.moveDown();});
		ball.setOnKeyPressed(e -> {
			if(e.getCode() == KeyCode.SPACE || e.getCode() == KeyCode.R) {
				ball.reset();
			}
			});//set ball to pane center
		
		border.setCenter(ball);
		border.setBottom(hbox);
		hbox.getChildren().addAll(btLeft, btRight, btUp, btDown);
		
		
		Scene scene = new Scene(border, 350, 250);
		primaryStage.setTitle("MoveBallControl"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
		ball.requestFocus();
	}
}