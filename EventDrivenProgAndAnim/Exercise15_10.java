package EventDrivenProgAndAnim;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
 * **15.10 (Enter and display a string) Write a program that receives a string from the
keyboard and displays it on a pane. The Enter key signals the end of a string.
Whenever a new string is entered, it is displayed on the pane.
 */

public class Exercise15_10 extends Application {

	Scene scene;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Label lbl = new Label();
		StackPane pane = new StackPane();
		Text text = new Text(100, 100,"Greatness is in you");
		FlowPane flow = new FlowPane();
		HBox hbox = new HBox();
		VBox vbox = new VBox(20);
		TextField tf = new TextField();
		hbox.setAlignment(Pos.BOTTOM_CENTER);
		Button btnClear = new Button("Clear");
		flow.setAlignment(Pos.TOP_LEFT);
		flow.setPadding(new Insets(15));
		pane.setPadding(new Insets(10));
		StringBuilder s = new StringBuilder();
		
		pane.setOnKeyPressed(e ->{
			if(e.getCode().equals(KeyCode.ENTER)) {
				lbl.setText(s.toString());
				s.delete(0, s.length());
			}
			else {
				s.append(e.getText());
				lbl.setText(s.toString());
			}
//			lbl.setText(.getText());
////			tf.setVisible(false);
////			text.setText("\n");
//			if(e.getCode() == KeyCode.ESCAPE) {
//				primaryStage.close();
//			}
//			if(e.getCode() == KeyCode.CAPS) {
//				text.setText("Caplock's on");
//			}
//			
//			if(e.getCode() == KeyCode.ENTER) {
////				text.setWrappingWidth(11);
//				tf.setText("\n");
//				text.setText("Greatness is in you");
//				text.wrappingWidthProperty();
//			}
		});
		
		btnClear.setOnMouseClicked(e->{
			flow.getChildren().clear();
		});
		pane.getChildren().add(lbl);
//		hbox.getChildren().add(lbl);
//		hbox.getChildren().add(btnClear);
		vbox.getChildren().addAll(tf, lbl);
		
		scene = new Scene(pane, 360, 300);
//		primaryStage.setTitle("Change Circle Color"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // 
		
		lbl.requestFocus();
	}

}
