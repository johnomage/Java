package UIControlsAndMultimedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/*
 * **16.10 (Text viewer) Write a program that displays a text file in a text area, as shown
in Figure 16.40a. The user enters a file name in a text field and clicks the View
button; the file is then displayed in a text area.
 */

public class Exercise16_10_Text_Viewer extends Application {
	static TextField txtFileName;
	static TextArea textArea = new TextArea();
	File file;
	FileOutputStream outputStream;
	String path = "C:/Users/Honeeks Inc/Documents/";

	public static void main(String[] args) {
		 Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws FileNotFoundException {
		BorderPane border = new BorderPane();
		border.setPadding(new Insets(20));
		
		Label lblFilename = new Label("Filename ", txtFileName = new TextField());
		lblFilename.setContentDisplay(ContentDisplay.RIGHT);
		
		Button viewButton = new Button("View");
		HBox hBox = new HBox(lblFilename, viewButton);
		hBox.setAlignment(Pos.CENTER);
		border.setBottom(hBox);
		border.setCenter(textArea);
		
		txtFileName.setOnKeyPressed(e->{
			if(e.getCode().equals(KeyCode.ENTER)) {
				try {
					getTextFile(file);
				} catch (FileNotFoundException e1) {
					textArea.setText("Error! File not found.");
				}
			}
		});
		
		viewButton.setOnAction(e->	{
			try {
				getTextFile(file);
			} catch (FileNotFoundException e1) {
				
			}
		});
		
		txtFileName.requestFocus();
		Scene scene = new Scene(border, 700, 300);
		stage.setScene(scene);
		stage.show();
	}

	private void  getTextFile(File file) throws FileNotFoundException {
		file = new File(path + txtFileName.getText());
		if (file.exists()){
			String text = "";
			Scanner scan = new Scanner(file);
			while(scan.hasNext()) {
				text += scan.nextLine();
				text += "\n";
				}
			textArea.setText(text);
			}
		
		else textArea.setText(" \"" + file.getName() + "\"" + " not found in " + file.getParent());
	}

}
