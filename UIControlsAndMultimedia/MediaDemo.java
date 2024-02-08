package UIControlsAndMultimedia;

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MediaDemo extends Application {
	private static final String path = "C:\\Users\\Honeeks Inc\\Videos\\The_Shack_2017.mp4".replace('\\', '/');//"C:\\Users\\Honeeks Inc\\Videos\\The_Shack_2017.mp4".replace("\\", "/");

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Media media = new Media(new File(path).toURI().toString());
		MediaPlayer player = new MediaPlayer(media);
		MediaView view = new MediaView(player);
		
		Button playButton = new Button("Play >");
		playButton.setOnAction(e->{
			if(playButton.getText().equals("Play >")) {
				player.play();
				playButton.setText("Pause ||");
			}
			
			else {
				player.pause();
				playButton.setText("Play >");
			}
		});
		
		Button rewindButton = new Button("Rewind <<");
		rewindButton.setOnAction(e-> player.seek(Duration.ZERO));
		
		Button ffButton = new Button(">>");
		ffButton.setOnAction(e-> player.seek(player.getCurrentTime().add(Duration.seconds(50))));
		
		Slider volumeSlide = new Slider();
		volumeSlide.setPrefWidth(150);
		volumeSlide.setMaxWidth(Region.USE_PREF_SIZE);
		volumeSlide.setMinWidth(30);
		volumeSlide.setValue(50);
		volumeSlide.setShowTickLabels(true);
		player.volumeProperty().bind(volumeSlide.valueProperty().divide(100));
		
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().addAll(playButton, rewindButton, ffButton, new Label("Volume "), volumeSlide);
		
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(20,20,20,20));
		borderPane.setCenter(view);
		borderPane.setBottom(hBox);
		
		Scene scene = new Scene(borderPane, 650, 500);
		stage.setScene(scene);
		stage.show();
	}

}
