package EventDrivenProgAndAnim;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


class WorkingClock {
	private int hour;
	private int minute;
	private int second;
	static Pane pane = new Pane();
	// Clock pane's width and height
	private double w = 400, h = 400;
	
	/** Construct a default clock with the current time*/
	public WorkingClock() {
		setCurrentTime();
	}
	
	/** Construct a clock with specified hour, minute, and second */
	public WorkingClock(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		paintClock();
	}
	
	
	/** Return hour */
	public int getHour() {
		return hour;
	}
	
	/** Set a new hour */
	public void setHour(int hour) {
		this.hour = hour;
		paintClock();
		}
	
	/** Return minute */
	public int getMinute() {
		return minute;
		}

	/** Set a new minute */
	public void setMinute(int minute) {
		this.minute = minute;
		paintClock();
		}
	
	/** Return second */
	public int getSecond() {
		return second;
		}
	
	/** Set a new second */
	public void setSecond(int second) {
		this.second = second;
		paintClock();
		}
	
	/** Return clock pane's width */
	public double getW() {
		return w;
		}
	
	/** Set clock pane's width */
	public void setW(double w) {
		this.w = w;
		paintClock();
		}
	
	/** Return clock pane's height */
	public double getH() {
	return h;
	}
	
	/** Set clock pane's height */
	public void setH(double h) {
		this.h = h;
		paintClock();
		}
	
	/* Set the current time for the clock */
	public void setCurrentTime() {
	// Construct a calendar for the current date and time
		Calendar calendar = new GregorianCalendar();
	// Set current hour, minute and second
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.second = calendar.get(Calendar.SECOND);
		paintClock(); // Repaint the clock
		}
	
	/** Paint the clock */
	protected void paintClock() {
	// Initialize clock parameters
		double clockRadius = Math.min(w, hour) * 0.8 * 0.5;
		double centerX = w / 2;
		double centerY = hour / 2;
		// Draw circle
		Circle circle = new Circle(centerX, centerY, clockRadius);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
		Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
		Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
		Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");
	// Draw second hand
		double sLength = clockRadius * 0.8;
		double secondX = centerX + sLength * Math.sin(second * (2 * Math.PI / 60));
		double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));
		Line sLine = new Line(centerX, centerY, secondX, secondY);
		sLine.setStroke(Color.BLACK);
	// Draw minute hand
		double mLength = clockRadius * 0.65;
		double xMinute = centerX + mLength * Math.sin(minute * (2 * Math.PI / 60));
		double minuteY = centerY - mLength * Math.cos(minute * (2 * Math.PI / 60));
		Line mLine = new Line(centerX, centerY, xMinute, minuteY);
	// Draw hour hand
		double hLength = clockRadius * 0.5;
		double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		double hourY = centerY - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
		Line hLine = new Line(centerX, centerY, hourX, hourY);
		hLine.setStroke(Color.GREEN);
		pane.getChildren().clear();
		pane.getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine);
	}
//	@Override
//	public void start(Stage stage){
//		setCurrentTime();
//		paintClock();
//		Scene scene = new Scene(pane, 400, 400);
//		stage.setScene(scene);
//		stage.show();
//		
//	}
	
}

public class clockAnimate extends Application {
	public void start(Stage primaryStage) {
		wallClock clock = new wallClock(); // Create a clock
		// Create a handler for animation
		EventHandler<ActionEvent> eventHandler = e -> {
			clock.setCurrentTime(); // Set a new clock time
		};

// Create an animation for a running clock
		Timeline animation = new Timeline( new KeyFrame(Duration.millis(1000), eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play(); // Start animation
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(clock.pane, 250, 50);
		primaryStage.setTitle("ClockAnimation"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}
	
	public static void main (String[] edus) {
		Application.launch(edus);
	}
}
