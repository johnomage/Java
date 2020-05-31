package recursion;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise_1820 extends Application {

	StackPane stac = new StackPane();
//	static Circle circle = new Circle();
	static int radius = 10;
	int count;
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stac.setPadding(new Insets(10));
		oval(20);
		
		Scene scene = new Scene(stac, 280, 260);
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void oval(int n) {
		Circle circle = new Circle();
		if(n > 0) {
			circle.setRadius(radius*n);
			circle.setFill(null);
			circle.setStroke(Color.BLACK);
			stac.getChildren().add(circle);
			oval(n-1);
		}
	}
}
