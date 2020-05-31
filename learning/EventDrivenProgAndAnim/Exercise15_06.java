package EventDrivenProgAndAnim;
/*
 * **15.6 (Alternate two messages) Write a program to display the text Java is fun
	and Java is powerful alternately with a mouse click.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise15_06 extends Application {

	StackPane hbox = new StackPane();
	Text txtFun, txtPower;
	Text clear = new Text();
	Scene scene;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		hbox.setPadding(new Insets(10,10,10,10));
		hbox.setAlignment(Pos.CENTER);
		txtPower = new Text("Java is powerful");
		txtFun = new Text("Java is fun");
		
		hbox.getChildren().addAll(txtFun);

		hbox.setOnMouseClicked(e ->{
			if(hbox.getChildren().contains(txtFun)) {
				hbox.getChildren().add(txtPower);
				hbox.getChildren().remove(txtFun);
			}
			else {
				hbox.getChildren().add(txtFun);
				hbox.getChildren().remove(txtPower);
			}
		});
		
		scene = new Scene(hbox, 300, 100);
		primaryStage.setTitle("Fun.Power"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

}
