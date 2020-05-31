/*
*16.7 (Set clock time) Write a program that displays a clock and sets the time with the
input from three text fields, as shown in Figure 16.38b. Use the ClockPane in
Listing 14.21. Resize the clock to the center of the pane.
 */
package UIControlsAndMultimedia;

import chapter14_JavaFXBasics.VirginCLock;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise16_7_Set_Clock_Time extends Application {
	
	static int hour, minute, sec;
	static TextField hourField, minuteField, secField;
	static VirginCLock clock = new VirginCLock();

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		Label hourLabel = new Label("Hour ", hourField = new TextField("0")), minunteLabel = new Label("Minute ", minuteField = new TextField("0")),
				secLabel = new Label("Second ", secField = new TextField("0"));
		HBox hBox = new HBox(hourLabel, minunteLabel, secLabel);
		BorderPane border = new BorderPane();
		
		hBox.setAlignment(Pos.BOTTOM_CENTER);
		
		border.setBottom(hBox);
		border.setCenter(clock);
		border.setPadding(new Insets(15));
		
		clock.setOnMouseClicked(e->{
			clock.setHr(Integer.parseInt(hourField.getText()));
			clock.setMin(Integer.parseInt(minuteField.getText()));
			clock.setSec(Integer.parseInt(secField.getText()));
		});
		
		hourField.setPrefWidth(50);
		hourField.setAlignment(Pos.CENTER_RIGHT);
		minuteField.setPrefWidth(50);
		minuteField.setAlignment(Pos.CENTER_RIGHT);
		secField.setPrefWidth(50);
		secField.setAlignment(Pos.CENTER_RIGHT);
		
		hourLabel.setContentDisplay(ContentDisplay.RIGHT);
		minunteLabel.setContentDisplay(ContentDisplay.RIGHT);
		secLabel.setContentDisplay(ContentDisplay.RIGHT);
		
		hBox.setSpacing(10);
		
		Scene scene = new Scene(border, 750, 820);
		stage.setScene(scene);
		stage.setTitle("Clock");
		stage.show();
	}

}
