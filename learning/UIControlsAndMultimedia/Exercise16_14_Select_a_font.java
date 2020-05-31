package UIControlsAndMultimedia;
/*
 * **16.14 (Select a font) Write a program that can dynamically change the font of a text
in a label displayed on a stack pane. The text can be displayed in bold and
italic at the same time. You can select the font name or font size from combo
boxes, as shown in Figure 16.42a. The available font names can be obtained
using Font.getFamilies(). The combo box for the font size is initialized
with numbers from 1 to 100.
 */

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise16_14_Select_a_font extends Application {
	
	ComboBox<String> fontComboBox = new ComboBox<>();
	ComboBox<Integer> sizeComboBox = new ComboBox<>();
	static CheckBox boldCheck, italicCheck;
	
	public static void main(String[] args) {
//		fontSizeRange();
		Application.launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane borderPane = new BorderPane();

		sizeComboBox.getItems().addAll(fontSizeRange());
		sizeComboBox.setValue(20);
		fontComboBox.getItems().addAll(Font.getFamilies());
		fontComboBox.setValue("Times New Roman");
		Label fontNameLabel = new Label("Font Name ", fontComboBox), fontSizeLabel = new Label("Font Size ", sizeComboBox);
		Label boldLabel = new Label("Bold ", boldCheck = new CheckBox()), italicLabel = new Label("Italic ", italicCheck = new CheckBox());
		Text text = new Text("Edupe The Great!");
		

		fontNameLabel.setContentDisplay(ContentDisplay.RIGHT);
		fontSizeLabel.setContentDisplay(ContentDisplay.RIGHT);
		boldLabel.setContentDisplay(ContentDisplay.RIGHT);
		italicLabel.setContentDisplay(ContentDisplay.RIGHT);
		
		
		HBox boldItalicHBox = new HBox(boldLabel, italicLabel), fontPropertyHBox = new HBox(fontNameLabel, fontSizeLabel);
		fontPropertyHBox.setAlignment(Pos.CENTER);
		fontPropertyHBox.setSpacing(20);
		boldItalicHBox.setSpacing(20);
		boldItalicHBox.setAlignment(Pos.CENTER);
		
		borderPane.setTop(fontPropertyHBox);
		borderPane.setBottom(boldItalicHBox);
		borderPane.setCenter(text);
		borderPane.setPadding(new Insets(20));
		
		Font fontBoldItalic = Font.font(fontComboBox.getValue(), FontWeight.BOLD, FontPosture.ITALIC, sizeComboBox.getValue());//bold and italic
		Font fontBold = Font.font(fontComboBox.getValue(), FontWeight.BOLD, sizeComboBox.getValue());
		Font fontItalic = Font.font(fontComboBox.getValue(), FontPosture.ITALIC, sizeComboBox.getValue());
		Font fontNormal = Font.font(fontComboBox.getValue(), FontWeight.NORMAL, 20);
		
		EventHandler<ActionEvent> handler = e -> {
			if(boldCheck.isSelected()) text.setFont(fontBold);
			
			if(italicCheck.isSelected()) text.setFont(fontItalic);
			
			else if(italicCheck.isSelected() && boldCheck.isSelected()) text.setFont(fontBoldItalic);//Style("-fx-font-weight: bold; -fx-font-style: italic");
			
			else text.setFont(fontNormal);
		};
		
		sizeComboBox.setOnAction(e-> text.setStyle("-fx-font-size: " + sizeComboBox.getValue()));
		fontComboBox.setOnAction(e-> text.setStyle("-fx-font-family: " + fontComboBox.getValue()));
		
		italicCheck.setOnAction(e-> text.setStyle("-fx-font-style: italic"));
		
		italicCheck.setOnAction(handler);
		boldCheck.setOnAction(handler);
		
		Scene scene = new Scene(borderPane, 600, 300);
		stage.setScene(scene);
		stage.show();
	}
	
	static ArrayList<Integer> fontSizeRange () {
		ArrayList<Integer> size = new ArrayList<Integer>();
		for(int i=0; i<101; i++)
			size.add(i);
		return size;
	}

}
