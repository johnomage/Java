package binary_IO;

import java.io.*;
import java.util.*;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/*
 * ***17.9 (Address book) Write a program that stores, retrieves, adds, and updates addresses
as shown in Figure 17.20. Use a fixed-length string for storing each attribute in the
address. Use random access file for reading and writing an address. Assume that
the size of name, street, city, state, and zip is 32, 32, 20, 2, 5 bytes, respectively.
 */
public class Exercise17_02_AddressBook extends Application{

	static private Button addButton = new Button("Add"), firstButton = new Button("First"), nextButton = new Button("Next"), previousButton = new Button("Previous"),
			lastButton = new Button("Last"), updateButton = new Button("Update");
	static TextField nameField = new TextField(), streetField = new TextField(), cityField = new TextField(), stateField = new TextField(), zipField = new TextField();
	static private Label nameLabel, streetLabel, cityLabel, stateLabel, zipLabel;
	static private Alert alert;
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws IOException {
		
		nameLabel = new Label("Name ", nameField);
		nameField.setPrefWidth(392);
		nameLabel.setContentDisplay(ContentDisplay.RIGHT);
		
		streetLabel = new Label("Street ", streetField);
		streetField.setPrefWidth(392);
		streetLabel.setContentDisplay(ContentDisplay.RIGHT);
		
		cityLabel = new Label("City    ", cityField);
		cityLabel.setContentDisplay(ContentDisplay.RIGHT);
		
		stateLabel = new Label("State ", stateField);
		stateField.setPrefWidth(70);
		stateLabel.setContentDisplay(ContentDisplay.RIGHT);
		
		zipLabel = new Label("Zip", zipField);
		zipField.setPrefWidth(50);
		zipLabel.setContentDisplay(ContentDisplay.RIGHT);
		
		//HBox for buttons, and (city, state, zip)
		HBox buttonHBox = new HBox(10), cityStateZipHBox = new HBox(10);
		cityStateZipHBox.getChildren().addAll(cityLabel, stateLabel, zipLabel);
		buttonHBox.getChildren().addAll(addButton, firstButton, nextButton, previousButton, lastButton, updateButton);
		buttonHBox.setAlignment(Pos.CENTER);
		
		//VBox for name, street, city, state, zip
		VBox hboxVBox = new VBox(10), nameStreetVBox = new VBox(10);
		nameStreetVBox.getChildren().addAll(nameLabel, streetLabel);
		hboxVBox.getChildren().addAll(nameStreetVBox, cityStateZipHBox, buttonHBox);
		
		BorderPane border = new BorderPane();
		
		border.setBottom(hboxVBox);
		border.setPadding(new Insets(20));
		
		//EVENTS
		ButtonEvents click = new ButtonEvents();
		//add new profile
		addButton.setOnAction(e->{
			if(nameField.getText().isEmpty() && streetField.getText().isEmpty() && cityField.getText().isEmpty() && stateField.getText().isEmpty() && zipField.getText().isEmpty()) {
				alert = new Alert(AlertType.ERROR, "All fields must be filled!");
				alert.setHeaderText(null);
				alert.showAndWait();
			}
			else if(nameField.getText().isEmpty()) {
				flag(nameLabel.getText());
			}
			else if(streetField.getText().isEmpty()){
				flag(streetLabel.getText());
			}
			
			else if(cityField.getText().isEmpty()){
				flag(cityLabel.getText());
			}
			
			else if(stateField.getText().isEmpty()){
				flag(stateLabel.getText());
			}
			else if(zipField.getText().isEmpty()){
				flag(zipLabel.getText());
			}
			
			else {
				try {
					click.add();
					alert = new Alert(AlertType.CONFIRMATION, "Book for '" + nameField.getText() + "' saved.", ButtonType.OK);
					alert.setHeaderText(null);
					alert.showAndWait();
				} 
				catch (IOException e1) {}
				//clear all fields after successful add
				nameField.clear();
				streetField.clear();
				cityField.clear();
				stateField.clear();
				zipField.clear();
			}
			
		});
		
		//FIRST ENTERED DETAILS
		firstButton.setOnAction(e->{
			try {
				click.first();
			} 
			
			catch (IOException e1) {}
		});
		
		//NEXT DETAILS
		nextButton.setOnAction(e->{
			click.next();
		});
		
		//PEVIOUS DETAILS
		previousButton.setOnAction(e->{
			try {
				click.previous();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		//LAST DETAILS
		lastButton.setOnAction(e->{
			try {
				click.last();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		//UPDATE RECORDS
		updateButton.setOnAction(e->{
			click.update();
			alert = new Alert(AlertType.CONFIRMATION, "Book for '" + nameField.getText() + "' updated.", ButtonType.OK);
			alert.setHeaderText(null);
			alert.showAndWait();
			
		});
		
		Scene scene = new Scene(border, 500, 200);
		stage.setScene(scene);
		stage.setTitle("Address Book");
		stage.show();
		
	}
	
	//ALERT FOR ERRORS
	void flag(String error) {
		alert = new Alert(AlertType.ERROR, error + " cannot be empty!");
		alert.setHeaderText(null);
		alert.showAndWait();
	}

}

//CLASS FOR BUTTON EVENTS AND METHODS
class ButtonEvents{
	static private RandomAccessFile  accessFile;
	private final int NAME = 32, STREET = 32, CITY = 10, STATE = 8, ZIP = 5; 
	static protected int count = 0;
	private Alert alert;

			
	ButtonEvents() throws IOException{
		accessFile = new RandomAccessFile(".Address Book.dat", "rw");
	}
	
	//write details from textfields to file
	void add() throws IOException {
		accessFile.seek(accessFile.length());
		write(accessFile);
	}
	
	
	//READ FIRST DETAILS ENTERED
	protected void first() throws IOException {
		if(accessFile.length() > 0) {
			accessFile.seek(0);
			read(accessFile);
			count = 1;
		}
	}
	
	protected void next() {
		try {
			if(count*89 < accessFile.length()) {
				accessFile.seek(count*89);
				read(accessFile);
				count++;
			}
		} 
		
		catch (IOException e) {
			alert = new Alert(AlertType.INFORMATION, "End of file reached\n. " + count + " books read.", ButtonType.OK);
			alert.setHeaderText(null);
			alert.showAndWait();
		}
	}
	
//	Read about randomaccessfile again
	
	protected void previous() throws IOException {
		if(count > 1)
			count--;
		else count = 1;
		accessFile.seek((count - 1)*89);
		read(accessFile);
		
	}
	
	protected void last() throws IOException {
		count = ((int)accessFile.length()) / 89;
		accessFile.seek((count - 1)*89);
		read(accessFile);
	}
	
	protected void update() {
		try {
			accessFile.seek((count - 1)*89);
			write(accessFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private void write(RandomAccessFile raf) throws IOException {
		raf.write(fixedLength(Exercise17_02_AddressBook.nameField.getText().getBytes(), NAME));
		raf.write(fixedLength(Exercise17_02_AddressBook.streetField.getText().getBytes(), STREET));
		raf.write(fixedLength(Exercise17_02_AddressBook.cityField.getText().getBytes(), CITY));
		raf.write(fixedLength(Exercise17_02_AddressBook.stateField.getText().getBytes(), STATE));
		raf.write(fixedLength(Exercise17_02_AddressBook.zipField.getText().getBytes(), ZIP));
		raf.writeUTF("\n");
	}
	
	//READ FILE AND COPY TO TEXTFIELDS  q
	private void read(RandomAccessFile raf) throws IOException {
		int position;
		
		byte[] name = new byte[NAME];
		position = raf.read(name);
		Exercise17_02_AddressBook.nameField.setText(new String(name));
		
		byte[] street = new byte[STREET];
		position += raf.read(street);
		Exercise17_02_AddressBook.streetField.setText(new String(street));
		
		byte[] city = new byte[CITY];
		position += raf.read(city);
		Exercise17_02_AddressBook.cityField.setText(new String(city));
		
		byte[] state = new byte[STATE];
		position += raf.read(state);
		Exercise17_02_AddressBook.stateField.setText(new String(state));
		
		byte[] zip = new byte[ZIP];
		position += raf.read(zip);
		Exercise17_02_AddressBook.zipField.setText(new String(zip));
	}
	
	//return a Byte[] of fixed length
	private byte[] fixedLength(byte[] x, int n) {
		byte b[] = new byte[n];
		for(int i=0; i<x.length; i++) {
			b[i] = x[i];
		}
		
		return b;
	}
	
}