package chapter14_JavaFXBasics;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class HBoxVBoxDemo extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane border = new BorderPane();
		border.setTop(getHBox());
		border.setBottom(getVBox());
		
		Scene scene = new Scene(border, 1200, 800);
		primaryStage.setTitle("HBoxVBox Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private HBox getHBox() {
		// TODO Auto-generated method stub
		HBox hb = new HBox();
		hb.setPadding(new Insets(15, 15, 15, 15));
		hb.setStyle("-fx-background-color: grey");
		hb.getChildren().add(new Button("Chemistry"));
		hb.getChildren().add(new Button("Physics"));
		ImageView image = new ImageView(new Image("file:///C:/Users/Honeeks Inc/eclipse-workspace/learning/kissy.png"));
		hb.getChildren().add(image);
		return hb;
		
	}

	private VBox getVBox() {
		// TODO Auto-generated method stub
		VBox vb = new VBox(0);
		vb.setPadding(new Insets(15, 5, 5, 5));
		vb.getChildren().add(new Label("Courses"));
		Label[] courses = {new Label("Maths"), new Label("English"), new Label("ELA"), new Label("Geography")};
		
		for(Label course: courses) {
			vb.setMargin(course, new Insets(0, 0, 0, 15));
			vb.getChildren().add(course);
		}
		return vb;
	}

}
