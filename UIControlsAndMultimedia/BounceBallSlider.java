package UIControlsAndMultimedia;

import EventDrivenProgAndAnim.BallPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BounceBallSlider extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		BallPane ballPane = new BallPane();
		Slider slider = new Slider();
		slider.setMax(100);
		ballPane.rateProperty().bind(slider.valueProperty());
		
		BorderPane pane = new BorderPane();
		pane.setCenter(ballPane);
		pane.setBottom(slider);
		
		slider.setMajorTickUnit(10);
		slider.setMinorTickCount(10);
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		
		Scene scene = new Scene(pane, 500, 500);
		stage.setScene(scene);
		stage.show();
	}

}
