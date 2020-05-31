package EventDrivenProgAndAnim;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControlCircleWithMouseAndKey extends Application {
	static double radius = 50;
	Circle circle = new Circle(radius);
	public static void main(String[] edus) {
		// TODO Auto-generated method stub
		Application.launch(edus);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		HBox box = new HBox();
		Button enlarge = new Button("Enlagre");
		Button shrink = new Button("Shrink");
		Button reset = new Button("Reset");
		
		circle.setFill(Color.DARKGREEN);
//		enlarge.setAlignment(Pos.BOTTOM_LEFT);
//		shrink.setAlignment(Pos.BOTTOM_RIGHT);
		box.setSpacing(15);
		box.setAlignment(Pos.CENTER);
		box.getChildren().addAll(enlarge, shrink, reset);
		box.setAlignment(Pos.BOTTOM_CENTER);
		enlarge.setOnAction(e-> enlarge());
		shrink.setOnAction(e-> shrink());
		reset.setOnAction(e -> reset());
		
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(circle);
		borderPane.setBottom(box);
		BorderPane.setAlignment(box, Pos.CENTER);
		
		Scene scene = new Scene(borderPane, 300,300);
		stage.setScene(scene);
		stage.show();
	}

	private Object reset() {
		// TODO Auto-generated method stub
		circle.setRadius(radius);
		return null;
	}

	private Object shrink() {
		// TODO Auto-generated method stub
		circle.setRadius(radius/2);
		return null;
		
	}

	private Object enlarge() {
		// TODO Auto-generated method stub
				circle.setRadius(radius*2);
		return null;
	}

}
