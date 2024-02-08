package binary_IO;

import java.io.*;
import java.util.*;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * *17.10 (Split files) Suppose you want to back up a huge file (e.g., a 10-GB AVI file) to a
CD-R. You can achieve it by splitting the file into smaller pieces and backing up
these pieces separately. Write a utility program that splits a large file into smaller
ones using the following command: java Exercise17_10 SourceFile numberOfPieces
The command creates the files SourceFile.1, SourceFile.2, . . . , SourceFile.n,
where n is numberOfPieces and the output files are about the same size.
**17.11 (Split files GUI) Rewrite Exercise 17.10 with a GUI, as shown in Figure 17.21a.
*17.12 (Combine files) Write a utility program that combines the files together into a
new file using the following command:
java Exercise17_12 SourceFile1 . . . SourceFilen TargetFile
The command combines SourceFile1, . . . , and SourceFilen into TargetFile.
Split a large file
 */
public class Exercise17_02_splitCombineFile extends Application  {
	
	static File tempFile;
	static private RandomAccessFile raf, splits[];
	private static int parts;
	static Label lblFile, lblSplit, lblInfo;
	static TextField txtFile, txtSplit;
	
	
	public static void main(String edus[]) throws IOException {
		Application.launch(edus);
//		edus = new String[2];
//		System.out.print("Enter File Name: ");
//		edus[0] = input.nextLine();
//		fileName = edus[0];
//		raf = new RandomAccessFile(fileName, "rw");
//		
//		System.out.print("Enter parts: ");
//		edus[1] = input.next();
//		parts = Integer.parseInt(edus[1]);
//		
//		System.out.println("File size: " + raf.length() + " Bytes");
//		System.out.println("File splits into " + parts + " parts:\n");
//		splitFile(parts);
//		combineFiles(raf);
	}

	//COMBINE FILES INTO ONE
	public static void combineFiles() throws IOException {
		RandomAccessFile target = new RandomAccessFile(txtFile.getText(), "rw");
		RandomAccessFile[] source = new RandomAccessFile[parts];
		byte[] temp;
		for(int i=0; i<source.length; i++) {
			source[i] = new RandomAccessFile(txtFile.getText() + "." + (i+1), "rw");
		}

		for(int i=0; i<source.length; i++){
			temp = new byte[(int) source[i].length()];
			source[i].seek(i);
			source[i].read(temp);
			target.seek(i);
			target.write(temp);
		}
	}

	//SPLIT SINGLE FILE INTO MULTIPLE
	public static void splitFile() throws IOException {
		int shreds = Integer.parseInt(txtSplit.getText());
		raf = new RandomAccessFile(txtFile.getText(), "rw"); 	
		splits = new RandomAccessFile[shreds];
		//ADD SPLIT FILES TO ARRAY
		for(int i=0; i<splits.length; i++)
			 splits[i] = new RandomAccessFile(txtFile.getText() + (i+1)	 + ".temp", "rw");
		
		int sizePerSplit = Math.round(raf.length()/shreds); //SIZE OF EACH SPLIT
		int count = 0; //TO SHIFT SEEK BY COUNT BYTE
		byte[] b;
		
		for(int i=0; i<shreds; i++) {
			raf.seek(count * sizePerSplit);
			b = new byte[sizePerSplit];
			raf.read(b); //MOVE POINTER TO B.LENGTH
			splits[i].write(b); //WRITE AFTER B.LENGTH
			count++;
		} 
		
		raf.seek(count * sizePerSplit);
		b = new byte[(int) (raf.length() - (count * sizePerSplit))];
		raf.read(b);
		splits[shreds - 1].write(b);
	}

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane border;
		lblFile = new Label("Enter a file:", txtFile = new TextField());
		txtFile.setPromptText("e.g file.txt");
		txtFile.setTooltip(new Tooltip("e.g file.txt"));
		lblFile.setContentDisplay(ContentDisplay.RIGHT);
		lblSplit = new Label("Enter splits:", txtSplit = new TextField());
		lblSplit.setContentDisplay(ContentDisplay.RIGHT);
		
		Button btnSplit = new Button("Split"), btnCombine = new Button("Combine");
		lblInfo = new Label("This program splits a file into parts or combine splits into a single file.");
		lblInfo.setStyle("-fx-background-color: #f0ff70");
		lblInfo.setWrapText(true);
		
		//BUTTON EVENTS
		btnSplit.setOnAction(e->{ //split on click
			if(txtFile.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.INFORMATION, "Enter file name or include extension like .txt, .bat, .docx.....", ButtonType.OK);
				alert.setHeaderText(null);
				alert.showAndWait();
			}
			
			else if(txtSplit.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.INFORMATION, "Enter number of splits", ButtonType.OK);
				alert.setHeaderText(null);
				alert.showAndWait();
			} 
			
			else {
				try {splitFile();} 
					
				catch (NumberFormatException nfe) {
					Alert alert = new Alert(AlertType.ERROR, "Enter a whole number like 2, 4, 8... for splits", ButtonType.OK);
					alert.setHeaderText(null);
					alert.showAndWait();
					}
					
				catch (IOException e2) {
					Alert alert = new Alert(AlertType.ERROR, txtFile.getText() + " not found", ButtonType.OK);
					alert.setHeaderText(null);
					alert.showAndWait();
					}
				}
			});
		
		btnCombine.setOnAction(e->{ //combine on click
			if(txtFile.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.INFORMATION, "Enter file name or include extension like .txt, .bat, .docx.....", ButtonType.OK);
				alert.setHeaderText(null);
				alert.showAndWait();
			}
			
			else if(!txtSplit.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.INFORMATION, "Number of splits not needed", ButtonType.OK);
				alert.setHeaderText(null);
				alert.showAndWait();
			} 
			
			else {
				try {combineFiles();} 
					
				catch (NumberFormatException nfe) {
					Alert alert = new Alert(AlertType.ERROR, "Enter a whole number like 2, 4, 8... for splits", ButtonType.OK);
					alert.setHeaderText(null);
					alert.showAndWait();
					}
					
				catch (IOException e2) {
					Alert alert = new Alert(AlertType.ERROR, txtFile.getText() + " not found", ButtonType.OK);
					alert.setHeaderText(null);
					alert.showAndWait();
					}
				}
		});
		
		VBox vBox = new VBox(5, lblFile, lblSplit);
		HBox buttonBox = new HBox(20, btnSplit, btnCombine);
		
		border = new BorderPane(vBox, lblInfo, null, buttonBox, null);
		border.setPadding(new Insets(10,5,4,5));
		buttonBox.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(border, 350, 180);
		stage.setScene(scene);
		stage.setTitle("Split of Combine");
		stage.show();
	}
}
