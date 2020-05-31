package chapter14_JavaFXBasics;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class PolygonDemo extends Application {
	public final double WIDTH = 400, HEIGHT = 400;
	double r = Math.min(WIDTH, HEIGHT)*.4;
	double centerX = WIDTH/2;
	double centerY = HEIGHT/2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Pane pane = new Pane();
		Polygon pol = new Polygon();
		pol.setFill(Color.LIGHTGOLDENRODYELLOW);
		pol.setStroke(Color.BROWN);
		pane.getChildren().add(pol);
		
		ObservableList<Double> list = pol.getPoints();
		for(int i=0; i<6; i++) {
			list.add(centerX + r*Math.cos(2*Math.PI*i/6));
			list.add(centerY - r*Math.sin(2*Math.PI*i/6));
		}
		
		Scene scene = new Scene(pane, WIDTH, HEIGHT);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Polygon Demo");
		primaryStage.show();
	}
}
