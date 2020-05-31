package EventDrivenProgAndAnim;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/*
 * **15.15 (Geometry: add and remove points) Write a program that lets the user click on
a pane to dynamically create and remove points (see Figure 15.28a). When the
user left-clicks the mouse (primary button), a point is created and displayed
at the mouse point. The user can remove a point by pointing to it and rightclicking
the mouse (secondary button).
 */

public class Exercise15_15  extends Application {

	static Circle circle;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Pane pane = new Pane();
		
		pane.setOnMouseClicked(e->{
			if(e.getButton() == MouseButton.PRIMARY) {
				circle = new Circle(e.getSceneX(), e.getSceneY(), 10);
				pane.getChildren().addAll(circle);
			}
			
			else if(e.getButton() == MouseButton.SECONDARY) {
				Node picked = e.getPickResult().getIntersectedNode();
				if(picked instanceof Circle) {
					pane.getChildren().remove(picked);
				}
			}
						  
//			circle.setOnMouseClicked(c->{
//				if(c.getButton() == MouseButton.SECONDARY) {
//					c.consume();
//					pane.getChildren().remove(circle);
//				}
//			});
			
		});
		
//		circle.setOnMouseClicked(e->{
//			if(e.getButton() == MouseButton.SECONDARY) {
//				pane.getChildren().remove(circle);
//			}
//		});
		
		Scene scene = new Scene(pane, 560, 500);
//		primaryStage.setTitle("Change Circle Color"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // 
	}

}
