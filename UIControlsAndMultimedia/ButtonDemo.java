package UIControlsAndMultimedia;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ButtonDemo extends Application {
	protected Text text = new Text(50, 50, "Edus is great!");
	
	protected BorderPane getPane() {
		HBox hbox = new HBox(20);
		Button btLeft = new Button("⏮", new Text(""));
		Button btRight = new Button("⏭", new Text(""));
		hbox.getChildren().addAll(btLeft, btRight);
		hbox.setAlignment(Pos.CENTER);
		hbox.setStyle("-fx-border-color: red");
		
		BorderPane border = new BorderPane();
		border.setBottom(hbox);
		
		Pane panefortext = new Pane();
		panefortext.getChildren().add(text);
		border.setCenter(panefortext);
		border.setPadding(new Insets(10));
		
		btLeft.setOnAction(e-> text.setX(text.getX() - 10));
		btRight.setOnAction(e -> text.setX(text.getX() + 10));
		
		return border;
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Scene scene = new Scene(getPane(), 450, 200);
		stage.setScene(scene);
		stage.show();
		
	}

}
