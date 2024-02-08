package chapter14_JavaFXBasics;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneDemo extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setAlignment(Pos.CENTER);
		
//		ADDING NODES TO PANE
		Button btn = new Button("logon");
		grid.add(new Label("Username "), 0, 0);
		grid.add(new TextField(), 1, 0);
		grid.add(new Label("Password "), 0, 1);
		grid.add(new TextField(), 1, 1);
		grid.add(btn, 1, 2);
		btn.setStyle("-fx-cursor: hand");
		
//		ADDING SCENE AND STAGE
		Scene scene = new Scene(grid, 400, 400);
		primaryStage.setTitle("Grid Pane Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
