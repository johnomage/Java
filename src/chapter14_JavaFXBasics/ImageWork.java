package chapter14_JavaFXBasics;

import java.beans.EventHandler;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.*;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ImageWork extends Application {
	public static final double WIDTH = 400, HEIGHT=400;

	public static void main(String[] edus) {
		// TODO Auto-generated method stub
		Application.launch(edus);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Pane pane = new Pane();
		GridPane grid = new GridPane();
		Image image1 = new Image("file:///C:/Users/Honeeks Inc/Documents/Corel/work/finished/12345.jpg");
		Image image2 = new Image("file:///C:/Users/Honeeks Inc/Documents/Corel/work/finished/11372613.png");
		Image image3 = new Image("file:///C:/Users/Honeeks Inc/Documents/Corel/work/finished/ila.jpg");
		Image image4 = new Image("file:///C:/Users/Honeeks Inc/Documents/Corel/work/finished/red.png");
		
		ImageView view1 = new ImageView(image1);
		view1.setFitHeight(102.08);
		view1.setFitWidth(132.08);
		view1.setY(145);
		view1.setX(205);
		
		ImageView view2 = new ImageView(image2);
		view2.setFitHeight(124.2);
		view2.setFitWidth(124.2);
//		grid.add(view2, 0, 1);
		
		ImageView view3 = new ImageView(image3);
		view3.setFitHeight(158.58);
		view3.setFitWidth(205.2);
		view3.setX(0);
		view3.setY(145);
		
		ImageView view4 = new ImageView(image4);
		view4.setFitHeight(102.16);
		view4.setFitWidth(132.16);
		view4.setX(135);
		view4.setY(0);
		
		Button btn = new Button("Close");
		btn.setCursor(Cursor.HAND);
		btn.setTextFill(Color.RED);
		btn.setLayoutX(WIDTH/2);
		btn.setLayoutY(HEIGHT-50);
		btn.setOnAction(e -> Platform.exit());
		
		Button btn1 = new Button("Enlarge");
		btn1.setCursor(Cursor.HAND);
		btn1.setTextFill(Color.PURPLE);
		btn1.setLayoutX(WIDTH/2);
		btn1.setLayoutY(HEIGHT-100);
		btn1.setOnAction(new EventHandler() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setWidth(WIDTH*2);
				primaryStage.setHeight(HEIGHT*2);
			}
		});
		
		pane.getChildren().addAll(view1, view2, view3, view4, btn, btn1);
		
		
		Scene scene = new Scene(pane, WIDTH, HEIGHT);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}

}
