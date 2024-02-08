/*
 * ***15.34 (Simulation: self-avoiding random walk) A self-avoiding walk in a lattice is a
path from one point to another that does not visit the same point twice. Selfavoiding
walks have applications in physics, chemistry, and mathematics. They
can be used to model chain-like entities such as solvents and polymers. Write
a program that displays a random path that starts from the center and ends at a
point on the boundary, as shown in Figure 15.37a or ends at a dead-end point
(i.e., surrounded by four points that have already been visited), as shown in
Figure 15.37b. Assume the size of the lattice is 16 by 16.
 */
package EventDrivenProgAndAnim;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SelfAvoiding extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Pane pane = new Pane();
		Button btnStart = new Button("Start");
		HBox hbox = new HBox(btnStart);
		hbox.setPadding(new Insets(8));
//		btnStart.setAlignment(Pos.BOTTOM_CENTER);
		hbox.setAlignment(Pos.BOTTOM_CENTER);
		GridPane grid = new GridPane();
		grid.setGridLinesVisible(true);
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                

//        final NumberAxis x = new NumberAxis();
//        final NumberAxis y = new NumberAxis();
//        x.setAutoRanging(false);
//        y.setAutoRanging(false);
//
//        final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(x, y);
//        lineChart.setPrefSize(900, 900);
//        lineChart.setLegendVisible(false);
//        lineChart.setCreateSymbols(false);
//        lineChart.setAlternativeColumnFillVisible(false);
//        lineChart.setAlternativeRowFillVisible(false);
//
//        final XYChart.Series seriesX = new XYChart.Series();
//
//        for (int i = 1; i < 100; i++) {
//            if ((i % 2) != 0) {
//                seriesX.getData().add(new XYChart.Data(i, 0));
//                seriesX.getData().add(new XYChart.Data(i, 100));
//            }
//            else {
//                seriesX.getData().add(new XYChart.Data(i, 100));
//                seriesX.getData().add(new XYChart.Data(i, 0));
//            }
//
//        }
//
//        final XYChart.Series seriesY = new XYChart.Series();
//
//        for (int i = 1; i < 100; i++) {
//            if ((i % 2) != 0) {
//                seriesY.getData().add(new XYChart.Data(0, i));
//                seriesY.getData().add(new XYChart.Data(100, i));
//            }
//            else {
//                seriesY.getData().add(new XYChart.Data(100, i));
//                seriesY.getData().add(new XYChart.Data(0, i));
//            }
//
//        }
//        
//
//        lineChart.getData().add(seriesX);
//        lineChart.getData().add(seriesY);
//        lineChart.getStylesheets().add("site.css");
		hbox.getChildren().add(grid);
		Scene scene = new Scene(hbox, 300, 300);
		stage.setScene(scene);
		stage.show();
	}

}
