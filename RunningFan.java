import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise15_28 extends Application {
	static int i = -1;
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		StackPane stack = new StackPane();
		Button pause = new Button("Pause"), resume = new Button("Resume"), reverse = new Button("Reverse"), fast = new Button("Fast"), slow = new Button("Slow");
		HBox hbox = new HBox();
		hbox.setSpacing(10);
		hbox.setPadding(new Insets(0,0,10,0));
		Pane pane = new Pane();
		Circle circle = new Circle(300, 300, 200), smallCircle = new Circle(300, 300, 1);
		Arc arc1 = new Arc(300, 300, 180, 180, 45, 40);
		arc1.setType(ArcType.ROUND);
		Arc arc2 = new Arc(300, 300, 180, 180, 135, 40);
		arc2.setType(ArcType.ROUND);
		Arc arc3 = new Arc(300, 300, 180, 180, 225, 40);
		arc3.setType(ArcType.ROUND);
		Arc arc4 = new Arc(300, 300, 180, 180, 315, 40);
		arc4.setType(ArcType.ROUND);
		
		resume.setCursor(Cursor.HAND);
		
		hbox.getChildren().addAll(pause, resume, reverse, fast, slow);
		hbox.setAlignment(Pos.BOTTOM_CENTER);
		circle.setFill(null);
		circle.setStroke(Color.BLACK);
		
		PathTransition fan = new PathTransition(Duration.millis(5000), smallCircle, pane);
		fan.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
		fan.setCycleCount(Timeline.INDEFINITE);
//		fan.play();
		
		pause.setOnMouseClicked(e->{
			fan.pause();
		});
		
		resume.setOnMouseClicked(e->{
			fan.play();
		});
		
		reverse.setOnMouseClicked(e->{
			i = -i;
			fan.setRate(i);
		});
		
		fast.setOnMouseClicked(e->{
			fan.setRate(4);
		});
		
		slow.setOnMouseClicked(e->{
			fan.setRate(.5);
		});
		
		
		pane.getChildren().addAll(arc1, arc2, arc3, arc4);
		stack.getChildren().addAll(circle, smallCircle, pane, hbox);
//		hbox.getChildren().add(stack);
		Scene scene = new Scene(stack, 600, 600);	
		stage.setScene(scene);
		stage.show();
	}

}
