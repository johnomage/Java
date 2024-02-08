package UIControlsAndMultimedia;

import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class RadioButtonDemo extends CheckBoxDemo{
	String colorString;
	Color color = Color.WHITE;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	protected BorderPane getPane() {
		BorderPane border = super.getPane();
		
		VBox vboxRB = new VBox(20);
		vboxRB.setPadding(new Insets(5));
		vboxRB.setStyle("-fx-border-color: green; -fx-border-width: 2px");
		
		RadioButton rbRed = new RadioButton("Red");
		RadioButton rbGreen = new RadioButton("Green");
		RadioButton rbBlue = new RadioButton("Blue");
		
		vboxRB.getChildren().addAll(rbRed, rbGreen, rbBlue);
		border.setLeft(vboxRB);
		
		ToggleGroup group = new ToggleGroup();
		rbRed.setToggleGroup(group);
		rbGreen.setToggleGroup(group);
		rbBlue.setToggleGroup(group);
		
		rbRed.setOnAction(e->{
			if(rbRed.isSelected()) {
				text.setFill(Color.RED);
				colorString = "rgb(" + color.getRed()*0 + ", " + color.getGreen()*255 + ", " + color.getBlue()*255 + ")";
				border.setStyle("-fx-background-color: " + colorString);
			}
		});
		
		rbGreen.setOnAction(e->{
			if(rbGreen.isSelected()) {
				text.setFill(Color.GREEN);
				colorString = "rgb(" + color.getRed()*255 + ", " + color.getGreen()*0 + ", " + color.getBlue()*255 + ")";
				border.setStyle("-fx-background-color: " + colorString);
			}
		});
		
		rbBlue.setOnAction(e->{
			if(rbBlue.isSelected()) {
				text.setFill(Color.BLUE);
				colorString = "rgb(" + color.getRed()*255 + ", " + color.getGreen()*255 + ", " + color.getBlue()*0 + ")";
				border.setStyle("-fx-background-color: " + colorString);
			}
		});
		
		return border;
	}
}
