package EventDrivenProgAndAnim;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;


public class LambdaHandlerDemo extends Application {

	public static void main(String[] edus) {
		// TODO Auto-generated method stub
		Application.launch(edus);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		HBox hbox = new HBox();
		hbox.setSpacing(10);
		hbox.setAlignment(Pos.BOTTOM_CENTER);
		Button btNew = new Button("New");
		Button btOpen = new Button("Open");
		Button btSave = new Button("Save");
		Button btPrint = new Button("Print");
		Button btExit = new Button("Exit");

		hbox.getChildren().addAll(btNew, btOpen, btSave, btPrint, btExit);
		
		btNew.setOnAction(ActionEvent -> {
			System.out.println("Process New");
		});
		
		btOpen.setOnAction((e) ->{
			System.out.println("Process Open");
		});
		
		btSave.setOnAction(e ->{
			System.out.println("Process Save");
		});
		
		btPrint.setOnAction(e -> System.out.println("Process Print"));
		
		btExit.setOnAction(e ->{
			System.out.println("Closing...");
			new Timer().schedule((TimerTask) delay(), 3000);
		});
		
		Scene scene = new Scene(hbox, 300, 95);
		primaryStage.setTitle("LambdaHandlerDemo"); // Set title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show();
	}
	
	public Object delay() {
		System.exit(0);
		return 0;
	}
}
