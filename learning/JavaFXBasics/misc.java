package chapter14_JavaFXBasics;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class misc extends Application {
	public static final double HEIGHT = 1200, WIDTH = 1200;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Pane pane = new Pane();
		pane.getChildren().addAll(new Txt(), new Lin(), new Rect(), new Elips(), new Crcle(), new Ark(), new Poligon());
		
		Scene scene = new Scene(pane, WIDTH, HEIGHT);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

class Txt extends Pane { //TEXT CLASS
	Txt(){
//		Text txt = new Text();
		for(int i=0; i<8; i++) {
			Text text = new Text("Rotaing Text @ 45 deg");
			text.setX(misc.WIDTH/2);
			text.setY(misc.HEIGHT/2);
			text.setRotate(i*45);
			text.setFill(Color.color(Math.random(), Math.random(), Math.random(), Math.random()));
			getChildren().add(text);
		}
	}
}

class Lin extends Pane{ //LINE CLASS
	Lin(){
		Line line = new Line(10,10,1200,1200);
		line.setStrokeWidth(misc.WIDTH/120);
		getChildren().add(line);
	}
}

class Rect extends Pane{ //RECTANGLE CLASS
	Rect(){
		Rectangle rect = new Rectangle(500,100,misc.WIDTH/12,misc.HEIGHT/20);
		Rectangle rect1 = new Rectangle(100,500,100,200);
		rect.setFill(Color.RED);
		rect1.setArcWidth(40);
		rect1.setArcHeight(20);
		rect1.setFill(Color.BROWN);
		getChildren().addAll(rect,rect1);
	}
}

class Elips extends Pane{
	Elips(){
		Ellipse ell = new Ellipse(900,900,50,100);
		getChildren().add(ell);
	}
}

//SEMI-CIRCLE CLASS
class Crcle extends Pane{
	Crcle(){
		Circle circle = new Circle(200,200,45);
		circle.setFill(Color.DEEPSKYBLUE);
		circle.setStroke(Color.DARKGREEN);
		circle.setStrokeWidth(15);
		getChildren().add(circle);
		
	}
}

class Ark extends Pane{
	Ark(){
		Arc arc = new Arc(800, 200, 100, 100, 0, 180);
		arc.setFill(Color.DARKSALMON);
		arc.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
		arc.setStrokeWidth(5);
		
		Arc arc1 = new Arc(200, 800, 100, 100, 180, 180);
		arc1.setFill(Color.DARKSALMON);
		arc1.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
		arc1.setStrokeWidth(5);
		getChildren().addAll(arc, arc1);
	}
}

//Write code fragments to display a polygon connecting the following points: (20, 40),
//(30, 50), (40, 90), (90, 10), (10, 30), and fill the polygon with green color.
class Poligon extends Pane{
	Poligon(){
		Polygon poli = new Polygon(40, 80, 60, 100, 80, 180, 180, 20, 40,60);
		Polyline  line = new Polyline(40, 80, 60, 100, 80, 180, 180, 20, 40,60);
//		ObservableList<Double> points = poli.getPoints(); //20, 40, 30, 50, 40, 90, 90, 10, 10, 30
//		for(int i=0; i<6; i++) {
//			points.add(400 + 100*Math.cos(2*Math.PI*i/6));
//			points.add(400 - 100*Math.sin(2*Math.PI*i/6));
//		}
		line.setStroke(Color.RED);
		poli.setStroke(Color.YELLOW);
		poli.setStrokeWidth(10);
		poli.setFill(Color.MEDIUMTURQUOISE);
		getChildren().addAll(poli, line);
		
	}
}
