/*
 * *14.9 (Create four fans) Write a program that places four fans in a GridPane with two
rows and two columns
 */

package chapter14_JavaFXBasics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Exercise_9 extends Application {
	
	private static final double HEIGHT = 600;
	private static final int WIDTH = 600;
	Pane pane = new Pane();
	

	public static void main (String[] edus) {
		Application.launch(edus);
	}


	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		StackPane stack = new StackPane();
		StackPane stack2 = new StackPane();
//		StackPane stack3 = new StackPane();
//		StackPane stack4 = new StackPane();
		GridPane grid = new GridPane();
		
		Arc a1 = new Arc(200,200,100,100,30,30);
		a1.setType(ArcType.ROUND);
		Arc a2 = new Arc(200,200,100,100,120,30);
		a2.setType(ArcType.ROUND);
		Arc a3 = new Arc(200,200,100,100,210,30);
		a3.setType(ArcType.ROUND);
		Arc a4 = new Arc(200,200,100,100,300,30);
		a4.setType(ArcType.ROUND);
//		pane.getChildren().addAll(a1,a2,a3,a4);
		
		Circle c1 = new Circle(200,200, 120);
		c1.setFill(Color.NAVAJOWHITE);
//		grid.getChildren().addAll(arc(),c1);
		stack.getChildren().addAll(c1, arc());
//		vbox.getChildren().addAll(arc(),c1);
		grid.add(stack, 0, 0);
//		grid.add(c1, 0, 0);
//		stack.getChildren().addAll(c1,arc());
		Circle c2 = new Circle(200,200, 120);
		c2.setFill(Color.color(Math.random(), .03444, .0099));
		stack2.getChildren().addAll(arc(),c2);
//		grid.add(stack, 1, 0);
		grid.add(c2, 1, 0);
		Circle c3 = new Circle(200,200, 120);
		c3.setFill(Color.FORESTGREEN);
		grid.add(c3, 0, 1);
		Circle c4 = new Circle(200,200, 120);
		c4.setFill(Color.BLUE);
		grid.add(c4, 1, 1);
		
		pane.getChildren().addAll(c1, a1,a2,a3,a4);
		
		Scene scene = new Scene(pane, WIDTH, HEIGHT);
		stage.setScene(scene);
		stage.show();
	}
	
	protected Arc arc(){
		Arc a1 = new Arc(200,200,100,100,30,30);
		a1.setType(ArcType.ROUND);
		Arc a2 = new Arc(200,200,100,100,120,30);
		a2.setType(ArcType.ROUND);
		Arc a3 = new Arc(200,200,100,100,210,30);
		a3.setType(ArcType.ROUND);
		Arc a4 = new Arc(200,200,100,100,300,30);
		a4.setType(ArcType.ROUND);
		pane.getChildren().addAll(a1,a2,a3,a4);
		return new Arc();
	}
}