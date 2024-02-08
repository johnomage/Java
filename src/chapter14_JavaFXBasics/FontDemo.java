package chapter14_JavaFXBasics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class FontDemo extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Pane pane = new StackPane();
		Rectangle rect = new Rectangle();
		Circle circle = new Circle();
		Font font = new Font("Times New Roman", 20);
		Label label = new Label("You Try");
//		Scene scene = new Scene();
		
		label.setTextFill(Color.GREENYELLOW);
		label.setFont(Font.font("Calibri", FontWeight.BOLD, FontPosture.ITALIC, 40));
		
		rect.setHeight(199.99999);
		rect.setWidth(200);
		rect.setFill(Color.SANDYBROWN);
		rect.setStrokeWidth(8);
		rect.setStroke(Color.PALEVIOLETRED);
		
		circle.setRadius(100);
		circle.setStroke(Color.YELLOW);
		circle.setStrokeWidth(4);
		circle.setFill(Color.DEEPSKYBLUE);
		
		pane.getChildren().addAll(rect, circle, label);
		
		Scene scene = new Scene(pane, 400, 400);
		
		primaryStage.setTitle("Font Demo");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

}
