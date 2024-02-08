package EventDrivenProgAndAnim;
//15.2 (Rotate a rectangle) Write a program that rotates a rectangle 15 degrees right when the Rotate button is clicked, as shown in Figure 15.24b.

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise15_02 extends Application {
	static int angle, cycle;
	static int count;
	static Label lbCycleText, lbCycleCount;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		VBox vbox = new VBox(80);
		HBox hbox = new HBox();
		HBox hboxc = new HBox();
		GridPane grid = new GridPane();
		Label lbCount = new Label("Rotate Count: ");
		Label lbText = new Label("0");
		lbCycleCount = new Label("Cycle Count: ");
		lbCycleText = new Label("0");
		
		count = 0;
		vbox.setPadding(new Insets(5,5,5,5));
		Rectangle rect = new Rectangle(100, 150, 40, 80);
		Button btRotate = new Button("Rotate");
		btRotate.setAlignment(Pos.BASELINE_CENTER);
		hbox.setAlignment(Pos.CENTER);
		vbox.setAlignment(Pos.BOTTOM_CENTER);

		btRotate.setOnMouseClicked(e-> {
			lbText.setText(rotate(rect));
			rect.setFill(Color.color(Math.random(), Math.random(), Math.random()));
			rect.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
			
		});
		
//		lbCycleText.setText("0");
		hbox.getChildren().addAll(lbCount, lbText);
		hboxc.getChildren().addAll(lbCycleCount, lbCycleText);
		grid.add(hbox, 0, 0);
		grid.add(hboxc, 0, 1);
		vbox.getChildren().addAll( grid, rect, btRotate);
		
		Scene scene = new Scene(vbox, 450, 330);
		stage.setScene(scene);
		stage.show();
	}

	private String rotate(Rectangle rect) {
		// TODO Auto-generated method stub
		angle += 15;
		rect.setRotate(angle);
		count++;
		if(count % 24 == 0) {
			cycle++;
			lbCycleText.setText(String.valueOf(cycle));
		}
		return String.valueOf(count);
	}

}
