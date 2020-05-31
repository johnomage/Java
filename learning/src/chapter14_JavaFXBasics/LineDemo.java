package chapter14_JavaFXBasics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class LineDemo extends Application {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Scene scene = new Scene(new LinePane(), 400, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Line Demo");
		primaryStage.show();
	}
}

class LinePane extends Pane{
	public LinePane() {
		Line line1 = new Line(20,20,20,20);
		line1.endXProperty().bind(widthProperty().subtract(10));
		line1.endYProperty().bind(heightProperty().subtract(10));
		line1.setStroke(Color.ORANGERED);
		line1.setStrokeWidth(10);
		
		Line line2 = new Line(20,20,20,20);
		line2.startXProperty().bind(widthProperty().subtract(10));
		line2.endYProperty().bind(heightProperty().subtract(10));
		line2.setStroke(Color.BLUE);
		line2.setStrokeWidth(10);
		
		getChildren().addAll(line1, line2);
	}
}
