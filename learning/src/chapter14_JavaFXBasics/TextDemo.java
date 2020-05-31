package chapter14_JavaFXBasics;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TextDemo extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		String fontname = "";
		String posture = "";
//		System.out.print("Enter font name: ");
//		fontname = new java.util.Scanner(System.in).nextLine();
//		System.out.print("Enter style: ");
//		posture = new java.util.Scanner(System.in).nextLine();
		
		//CREATE PANES
		TextField box = new TextField(fontname + " selected"); //TEXTIELD
		GridPane pane = new GridPane();  //GRIDPANE
		StackPane stack = new StackPane(); //STACKPANE
		pane.add(new Label("Enter font name"), 0, 0); //LABELS
		Button btn = new Button("Select");//BUTTON
		pane.add(btn, 2, 0); 
		pane.add(box, 1, 0);
		Text text = new Text(20, 20, "I am not giving up\nNever!");
		pane.add(text, 0,8);
//		stack.getChildren().add(text);
//		text.setStyle("-fx-font: Times New Roman");
		text.setFont(Font.font(btn.getText(), FontWeight.EXTRA_BOLD, 20));
//		text.setFont(Font.font);
		text.setFont(Font.font(fontname, FontWeight.EXTRA_BOLD, FontPosture.ITALIC,20));
		
		pane.setPadding(new Insets(5, 5, 5, 5));
		
//		pane.getChildren().add(text);
		Scene scene = new Scene(pane, 500, 300);
//		Scene scene1 = new Scene(stack, 500, 300);
		
		primaryStage.setScene(scene);
//		primaryStage.setScene(scene1);
		primaryStage.setTitle("Text Demo");
		primaryStage.show();
		
		
	}

}
