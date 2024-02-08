package UIControlsAndMultimedia;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
 * **16.17 (Use ScrollBar and Slider) Write a program that uses scroll bars or sliders
to select the color for a text, as shown in Figure 16.43b. Four horizontal
scroll bars are used for selecting the colors: red, green, blue, and opacity
percentages.
 */
public class Exercise16_17_ScrollBar_Slider extends Application {

	Text text = new Text("	Show Color	");
	static Slider redSlider = new Slider(), greenSlider = new Slider(), blueSlider = new Slider(), opacitySlider = new Slider();
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		Text redText = new Text("Red"), yellowText = new Text("Yellow"), blueText = new Text("Blue"), opacityText = new Text("Opacity");
		HBox redHBox = new HBox(redText, redSlider), yellowHBox = new HBox(yellowText, greenSlider), blueHBox = new HBox(blueText, blueSlider),
				opacityHBox = new HBox(opacityText, opacitySlider);
		redHBox.setAlignment(Pos.CENTER);
		yellowHBox.setAlignment(Pos.CENTER);
		blueHBox.setAlignment(Pos.CENTER);
		opacityHBox.setAlignment(Pos.CENTER);
		
		redSlider.setMin(0.0);
		redSlider.setMax(1.0);
		greenSlider.setMin(0.0);
		greenSlider.setMax(1.0);
		blueSlider.setMin(0.0);
		blueSlider.setMax(1.0);
		opacitySlider.setMin(0.0);
		opacitySlider.setMax(1.0);

		
		VBox slideVBox = new VBox(text, redHBox, yellowHBox, blueHBox, opacityHBox);
		slideVBox.setSpacing(15);
		slideVBox.setAlignment(Pos.CENTER);
		slideVBox.setPadding(new Insets(20));
		
		redSlider.valueProperty().addListener(ov-> setColor());
		greenSlider.valueProperty().addListener(ov-> setColor());
		opacitySlider.setValue(1);
		blueSlider.valueProperty().addListener(ov-> setColor());
		
		
		
		Scene scene = new Scene(slideVBox, 400, 250);
		stage.setScene(scene);
		stage.show();
	}
	
	private void setColor() {
		text.setFill(new Color(redSlider.getValue(), greenSlider.getValue(), 
				blueSlider.getValue(), opacitySlider.getValue()));
	}

}
