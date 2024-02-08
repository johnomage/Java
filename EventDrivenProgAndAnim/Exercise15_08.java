package EventDrivenProgAndAnim;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
 * *15.8 (Display the mouse position) Write two programs, such that one displays the
mouse position when the mouse button is clicked (see Figure 15.26a) and the
other displays the mouse position when the mouse button is pressed and ceases
to display it when the mouse button is released.
 */
public class Exercise15_08 extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Pane pane = new Pane();
		Text text = new Text();
		Label lbl = new Label();
		
		pane.setOnMousePressed(e->{
			double x,y;
			x = e.getSceneX();
			y = e.getSceneY();
			String loc = "(" + String.valueOf(x) + ", " + String.valueOf(y) + ")";
			text.setText(loc);
			text.setX(x);
			text.setY(y);
			lbl.setText(loc);
			lbl.setAlignment(Pos.BOTTOM_CENTER);
			
		});
		
		pane.setOnMouseReleased(e->{;
		
		});
		
		pane.getChildren().addAll(lbl, text);
		
		Scene scene = new Scene(pane, 300, 100);
//		primaryStage.setTitle("Change Circle Color"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // 
	}

}
