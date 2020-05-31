package UIControlsAndMultimedia;
/*
 * **16.15 (Demonstrate Label properties) Write a program to let the user dynamically
set the properties contentDisplay and graphicTextGap
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise16_15_Label_Properties extends Application {
	static HBox centerBox, propertyBox;
	static BorderPane border = new BorderPane();
	static Text text = new Text("Beach");
	static TextField sizeField;
	static ImageView graphic;
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		ComboBox<String> cmbAlignment = new ComboBox<String>();
		cmbAlignment.getItems().addAll("LEFT", "RIGHT", "TOP", "BOTTOM");
		sizeField = new TextField("20");
		sizeField.setPrefWidth(60);
		graphic = new ImageView(new Image("file:///C:/Users/Honeeks Inc/Pictures/Ultra.HD.Wallpaper.Pack.20/005.jpg", 100, 120, false, true));
		
		Label lblContentDisplay = new Label("ContentDisplay ", cmbAlignment), lblGraphicTextGap = new Label("GraphicTextGap ", sizeField);
		lblContentDisplay.setContentDisplay(ContentDisplay.RIGHT);
		lblGraphicTextGap.setContentDisplay(ContentDisplay.RIGHT);
		cmbAlignment.setValue("LEFT");
		
		centerBox = new HBox(graphic, text);
		propertyBox = new HBox(lblContentDisplay, lblGraphicTextGap);
		propertyBox.setSpacing(20);
		
		centerBox.setSpacing(Double.parseDouble(sizeField.getText()));
		centerBox.setPadding(new Insets(25));
		centerBox.setAlignment(Pos.CENTER);
		
		border.setTop(propertyBox);
		border.setCenter(centerBox);
		border.setPadding(new Insets(15));
		
		//EVENTS
		cmbAlignment.setOnAction(e-> {
			double angle = 0;
			if(cmbAlignment.getValue().equals("LEFT")) {
				centerBox.getChildren().clear();
				centerBox = new HBox(graphic, text);
				setCenterBoxProperty();
			}
			
			else if(cmbAlignment.getValue().equals("RIGHT")) {
				centerBox.getChildren().clear();
				centerBox = new HBox(text, graphic);
				setCenterBoxProperty();
			}
			
			else if(cmbAlignment.getValue().equals("TOP")) centerBox.setRotate(angle + 90);
			
			else if(cmbAlignment.getValue().equals("BOTTOM")) centerBox.setRotate(angle+270);
		});
		
		sizeField.setOnAction(e-> {
			double size = 	Double.parseDouble(sizeField.getText());
			if(size >0 && size < 300)
				centerBox.setSpacing(Double.parseDouble(sizeField.getText()));
			
			else {
				sizeField.setText("300");
				centerBox.setSpacing(Double.parseDouble(sizeField.getText()));
			}
		});
		
		sizeField.setOnKeyPressed(e->{
			double size = Double.parseDouble(sizeField.getText());
			if(e.getCode().equals(KeyCode.UP) && size < 300) {
				size += 1;
				sizeField.setText(String.valueOf(size));
				centerBox.setSpacing(size);
			}
			
			else if(e.getCode()==KeyCode.DOWN && size > 0) {
				size -= 1;
				sizeField.setText(String.valueOf(size));
				centerBox.setSpacing(size);
			}
		});
		
		sizeField.requestFocus();
		
		Scene scene = new Scene(border, 500, 300);
		stage.setScene(scene);
		stage.show();
	}
	
	public HBox setCenterBoxProperty() {
		centerBox.setSpacing(Double.parseDouble(sizeField.getText()));
		centerBox.setPadding(new Insets(25));
		centerBox.setAlignment(Pos.CENTER);
		border.setCenter(centerBox);
		return centerBox;
	}

}
