package UIControlsAndMultimedia;
/*
*16.20 (Count-up stopwatch) Write a program that simulates a stopwatch, as shown
in Figure 16.45a. When the user clicks the Start button, the button’s label is
changed to Pause, as shown in Figure 16.45b. When the user clicks the Pause
button, the button’s label is changed to Resume, as shown in Figure 16.45c. The
Clear button resets the count to 0 and resets the button’s label to Start.
 */

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise16_2021_Count_Up_Down_Stopwatch extends Application {
	
	static Text txtTime = new Text("00 : 00 : 00"), txtMessage;
	static Button btnStart, btnClear, btnResume;
	static ComboBox<String> cmbWatchMode;
	BorderPane border = new BorderPane();
	Label lblSec, lblMin;
	TextField tfSec = new TextField("0") , tfMin = new TextField("0");
	HBox modeHBox;
	CountDownStopWatch clockDown;
	CountUpStopWatch clockUp;
	
	@Override
	public void start(Stage stage) {
		//DROPDOWN LIST
		cmbWatchMode = new ComboBox<String>();
		cmbWatchMode.getItems().addAll("Count Down", "Count Up");
		cmbWatchMode.setValue("Choose Mode");
		
		txtTime.setStyle("-fx-font-size: 60");
		btnStart = new Button("Start");
		btnClear = new Button("Clear");
		
		//HBOX FOR START/STOP BUTTONS
		HBox btnHBox = new HBox(btnStart, btnClear);
		modeHBox = new HBox(cmbWatchMode);
		
		//add children to border pane
		border.setBottom(btnHBox);
		border.setTop(modeHBox);
		border.setCenter(txtTime);
		border.setPadding(new Insets(10));
		
		//border background image.3840,2160
		BackgroundImage sceneImage = new BackgroundImage(new Image("file:///C:/Users/Honeeks Inc/eclipse-workspace/learning/052.jpg",
				3840, 2160, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		border.setBackground(new Background(sceneImage));
		
		//HBOX AND BUTTON SIZING
		modeHBox.setSpacing(10);
		modeHBox.setAlignment(Pos.CENTER_LEFT);
		btnHBox.setSpacing(10);
		btnHBox.setAlignment(Pos.CENTER);
		
		//EVENTS DEFINITIONS FOR COMBOLIST
		EventHandler<ActionEvent> handler = e->{ 
			if(cmbWatchMode.getValue().equals("Count Up")) { //COUNT UP CLOCK
				modeHBox.getChildren().removeAll(lblSec, lblMin);
				clockIt(clockUp = new CountUpStopWatch());
			}
			
			else if(cmbWatchMode.getValue().equals("Count Down")){ //COUNT DOWN CLOCK
				modeHBox.getChildren().clear();
				lblSec = new Label("Sec: ", tfSec);
				lblSec.setContentDisplay(ContentDisplay.RIGHT);
				lblSec.setTextFill(Color.YELLOW);
				tfSec.setPrefWidth(75);
				tfSec.setAlignment(Pos.CENTER_RIGHT);
				tfSec.setTooltip(new Tooltip("Enter seconds"));
				
				lblMin = new Label("Min: ", tfMin);
				lblMin.setContentDisplay(ContentDisplay.RIGHT);
				lblMin.setTextFill(Color.YELLOW);
				tfMin.setPrefWidth(75);
				tfMin.setAlignment(Pos.CENTER_RIGHT);
				tfMin.setTooltip(new Tooltip("Enter Minute"));
				modeHBox.getChildren().addAll(cmbWatchMode, lblMin, lblSec);
				clockIt(clockDown = new CountDownStopWatch());
			}
			
			else {
				Alert alert = new Alert(AlertType.WARNING, "Choose Timing Mode", ButtonType.OK);
				alert.setTitle(null);
				alert.showAndWait();
			}
		};
		
		cmbWatchMode.setOnAction(handler);
		
		GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		Scene scene = new Scene(border,  device.getDisplayMode().getWidth()/4, device.getDisplayMode().getHeight()*.2);
		stage.setScene(scene);
		stage.resizableProperty().setValue(true);
		stage.show();
		
		scene.widthProperty().addListener(vv-> txtTime.getText());
		scene.heightProperty().addListener(vv-> txtTime.getText());
	}
	
	//button actions
	public void clockIt(CountDownStopWatch clock) { //COUNT DOWN BUTON ACTIONS METHOD
		btnStart.setOnAction(e->{
			if(btnStart.getText().equals("Start")) {
				clock.play();
				btnStart.setText("Pause");
				btnClear.setText("Stop");
				modeHBox.setDisable(true);
			}
			
			else if (btnStart.getText().equals("Pause")){
				clock.pause();
				btnStart.setText("Resume");
				modeHBox.setDisable(true);
			}
			
			else {
				clock.play();
				btnStart.setText("Pause");
				modeHBox.setDisable(true);
			}
		});
		
		btnClear.setOnAction(e->{
			clock.clear();
			btnStart.setText("Start");
			tfMin.setText("0");
			tfSec.setText("0");
			cmbWatchMode.setDisable(false);
			modeHBox.setDisable(false);
		});
	}
	
	public void clockIt(CountUpStopWatch clock) { //COUNT UP BUTTON ACTIONS METHOD
		btnStart.setOnAction(e->{
			if(btnStart.getText().equals("Start")) {
				clock.play();
				btnStart.setText("Pause");
				btnClear.setText("Stop");
				modeHBox.setDisable(true);
			}
			
			else if (btnStart.getText().equals("Pause")){
				clock.pause();
				btnStart.setText("Resume");
				modeHBox.setDisable(true);
			}
			
			else {
				clock.play();
				btnStart.setText("Pause");
				modeHBox.setDisable(true);
			}
		});
		
		btnClear.setOnAction(e->{
			clock.clear();
			btnStart.setText("Start");
			tfMin.setText("0");
			tfSec.setText("0");
			cmbWatchMode.setDisable(false);
			modeHBox.setDisable(false);
		});
	}

	//main method =========================================================
	public static void main(String[] args) {
		Application.launch(args);
	}
	// ====================================================================
	
	
	// Count Up Class
	class CountUpStopWatch {
		int hr = 0, min = 0, sec = 0;
		Timeline watch;
		
		public CountUpStopWatch () { //CONSTRUCTOR
			watch = new Timeline(new KeyFrame(Duration.millis(1000), e-> run()));
			watch.setCycleCount(Timeline.INDEFINITE);
		}
		
		public void updateTick() {
			border.getChildren().remove(txtTime);
			txtTime.setText(String.valueOf(hr) + " : " + String.valueOf(min) + " : " + String.valueOf(sec));
			txtTime.setFill(Color.YELLOW);
			border.setCenter(txtTime);
		}
		public void play() {
			watch.play();
		}
		
		public void pause() {
			watch.pause();
		}
		
		public void clear() {
			watch.stop();
			sec = 0; min = 0; hr = 0;
			txtTime.setText("00 : 00 : 00");
		}
		
		public void run() {
			sec = sec < 59 ? sec = sec+1 : 0;
			updateTick();
			
			if(sec == 0) {
				min++;
				updateTick();
			}
			
			if(min == 59) {
				hr++;
				updateTick();
			}
		}
	}
	
	
	// Count Down Class
	class CountDownStopWatch {
		private Integer hr = 0, min = 0, sec = 0;
		Timeline watch;
		
		public CountDownStopWatch () {
			watch = new Timeline(new KeyFrame(Duration.millis(1000), e-> run()));
			watch.setCycleCount(Timeline.INDEFINITE);
		}
		
		
		
		public Integer getHr() {
			return hr;
		}

		public Integer getMin() {
			return min;
		}

		public Integer getSec() {
			return sec;
		}

		public void updateTick() { //update/refresh per second values
			border.getChildren().remove(txtTime);
			txtTime.setText(String.valueOf(hr) + " : " + String.valueOf(min) + " : " + String.valueOf(sec));
			txtTime.setFill(Color.YELLOW);
			border.setCenter(txtTime);
			if(hr == 0 && min == 0 && sec == 5) {
				txtMessage = new Text("5 SECONDS MORE");
				BorderPane.setAlignment(txtMessage, Pos.TOP_RIGHT);
				border.getChildren().add(txtMessage);
			}
		}
		
		public void play() {
			sec = Integer.parseInt(tfSec.getText()) + 1;
			min = Integer.parseInt(tfMin.getText());
			confirmValues();
			watch.play();
		}
		
		public void pause() {
			watch.pause();
			tfMin.setText(min.toString());
			tfSec.setText(sec.toString());
		}
		
		public void clear() { //RESET APPLICATION
			watch.stop();
			sec = 0; min = 0; hr = 0;
			txtTime.setText("00 : 00 : 00");
			tfSec.setText("0");
			tfMin.setText("0");
			btnStart.setText("Start");
			cmbWatchMode.setDisable(false);
			modeHBox.setDisable(false);
		}
		
		public void confirmValues() { //CHECK FOR VALIDITY OF MINUTE AND SECOND
			if(sec > 60) {
				min = (int)sec/60 + min;
				sec = sec%60;
				tfSec.setText(String.valueOf(sec));
			}
			
			else if(min > 60) {
				hr = hr + (int)min/60;
				min = min%60;
				tfMin.setText(String.valueOf(min));
			}
		}
		
		public void run() { //CLOCK ENGINE
			if(hr>0) {
				if(min == 0 && sec == 0) {
					hr--;
					min=59;
					sec=59;
					updateTick();
				}
				else if (min > 0 && sec == 0) {
					min--;
					sec = 59;
					updateTick();
				}
				
				else if(min > 0 && sec > 0 || min == 0 && sec > 0) {
					sec--;
					updateTick();
				}
			}
			
			else if (hr==0) {
				if(min > 0 && sec > 0 || min == 0 && sec > 0) {
					sec--;
					updateTick();
				}
				else if (min > 0 && sec == 0) {
					min--;
					sec = 59;
					updateTick();
				}
				
				else if(min == 0 && sec == 0) {
					clear();
				}
				
			}
		}
	}
}
