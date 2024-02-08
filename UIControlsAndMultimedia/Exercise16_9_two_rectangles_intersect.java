/*
 * **16.9 (Geometry: two rectangles intersect?) Write a program that enables the user to
specify the location and size of the rectangles and displays whether the two rectangles
intersect, as shown in Figure 16.39b. Enable the user to point the mouse
inside a rectangle and drag it. As the rectangle is being dragged, the rectangle’s
center coordinates in the text fields are updated.
 */
package UIControlsAndMultimedia;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Exercise16_9_two_rectangles_intersect extends Application {

	static Rectangle sRectangle, bRectangle;
	static Text intersecText = new Text(300, 120, "Two circles intersect? NO");
//	Pane pane = new Pane();
	BorderPane pane = new BorderPane();
	FlowPane flowPane = new FlowPane();
	static TextField centerXField, centerYField, widthField, heightField, centerXField1, centerYField1, widthField1, heightField1;
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		sRectangle = new Rectangle(90, 110, 50, 100);
		sRectangle.setFill(null);
		sRectangle.setStroke(Color.BLACK);
		bRectangle = new Rectangle(110, 170, 180, 150);
		bRectangle.setFill(null);
		bRectangle.setStroke(Color.BLACK);
		
//		Pane pane = new Pane(smallCircle, bigCircle);
		HBox hBox = new HBox();
		hBox.setAlignment(Pos.BOTTOM_CENTER);
		hBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
		hBox.setPadding(new Insets(6));
		Button resetButton = new Button("Redraw Rectangles");
		
		resetButton.setOnMouseClicked(e->{
			pane.getChildren().removeAll(sRectangle, bRectangle);
			sRectangle = new Rectangle(90, 110, 50, 100);
			sRectangle.setStroke(Color.BLACK);
			sRectangle.setFill(null);
			bRectangle = new Rectangle(110, 170, 180, 150);
			bRectangle.setStroke(Color.BLACK);
			bRectangle.setFill(null);
			pane.getChildren().addAll(sRectangle, bRectangle);
			centerXField.setText("90");
			centerYField.setText("110");// = new TextField("100");
			widthField.setText("50");// = new TextField("30");
			heightField.setText("100");
			centerXField1.setText("110");// = new TextField("180");
			centerYField1.setText("170");// = new TextField("150");
			widthField1.setText("180");// = new TextField("50");
			heightField1.setText("150");

		});
		resetButton.setAlignment(Pos.BOTTOM_CENTER);
		
		VBox leftVBox = new VBox(15);
		Label centerXLabel = new Label("Center X: ", centerXField = new TextField("50"));
		Label centerYLabel = new Label("Center Y: ", centerYField = new TextField("100"));
		Label widthLabel = new Label("Width:    ", widthField = new TextField("30"));
		Label heightLabel = new Label("Height:    ", heightField = new TextField("30"));
		
		centerXLabel.setContentDisplay(ContentDisplay.RIGHT);
		centerYLabel.setContentDisplay(ContentDisplay.RIGHT);
		widthLabel.setContentDisplay(ContentDisplay.RIGHT);
		heightLabel.setContentDisplay(ContentDisplay.RIGHT);
		centerXField.setPrefWidth(70);
		centerYField.setPrefWidth(70);
		widthField.setPrefWidth(70);
		heightField.setPrefWidth(70);
		
		VBox rightVBox = new VBox(15);
		Label centerXLabel1 = new Label("Center X: ", centerXField1 = new TextField("180"));
		Label centerYLabel1 = new Label("Center Y: ", centerYField1 = new TextField("150"));
		Label widthLabel1 = new Label("Width:    ", widthField1 = new TextField("50"));
		Label heightLabel1 = new Label("Height:    ", heightField1 = new TextField("50"));
		centerXLabel1.setContentDisplay(ContentDisplay.RIGHT);
		centerYLabel1.setContentDisplay(ContentDisplay.RIGHT);
		widthLabel1.setContentDisplay(ContentDisplay.RIGHT);
		heightLabel1.setContentDisplay(ContentDisplay.RIGHT);
		centerXField1.setPrefWidth(70);
		centerYField1.setPrefWidth(70);
		widthField1.setPrefWidth(70);
		heightField1.setPrefWidth(70);
		
		leftVBox.getChildren().addAll(new Text("Enter Rectangle 1 info:"), centerXLabel, centerYLabel, widthLabel, heightLabel);
		leftVBox.setAlignment(Pos.BOTTOM_LEFT);
		leftVBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
		leftVBox.setPadding(new Insets(5));
		rightVBox.getChildren().addAll(new Text("Enter Rectangle 2 info:"), centerXLabel1, centerYLabel1, widthLabel1, heightLabel1);
		rightVBox.setAlignment(Pos.BOTTOM_RIGHT);
		rightVBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
		rightVBox.setPadding(new Insets(5));
		
		VBox lastVBox = new VBox(15), textVBox = new VBox(intersecText);
		hBox.getChildren().addAll(leftVBox, rightVBox);
		hBox.setSpacing(20);
		hBox.setPrefWidth(400);
		
		lastVBox.getChildren().addAll(hBox, resetButton);
		lastVBox.setAlignment(Pos.BOTTOM_CENTER);
		pane.setBottom(lastVBox);
		pane.setTop(textVBox);
		intersecText.setTextAlignment(TextAlignment.CENTER);
		textVBox.setAlignment(Pos.TOP_CENTER);
		pane.setPadding(new Insets(20, 60, 20, 60)); 
		
		pane.getChildren().addAll(sRectangle, bRectangle);
		
		double distance = distance(sRectangle.getX(), sRectangle.getY(), bRectangle.getX(), bRectangle.getY());
	
		pane.setOnMouseDragged(e->{
			if(sRectangle.contains(e.getX(), e.getY())){
				pane.getChildren().remove(sRectangle);
				sRectangle.setX(e.getX());
				sRectangle.setY(e.getY());
				pane.getChildren().add(sRectangle);
				
				centerXField.setText(String.valueOf(e.getX()));
				centerYField.setText(String.valueOf(e.getY()));
				
				//double distance = distance(sRectangle.getX(), sRectangle.getY(), bRectangle.getX(), bRectangle.getY());
				if(Math.abs(-2) < sRectangle.getWidth()/2 + bRectangle.getWidth()/2 || distance < sRectangle.getHeight()/2 + bRectangle.getHeight()/2) {
					intersecText.setText("Two circles intersect? YES");
					intersecText.setFill(Color.LIGHTGREEN);
					textVBox.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, null)));
					intersecText.setText("Two circles intersect? YES");
					intersecText.setStyle("-fx-font-weight: bold");
				}
				else intersecText.setText("Two circles intersect? NO");
			}
			
			else if(bRectangle.contains(e.getX(), e.getY())){
				pane.getChildren().remove(bRectangle);
				bRectangle.setX(e.getX());
				bRectangle.setY(e.getY());
				pane.getChildren().add(bRectangle);
				
				centerXField1.setText(String.valueOf(e.getX()));
				centerYField1.setText(String.valueOf(e.getY()));
				
				//double distance = distance(sRectangle.getX(), sRectangle.getY(), bRectangle.getX(), bRectangle.getY());
				if(distance < sRectangle.getWidth()/2 + bRectangle.getWidth()/2 || distance < sRectangle.getHeight()/2 + bRectangle.getHeight()/2) {
					intersecText.setFill(Color.LIGHTGREEN);
					textVBox.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, null)));
					intersecText.setText("Two circles intersect? YES");
					intersecText.setStyle("-fx-font-weight: bold");
				}
				else intersecText.setText("Two circles intersect? NO");
			}
		});
		
		pane.setOnMouseClicked(e->{
			//double distance = distance(sRectangle.getCenterX(), sRectangle.getCenterY(), bRectangle.getCenterX(), bRectangle.getCenterY());
			sRectangle.setX(Double.parseDouble(centerXField.getText()));
			sRectangle.setY(Double.parseDouble(centerYField.getText()));
			sRectangle.setWidth(Double.parseDouble(widthField.getText()));
			sRectangle.setHeight(Double.parseDouble(heightField.getText()));
			
			bRectangle.setX(Double.parseDouble(centerXField1.getText()));
			bRectangle.setY(Double.parseDouble(centerYField1.getText()));
			bRectangle.setWidth(Double.parseDouble(widthField1.getText()));
			bRectangle.setHeight(Double.parseDouble(heightField1.getText()));

			if(distance < sRectangle.getWidth()/2 + bRectangle.getWidth()/2 || distance < sRectangle.getHeight()/2 + bRectangle.getHeight()/2) {
				intersecText.setText("Two circles intersect? YES");
				intersecText.setFill(Color.LIGHTGREEN);
				textVBox.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, null)));
				intersecText.setText("Two circles intersect? YES");
				intersecText.setStyle("-fx-font-weight: bold");
			}
			else intersecText.setText("Two rectangles intersect? NO");
		});
		
		Scene scene = new Scene(pane, 600, 700);
		stage.setScene(scene);
		stage.show();
	}
	
	double distance(double x1, double y1, double x2, double y2) {
		return java.awt.geom.Point2D.Double.distance(x1, y1, x2, y2);
	}
	
}
