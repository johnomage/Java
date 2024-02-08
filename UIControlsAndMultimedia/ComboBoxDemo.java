package UIControlsAndMultimedia;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ComboBoxDemo extends Application {
	Scene scene;
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		ComboBox<String> cbItems = new ComboBox<String>();
		cbItems.getItems().addAll("", "Lagos", "Edo", "Abuja", "Ogun");
		
		VBox Vpane = new VBox(20, cbItems);
		Vpane.setPadding(new Insets(40));
		Vpane.setAlignment(Pos.CENTER);
		Text text = new Text("Select State");
		
		EventHandler<ActionEvent> handler = e->{
			if(!cbItems.getValue().equals("")) {
				text.setText(cbItems.getValue().toString() + " selected");
			}
			
			else {
				text.setText("Select State");
			}
		};
		
		Vpane.getChildren().add(text);
		
		cbItems.setOnAction(handler);
		
		scene = new Scene(Vpane, 400, 400);
		stage.setScene(scene);
		stage.show();
	}

}
