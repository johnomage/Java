package EventDrivenProgAndAnim;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MouseEventDemo extends Application{

	public static void main(String[] edus) {
		// TODO Auto-generated method stub
		Application.launch(edus);

	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Pane pane = new Pane();
		Text text = new Text(20, 20, "Programming is fun");
		pane.getChildren().add(text);
		text.setOnMouseDragged(e ->{
			text.setX(e.getX());
			text.setY(e.getY());
		});
		
		text.setOnMouseClicked(e->{
			text.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		});
		
		text.setOnMouseMoved(e ->{
			text.setX(e.getSceneX());
			text.setY(e.getSceneY());
		});
		
		Scene scene = new Scene(pane,300,100);
		stage.setScene(scene);
		stage.show();
	}

}
