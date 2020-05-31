package UIControlsAndMultimedia;

import java.util.*;

import javafx.application.Application;
import javafx.stage.Stage;

/*
 * **16.30 (Pattern recognition: consecutive four equal numbers) Write a GUI program for
Programming Exercise 8.19, as shown in Figure 16.49a–b. Let the user enter the
numbers in the text fields in a grid of 6 rows and 7 columns. The user can click
the Solve button to highlight a sequence of four equal numbers, if it exists. Initially,
the values in the text fields are filled with numbers from 0 to 9 randomly.
 */

public class Exercise16_30_PatternRecognition extends Application {
	static Scanner scan = new Scanner(System.in);
	static int row, col;

	public static void main(String[] args) {
//		Application.launch(args);
		System.out.print("Enter row: ");
		row = scan.nextInt();
		System.out.print("Enter col: ");
		col = scan.nextInt();
		int[][] matrix = new int[row][col];
		isConsecutiveFour(matrix);
	}

	@Override
	public void start(Stage stage) throws Exception {
//		isConsecutiveFour(values)
	}
	
	public static boolean isConsecutiveFour(int [][] values) {
		
		for(int i=0; i<values.length; i++) {
			for(int j=0; j<values[i].length; j++) {
				values[i][j] = (int) (Math.random()*10);
				System.out.print(values[i][j] + " ");
			}
			System.out.println();
		}
		
		for(int i=0; i<values.length; i++) {
			for(int j=0; j<values[i].length; j++) {
				if(values[i][j] == values[j][i]) {
					System.out.print("Diagonal Matrix");
				}
				
				else System.out.print("Not square Matrix");
			}
		}
		
		return true;
	}

}
