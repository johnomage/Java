package UIControlsAndMultimedia;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SliderDemo extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Text text = new Text(200, 200, "Make Excellence a habit.");
		
		Slider sbHorizontal = new Slider();
		Slider sbVertical = new Slider();
		sbHorizontal.setMajorTickUnit(20);
		sbHorizontal.setMinorTickCount(10);
		sbVertical.setMinorTickCount(10);
		sbVertical.setMajorTickUnit(20);
		sbHorizontal.setShowTickMarks(true);
		sbVertical.setShowTickMarks(true);
		sbHorizontal.setShowTickLabels(true);
		sbVertical.setShowTickLabels(true);
		sbVertical.setOrientation(Orientation.VERTICAL);
		
		Pane paneText = new Pane(text);
		
		BorderPane border = new BorderPane();
		border.setPadding(new Insets(20));
		border.setCenter(paneText);
		border.setBottom(sbHorizontal);
		border.setLeft(sbVertical);
		
		sbHorizontal.valueProperty().addListener(ov->
			text.setX(sbHorizontal.getValue() * border.getWidth() / sbHorizontal.getMax()));
//		text.xProperty().bind(sbHorizontal.valueProperty().multiply(paneText.widthProperty()).divide(sbHorizontal.maxProperty()));
	
		sbVertical.valueProperty().addListener(ov ->
			text.setY(sbVertical.getValue() * paneText.getHeight() / sbVertical.getMax()));
		
		Scene scene = new Scene(border, 500, 500);
		stage.setScene(scene);
		stage.show();
		
	}

}
