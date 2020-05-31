package recursion;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class SierpinskiTriangle extends Application {

	static int triangleCount;
	static Label lblCount, base;
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		lblCount = new Label("Traingles Count: 1");
		SierpinskiTrianglePane triangles = new SierpinskiTrianglePane();
		BorderPane borderPane = new BorderPane(lblCount);
		TextField txtOrder = new TextField("0");
		Button btnPlus = new Button("+"), btnMinus = new Button("-");
		
		btnPlus.setOnAction(e->{
			if(btnMinus.isDisable()) {
				btnMinus.setDisable(false);
				borderPane.getChildren().remove(base);
				borderPane.setCenter(triangles);
				
			}
			triangles.setOrder(triangles.getOrder()+1);
			triangleCount = (int) Math.pow(3, triangles.getOrder());
			lblCount.setText("Traingles Count: " + String.valueOf(triangleCount) + "\nOrder: " + triangles.getOrder());
		});
		
		btnMinus.setOnAction(e->{
			if(triangles.getOrder() == 0) {
				btnMinus.setDisable(true);
				borderPane.setCenter(base = new Label("There's nothing here to see.\nHit the other button."));
				triangles.setOrder(-1);
			}

			else {
				triangles.setOrder(triangles.getOrder()-1);
				triangleCount = (int) Math.pow(3, triangles.getOrder());
				lblCount.setText("Traingles Count: " + String.valueOf(triangleCount) + "\nOrder: " + triangles.getOrder());
			}
		});
		
		lblCount.setStyle("-fx-background-color: #000000");
		lblCount.setTextFill(Color.WHITE);
		
		HBox hBox = new HBox(10);
		hBox.getChildren().addAll(btnMinus, btnPlus);
		hBox.setAlignment(Pos.CENTER);
		
		borderPane.setCenter(triangles);
		borderPane.setBottom(hBox);
		borderPane.setTop(lblCount);
		BorderPane.setAlignment(lblCount, Pos.TOP_LEFT);
		
		Scene scene = new Scene(borderPane, 200, 210);
		primaryStage.setTitle("SierpinskiTriangle"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show();
		
		scene.widthProperty().addListener(ov-> triangles.paint());
		scene.heightProperty().addListener(ov-> triangles.paint());
	}
}


class SierpinskiTrianglePane extends Pane{
	private int order;
	
	public SierpinskiTrianglePane() {}

	public void setOrder(int order) {
		this.order = order;
		if(this.order >= 0)
			paint();
	}
	
	public int getOrder() {
		return order;
	}

	protected void paint() {
		Point2D p1 = new Point2D(getWidth()/2, 10);
		Point2D p2 = new Point2D(10, getHeight()-10);
		Point2D p3 = new Point2D(getWidth() - 10, getHeight() - 10);
		
		getChildren().clear();
		
		plotTriangles(order, p1, p2, p3);
		
	}

	private void plotTriangles(int order, Point2D p1, Point2D p2, Point2D p3) {
		if(order == 0) {
			Polygon triangle = new Polygon();
			triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
			triangle.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
			triangle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
			
			getChildren().add(triangle);
		}
		
		else {
			Point2D p12 = p1.midpoint(p2);
			Point2D p23 = p2.midpoint(p3);
			Point2D p31 = p3.midpoint(p1);
			
			plotTriangles(order-1, p1, p12, p31);
			plotTriangles(order-1, p2, p23, p12);
			plotTriangles(order-1, p3, p31, p23);
		}
	}
	
}
