/*
 * **15.30 (Slide show) Twenty-five slides are stored as image files (slide0.jpg, slide1
.jpg, . . . , slide24.jpg) in the image directory downloadable along with the
source code in the book. The size of each image is 800 * 600. Write a program
that automatically displays the slides repeatedly. Each slide is shown for
two seconds. The slides are displayed in order. When the last slide finishes, the
first slide is redisplayed, and so on. Click to pause if the animation
 */

package EventDrivenProgAndAnim;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise15_30 extends Application{
	int clickCount = 0;
	static VBox vbox;
	static HBox box;
	static int value1, value2, value3, value4;
	static String file1, file2, file3, file4;
	static Label label1, label2, label3, label4;
	static ImageView view001, view002, view003, view004;
	static String root = "file:///C:/Users/Honeeks Inc/Pictures/Ultra.HD.Wallpaper.Pack.20/";
	static String[] name = {"001",	"002",	"003",	"004",	"005",	"006",	"007",	"008",	"009",	"010",	"011",	"012",	"013",	"014",	"015",	"016",	"017",	"018",	"019",	"020",	"021",	"022",	"023",	"024",	"025",	"026",	"027",	"028",	"029",	"030",	"031",	"032",	"033",	"034",	"035",	"036",	"037",	"038",	"039",	"040",	"041",	"042",	"043",	"044",	"045",	"046",	"047",	"048",	"049",	"050",	
			  "051",	"052",	"053",	"054",	"055",	"056",	"057",	"058",	"059",	"060",	"061",	"062",	"063",	"064",	"065",	"066",	"067",	"068",	"069",	"070",	"071",	"072",	"073",	"074",	"075",	"076",	"077",	"078",	"079",	"080",	"081",	"082",	"083",	"084",	"085",	"086",	"087",	"088",	"089",	"090",	"091",	"092",	"093",	"094",	"095",	"096",	"097",	"098",	"099",	"100",};

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		Button btnPlayPause = new Button("Play/Pause"); //button
		box = new HBox(); //hbox
		box.setPadding(new Insets(5,5,5,5));
		vbox = new VBox(); //vbox
		vbox.setPadding(new Insets(5,5,5,5));
		box.setSpacing(10);
		box.setAlignment(Pos.CENTER);
		btnPlayPause.setAlignment(Pos.BOTTOM_CENTER);
		vbox.setAlignment(Pos.BOTTOM_CENTER);
		
		loadInitialImages();
		
		PathTransition slide = new PathTransition(Duration.millis(5000), new Line(240, 200,240, -120), box);
		slide.setAutoReverse(false);
//		slide.play();
		btnPlayPause.setOnAction(e ->{
			clickCount++; //number of clicks
			if(clickCount % 2 != 0) {
				slide.play();
				slide.setOnFinished(r->{
					refresh(box);
					slide.play();
				});
			}
			
			else slide.pause();
		});
		
		vbox.getChildren().addAll(box, btnPlayPause);
		
		Scene scene = new Scene(vbox, 480, 200);
		stage.setScene(scene);
		stage.show();
	}
	
	void loadInitialImages() {
		file1 = root + name[1] + ".jpg";
		file2 = root + name[2] + ".jpg";
		file3 = root + name[3] + ".jpg";
		file4 = root + name[4] + ".jpg";

		view001 = new ImageView(new Image(file1, 100, 120, false, true));
		view002 = new ImageView(new Image(file2, 100, 120, false, false));
		view003 = new ImageView(new Image(file3, 100, 120, false, false));
		view004 = new ImageView(new Image(file4, 100, 120, false, false));
		
		box.getChildren().addAll(view001, view002, view003, view004);
	}

	void refresh(HBox box) {
		box.getChildren().clear();

		file1 = root + name[(int) (Math.random()*100)] + ".jpg";
		file2 = root + name[(int) (Math.random()*100)] + ".jpg";
		file3 = root + name[(int) (Math.random()*100)] + ".jpg";
		file4 = root + name[(int) (Math.random()*100)] + ".jpg";

		view001 = new ImageView(new Image(file1, 100, 120, false, true));
		view002 = new ImageView(new Image(file2, 100, 120, false, false));
		view003 = new ImageView(new Image(file3, 100, 120, false, false));
		view004 = new ImageView(new Image(file4, 100, 120, false, false));
		
		box.getChildren().addAll(view001, view002, view003, view004);
	}

}
