package UIControlsAndMultimedia;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise16_18_FanGroup extends Application {

	static StackPane stack = new StackPane();
	static VBox vBox = new VBox();
	static Circle smallCircle, circle;
	static Button pause, resume, reverse, fast, slow;
	FlowPane flowPane;
	Pane pane;
	BorderPane border;
	HBox hBox = new HBox();
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Fan fan1 = new Fan(), fan2 = new Fan(), fan3 = new Fan();
		fan1.designFan(150, 300);
		fan2.designFan(450, 300);
		fan3.designFan(750, 300);
		
		Scene scene = new Scene(border, 900, 600);	
		stage.setScene(scene);
		stage.show();
		
	}
	
	class Fan{
		double x, y;
		public Fan() {}
		
		void designFan(double x, double y) {
			this.x = x;
			this.y = y;
			border = new BorderPane();
			pane = new Pane();
			
			//REGULATORS
			pause = new Button("Pause"); resume = new Button("Resume"); reverse = new Button("Reverse"); //fast = new Button("Fast"); slow = new Button("Slow");
			
			HBox buttonHBox = new HBox();
			buttonHBox.setSpacing(10);
			buttonHBox.setPadding(new Insets(0,0,10,0));
			buttonHBox.getChildren().addAll(resume, pause, reverse);
			buttonHBox.setAlignment(Pos.TOP_CENTER);
			
			flowPane = new FlowPane();
			
			hBox.setPadding(new Insets(20));
//			hBox.getChildren().addAll(stack, buttonHBox);
			border.setTop(buttonHBox);
			border.setCenter(stack);
			
			createFan();
			animateFan();
			addBoundary();
		}
		
		//Create Blades, Circles
		void createFan() {
			circle = new Circle(x, y, 130);
			smallCircle = new Circle(x, y, 1);
			circle.setFill(null);
			circle.setStroke(Color.BLACK);
			
			//FAN BLADES
			Arc arc1 = new Arc(x, y, 120, 120, 45, 40);
			arc1.setType(ArcType.ROUND);
			Arc arc2 = new Arc(x, y, 120, 120, 135, 40);
			arc2.setType(ArcType.ROUND);
			Arc arc3 = new Arc(x, y, 120, 120, 225, 40);
			arc3.setType(ArcType.ROUND);
			Arc arc4 = new Arc(x, y, 120, 120, 315, 40);
			arc4.setType(ArcType.ROUND);
			pane.getChildren().addAll(smallCircle, circle, arc1, arc2, arc3, arc4);
			stack.getChildren().addAll(addBoundary(), pane);
//			pane.setMaxSize(280, 280);
//			pane.setStyle("-fx-border-color: black; -fx-border-width: 2");
		}
		
		//ANimate fan with controls
		void animateFan() {
			PathTransition fanControl = new PathTransition(Duration.millis(2000), smallCircle, pane);
			fanControl.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
			fanControl.setCycleCount(Timeline.INDEFINITE);
			
//			fanControl.play();
			resume.setOnMouseClicked(e->{
				fanControl.play();
			});
			
			pause.setOnAction(e-> fanControl.pause());
		}
		
		//bounding rectangle
		Rectangle addBoundary() {
			Rectangle rect = new Rectangle(280, 280);
			rect.setStroke(Color.BLACK);
			rect.setFill(null);
			return rect;
		}
	}
}
