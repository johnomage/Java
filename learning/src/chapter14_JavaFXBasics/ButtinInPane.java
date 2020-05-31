package chapter14_JavaFXBasics;

import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class ButtinInPane extends Application {

	public static void main(String[] edus) {
		// TODO Auto-generated method stub
		Application.launch(edus);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		StackPane pane = new StackPane();
		pane.getChildren().add(new Button("Edus"));
		Scene scene = new Scene(pane, 250, 250);
		primaryStage.setTitle("Button in pane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
