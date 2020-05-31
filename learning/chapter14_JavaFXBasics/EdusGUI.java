package chapter14_JavaFXBasics;

import javafx.application.Application;
import javafx.beans.property.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class EdusGUI extends Application {
	
	public static void main(String[] edus) {
		// TODO Auto-generated method stub
		Application.launch(edus);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Button btnOK = new Button("Edus");
		btnOK.setStyle("-fx-cursor: hand");
		Scene scene = new Scene(btnOK, 300, 250);
		primaryStage.setTitle("EdusGUI");
		primaryStage.setScene(scene);
		primaryStage.setResizable(true);
		primaryStage.show();
		
	}

}
