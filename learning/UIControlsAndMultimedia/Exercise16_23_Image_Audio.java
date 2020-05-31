package UIControlsAndMultimedia;

import java.io.File;

import javax.swing.GroupLayout.Alignment;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

/*
 * **16.23 (Create an image animator with audio) Create animation in Figure 16.46b to
meet the following requirements:
 - Allow the user to specify the animation speed in a text field.
 - Get the number of iamges and image’s file-name prefix from the user. For
example, if the user enters n for the number of images and L for the image
prefix, then the files are L1.gif, L2.gif, and so on, to Ln.gif. Assume that the
images are stored in the image directory, a subdirectory of the program’s
class directory. The animation displays the images one after the other.
 - Allow the user to specify an audio file URL. The audio is played while the
animation runs.
 */

public class Exercise16_23_Image_Audio extends Application {
	private static Image image;
	private static ImageView imageView;
	private static Text text, infoText;
	private static TextField tfSpeed, tfImage, tfCountImage, tfAudio;
	private static Button btnStart = new Button("Start Animation");
	private static BorderPane border = new BorderPane();
	private static MediaView audioMedia;
	private static MediaPlayer player;
	private static String ImagePath = "file:///C:/Users/Honeeks Inc/Pictures/Ultra.HD.Wallpaper.Pack.20/008.jpg";
	private static String audioPath = "C:/Users/Honeeks Inc/music/Alexandra Burke- Hallelujah.mp3";
	private static Circle circle = new Circle(250, 225, 0);
	private static File file = new File(audioPath);
	Text playText = new Text("Now Playing: " + file.getName());
	private static Scene scene;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		btnStart.setAlignment(Pos.CENTER_RIGHT);
		
		text = new Text("Welcome to greatness!");
		text.setStyle("-fx-font-size: 40; -fx-font-weight: bold; -fx-font-color: cyan");
		text.setFill(Color.DARKOLIVEGREEN);
		
		infoText = new Text("Enter Information for Animation");
		infoText.setTextAlignment(TextAlignment.LEFT);
		infoText.setStyle("-fx-font-weight: bold");
		
		tfImage = new TextField();
		tfImage.setAlignment(Pos.CENTER_RIGHT);
		tfSpeed = new TextField("200");
		tfSpeed.setAlignment(Pos.CENTER_RIGHT);
		tfAudio = new TextField(audioPath);
		tfCountImage = new TextField();
		
		GridPane grid = new GridPane();
		grid.add(infoText, 0, 0);
		grid.add(new Text("Animation Speed in milliseconds "), 0, 1); grid.add(tfSpeed, 1, 1);
		grid.add(new Text("Image File"), 0, 2); grid.add(tfImage, 1, 2);
		grid.add(new Text("Number of Images"), 0, 3); grid.add(tfCountImage, 1, 3);
		grid.add(new Text("Audio File URL/Path"), 0, 4); grid.add(tfAudio, 1, 4);
		
		VBox vBox = new VBox(grid);
		vBox.setSpacing(10);
		
		HBox hBox = new HBox(10, playText, btnStart);
		btnStart.setAlignment(Pos.CENTER_RIGHT);
		playText.setTextAlignment(TextAlignment.LEFT);
		Design design = new Design();
		
		btnStart.setOnAction(e->{
			if(btnStart.getText().equals("Start Animation")) {
				design.play();
				playText.setVisible(true);
				btnStart.setText("Stop Animation");
			}
			
			else if(btnStart.getText().equals("Stop Animation")) {
				design.stop();
				playText.setVisible(false);
				btnStart.setText("Start Animation");
			}
		});
		
		playText.setVisible(false);
		border.setTop(hBox);
		border.setCenter(text);
		border.setBottom(vBox);
		border.setPadding(new Insets(20));
		
		scene = new Scene(border, 500, 450);
		stage.setScene(scene);
		stage.show();
	}
	
	class Design {
		RotateTransition rotate;
		int millsec = Integer.parseInt(tfSpeed.getText());
		
		public Design() {
			rotate = new RotateTransition(Duration.millis(millsec), text);
			rotate.setToAngle(225);
			player = new MediaPlayer(new Media(file.toURI().toString()));
			audioMedia = new MediaView(player);
			rotate.setCycleCount(Timeline.INDEFINITE);
		}
		
		public void play() {
			rotate.play();
			player.play();	
//			if(player.getMedia().getDuration().equals(player.getTotalDuration())) {
//				rotate.stop();
//			}
		}
		
		public void stop() {
			rotate.stop();
			player.stop();
		}
	}

}
