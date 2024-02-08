package UIControlsAndMultimedia;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise16_1_RadioButton extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(20));
		HBox topHBox = new HBox(20), bottomHBox = new HBox(20);
		Text text = new Text(30, 20, "Edupe the Great!!!");
//		textLabel.;
		text.setStyle("-fx-background-color: #0000ff; -fx-border-color: black; -fx-border-width: 2");

		RadioButton redRadioButton = new RadioButton("Red"), yellowRadioButton = new RadioButton("Yellow"), blackRadioButton = new RadioButton("Black"),
				orangeRadioButton = new RadioButton("Orange"), greenRadioButton = new RadioButton("Green");
		Button rightButton = new Button("=>"), leftButton = new Button("<=");
		
		topHBox.setAlignment(Pos.CENTER);
		topHBox.getChildren().addAll(redRadioButton, yellowRadioButton, blackRadioButton, orangeRadioButton, greenRadioButton);
		borderPane.setTop(topHBox);
		
		Pane pane = new Pane(text);
		pane.setStyle("-fx-border-width: 3");
		
		bottomHBox.setAlignment(Pos.CENTER);
		bottomHBox.getChildren().addAll(leftButton, rightButton);
		borderPane.setBottom(bottomHBox);
		
		borderPane.setCenter(pane);
		
		ToggleGroup group = new ToggleGroup();
		redRadioButton.setToggleGroup(group);
		yellowRadioButton.setToggleGroup(group);
		blackRadioButton.setToggleGroup(group);
		orangeRadioButton.setToggleGroup(group);
		greenRadioButton.setToggleGroup(group);
		
		
		
		EventHandler<ActionEvent> handler = e->{
			if(redRadioButton.isSelected())
				text.setFill(Color.RED);
			else if (yellowRadioButton.isSelected())
				text.setFill(Color.YELLOW);
			else if(blackRadioButton.isSelected())
				text.setFill(Color.BLACK);
			else if(orangeRadioButton.isSelected())
				text.setFill(Color.ORANGE);
			else if(greenRadioButton.isSelected())
				text.setFill(Color.GREEN);
		};
		
		redRadioButton.setOnAction(handler);
		yellowRadioButton.setOnAction(handler);
		blackRadioButton.setOnAction(handler);
		orangeRadioButton.setOnAction(handler);
		greenRadioButton.setOnAction(handler);
		
		leftButton.setOnAction(e-> text.setX(text.getX() - 20));
			
		rightButton.setOnAction(e-> text.setX(text.getX() + 20));	
		
		Scene scene = new Scene(borderPane, 500, 120);
		stage.setScene(scene);
		stage.show();
	}

}
