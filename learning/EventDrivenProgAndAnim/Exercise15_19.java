package EventDrivenProgAndAnim;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/*
 * **15.19 (Game: eye-hand coordination) Write a program that displays a circle of radius
10 pixels filled with a random color at a random location on a pane, as shown
in Figure 15.29b. When you click the circle, it disappears and a new randomcolor
circle is displayed at another random location. After twenty circles are
clicked, display the time spent in the pane
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise15_19 extends Application {
	Circle circle = new Circle(74, 91, 10);
	int count=0;
	Label lblMessage;
	LocalTime time1 = LocalTime.now(), time2;
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Pane pane = new Pane(circle);
		
		circle.setOnMouseClicked(e->{
			
			circle.setCenterX(pane.getWidth()/generateRandom());
			circle.setCenterY(pane.getHeight()/generateRandom());
			count++;
			if(count==20) {
				lblMessage = new Label("10 circles counted");
				time2 = LocalTime.now();
				long time = ChronoUnit.SECONDS.between(time1, time2);
				lblMessage.setText(String.format("%d", time)+ "s elapsed to click circle 20 times.\nClick rate: " + 
				String.format("%.2f", 20/Double.parseDouble(String.format("%d", time))));
				pane.getChildren().add(lblMessage);
			}
		});
		
		pane.setOnMouseDragged(e->{
			circle.setCenterX(e.getSceneX());
			circle.setCenterY(e.getSceneY());
		});
		
		
		Scene scene = new Scene(pane, 560, 500);
//		primaryStage.setTitle("Change Circle Color"); // Set the stage title
		stage.setScene(scene); // Place the scene in the stage
		stage.show(); //
	}
	
	double generateRandom() {
		double center = Math.random();
		return 89*center;
	}
}
