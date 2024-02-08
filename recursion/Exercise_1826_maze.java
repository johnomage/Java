package recursion;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Exercise_1826_maze extends Application {

	Line vertcalLine, horizontaLine;
	static Pane pane = new Pane();
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Rectangle[][] rect = new Rectangle[8][8];
		int x = 50;
		int y = 50;
		GridPane grid = new GridPane();
		
		Rectangle rectangle = new Rectangle(x, y, 50, 50);
		int row=0, col = 0;
		int startX = 50;
		int startY = 50;
		for(row=0; row<500; row+=50) {
			vertcalLine = new Line(startX + row, 50, startX + row, 450);
			horizontaLine = new Line(50, startY+row, 450, startY+row);
			pane.getChildren().addAll(horizontaLine, vertcalLine);
		}
		
		for(row=50; row<450; row+=50) {
			rectangle = new Rectangle(row, y, 50, 50);
			rectangle.setFill(null);
			rectangle.setStroke(Color.BLACK);
//			pane.getChildren().addAll(rectangle);
		}
		
//		for(row = 0; row<450 && col<450;  col+=50) {
//			grid.add(rectangle, col, row);
////			pane.getChildren().add(grid);  
//			
//		}
		
		for(row=50; row< rect.length; row+=50) {
			for(col=50; col<rect[row].length; col+=50) {
				rect[row][col] = new Rectangle(row, col, 50, 50);
//				pane.getChildren().add(rect);
				System.out.print(rect.length);
			}
		}
		
		Scene scene = new Scene(pane, 500, 500);
		stage.setScene(scene);
		stage.show();
	}

}
