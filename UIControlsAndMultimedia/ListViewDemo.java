package UIControlsAndMultimedia;

import java.io.File;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ListViewDemo extends Application {
	private String imageUrl = "file:///C:/Users/Honeeks Inc/Pictures/Ultra.HD.Wallpaper.Pack.20/";
	private String[] picture = {"001.jpg", "002.jpg", "003.jpg", "004.jpg", "005.jpg", "006.jpg", "007jpg"};
	String file0 = imageUrl+picture[0], file1 = imageUrl+picture[1], file2 = imageUrl+picture[2], file3 = imageUrl+picture[3], file4 = imageUrl+picture[4], file5 = imageUrl+picture[5], file6=imageUrl+picture[6];
	private String audioUrl = "file:///C:/Users/Honeeks Inc/music/";
	private String[] audioList = {};
	FileChooser openFile = new FileChooser();
	private ImageView[] picView = {
			new ImageView(new Image(file0, 100, 120, false, true)),
			new ImageView(new Image(file1, 100, 120, false, true)),
			new ImageView(new Image(file2, 100, 120, false, true)),
			new ImageView(new Image(file3, 100, 120, false, true)),
			new ImageView(new Image(file4, 100, 120, false, true)),
			new ImageView(new Image(file5, 100, 120, false, true)),
			new ImageView(new Image(file6, 100, 120, false, true))
			};
	Button openButton = new Button("Open");
	
//	private Media media = new Media(file1);
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		ListView<String> lv = new ListView<String>(FXCollections.observableArrayList(picture));
		lv.setPrefSize(400, 400);
		lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		Button playButton = new Button(">");
		
		playButton.setOnAction(e->{
			if(playButton.getText().equals(">"))
				playButton.setText("||");
		});
		
		HBox hBox = new HBox(openButton, playButton);
		FlowPane flow = new FlowPane(20, 10);
		BorderPane pane = new BorderPane();
		pane.setLeft(new ScrollPane(lv));
		pane.setCenter(flow);
		pane.setBottom(hBox);
		
		lv.getSelectionModel().selectedItemProperty().addListener(ov->{
			flow.getChildren().clear();
			for(int i: lv.getSelectionModel().getSelectedIndices()) {
				flow.getChildren().add(picView[i]);
			}
		});
		
		openButton.setOnAction(e->{
			openFile.showOpenDialog(stage);
		});
		
		Scene scene = new Scene(pane, 650, 170);
		stage.setScene(scene);
		stage.show();
	}

}
