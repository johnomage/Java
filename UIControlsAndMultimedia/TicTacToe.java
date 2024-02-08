package UIControlsAndMultimedia;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class TicTacToe extends Application {

	private char whoseTurn = 'X';
	private Cell[][] cell = new Cell[3][3];
	private Label lblStatus = new Label("X's turn to play");
	private Button btnReset = new Button("Reset");
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		GridPane grid = new GridPane();
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				grid.add(cell[i][j] = new Cell(), j, i);
			}
		}
		
		HBox box = new HBox(lblStatus, btnReset);
		box.setSpacing(50);
		box.setPadding(new Insets(10));
				
		BorderPane border = new BorderPane();
		border.setCenter(grid);
		border.setBottom(box);
		border.setPadding(new Insets(20));
		
		
		Scene scene = new Scene(border, 500, 500);
		stage.setScene(scene);
		stage.setTitle("Tic-Ta-Toe Game");
		stage.show();
	}
	
	boolean isFull() {
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				if(cell[i][j].getToken() == ' ')
					return false;
		return true;
	}
	
	// An inner class for a cell
	public class Cell extends Pane{
		private char token = ' ';
		
		public Cell() {
			setStyle("-fx-border-color: black");
			this.setPrefSize(2000, 2000);
			this.setOnMouseClicked(e -> handleMouseClick());
		}

		public char getToken() {
			return token;
		}
		
		private boolean isWon(char token) {
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					if(cell[i][0].getToken()==token && cell[i][1].getToken()==token && cell[i][2].getToken()==token ||
							cell[0][j].getToken()==token && cell[1][j].getToken()==token && cell[2][j].getToken()==token ||
							cell[0][2].getToken()==token && cell[1][1].getToken()==token && cell[2][0].getToken() == token ||
							cell[0][0].getToken()==token && cell[1][1].getToken()==token && cell[2][2].getToken()==token)// || cell[j][i].getToken()==cell[i][j].getToken())
						return true;
				}
			}
			return false;
		}

		public void setToken(char c) {
			token = c;
			if(token == 'X') {
				Line line1 = new Line(10, 10, this.getWidth() - 10, this.getHeight() - 10);
				line1.endXProperty().bind(this.widthProperty().subtract(10));
				line1.endYProperty().bind(this.heightProperty().subtract(10));
				
				Line line2 = new Line(10, this.getHeight() - 10, this.getWidth() - 10, 10);
				line2.startYProperty().bind(this.heightProperty().subtract(10));
				line2.startXProperty().bind(this.widthProperty().subtract(10));
				
				this.getChildren().addAll(line1, line2);
			}
			
			else if(token == 'O') {
				Ellipse ellipse = new Ellipse(this.getWidth() / 2, this.getHeight() / 2, this.getWidth() / 2 - 10, this.getHeight() / 2 - 10);
				ellipse.centerXProperty().bind(this.widthProperty().divide(2));
				ellipse.centerYProperty().bind(this.heightProperty().divide(2));
				ellipse.radiusXProperty().bind(this.widthProperty().divide(2).subtract(10));
				ellipse.radiusYProperty().bind(this.heightProperty().divide(2).subtract(10));
				ellipse.setStroke(Color.BLACK);
				ellipse.setFill(Color.WHITE);
				
				getChildren().add(ellipse);
			}
		}
		
		private void handleMouseClick() {
			if(token == ' ' && whoseTurn != ' ') {
				setToken(whoseTurn);
				
				if(isWon(whoseTurn)) {
					lblStatus.setText(whoseTurn + " won the round.\n\nGame Over!!");
					whoseTurn = ' ';
				}
				
				else if(isFull()) {
					lblStatus.setText("Draw! The game is over");
					whoseTurn = ' ';
				}
				
				else {
					whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
					// Display whose turn
					lblStatus.setText(whoseTurn + "'s turn");
				}
			}
			
			btnReset.setOnMouseClicked(e->{
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						if(cell[i][j].getToken()== token)
							cell[i][j].setToken(' ');
//							setToken(' 'a);
					}
				}
			});
		}
	}
}
