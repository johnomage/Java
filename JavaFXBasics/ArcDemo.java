package chapter14_JavaFXBasics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class ArcDemo extends Application {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Scene scene = new Scene(new ArcTest(), 400, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Arc Demo");
		primaryStage.show();
	}
}

class ArcTest extends Pane{
	public ArcTest(){
		Arc arc = new Arc(200,200,80,100,0,30);
		Arc arc1 = new Arc(200,200,80,100,180,30);
		arc.setFill(Color.DARKRED);
		arc.setType(ArcType.ROUND);
		arc1.setType(ArcType.ROUND);
		arc1.setStroke(Color.BROWN);
		arc1.setFill(Color.BLANCHEDALMOND);
		getChildren().addAll(arc, arc1);
	}
	
}