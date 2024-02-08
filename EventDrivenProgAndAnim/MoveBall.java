package EventDrivenProgAndAnim;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MoveBall extends Pane {
	private static double dx = 5, dy = 5, radius = 20;
	private double x=175, y=115;
	private Circle circle = new Circle(175, 115, radius);
	public MoveBall() {
		circle.setFill(Color.GREEN);
		getChildren().add(circle);
	}
	
	public void moveRight() {
		checkBoundary();
		x = x + dx;
		circle.setCenterX(x);
		circle.setCenterY(y);
	}
	
	public void moveLeft() {
		checkBoundary();
		x = x - dx;
		circle.setCenterX(x);
		circle.setCenterY(y);
	}
	
	public void moveUp() {
		checkBoundary();
		y = y - dy;
		circle.setCenterX(x);
		circle.setCenterY(y);
	}
	
	public void moveDown() {
		checkBoundary();
		y = y + dy;
		circle.setCenterX(x);
		circle.setCenterY(y);
	}
		
	private void checkBoundary() {
		// check boundaries
		if(x < radius || x > getWidth() - radius) {
			dx = 0;
			circle.setFill(Color.RED);
		}
		
		if(y < radius || y > getHeight() - radius) {
			dy = -dy;
			circle.setFill(Color.RED);
		}
		
		else circle.setFill(Color.GREEN);
		
	}

	public void reset() {
		// TODO Auto-generated method stub
		circle.setCenterX(x);
		circle.setCenterY(y);
	}
}
