package chapter14_JavaFXBasics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EllipseDemo extends Application {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Scene scene = new Scene(new EllipsePane(), 400,300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Eclipse Demo");
		primaryStage.show();
	}
}
	
class EllipsePane extends Pane{
	public EllipsePane(){
		Ellipse ells = new Ellipse(50,50,50,80);
		Ellipse e1 = new Ellipse(50,110,50,80);
		Ellipse e2 = new Ellipse(50,220,50,80);
		
		ells.setStroke(Color.DARKRED);
		ells.setFill(Color.SANDYBROWN);
		getChildren().add(new Text(50,50,"ells"));
		
		e1.setFill(Color.DARKOLIVEGREEN);
		e1.setStroke(Color.YELLOWGREEN);
		getChildren().add(new Text(50, 110, "e1"));
		
		e1.setFill(Color.INDIGO);
		e1.setStroke(Color.ROSYBROWN);
		getChildren().add(new Text(50, 220, "e1"));
		
		getChildren().addAll(ells, e1, e2);
		
		for(int i=0; i<7; i++) {
			Ellipse e = new Ellipse(250,150,90,110);
			e.setRotate(i*45);
			e.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
			e.setFill(Color.color(Math.random(), Math.random(), Math.random()));
			getChildren().add(e);
		}
	}
	
}