package EventDrivenProgAndAnim;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControlCircle extends Application {
	Circle circle = new Circle();
	static double radius = 50;
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
		
		box.setSpacing(15);
		box.setAlignment(Pos.CENTER);
		box.getChildren().addAll(enlarge, shrink);
		box.setAlignment(Pos.BOTTOM_CENTER);
		enlarge.setOnAction(e-> enlarge());
		shrink.setOnAction(e-> shrink());
		
		
		Scene scene = new Scene(box, 300,300);
		stage.setScene(scene);
		stage.show();
	}

	private Object shrink() {
		// TODO Auto-generated method stub
		return null;
		
	}

	private Object enlarge() {
		// TODO Auto-generated method stub
		circle.setOnMouseClicked(e->{
			if(e.getButton() == MouseButton.PRIMARY) {
				circle.setRadius(radius*1.2);
			}
		});
		return null;
	}

}
