package chapter14_JavaFXBasics;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class VirginCLock extends Pane {
	int hr, min, sec;
	private double clockWidth, clockHeight;
	
	public VirginCLock(){
		setCurrentTime();
		paintClock();
	}
	
	public void setCurrentTime() {
		// TODO Auto-generated method stub
		Calendar calendar = new GregorianCalendar();
		this.sec = calendar.get(Calendar.SECOND);
		this.min = calendar.get(Calendar.MINUTE);
		this.hr = calendar.get(Calendar.HOUR_OF_DAY);
		paintClock();
	}

	public VirginCLock(int hr, int min, int sec){
		this.hr = hr;
		this.min = min;
		this.sec = sec;
		paintClock();
	}

	public double getClockWitdh() {
		return clockWidth;
	}

	public void setClockWidth(double clockWitdh) {
		this.clockWidth = clockWitdh;
		paintClock();
	}

	public double getClockHeight() {
		return clockHeight;
	}

	public void setClockHeight(double clockHeight) {
		this.clockHeight = clockHeight;
		paintClock();
	}

	public int getHr() {
		return hr;
	}

	public void setHr(int hr) {
		this.hr = hr;
		paintClock();
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
		paintClock();
	}

	public int getSec() {
		return sec;
	}

	public void setSec(int sec) {
		this.sec = sec;
		paintClock();
	}
	
	protected void paintClock() { //PAINT CLOCK
		// TODO Auto-generated method stub
		double clockRadius = Math.min(800, 800)*.8*.5;
		double centerX = 400;
		double centerY = 400;
		
//		creating circle
		Circle circle = new Circle(centerX, centerY, clockRadius); //create circle
		circle.setFill(Color.THISTLE);
		circle.setStroke(Color.BLACK);
		Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
		Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
		Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
		Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");
		
		//draw seconds hand
		double secLength = clockRadius*.8; 
		double secondX = centerX + secLength*Math.sin(sec * (2 * Math.PI / 60));
		double secondY = centerY - secLength*Math.cos(sec * (2 * Math.PI / 60));
		Line secLine = new Line(centerX, centerY, secondX, secondY);
		secLine.setFill(Color.WHITE);
		
//		minute hand
		double minLength = clockRadius*.65;
		double minuteX = centerX + minLength * Math.sin(min * (2 * Math.PI / 60));
		double minuteY = centerY - minLength * Math.cos(min * (2 * Math.PI / 60));
		Line minLine = new Line(centerX, centerY, minuteX, minuteY);
		minLine.setStroke(Color.BLUE);
		minLine.setStrokeWidth(5);
		
//		hour hand
		double hrLength = clockRadius * 0.5;
		double hourX = centerX + hrLength *	Math.sin((hr % 12 + min / 60.0) * (2 * Math.PI / 12));
		double hourY = centerY - hrLength *	Math.cos((hr % 12 + min / 60.0) * (2 * Math.PI / 12));
		Line hrLine = new Line(centerX, centerY, hourX, hourY);
		hrLine.setStrokeWidth(8);
		hrLine.setStroke(Color.GREEN);
		hrLine.setFill(Color.RED);
		
		getChildren().clear();
		getChildren().addAll(circle, t1,t2,t3,t4,secLine, minLine, hrLine);
	}
}

