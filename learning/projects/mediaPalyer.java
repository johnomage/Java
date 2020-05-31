package projects;

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class mediaPalyer extends Application {
	
	MediaPlayer player;
	Label time;
	Duration duration;
	Button btnFullScreen;
	Scene scene;
	double width, height;
	MediaView mediaView;
	Media media;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		scene = setScene(this.width, this.height);
		stage.setTitle("Media Player");
		stage.setScene(scene);
		stage.show();
	}

	private Scene setScene(double width, double height) {
		this.height = height;
		this.width = width;
		
		//video path
		String path = "C:\\Users\\Honeeks Inc\\Videos\\The_Shack_2017.mp4".replace('\\', '/');
		media = new Media(new File(path).toURI().toString());
		player = new MediaPlayer(media);
		
		player.setAutoPlay(false);
		mediaView = new MediaView(player);
//		⏹ ⏮ ⏭ ⏪ 🔀 ⏯ ⏏ ⏩
		//Drop Shadow Effect
		DropShadow dropshadow = new DropShadow();
		dropshadow.setOffsetX(5);
		dropshadow.setOffsetY(5);
		dropshadow.setColor(Color.WHITE);
		
		mediaView.setEffect(dropshadow);
		
		BorderPane border = new BorderPane();
		border.setCenter(mediaView);
		border.setBottom(addToolBar());
		border.setStyle("-fx-background-color: Black");
		scene = new Scene(border, 600, 600);
		scene.setFill(Color.BLACK);
		return scene;
	}

	private HBox addToolBar() {
		HBox HbToolBar = new HBox();
		HbToolBar.setPadding(new Insets(20));
		HbToolBar.setAlignment(Pos.CENTER);
		HbToolBar.alignmentProperty().isBound();
		HbToolBar.setSpacing(5);
		
		Button btnPlay = new Button("▶"), btnStop = new Button("⏹"), btnFF = new Button("⏩"), btnRW = new Button("⏪"), btnOpen = new Button("⏏");
		Button btnPause = new Button("⏸"), btnNext = new Button("⏯"), btnPrevious = new Button("⏮"), btnShuffle = new Button("🔀");
		
		return null;
	}

}
