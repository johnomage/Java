package EventDrivenProgAndAnim;

//(Pick four cards) Write a program that lets the user click the Refresh button to display four cards from a deck of 52 cards

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise15_01 extends Application{
	static VBox vb;
	static HBox box;
	static int value1, value2, value3, value4;
	static String file1, file2, file3, file4;
	static Label label1, label2, label3, label4;
	static ImageView view001, view002, view003, view004;
	static String root = "file:///C:/Users/Honeeks Inc/Pictures/Ultra.HD.Wallpaper.Pack.20/";
	static String[] name = {"001",	"002",	"003",	"004",	"005",	"006",	"007",	"008",	"009",	"010",	"011",	"012",	"013",	"014",	"015",	"016",	"017",	"018",	"019",	"020",	"021",	"022",	"023",	"024",	"025",	"026",	"027",	"028",	"029",	"030",	"031",	"032",	"033",	"034",	"035",	"036",	"037",	"038",	"039",	"040",	"041",	"042",	"043",	"044",	"045",	"046",	"047",	"048",	"049",	"050",	
			  "051",	"052",	"053",	"054",	"055",	"056",	"057",	"058",	"059",	"060",	"061",	"062",	"063",	"064",	"065",	"066",	"067",	"068",	"069",	"070",	"071",	"072",	"073",	"074",	"075",	"076",	"077",	"078",	"079",	"080",	"081",	"082",	"083",	"084",	"085",	"086",	"087",	"088",	"089",	"090",	"091",	"092",	"093",	"094",	"095",	"096",	"097",	"098",	"099",	"100",};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		// TODO Auto-generated method stub
		Button refresh = new Button("Refresh"); //button
		box = new HBox(); //hbox
		box.setPadding(new Insets(5,5,5,5));
		vb = new VBox(); //vbox
		vb.setPadding(new Insets(5,5,5,5));
		box.setSpacing(10);
		box.setAlignment(Pos.CENTER);
		refresh.setAlignment(Pos.BOTTOM_CENTER);
		vb.setAlignment(Pos.BOTTOM_CENTER);
		
		loadInitialImages();
		
		refresh.setOnAction(e ->{
			refresh(box);
		});
		
		vb.getChildren().addAll(box, refresh);
		
		Scene scene = new Scene(vb, 480, 200);
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
