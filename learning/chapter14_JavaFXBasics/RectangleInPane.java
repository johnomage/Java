package chapter14_JavaFXBasics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RectangleInPane extends Application{

	public static void main(String[] edus) {
		// TODO Auto-generated method stub
		Application.launch(edus);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Rectangle rect = new Rectangle();
		Text text = new Text();
		Pane pane = new StackPane();
		Polygon hex = new Polygon(6);
		
		rect.setWidth(200);
		rect.setHeight(200);
		rect.xProperty().bind(pane.widthProperty().divide(2));
		rect.yProperty().bind(pane.heightProperty().divide(2));
		rect.setStroke(Color.BLUE);
		rect.setStrokeWidth(5);
		rect.setFill(Color.AQUA);
		rect.accessibleTextProperty();
		
		hex.setStroke(Color.AZURE);
		hex.setFill(Color.PURPLE);
		hex.autosize();
		
//		pane.getChildren().add(rect);
		
		Scene scene = new Scene(pane, 460, 480);
		scene.setCamera(null);
		
		Label label = new Label("Font in scene");
		Font font = new Font(12);
		label.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 32));
		label.setTextFill(Color.rgb(200, 120, 240, .935));
		pane.getChildren().addAll(rect, hex, label);
		
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Rectangle in pane");
		primaryStage.show();
//		rect.setStyle("-fx-stroke: brown; -fx-fill: red;");
		rect.setRotate(-45);
	}

}
