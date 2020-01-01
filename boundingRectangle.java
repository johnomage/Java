import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Exercise15_17 extends Application {
	ArrayList<Double> dotX = new ArrayList<>();
	ArrayList<Double>dotY = new ArrayList<>();
	Circle circle;
	Rectangle rect = new Rectangle();
	Pane pane = new Pane();
	double maxX=0, maxY=0, size;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		pane.setOnMouseClicked(e->{
			switch(e.getButton()) {
			
			case PRIMARY: circle = new Circle(e.getSceneX(), e.getSceneY(), 10);
			dotX.add(circle.getCenterX());
			dotY.add(circle.getCenterY());
			pane.getChildren().remove(rect);
			updateRectangle(trackMaxX()+circle.getRadius(),trackMaxY()+circle.getRadius());
			pane.getChildren().addAll(circle);
			break;
						  
			case SECONDARY:	Node picked = e.getPickResult().getIntersectedNode();
				if(picked instanceof Circle) {
					pane.getChildren().removeAll(picked, rect);
					updateRectangle(trackMaxX()+circle.getRadius(),trackMaxY()+circle.getRadius());
//					pane.getChildren().add(rect);
					size = dotY.size()-1;
					System.out.println("Max: " +trackMaxX() + " " + trackMaxY() + " " + (dotY.size()-1));
				}
			break;
			default: break;
			}
//			System.out.println("Max: " +trackMaxX() + " " + trackMaxY() + " " + dotY.size());
		});
		
		Scene scene = new Scene(pane, 560, 500);
//		primaryStage.setTitle("Change Circle Color"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); //
	}

	private double trackMaxY() {
		for(int y=0; y<dotY.size(); y++) {
			if (dotY.get(y) > maxY){
				maxY = dotY.get(y);
			}
		}
		return maxY;
	}

	private double trackMaxX() {
		for(int x=0; x<dotX.size(); x++) {
			if (dotX.get(x) > maxX){
				maxX = dotX.get(x);
			}
		}
		return maxX;
	}

	private void updateRectangle(double d, double e) {
		rect = new Rectangle(d, e);
		rect.setFill(null);
		rect.setStroke(Color.BLACK);
		pane.getChildren().addAll(rect);
	}

}
