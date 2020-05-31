package chapter14_JavaFXBasics;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ImageDemo extends Application {

	public static void main(String[] edus) {
		// TODO Auto-generated method stub
		Application.launch(edus);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Pane pane = new HBox(10);
		pane.setPadding(new Insets(5,5,5,5));
		Image image = new Image("file:///C:/Users/Honeeks Inc/eclipse-workspace/learning/kissy.png");
		ImageView view = new ImageView(image);
		view.setFitHeight(400);
		view.setFitWidth(300);
		
		pane.getChildren().add(view);
		
		Scene scene = new Scene(pane, 200,200);
		primaryStage.setTitle("Showing Image");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
