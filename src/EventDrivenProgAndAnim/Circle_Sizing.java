package EventDrivenProgAndAnim;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Circle_Sizing extends Application{
	static double radius = 50;
	static Circle circle;
	
	public static void main (String[] edus) {
		Application.launch(edus);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		StackPane stack = new StackPane();
		BorderPane border = new BorderPane();
		
		circle = new Circle(radius);
		circle.setStroke(Color.BLUE);
		circle.setFill(Color.DARKGREEN);
		stack.getChildren().addAll(circle);
		stack.setAlignment(Pos.CENTER);
		
		HBox box = new HBox();
		box.setSpacing(10);
		box.setAlignment(Pos.BOTTOM_CENTER);
		box.setPadding(new Insets(10,10,10,10));
		
		Button enlarge = new Button("Enlarge");
		Button shrink = new Button("Shrink");
		Button reset = new Button("Reset");
		enlarge.setCursor(Cursor.HAND);
		shrink.setCursor(Cursor.HAND);
		reset.setCursor(Cursor.HAND);
		box.getChildren().addAll(enlarge, shrink, reset);
		
		border.setPadding(new Insets(15,15,15,15));
		border.setCenter(stack);
		border.setBottom(box);
		BorderPane.setAlignment(box, Pos.CENTER);
		
		enlarge.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				circle.setRadius(radius*1.5);
			}
		});
		
		shrink.setOnAction(e ->{
			while(e.getButton) {
				circle.setRadius(radius/1.5);
			}
		});
		
		reset.setOnAction(e->circle.setRadius(radius));
		
		Scene scene = new Scene(border, 300,250);
		stage.setScene(scene);
		stage.show();
	}	
}
