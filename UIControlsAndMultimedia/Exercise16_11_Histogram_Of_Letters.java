package UIControlsAndMultimedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/*
 * **16.11 (Create a histogram for occurrences of letters) Write a program that reads a
file and displays a histogram to show the occurrences of each letter in the file,
as shown in Figure 16.40b. The file name is entered from a text field. Pressing
the Enter key on the text field causes the program to start to read and process
the file and displays the histogram. The histogram is displayed in the center of the
window. Define a class named Histogram that extends Pane. The class contains
the property counts that is an array of 26 elements. counts[0] stores the
number of A, counts[1] the number of B, and so on. The class also contains a
setter method for setting a new counts and displaying the histogram for the new
counts.
 */

public class Exercise16_11_Histogram_Of_Letters extends Application {
	
	static BorderPane border = new BorderPane();
	static File file;
	static String[] list;
	static String filename; //Exercise16_10_Text_Viewer.txtFileName.getText();
	static TextArea textArea = new TextArea();
	String path = "C:/Users/Honeeks Inc/Documents/";
	static TextField txtFileName;
	Histogram plotHistogram  = new Histogram();
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
//		Exercise16_10_Text_Viewer setStage = new Exercise16_10_Text_Viewer();
////		setStage.start(stage);
//		Exercise16_10_Text_Viewer.textArea.setText("File contents here.");
////		filename = txtFileName.getText();
		
		
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
			
			try {
				plotHistogram.scanFile();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
		else textArea.setText(" \"" + file.getName() + "\"" + " not found in " + file.getParent());

	}
	
	
	class Histogram extends Pane{
		Rectangle[] histogram;
//		File file;
		
		private void scanFile() throws Exception{
			filename = txtFileName.getText();
			file = new File("C:\\Users\\Honeeks Inc\\Documents\\" + filename);
			Scanner scanner = new Scanner(file);
			doAnalysis(file);
		}
		
		void doAnalysis(File file2) throws FileNotFoundException {
			int wordCount=0; //word count
			int characters = 0; //characters count
			int lines=0; //lines count
			String word = "", run;
			
			int A=0, B=0, C=0, D=0, E=0, F=0, G=0, H=0,I=0,J=0,K=0,L=0,M=0,N=0,O=0,P=0,Q=0,R=0,S=0,T=0,U=0,V=0,W=0,X=0,Y=0,Z=0, 
					zero=0,one=0,two=0,three=0,four=0,five=0,six=0,seven=0,eight=0,nine=0;
			char[] array;// = new Character[200];
			ArrayList<String>letter = new ArrayList<>();
			
			try{
				Scanner scan = new Scanner(file2);
				while(scan.hasNext()){
					word = scan.nextLine().toUpperCase();
					characters +=word.length();
					//word.toUpperCase();
					letter.add(word);
					
					array = word.toCharArray();
					for(char CHAR: array){
						switch(CHAR){
							case 'A': A++; break;
							case 'B': B++; break;
							case 'C': C++; break;
							case 'D': D++; break;
							case 'E': E++; break;
							case 'F': F++; break;
							case 'G': G++; break;
							case 'H': H++; break;
							case 'I': I++; break;
							case 'J': J++; break;
							case 'K': K++; break;
							case 'L': L++; break;
							case 'M': M++; break;
							case 'N': N++; break;
							case 'O': O++; break;
							case 'P': P++; break;
							case 'Q': Q++; break;
							case 'R': R++; break;
							case 'S': S++; break;
							case 'T': T++; break;
							case 'U': U++; break;
							case 'V': V++; break;
							case 'W': W++; break;
							case 'X': X++; break;
							case 'Y': Y++; break;
							case 'Z': Z++; break;
							case '0': zero++; break;
							case '1': one++; break;
							case '2': two++; break;
							case '3': three++; break;
							case '4': four++; break;
							case '5': five++; break;
							case '6': six++; break;
							case '7': seven++; break;
							case '8': eight++; break;
							case '9': nine++; break;
//							default: System.out.println(file.getName() + " is empty, no characters found"); break;
						}
					}
				}
				
			    list = letter.toArray(new String[letter.size()]);
			    
			    int[] heights = {A, B, C, D, E, F, G, H, I, J, K, L, M, O, P, Q, R, S, T, U, V, W, X, Y, Z};
			    int xIncrement = 5;
			    
			    HBox box = new HBox();
			    histogram = new Rectangle[heights.length];
				for(int i=0; i<heights.length; i++) {
					Rectangle rect = new Rectangle();
					rect.setHeight(heights[i]);
					rect.setWidth(15);
					rect.setX(xIncrement + rect.getWidth());
					rect.setY(-rect.getHeight());
					rect.setStroke(Color.BLACK);
					rect.setFill(null);
					histogram[i] = rect;
					box.getChildren().addAll(histogram[i]);
					border.setCenter(box);
					xIncrement += 7;
				}
			    
				try{
					Scanner find = new Scanner(file2);
					while(find.hasNext()){
						run = find.next();
						wordCount++; //increment word count
					}
				}
				catch(Exception y){}
				
				ArrayList<Integer> digitList = new ArrayList<Integer>();
				digitList.add(zero);
				digitList.add(one);
				digitList.add(two);
				digitList.add(three);
				digitList.add(four);
				digitList.add(five);
				digitList.add(six);
				digitList.add(seven);
				digitList.add(eight);
				digitList.add(nine);
				
				int maxDigit = 0; //Max digit in list/file
				int digit=0;
				for(int i=0; i<digitList.size(); i++) {
					if(digitList.get(i)>maxDigit) {
						maxDigit = digitList.get(i);
						digit = i;
					}
				}
				
				TextArea detailsArea = new TextArea();
				detailsArea.setText("\nFile in use: "+file.getName() + "\nCharacters found\n" +  "\n'A' count: " + 
						A + "\n'B' count: " + B + "\n'C' count: " + C + "\n'D' count: " + D +
						"\n'E' count: " + E + "\n'F' count: " + F + "\n'G' count: " + G + "\n'H' count: " + H +
						"\n'I' count: " + I + "\n'J' count: " + J + "\n'K' count: " + K + "\n'L' count: " + L +
						"\n'M' count: " + M + "\n'N' count: " + N + "\n'O' count: " + O + "\n'P' count: " + P +
						"\n'Q' count: " + Q + "\n'R' count: " + R + "\n'S' count: " + S + "\n'T' count: " + T +
						"\n'U' count: " + U + "\n'V' count: " + V + "\n'W' count: " + W + "\n'X' count: " + X +
						"\n'Y' count: " + Y + "\n'Z' count: " + Z + "\n'0' count: " + zero+ "\n'1' count: " + one+ "\n'2' count: " + two +
						"\n'3' count: " + three + "\n'4' count: " + four+ "\n'5' count: " + five+ "\n'6' count: " + six+ "\n'7' count: " + seven +
						"\n'8' count: " + eight + "\n'9' count: " + nine + 
						"\nWord count: " + wordCount + "\nDigits count: " + (zero+one+two+three+four+five+six+seven+eight+nine) + 
						"\nMaximum digit count: " + maxDigit +"\nMaximum  Digit: '" + digit + "'" + "\nCharacter count: " +characters + "\n"+ "Line count: " +lines);
				border.setRight(detailsArea);
				
			}
			finally {
//				return histogram;
			}
		}
	}

}