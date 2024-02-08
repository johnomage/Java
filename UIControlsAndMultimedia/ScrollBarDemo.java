package UIControlsAndMultimedia;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScrollBarDemo extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		Text text = new Text(20, 20, "Make Excellence a habit.");
		
		ScrollBar sbHorizontal = new ScrollBar();
		ScrollBar sbVertical = new ScrollBar();
		sbVertical.setOrientation(Orientation.VERTICAL);
		
		Pane paneText = new Pane(text);
		
		BorderPane border = new BorderPane();
		border.setCenter(paneText);
		border.setBottom(sbHorizontal);
		border.setRight(sbVertical);
		
		sbHorizontal.valueProperty().addListener(ov->
			text.setX(sbHorizontal.getValue() * paneText.getWidth() / sbHorizontal.getMax()));
//		text.xProperty().bind(sbHorizontal.valueProperty().
//				multiply(paneText.widthProperty()).divide(sbHorizontal.maxProperty()));
	
		sbVertical.valueProperty().addListener(ov ->
			text.setY(sbVertical.getValue() * paneText.getHeight() / sbVertical.getMax()));
		
		Scene scene = new Scene(border, 500, 500);
		arg0.setScene(scene);
		arg0.show();
		
	}

}
