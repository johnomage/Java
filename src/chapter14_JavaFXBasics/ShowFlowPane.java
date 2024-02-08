package chapter14_JavaFXBasics;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ShowFlowPane extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		FlowPane flow = new FlowPane();
		flow.setPadding(new Insets(15,15,15,14));
		flow.setHgap(10);
		flow.setVgap(10);
		
		Label label = new Label("First Name");
		TextField text = new TextField();
		
		flow.getChildren().addAll(label, text, new Label("MI"));
		
		TextField tfMi = new TextField();
		tfMi.setPrefColumnCount(1);
		flow.getChildren().addAll(tfMi, new Label("Last Name:"),new TextField());
		Button btn = new Button();
		btn.setText("Submit");
		btn.setTextFill(Color.LIMEGREEN);
		btn.setStyle("-fx-cursor: hand");
		flow.getChildren().addAll(new Label("Rank"), new TextField(), btn);
		
		Scene scene = new Scene(flow, 400, 300);
		primaryStage.setTitle("ShowFlowPane"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show();
	}

}
