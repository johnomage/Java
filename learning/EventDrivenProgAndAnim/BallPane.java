package EventDrivenProgAndAnim;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class BallPane extends Pane{
	public final double radius = 20;
	private double x = radius, y = radius;
	private double dx = 1, dy = 1;
	private Circle circle = new Circle(20, 30, radius);
	private Timeline animation;
	
	public BallPane() {
		circle.setFill(Color.BLACK);
		getChildren().add(circle);
		
		animation = new Timeline(new KeyFrame(Duration.millis(50), e-> moveBall()));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}
	
	public BallPane(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
		circle.setFill(Color.BLACK);
		getChildren().add(circle);
		
		
//		animation = new Timeline(new KeyFrame(Duration.millis(50), e-> moveBall()));
//		animation.setCycleCount(Timeline.INDEFINITE);
//		animation.play();
	}

	public void play() {
		animation.play();
	}
	
	public void pause() {
		animation.pause();
	}
	
	public void increaseSpeed() {
		animation.setRate(animation.getRate() + 1.0);
	}
	
	public void decreseSpeed() {
		animation.setRate(animation.getRate() > 0 ? animation.getRate()-1.0 : 0);
	}
	
	public DoubleProperty rateProperty() {
		return animation.rateProperty();
	}
	
	private void moveBall() {
		// check boundaries
		if(x < radius || x > getWidth() - radius) {
			dx *= -1;
			circle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		}
		if(y < radius || y > getHeight() - radius) {
			dy *= -1;
			circle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		}
		
		//adjust position
		x += dx;
		y += dy;
		circle.setCenterX(x);
		circle.setCenterY(y);
	}

}
