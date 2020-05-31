package UIControlsAndMultimedia;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
 * ***16.29 (Display a calendar) Write a program that displays the calendar for the current
month. You can use the Prior and Next buttons to show the calendar of the
previous or next month. Display the dates in the current month in black and
display the dates in the previous month and next month in gray, as shown in
Figure 16.48.
 */

public class Exercise16_29_Calendar extends Application {
	Calendar calendar = new GregorianCalendar();
	Date date = new Date();
	Button btnNext, btnPrior;	
	BorderPane border = new BorderPane();
	Text days = new Text("Sunday	Monday	Tuesday	Wednesday	Thursday	Friday	Saturday");
	Text thisMonth = new Text();
	Map<Integer, String> mapMonth = new HashMap<Integer, String>();
	int n = date.getMonth()+1;
	int month = Calendar.MONTH + 1, year = calendar.get(Calendar.YEAR);
	Label lblDays = new Label();

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		btnNext = new Button("Next");
		btnPrior = new Button("Prior");
		
		mapMonth.put(1, "January");
		mapMonth.put(2, "February");
		mapMonth.put(3, "March");
		mapMonth.put(4, "April");
		mapMonth.put(5, "May");
		mapMonth.put(6, "June");
		mapMonth.put(7, "July");
		mapMonth.put(8, "August");
		mapMonth.put(9, "September");
		mapMonth.put(10, "October");
		mapMonth.put(11, "November");
		mapMonth.put(12, "December");
		
		thisMonth.setText(mapMonth.get(month) + ", " + year);
		
		VBox vBox = new VBox(10, thisMonth, days);
		vBox.setAlignment(Pos.CENTER);
		
		HBox hBox = new HBox(10, btnPrior, btnNext);
		hBox.setAlignment(Pos.CENTER);
		
		
		DesignCalendar design = new DesignCalendar(); //create DesignCalendar object
		
		btnNext.setOnAction(e->{
			n++;
			design.printMonth(year, month);
			if(n>12) {
				year++;
				n = 1;
				mapMonth.get(n);
			}
			vBox.getChildren().clear();
			thisMonth.setText(mapMonth.get(n) + ", " + year);
			vBox.getChildren().addAll(thisMonth, days);
		});
		
		
		btnPrior.setOnAction(e->{
			n--;
			design.printMonth(year, month);
			if(n<0) {
				year--;
				n = 12;
				mapMonth.get(n);
			}
			vBox.getChildren().clear();
			thisMonth.setText(mapMonth.get(n) + ", " + year);
			vBox.getChildren().addAll(thisMonth, days);
		});
		
		border.setCenter(lblDays);
		border.setBottom(hBox);
		border.setTop(vBox);
		border.setPadding(new Insets(15));
		
		Scene scene = new Scene(border, 600, 500);
		stage.setScene(scene);
		stage.show();
	}
	
	class DesignCalendar {
		DesignCalendar(){
			printMonth(year, month);
		}
		
		public void printMonth(int year, int month) {
			printMonthTitle(year, month);
			
			printMonthBody(year, month);
		}
		
		public void printMonthTitle(int year, int month) {
			month = n;
			System.out.println(" " + getMonthName(month) + " " + year);
			System.out.println("−−−−−−−−−−−−−−−−−−−−−−−−−−−−−");
			System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		}

		public String getMonthName(int month) {
			String monthname = "";
			switch(month){ //TO GIVE MONTH NAME
			case 1: monthname = "Janauary"; break;
			case 2: monthname = "February"; break;
			case 3: monthname = "March"; break;
			case 4: monthname = "April"; break;
			case 5: monthname = "May"; break;
			case 6: monthname = "June"; break;
			case 7: monthname = "July"; break;
			case 8: monthname = "August"; break;
			case 9: monthname = "September"; break;
			case 10: monthname = "October"; break;
			case 11: monthname = "November"; break;
			case 12: monthname = "December"; break;
			}
			return monthname;
			
		}
		
		
		
		public void printMonthBody(int year, int month) {
			// Get start day of the week for the first date in the month
			int startDay = getStartDay(year, month);
			
			 // Get number of days in the month
			int numberOfDaysInMonth = getAllDaysInMonth(year, month);
			
			// Pad space before the first day of the month
			int i = 0;
			for (i = 0; i < startDay; i++)
				System.out.print(" ");
			
			for (i = 1; i <= numberOfDaysInMonth; i++) {
				System.out.printf("%4d", i);
				if ((i + startDay) % 7 == 0)
					System.out.println();
				}
			
			System.out.println();
			}
		
		public int getStartDay(int year, int month) {
			final int START_DAY_FOR_JAN_1_1800 = 3; //first day of Jan 1, 1800 falls on Wednesday
			int totalNoOfDays = getTotalDaysFrom1800(year, month);
			return (totalNoOfDays + START_DAY_FOR_JAN_1_1800) % 7;
		}
		
		public int getTotalDaysFrom1800(int year, int month) {
			int total = 0;
			
			for(int i=1800; i<year; i++) {
				if(isLeapYear(i))
					total = total + 366;
				else total = total + 365;
			}
			
			for (int i = 1; i < month; i++)
				total = total + getAllDaysInMonth(year, i);
			return total;
		}
		
		public int getAllDaysInMonth(int year, int month) {
			if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
				return 31;
			else if(month == 4 || month == 6 || month == 9 || month == 11)
				return 30;
			else {
				month = isLeapYear(year) ? 29 :  28;
			}
			return -1;
		}
	
		boolean isLeapYear(int year) { //Check leap year
			return year%400 == 0 || (year%100 != 0 && year%4==0);
		}
	
	}

}
