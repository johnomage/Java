package EventDrivenProgAndAnim;


import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HandleEvent extends Application{
	static HBox pane = new HBox(10);
	public static File file;
	public static void main(String[] edus) {
		// TODO Auto-generated method stub
		Application.launch(edus);
	}
	public EventHandler<ActionEvent> file() {
		
		file = new File("C:\\Users\\Honeeks Inc\\eclipse-workspace\\learning\\zzFiles\\list.txt");
		Long len = file.length();
		Label label = new Label(len.toString());
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().add(label);
		return null;
	}

	
	@Override
	public void start(Stage stage) throws Exception {
		
		pane.setAlignment(Pos.CENTER);
		// TODO Auto-generated method stub
		Button btOK = new Button("OK");
		Button btCancel = new Button("Cancel");
		OkHandler handler1 = new OkHandler();
		btOK.setOnAction(handler1);
//		btOK.setOnAction(file);
		cancelHandler handler2 = new cancelHandler();
		btCancel.setOnAction(handler2);
		pane.getChildren().addAll(btOK, btCancel);
		
		Scene scene = new Scene(pane,200,200);
		stage.setScene(scene);
		stage.show();
	}
}

class OkHandler implements EventHandler<ActionEvent>{
	@Override
	public void handle(ActionEvent e) {
		new HandleEvent().file();
		System.out.println("Ok button clicked");
	}
}

class cancelHandler implements EventHandler<ActionEvent>{
	@Override
	public void handle(ActionEvent e) {
		System.out.println("Cancel button clicked");
		System.out.println(e.getSource());
	}
}