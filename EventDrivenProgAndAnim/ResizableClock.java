package EventDrivenProgAndAnim;

import chapter14_JavaFXBasics.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ResizableClock extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Boolean loop = true;
		ClockPanes clock = new ClockPanes();
		String timeString = clock.getHr() + ":" + clock.getMin() + ":" + clock.getSec();
		
		Label lblCurrentTime = new Label(timeString);
		BorderPane pane = new BorderPane();
		Button refresh = new Button("Refresh");
		
		pane.setCenter(clock);
		pane.setBottom(lblCurrentTime);
		BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);
		refresh.setOnAction(e -> {
			try {
				
				start(stage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		pane.setLeft(refresh);
		BorderPane.setAlignment(refresh, Pos.BOTTOM_LEFT);
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 800, 800);
		stage.setTitle("Resizable Clock"); // Set the stage title
		stage.setScene(scene); // Place the scene in the stage
		stage.show(); // Display the stage
		
		pane.heightProperty().addListener(ov -> clock.setClockHeight(pane.getHeight()));
		pane.widthProperty().addListener(ov -> clock.setClockWidth(pane.getWidth()));
	}

}
