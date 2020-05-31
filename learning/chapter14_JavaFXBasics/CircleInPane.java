package chapter14_JavaFXBasics;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CircleInPane extends Application {

	public static void main(String[] edus) {
		// TODO Auto-generated method stub
		Application.launch(edus);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Circle circle = new Circle(); //Node of a circle

		Pane pane = new Pane(); //designing pane
		
		circle.setRadius(50);
		circle.setStroke(Color.RED);
		circle.setFill(Color.CYAN);
		Circle circle1 = new Circle();
		circle.centerXProperty().bind(pane.widthProperty().divide(2));
		circle.centerYProperty().bind(pane.heightProperty().divide(2));
		circle1.centerXProperty().bind((pane.widthProperty().divide(2)));
		circle1.centerYProperty().bind((pane.heightProperty().divide(2)));
		circle1.setRadius(25);
		circle1.setStroke(Color.RED);
		circle1.setFill(Color.YELLOW);
		
		pane.getChildren().add(circle);
		pane.getChildren().add(circle1);
		
		Scene scene = new Scene(pane, 200, 200);// Scene creation
		primaryStage.setTitle("Circle in pane");//finally the stage
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
