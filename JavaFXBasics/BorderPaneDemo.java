package chapter14_JavaFXBasics;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BorderPaneDemo extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		BorderPane border = new BorderPane();
		border.setTop(new CustomPane("Top"));
		border.setLeft(new CustomPane("Left"));
		border.setBottom(new CustomPane("Bottom"));
		border.setRight(new CustomPane("Right"));
		
		Scene scene = new Scene(border, 350, 250);
		
		primaryStage.setTitle("Border Pane Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}

class CustomPane extends StackPane {
	CustomPane(String title) {
		getChildren().add(new Label(title));
		setStyle("-fx-border-color: blue");
		setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
	}
}
