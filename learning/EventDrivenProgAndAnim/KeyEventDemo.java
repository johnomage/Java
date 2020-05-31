package EventDrivenProgAndAnim;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KeyEventDemo extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Pane pane = new Pane();
		Text text = new Text(20, 20, "A");
		pane.getChildren().add(text);
		text.setOnKeyPressed(e ->{
			switch(e.getCode()) {
			case DOWN: text.setY(text.getY() + 10); break;
			case UP: text.setY(text.getY() - 10); break;
			case LEFT: text.setX(text.getX() - 10); break;
			case RIGHT: text.setX(text.getX() + 10); break;
			default: if(Character.isLetterOrDigit(e.getText().charAt(0))) {
				text.setText(e.getText());
			}
			}
		});
		
		Scene scene = new Scene(pane, 100,100);
		text.setOnKeyReleased(e-> scene.setFill(Color.color(Math.random(), Math.random(), Math.random())));
		primaryStage.setTitle("KeyEventDemo"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show();
		
		text.requestFocus();
	}

}
