package EventDrivenProgAndAnim;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TimelineDemo extends Application {
	
	public static void main(String[] edus) {
		Application.launch(edus);
	}
	
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		StackPane pane = new StackPane();
		Text text = new Text(20, 50, "Never Give Up");
//		text.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		pane.getChildren().add(text);
		
		EventHandler<ActionEvent> eventHandler = e -> {
			if(text.getText().length() != 0) {
				text.setText("");
			}
			
			else {
				text.setText("Never Give Up");
				text.setFill(Color.color(Math.random(), Math.random(), Math.random()));
			}
		};
		
		KeyFrame kf = new KeyFrame(Duration.millis(500), eventHandler);
		Timeline tl = new Timeline(kf);
		tl.setCycleCount(Timeline.INDEFINITE);
		tl.play();
		
		text.setOnMouseClicked(e -> {
		playpause(tl);
		});
		
		pane.setOnMouseClicked(e -> {
			playpause(tl);
			});
		
		Scene scene = new Scene(pane, 250, 250);
		primaryStage.setTitle("TimelineDemo"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	private void playpause(Timeline t) {
		// TODO Auto-generated method stub
		if (t.getStatus() == Animation.Status.PAUSED) {
			t.play();
			}
		else t.pause();
	}
		
}
