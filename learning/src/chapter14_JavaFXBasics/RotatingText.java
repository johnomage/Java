package chapter14_JavaFXBasics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RotatingText extends Application {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		final double WIDTH = 300, HEIGHT = 300;
//		Text text = new Text("Rotaing Text @ 45 deg");
//		Pane pane = new Pane();
//		text.setX(WIDTH/2);
//		text.setY(HEIGHT/2);
		Pane pane = new Pane();
		StackPane stack = new StackPane();
		Rectangle r = new Rectangle(0,0,WIDTH,HEIGHT);
		r.setFill(Color.BLACK);
		stack.getChildren().add(r);
		for(int i=0; i<8; i++) {
			Text text = new Text("Rotaing Text @ 45 deg");
//			Pane pane = new Pane();
			text.setX(WIDTH/2);
			text.setY(HEIGHT/2);
			text.setRotate(i*45);
			text.setFill(Color.color(Math.random(), Math.random(), Math.random(), Math.random()));
			stack.getChildren().add(text);
		}
		Exercise_9 ok = new Exercise_9();
		Scene scene = new Scene(stack, WIDTH, HEIGHT);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Rotating Text Demo");
		primaryStage.show();
	}

}
