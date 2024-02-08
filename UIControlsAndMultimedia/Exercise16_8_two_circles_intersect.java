/*
 * **16.8 (Geometry: two circles intersect?) Write a program that enables the user to
specify the location and size of the circles and displays whether the two circles
intersect, as shown in Figure 16.39a. Enable the user to point the mouse inside a
circle and drag it. As the circle is being dragged, the circle’s center coordinates
in the text fields are updated.
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
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Exercise16_8_two_circles_intersect extends Application {

	static Circle sCircle, bCircle;
	static Text intersecText = new Text(300, 120, "Two circles intersect? NO");
//	Pane pane = new Pane();
	BorderPane pane = new BorderPane();
	FlowPane flowPane = new FlowPane();
	static TextField centerXField, centerYField, radiusField, centerXField1, centerYField1, radiusField1;
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		sCircle = new Circle(50, 100, 30, null);
		sCircle.setStroke(Color.BLACK);
		bCircle = new Circle(180, 150, 50, null);
		bCircle.setStroke(Color.BLACK);
		
//		Pane pane = new Pane(smallCircle, bigCircle);
		HBox hBox = new HBox();
		hBox.setAlignment(Pos.BOTTOM_CENTER);
		hBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
		hBox.setPadding(new Insets(6));
		Button resetButton = new Button("Redraw Circles");
		
		resetButton.setOnMouseClicked(e->{
			pane.getChildren().removeAll(sCircle, bCircle);
			sCircle = new Circle(50, 100, 30, null);
			sCircle.setStroke(Color.BLACK);
			bCircle = new Circle(180, 150, 50, null);
			bCircle.setStroke(Color.BLACK);
			pane.getChildren().addAll(sCircle, bCircle);
			centerXField.setText("50");
			centerYField.setText("100");// = new TextField("100");
			radiusField.setText("30");// = new TextField("30");
			centerXField1.setText("180");// = new TextField("180");
			centerYField1.setText("150");// = new TextField("150");
			radiusField1.setText("50");// = new TextField("50");

		});
		resetButton.setAlignment(Pos.BOTTOM_CENTER);
		
		VBox leftVBox = new VBox(15);
		Label centerXLabel = new Label("Center X: ", centerXField = new TextField("50"));
		Label centerYLabel = new Label("Center Y: ", centerYField = new TextField("100"));
		Label radiusLabel = new Label("Radius:    ", radiusField = new TextField("30"));
		centerXLabel.setContentDisplay(ContentDisplay.RIGHT);
		centerYLabel.setContentDisplay(ContentDisplay.RIGHT);
		radiusLabel.setContentDisplay(ContentDisplay.RIGHT);
		centerXField.setPrefWidth(70);
		centerYField.setPrefWidth(70);
		radiusField.setPrefWidth(70);
		
		VBox rightVBox = new VBox(15);
		Label centerXLabel1 = new Label("Center X: ", centerXField1 = new TextField("180"));
		Label centerYLabel1 = new Label("Center Y: ", centerYField1 = new TextField("150"));
		Label radiusLabel1 = new Label("Radius:    ", radiusField1 = new TextField("50"));
		centerXLabel1.setContentDisplay(ContentDisplay.RIGHT);
		centerYLabel1.setContentDisplay(ContentDisplay.RIGHT);
		radiusLabel1.setContentDisplay(ContentDisplay.RIGHT);
		centerXField1.setPrefWidth(70);
		centerYField1.setPrefWidth(70);
		radiusField1.setPrefWidth(70);
		
		leftVBox.getChildren().addAll(new Text("Enter Circle 1 info:"), centerXLabel, centerYLabel, radiusLabel);
		leftVBox.setAlignment(Pos.BOTTOM_LEFT);
		leftVBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
		leftVBox.setPadding(new Insets(5));
		rightVBox.getChildren().addAll(new Text("Enter Circle 2 info:"), centerXLabel1, centerYLabel1, radiusLabel1);
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
		
		pane.getChildren().addAll(sCircle, bCircle);
	
		pane.setOnMouseDragged(e->{
			if(sCircle.contains(e.getX(), e.getY())){
				pane.getChildren().remove(sCircle);
				sCircle.setCenterX(e.getX());
				sCircle.setCenterY(e.getY());
				pane.getChildren().add(sCircle);
				
				centerXField.setText(String.valueOf(e.getX()));
				centerYField.setText(String.valueOf(e.getY()));
				
				double distance = distance(sCircle.getCenterX(), sCircle.getCenterY(), bCircle.getCenterX(), bCircle.getCenterY());
				if(distance < sCircle.getRadius() + bCircle.getRadius()) {
					intersecText.setText("Two circles intersect? YES");
					intersecText.setFill(Color.LIGHTGREEN);
					textVBox.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, null)));
					intersecText.setText("Two circles intersect? YES");
					intersecText.setStyle("-fx-font-weight: bold");
				}
				else intersecText.setText("Two circles intersect? NO");
			}
			
			else if(bCircle.contains(e.getX(), e.getY())){
				pane.getChildren().remove(bCircle);
				bCircle.setCenterX(e.getX());
				bCircle.setCenterY(e.getY());
				pane.getChildren().add(bCircle);
				
				centerXField1.setText(String.valueOf(e.getX()));
				centerYField1.setText(String.valueOf(e.getY()));
				
				double distance = distance(sCircle.getCenterX(), sCircle.getCenterY(), bCircle.getCenterX(), bCircle.getCenterY());
				if(distance < sCircle.getRadius() + bCircle.getRadius()) {
					intersecText.setFill(Color.LIGHTGREEN);
					textVBox.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, null)));
					intersecText.setText("Two circles intersect? YES");
					intersecText.setStyle("-fx-font-weight: bold");
				}
				else intersecText.setText("Two circles intersect? NO");
			}
		});
		
		pane.setOnMouseClicked(e->{
			double distance = distance(sCircle.getCenterX(), sCircle.getCenterY(), bCircle.getCenterX(), bCircle.getCenterY());
			sCircle.setCenterX(Double.parseDouble(centerXField.getText()));
			sCircle.setCenterY(Double.parseDouble(centerYField.getText()));
			sCircle.setRadius(Double.parseDouble(radiusField.getText()));
			
			bCircle.setCenterX(Double.parseDouble(centerXField1.getText()));
			bCircle.setCenterY(Double.parseDouble(centerYField1.getText()));
			bCircle.setRadius(Double.parseDouble(radiusField1.getText()));

			if(distance < sCircle.getRadius() + bCircle.getRadius()) {
				intersecText.setText("Two circles intersect? YES");
				intersecText.setFill(Color.LIGHTGREEN);
				textVBox.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, null)));
				intersecText.setText("Two circles intersect? YES");
				intersecText.setStyle("-fx-font-weight: bold");
			}
			else intersecText.setText("Two circles intersect? NO");
		});
		
		Scene scene = new Scene(pane, 600, 500);
		stage.setScene(scene);
		stage.show();
	}
	
	double distance(double x1, double y1, double x2, double y2) {
		return java.awt.geom.Point2D.Double.distance(x1, y1, x2, y2);
	}
	
}
