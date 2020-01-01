package projects;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class MeterSuitability extends Application {
	
	//object declarations
	double current;
	Alert alert;
	GridPane grid = new GridPane();//grid pane
	Label lblKW = new Label("KW Value: "); //Label for KW
	Label lblHP = new Label("HP Value: "), lblRequestedMeter = new Label("Reqstd Meter: "), lblDiversityFactor = new Label("Div.Factor: *");
	Label lblCurrent = new Label("Peak Load: "), lblVoltage = new Label("Voltage: *"), lblOldMeterDetails = new Label("Old Meter Details");
	Label lblMaxLoad = new Label("0"), lblOldMeter = new Label("Type&Rating: "), lblOldMeterNo = new Label("OldMeterNo: "), lblOldMeterStatus = new Label("Status: ");
	Label lblRemark = new Label("Remark: "), lblPeakLoad = new Label("Peak Load: "), lblOldtariff = new Label("Tariff in Use: ");
	Label lblName = new Label("Name: *"), lblAddress = new Label("Address: *"), lblPhone = new Label("Phone: *"), lblServiceHub = new Label("Service Hub: *");
	Label lblBusiness = new Label("Business: *"), lblTransformer = new Label("Transformer: *"), lblFeeder = new Label("Feeder: *");
	Label lblCoordinates = new Label("Coordinates: *"), lblNewTariff = new Label("Rec. Tariff: "), lblRecommendedMeter = new Label("Rec. Meter: ");
	Label lblDetails = new Label("CUSTOMER DETAILS"), lblAcctNo = new Label("Account No: "), lblEmail = new Label("Email: "), lblBhub = new Label("B Hub: *");
	
	public static TextField txtPower = new TextField("0");//Label for total power
	public static TextField txtMaxCurrent = new TextField("0"), txtBhub = new TextField(), txtServiceHub = new TextField(), txtRemark = new TextField();
	public static TextField txtKW = new TextField("0");
	public static TextField txtHP = new TextField("0"), txtUpdatePower = new TextField("0");
	public static TextField txtName = new TextField(""), txtRecommendedTariff = new TextField(), txtRecommendedMeter = new TextField();
	public static TextField txtAddress = new TextField(""), txtRequestedMeter = new TextField();
	public static TextField txtPhone = new TextField(""), txtTariffInUse = new TextField();
	public static TextField txtAcctNo = new TextField(""), txtOldMeter = new TextField(""), txtOldMeterNo = new TextField(), txtOldMeterStatus = new TextField();
	public static TextField txtEmail = new TextField(), txtPeakLoad = new TextField(), txtDiversityFactor = new TextField();
	public static TextField  txtBusiness = new TextField(""), txtTransformer = new TextField(""), txtFeeder = new TextField(""), txtCoordinates = new TextField("");
	
	TextArea txtaRecommend = new TextArea();
	
	Button btnAdd = new Button("Add");//Button for adding KW and HP into arraylist power 
	Button btnReset = new Button("Reset");
	Button btnSave = new Button("Save");
	Button btnExit = new Button("Exit");
	Button btnAnalyz = new Button("Analysis");//Button for calculating total power, current rating and tariff
	
	static String[] customerClassList = {"Residential", "Commercial", "Industrial", "Special", "Street Light"};
	static ComboBox<String> customerClass = new ComboBox<String>(FXCollections.observableArrayList(customerClassList));
	
	String[] customerTypeList = {"MD", "NMD"};
	ComboBox<String> customerType = new ComboBox<String>(FXCollections.observableArrayList(customerTypeList));
	
	Integer[] supplyVoltage = {240, 415, 11000, 33000}; //Supply Voltage
	ComboBox<Integer> cmbVoltage = new ComboBox<Integer>(FXCollections.observableArrayList(supplyVoltage));
	
//	String[] supplyVoltage = {"240", "415", "11000", "33000"}; //Supply Voltage
//	ComboBox<String> cmbVoltage = new ComboBox<String>(FXCollections.observableArrayList(supplyVoltage));
	
	Map<String, String> mapTariffCost = new HashMap<String, String>(); //Map for mapping current rating/KVA value to tariff
	static Map<String, String> mapTariffCode = new HashMap<String, String>(); 
	
	double subtotalKW /* Addition of KW and HP */, totalPower=0 /*Total of all KW and HP*/;
	
	ArrayList<Double> arrayPower = new ArrayList<>();
	
	//main class
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		//populate tariff code
		mapTariffCode.put("Residential1", "R1");
		mapTariffCode.put("Residential2", "R2");
		mapTariffCode.put("Residential3", "R3");
		mapTariffCode.put("Residential4", "R4");
		mapTariffCode.put("Commercial1", "C1");
		mapTariffCode.put("Commercial2", "C2");
		mapTariffCode.put("Commercial3", "C3");
		mapTariffCode.put("Industrial1", "D1");
		mapTariffCode.put("Industrial2", "D2");
		mapTariffCode.put("Industrial3", "D3");
		mapTariffCode.put("Special1", "A1");
		mapTariffCode.put("Special2", "A2");
		mapTariffCode.put("Special3", "A3");
		mapTariffCode.put("Street Light", "S1");
		
		//populate tariff cost
		mapTariffCost.put("R1", "N4.00");
		mapTariffCost.put("R2", "N24.97");
		mapTariffCost.put("R3", "N44.66");
		mapTariffCost.put("R4", "N44.66");
		mapTariffCost.put("C1", "N29.91");
		mapTariffCost.put("C2", "N42.03");
		mapTariffCost.put("C3", "N42.03");
		mapTariffCost.put("D1", "N33.70");
		mapTariffCost.put("D2", "N45.40");
		mapTariffCost.put("D3", "N45.40");
		mapTariffCost.put("A1", "N32.26");
		mapTariffCost.put("A2", "N32.26");
		mapTariffCost.put("A3", "N32.26");
		mapTariffCost.put("S1", "N24.93");
		
		//SETTING NODES PROPERTIES
		grid.setPadding(new Insets(20));
		
		lblDetails.setStyle("-fx-font-weight: bold");
		lblOldMeterDetails.setStyle("-fx-font-weight: bold");
		lblDiversityFactor.alignmentProperty().set(Pos.CENTER_RIGHT);
		
		//Textfields Property
		txtKW.alignmentProperty().set(Pos.CENTER_RIGHT);
		txtHP.alignmentProperty().set(Pos.CENTER_RIGHT);
		txtKW.setMaxWidth(70);
		txtHP.setMaxWidth(70);
		txtPower.setMaxWidth(90);
		txtPower.alignmentProperty().set(Pos.CENTER_LEFT);
		txtDiversityFactor.setMaxWidth(60);
		txtDiversityFactor.setText("0.60");
		txtMaxCurrent.setMaxWidth(120);
		txtMaxCurrent.setEditable(false);
		txtMaxCurrent.alignmentProperty().set(Pos.CENTER_LEFT);
		txtaRecommend.setStyle("-fx-background-color: #00e08b");
		txtaRecommend.setEditable(false);
		txtaRecommend.setWrapText(true);
		txtUpdatePower.setMaxWidth(110);
		txtUpdatePower.setStyle("-fx-background-color: #00e08b; -fx-text-inner-color: blue");
		txtUpdatePower.setEditable(false);
		txtPower.setEditable(false);
		txtEmail.setPromptText("name@domain.com");
		txtAcctNo.setPromptText("13/12/21/0000-01");
		txtTransformer.setPromptText("Sumo, 2MVA, Dedicated or Public");
		txtCoordinates.setPromptText("6.21345, 3.12432");
		txtFeeder.setPromptText("Estate, 33KV");
		txtaRecommend.setPromptText("Recommended meter rating");
		txtOldMeter.setPromptText("200/5A, Postpaid");
		txtRequestedMeter.setPromptText("300/5A PPM");
		txtRecommendedMeter.setPromptText("500/5A Postpaid");
		txtPeakLoad.setEditable(false);

		Tooltip tip = new Tooltip("e.g Sumo 2MVA (Dedicated) or (Public)");
		txtTransformer.setTooltip(tip);
		
		//Formatting TextFields
		
		//Buttons
		btnAnalyz.setCursor(Cursor.HAND);
		btnAnalyz.setStyle("-fx-background-color: #00008b");
		btnAnalyz.setTextFill(Color.ORANGE);
		btnAdd.setCursor(Cursor.HAND);
		
		//Combo List
		customerClass.setEditable(false);
		customerClass.setMaxWidth(140);
		customerType.setEditable(false);
		
		//populate grid pane
		grid.setVgap(10);
		grid.setHgap(5);
		grid.add(lblKW, 0, 0); grid.add(txtKW, 1, 0);
		grid.add(lblHP, 2, 0); grid.add(txtHP, 3, 0);
		grid.add(btnAdd, 0, 2); grid.add(txtUpdatePower, 1, 2);
		grid.add(lblVoltage, 2, 2); grid.add(cmbVoltage, 3, 2);
		grid.add(new Label("Cust Type: "), 0, 3); grid.add(customerType, 1, 3);
		grid.add(new Label("Cust Class: *"), 2, 3); grid.add(customerClass, 3, 3);
		grid.add(btnAnalyz, 0, 5, 2, 1); 
		grid.add(lblDiversityFactor, 2, 5); grid.add(txtDiversityFactor, 3, 5);
		grid.add(new Label("Power (KVA): "), 0, 6);	grid.add(txtPower, 1, 6);
		grid.add(txtMaxCurrent, 3, 6); grid.add(lblCurrent, 2, 6);
		grid.add(txtaRecommend, 0, 8, 4 ,2); grid.add(new Line(20, 390, 550, 390), 0, 10, 6, 1); 
		grid.add(lblDetails, 1, 11, 2, 1);
		
		//Customer Details
		grid.add(lblName, 0, 13); grid.add(txtName, 1, 13, 1, 1);
		grid.add(lblAddress, 2, 13); grid.add(txtAddress, 3, 13);
		grid.add(lblAcctNo, 0, 14); grid.add(txtAcctNo, 1, 14);
		grid.add(lblPhone, 2, 14); grid.add(txtPhone, 3, 14);
		grid.add(lblEmail, 0, 15); grid.add(txtEmail, 1, 15);
		grid.add(lblBhub, 2, 15); grid.add(txtBhub, 3, 15);
		grid.add(lblServiceHub, 0, 16); grid.add(txtServiceHub, 1, 16);
		grid.add(lblFeeder, 2, 16); grid.add(txtFeeder, 3, 16);
		grid.add(lblTransformer, 0, 17); grid.add(txtTransformer, 1, 17);
		grid.add(lblCoordinates, 2, 17); grid.add(txtCoordinates, 3, 17);
		grid.add(lblOldMeter, 0, 18); grid.add(txtOldMeter, 1, 18);
		grid.add(lblOldMeterNo, 2, 18); grid.add(txtOldMeterNo, 3, 18);
		grid.add(lblOldMeterStatus, 0, 19); grid.add(txtOldMeterStatus, 1, 19);
		grid.add(lblPeakLoad, 2, 19); grid.add(txtPeakLoad, 3, 19);
		grid.add(lblBusiness, 0, 20); grid.add(txtBusiness, 1, 20);
		grid.add(lblRequestedMeter, 2, 20); grid.add(txtRequestedMeter, 3, 20);
		grid.add(lblOldtariff, 0, 21); grid.add(txtTariffInUse, 1, 21);
		grid.add(lblNewTariff, 2, 21); grid.add(txtRecommendedTariff, 3, 21);
		grid.add(lblRecommendedMeter, 0, 22); grid.add(txtRecommendedMeter, 1, 22);
		
		grid.add(lblRemark, 0, 23); grid.add(txtRemark, 1, 23, 3,2);
		//OLD METER DETAILS
//		grid.add(new Line(20, 300, 300, 300), 0, 21, 2,1);
//		grid.add(lblOldMeterDetails, 0, 22);
		
		grid.add(btnSave, 0, 26);
		grid.add(btnReset, 2, 26);
		grid.add(btnExit, 4, 26);
		
		//set events
		btnAdd.setOnMouseClicked(e->{
//			if(getKVA()>38 && cmbVoltage.getValue()<415) {
//				cantLessThan415();
//			}
//			else {
				addPowerKW();
				txtUpdatePower.setText(String.format("%.2f", getPower()) + " KW");
//			}
		});
		
		btnAnalyz.setOnMouseClicked(e->{ //CALCULATE KVA AND CURRENT RATED
			if(getKVA()>5 && cmbVoltage.getValue() == 0) {
				Alert alert = new Alert(AlertType.ERROR, "Please choose supply voltage > 0 from the drop down list.");
				alert.setHeaderText(null);
				alert.showAndWait();
			}
			
			else if(getKVA()>5 && customerClass.getValue() == "Select") {
				Alert alert = new Alert(AlertType.ERROR, "Please choose customer class from the drop down list.");
				alert.setHeaderText(null);
				alert.showAndWait();
			}
			
			else if(getKVA()>5 && (getDiversityFactor()<=0 || getDiversityFactor()>1.0) && txtDiversityFactor.getText().isEmpty()) {
				Alert alert = new Alert(AlertType.ERROR, "Please enter a value for diversity factor > 0.0 but <= 1.0.");
				alert.setHeaderText(null);
				alert.showAndWait();
			}
			
			else { //String.format("%.2f", getKVA())
				getPower();
				switch(cmbVoltage.getValue()) {
				case 11000: txtMaxCurrent.setText(String.format("%.2f", getCurrent()) + " (HT 11KV)"); break;
//					txtMaxCurrent.prefWidth(txtMaxCurrent.getText().length()); break;
//					txtMaxCurrent.prefColumnCountProperty().bind(txtMaxCurrent.textProperty().length()); break;
				case 33000: txtMaxCurrent.setText(String.format("%.2f", getCurrent()) + " (HT 33KV)"); break;
//					txtMaxCurrent.prefWidth(txtMaxCurrent.getText().length()); break;
//					txtMaxCurrent.prefColumnCountProperty().bind(txtMaxCurrent.textProperty().length()); break;
				default: txtMaxCurrent.setText(String.format("%.2f", getCurrent()) + "A (LT)"); break;
				}
		
				recommendMeter();
				txtaRecommend.setStyle("-fx-control-inner-background: #00008b; -fx-text-inner-color: orange; -fx-font-weight: bold");
				txtPeakLoad.setText(String.format("%.0f", getCurrent()) + "A");
			}
		});
		
		btnSave.setOnMouseClicked(e->{ //BuTTON TO SAVE PROFILE
			if(txtName.getText().isEmpty()) {
				alert = new Alert(AlertType.ERROR, "Customer name cannot be empty!");
				alert.setHeaderText(null);
				alert.showAndWait();
			}
			
			else if(txtAddress.getText().isEmpty()) {
				alert = new Alert(AlertType.ERROR, "Customer address cannot be empty!");
				alert.setHeaderText(null);
				alert.showAndWait();
			}
			
			else if(!(txtPhone.getText().matches("\\d{8}|\\d{11}")) && txtPhone.getText().isEmpty()){ //txtPhone.getText().matches("/^[0-9]{11}")
				alert = new Alert(AlertType.ERROR, "Please enter a valid phone number");
				alert.setHeaderText(null);
				alert.showAndWait();
			}
			
			else if(!(txtEmail.getText().matches("^[a-zA-Z0-9_^.-]+@+[a-zA-Z0-9.-]+$") || txtEmail.getText().isEmpty())){
				alert = new Alert(AlertType.ERROR, "Please enter a valid e-mail address!");
				alert.setHeaderText(null);
				alert.showAndWait();
			}
			 
			else if(txtBhub.getText().isEmpty()) {
				alert = new Alert(AlertType.ERROR, "Business Hub cannot be empty!");
				alert.setHeaderText(null);
				alert.showAndWait();
			}
			
			else if(txtServiceHub.getText().isEmpty()) {
				alert = new Alert(AlertType.ERROR, "Service Hub cannot be empty!");
				alert.setHeaderText(null);
				alert.showAndWait();
			}
			
			else if(txtFeeder.getText().isEmpty()) {
				alert = new Alert(AlertType.ERROR, "Feeder Name cannot be empty!");
				alert.setHeaderText(null);
				alert.showAndWait();
			}
			
			else if(txtTransformer.getText().isEmpty()) {
				alert = new Alert(AlertType.ERROR, "Transformer Name cannot be empty!");
				alert.setHeaderText(null);
				alert.showAndWait();
			}
			
			else if(txtCoordinates.getText().isEmpty()) {
				alert = new Alert(AlertType.ERROR, "Coordinates cannot be empty!");
				alert.setHeaderText(null);
				alert.showAndWait();
			}
			
			else {
				try {
					new saveProfile().createFolder();
				} catch (IOException e1) {
					alert = new Alert(AlertType.ERROR, "FOLDER COULD NOT BE CREATED FOR SOME REASON\nKINDLY CONTACT 08099621343!"); //UNKOWN ERROR CREATING FOLDER
					alert.setHeaderText(null);
					alert.showAndWait();
				}
			}
		});
		
		btnReset.setOnMouseClicked(e->{ //clear ALL fields
			txtMaxCurrent.clear();
			txtPower.clear();
			arrayPower.clear();
			totalPower = 0;
			txtKW.setText("0");
			txtHP.setText("0");
			cmbVoltage.setValue(0);
			customerClass.setValue("Select");
			customerType.setValue("Select");
			txtUpdatePower.setText("0");
			txtaRecommend.setText("");
			txtName.clear(); txtEmail.clear();
			txtAddress.clear(); txtBhub.clear();
			txtServiceHub.clear(); txtPhone.clear();
			txtAcctNo.clear(); txtBusiness.clear();
			txtCoordinates.clear(); txtTransformer.clear();
			txtFeeder.clear(); txtRemark.clear();
			txtPeakLoad.clear(); txtOldMeterStatus.clear();
			txtOldMeterNo.clear(); txtOldMeter.clear();
			txtTariffInUse.clear();
			txtaRecommend.setStyle("-fx-control-inner-background: #ffffff; -fx-text-inner-color: black;");
			txtaRecommend.setPromptText("Recommended meter rating");
			txtOldMeter.setPromptText("200/5A Postpaid");
			txtRequestedMeter.setPromptText("300/5A PPM");
			txtRecommendedMeter.setPromptText("500/5A Postpaid");
			
		});
		
		btnExit.setOnMouseClicked(e->{ //close window
			ButtonType btntpYes = new ButtonType("Yes", ButtonData.OK_DONE);
			ButtonType btntpNo = new ButtonType("No", ButtonData.CANCEL_CLOSE);
			alert = new Alert(AlertType.CONFIRMATION, "Do you want to close application?", btntpYes, btntpNo);
			alert.setHeaderText(null);
			alert.setTitle("WARNING!!!");
			Optional<ButtonType> choose = alert.showAndWait();
			if(choose.get() == btntpYes) {
				stage.close();
			}
		});
		
		customerClass.setValue("Select");
		customerType.setValue("Select");
		cmbVoltage.setValue(0);
		
//		STAGE PREPARATION FOR DISPLAY 
		Scene scene = new Scene(grid, 700, 920);
		stage.resizableProperty().setValue(false);
		stage.setTitle("Meter Suitability"); // Set the stage title
		stage.getIcons().add(new Image("file:///C:/Users/Honeeks Inc/Documents/jaworks/IBEDC1.jpg"));
		stage.setScene(scene); // Place the scene in the stage
		stage.show(); //
	}
	
	double getDiversityFactor() {
		return Double.parseDouble(txtDiversityFactor.getText());
	}
	
	double getKVA() {
		double pf=.8, KVA;
		return KVA = totalPower/pf;
	}

	protected double getCurrent() {
		
		if(getKVA() < 5){
			return current = getKVA()*getDiversityFactor()/(.24);
		}
		if(getKVA()<50 && cmbVoltage.getValue() == 240) {
			return current = getKVA() * getDiversityFactor()/.240;
		}
		else if(getKVA()<50 && cmbVoltage.getValue() == 415) {
			return current = getKVA() * getDiversityFactor()/(.415*1.7321);
		}
		else if(getKVA()<500 && cmbVoltage.getValue() == 415) {
			return current = getKVA() * getDiversityFactor()/(.415*1.7321);
		}
		else if(getKVA()==500 && cmbVoltage.getValue() == 415) {
			return current = getKVA() /(.415*1.7321);
		}
		else if(getKVA()>500 && cmbVoltage.getValue() == 11000){
			return current = getKVA()/(11 * Math.sqrt(3));
		}
		else if(getKVA()>500 && cmbVoltage.getValue() == 11000){
			return current = getKVA()/(11 * Math.sqrt(3));
		}
		else {
			return current = getKVA()/(33 * Math.sqrt(3));
		}
	}
	
	void cantLessThan415() {
		Alert alert = new Alert(AlertType.ERROR, "Supply votage cannot be less than 415 at " + String.format("%.2f", getKVA()) + " KVA.");
		alert.setHeaderText(null);
		alert.showAndWait();
	}
	
	//get total rated power in KW
	private double getPower() { 
		for(int i=0; i<arrayPower.size(); i++) {
			totalPower += arrayPower.get(i);
//			lblUpdatePower.setText(String.format("%.2f", totalPower) + " KW");
		}
		
		txtPower.setText(String.format("%.1f", getKVA()));
		arrayPower.clear();
		return totalPower;
	}

	//Subtotal of power in KW
	private void addPowerKW() { 
		subtotalKW = Double.parseDouble(txtKW.getText()) + Double.parseDouble(txtHP.getText())*0.746;
		arrayPower.add(subtotalKW);
		txtKW.setText("0");
		txtHP.setText("0");
	}
	
	public void recommendMeter() {
		if(getKVA()<5) {
			customerType.setValue("NMD");
			customerClass.setValue("Residential");
			cmbVoltage.setValue(240);
			txtaRecommend.setText(" Single phase meter recommended.\r\n Tariff Code: " + mapTariffCode.get("Residential1") + 
					"\n Unit Cost is: " + mapTariffCost.get(mapTariffCode.get("Residential1")));
		}
			
		else if(getKVA()<50 && cmbVoltage.getValue() == 240) {
			customerType.setValue("NMD");
			switch(customerClass.getValue()) {
			case "Residential": recommendSinglePhase("Residential2"); break;
			case "Commercial": recommendSinglePhase("Commercial1"); break;
			case "Industrial": recommendSinglePhase("Industrial1"); break;
			case "Special": recommendSinglePhase("Special1"); break;
			case "Street Light": recommendSinglePhase("Street Light"); break;
			}
		}
		
		else if(getKVA()<50 && cmbVoltage.getValue() == 415) {
			customerType.setValue("NMD");
				switch(customerClass.getValue()) {
				case "Residential": recommend3phase("Residential2"); break;
				case "Commercial": recommend3phase("Commercial1"); break;
				case "Industrial": recommend3phase("Industrial1"); break;
				case "Special": recommend3phase("Special1"); break;
				case "Street Light": recommend3phase("Street Light"); break;
			}
		}
		
		else if(getKVA()<=500) {
			customerType.setValue("MD");
			if(getKVA()>=50 && cmbVoltage.getValue()<415) {
				cantLessThan415();
			}
			else if(getCurrent()<80) {
					switch(customerClass.getValue()) {
					case "Residential": recommendWC("Residential3"); break;
					case "Commercial": recommendWC("Commercial2"); break;
					case "Industrial": recommendWC("Industrial2"); break;
					case "Special": recommendWC("Special2"); break;
					}
				}
			
			else if(getCurrent()<100) {
				customerType.setValue("MD");
				switch(customerClass.getValue()) {
				case "Residential": recommend100by5("Residential3"); break;
				case "Commercial": recommend100by5("Commercial2"); break;
				case "Industrial": recommend100by5("Industrial2"); break;
				case "Special": recommend100by5("Special2"); break;
				}
			}
			
			else if(getCurrent()<200) {
				customerType.setValue("MD");
				switch(customerClass.getValue()) {
				case "Residential": recommend200by5("Residential3"); break;
				case "Commercial": recommend200by5("Commercial2"); break;
				case "Industrial": recommend200by5("Industrial2"); break;
				case "Special": recommend200by5("Special2"); break;
				}
			}
			
			else if(getCurrent()<300) {
				customerType.setValue("MD");
				switch(customerClass.getValue()) {
				case "Residential": recommend300by5("Residential3"); break;
				case "Commercial": recommend300by5("Commercial2"); break;
				case "Industrial": recommend300by5("Industrial2"); break;
				case "Special": recommend300by5("Special2"); break;
				}
			}
			
			else if(getCurrent()<500) {
				customerType.setValue("MD");
				switch(customerClass.getValue()) {
				case "Residential": recommend500by5("Residential3"); break;
				case "Commercial": recommend500by5("Commercial2"); break;
				case "Industrial": recommend500by5("Industrial2"); break;
				case "Special": recommend500by5("Special2"); break;
				}
			}
			
			else if(getCurrent()<800) {
				customerType.setValue("MD");
				recommend800by5(customerClass.getValue());
				switch(customerClass.getValue()) {
				case "Residential": recommend800by5("Residential3"); break;
				case "Commercial": recommend800by5("Commercial2"); break;
				case "Industrial": recommend800by5("Industrial2"); break;
				case "Special": recommend800by5("Special2"); break;
				}
			}
		}
		
		else {
			customerType.setValue("MD");
			if(cmbVoltage.getValue() == 11000 && customerClass.getValue()=="Residential") {
				recommendHT11KV(rateBy5(), "Residential4");
			}
			
			else if(cmbVoltage.getValue()==33000 && customerClass.getValue()=="Residential") {
				recommendHT11KV(rateBy1(), "Residential4");
			}
			else {
				switch(cmbVoltage.getValue()) {
				case 11000: recommendHT11KV(rateBy5(), customerClass.getValue()+"3"); break;
				case 33000: recommendHT33KV(rateBy1(), customerClass.getValue()+"3"); break;
				default: alert = new Alert(AlertType.CONFIRMATION,"Supply voltage cannot be " + cmbVoltage.getValue() + "V at "+String.format("%.2f", getKVA()) + " KVA.");
				alert.setHeaderText(null);
				alert.setTitle("ERROR!!!");
				alert.showAndWait(); break;
				}
			}
		}
	}
	
	String rateBy1() {
		if(getKVA()>500 && getCurrent()<20) {return "25/1A"; }
		else if(getKVA()>500 && getCurrent()<30) { return "30/1A"; }
		else if(getKVA()>500 && getCurrent()<50) { return "50/1A"; }
		else if(getKVA()>500 && getCurrent()<100) { return "100/1A"; }
		else if(getKVA()>500 && getCurrent()<150) { return "150/1A"; }
		else if(getKVA()>500 && getCurrent()<200) { return "200/1A"; }
		else if(getKVA()>500 && getCurrent()<400) { return "400/1A"; }
		else if(getKVA()>500 && getCurrent()<600) { return "600/1A"; }
		else return "Grid";
		}
	
	String rateBy5() {
		if(getKVA()>500 && getCurrent()<25) { return "25/5A"; }
		else if(getKVA()>500 && getCurrent()<50) { return "50/5A"; }
		else if(getKVA()>500 && getCurrent()<100) { return "100/5A"; }
		else if(getKVA()>500 && getCurrent()<200) { return "200/5A"; }
		else if(getKVA()>500 && getCurrent()<400) { return "300/5A"; }
		else if(getKVA()>500 && getCurrent()<400) { return "400/5A"; }
		else if(getKVA()>500 && getCurrent()<500) { return "500/5A"; }
		else if(getKVA()>500 && getCurrent()<800) { return "800/5A"; }
		else return "Grid"; 
		}
	
	void recommendSinglePhase(String customerClass) {
		txtaRecommend.setText(" A Single Phase meter recommended.\n Tariff Code: " + mapTariffCode.get(customerClass) + 
				"\n Unit Cost: " + mapTariffCost.get(mapTariffCode.get(customerClass))+
				"\n\n Rated current may not be accurate.");
	}
	
	void recommend3phase(String customerClass) {
		txtaRecommend.setText(" A Three Phase meter recommended.\n Tariff Code: " + mapTariffCode.get(customerClass) + 
				"\n Unit Cost: " + mapTariffCost.get(mapTariffCode.get(customerClass)));
	}
	
	void recommendWC(String customerClass) {
		txtaRecommend.setText(" A Whole Current meter recommended.\n Tariff Code: " + mapTariffCode.get(customerClass) + 
				"\n Unit Cost: " + mapTariffCost.get(mapTariffCode.get(customerClass)));
	}
	
	void recommend100by5(String customerClass) {
		txtaRecommend.setText(" A 100/5A LV MD meter recommended.\n Tariff Code: " + mapTariffCode.get(customerClass) + 
				"\n Unit Cost: " + mapTariffCost.get(mapTariffCode.get(customerClass)));
	}
	
	void recommend200by5(String customerClass) {
		txtaRecommend.setText(" A 200/5A LV MD meter recommended.\n Tariff Code: " + mapTariffCode.get(customerClass) + 
				"\n Unit Cost: " + mapTariffCost.get(mapTariffCode.get(customerClass)));
	}
	
	void recommend300by5(String customerClass) {
		txtaRecommend.setText(" A 300/5A LV MD meter recommended.\n Tariff Code: " + mapTariffCode.get(customerClass) + 
				"\n Unit Cost: " + mapTariffCost.get(mapTariffCode.get(customerClass)));
	}
	
	void recommend500by5(String customerClass) {
		txtaRecommend.setText(" A 500/5A LV MD meter recommended.\n Tariff Code: " + mapTariffCode.get(customerClass) + 
				"\n Unit Cost: " + mapTariffCost.get(mapTariffCode.get(customerClass)));
	}
	
	void recommend800by5(String customerClass) {
		txtaRecommend.setText("An 800/5A LV MD meter recommended.\n Tariff Code: " + mapTariffCode.get(customerClass) + 
				"\n Unit Cost: " + mapTariffCost.get(mapTariffCode.get(customerClass)));
	}
	
	void recommendHT11KV(String rate, String customerClass) {
		txtaRecommend.setText(" A " + rate + " HT(11KV) MD meter recommended.\n Tariff Code: " + mapTariffCode.get(customerClass) + 
				"\n Unit Cost: " + mapTariffCost.get(mapTariffCode.get(customerClass)));
	}
	
	void recommendHT33KV(String rate, String customerClass) {
		txtaRecommend.setText(" A " + rate+ " HT(33KV) MD meter recommended.\n Tariff Code: " + mapTariffCode.get(customerClass) + 
				"\n Unit Cost: " + mapTariffCost.get(mapTariffCode.get(customerClass)));
	}
	
	void recommendGrid132KV(String rate, String customerClass) {
		txtaRecommend.setText(" A " + rate + " HT(132KV) MD meter recommended.\n Tariff Code: " + mapTariffCode.get(customerClass) + 
				"\n Unit Cost: " + mapTariffCost.get(mapTariffCode.get(customerClass)));
	}
}

//CLASS FOR SAVING CUSTOMER PROFILE TO EXCEL SHEET
class saveProfile{
	MeterSuitability meter = new MeterSuitability() ;
	int n = 1;
	Alert alert;
	String filename = MeterSuitability.txtName.getText().toUpperCase() + " Suitability Report", folderName = "Meter Suitability", path;
	File folder  = new File(path = System.getProperty("user.home") + File.separator + "Documents" + File.separator + folderName);
	File report = new File(path + File.separator + filename);
	
	public saveProfile() {}
	
	void createFolder() throws IOException {
		if(!folder.exists()) {
			folder.mkdirs();
		}
		
		else createReport();
	}
	
	public void createReport() throws IOException { //SAVING REPORT
		if(report.exists()) {
			ButtonType btntpReplace = new ButtonType("Replace", ButtonData.OK_DONE);
			ButtonType btntpCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
			alert = new Alert(AlertType.CONFIRMATION, filename + " already exists.\nDo you want to replace?", btntpReplace, btntpCancel);
			alert.setHeaderText(null);
			alert.setTitle("WARNING!!!");
			
			Optional<ButtonType> choose = alert.showAndWait();
			if(choose.get() == btntpReplace) {
				report.delete();
//				report.createNewFile();
				try {
					new SaveToExcelx().export();
				} catch (Exception e) {
					e.printStackTrace();
				}
				alert = new Alert(AlertType.INFORMATION, filename+" successfully replaced.\n\nLocation: " + folder.getAbsolutePath());
				alert.setHeaderText(null);
				alert.showAndWait();
			}
			
			else {
				alert.close();
			}
		}
		
		else {
			try {
				new SaveToExcelx().export();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(!report.exists()) {
				alert = new Alert(AlertType.INFORMATION, filename+" successfully saved.\n\nLocation: " + report.getAbsolutePath());
//				System.out.println(MeterSuitability.txtName.getText().toUpperCase() + " Suitability Report.xlsx");
				alert.setHeaderText(null);
				alert.setTitle("Success!!");
				alert.showAndWait();
			}
			
//			else {
//				alert = new Alert(AlertType.ERROR, "Error saving " + filename);
//				System.out.println(MeterSuitability.txtName.getText().toUpperCase() + " Suitability Report.xlsx");
//				alert.setHeaderText(null);
//				alert.setTitle("ERROR!!");
//				alert.showAndWait();
//			}
//			System.out.println(MeterSuitability.txtName.getText().toString() + " Report");
		}
		
	}
}

class SaveToExcelx {
	private static String[] headerColumns = {"S/N", "Customer Name", "Customer Address","Account Number", "Phone Number", "E-Mail Address", "Location", "BHub", "SHub",
			"feeder", "DSS", "Present Meter Type&Rating", "Present Meter Number",  "Present Meter Status", "Peak Load (Amp)",  "Nature of Business",
			"Requested Meter Rating/Type", "Tariff in Use", "Recommended Tariff", "Recommended Meter", "Remark"};
	
	public String[] subHeaderColumn = {"B Hub", "Service Hub", "Feeder", "Distribution S/S", "Coordniates"};
	public String[] txtSubHeaderColumnInput = {MeterSuitability.txtBhub.getText(), MeterSuitability.txtServiceHub.getText(), MeterSuitability.txtFeeder.getText(),
			MeterSuitability.txtTransformer.getText(), MeterSuitability.txtCoordinates.getText()};
	
	private static List<CustomerDetails> customer = new ArrayList<CustomerDetails>();
	
	static MeterSuitability meter = new MeterSuitability();
	static String newTariff = meter.mapTariffCode.get(meter.customerClass.getValue());
	
	static Workbook workbook = new HSSFWorkbook();
	static HSSFCellStyle headerCellStyle = (HSSFCellStyle) workbook.createCellStyle();
	Sheet sheet;

	public SaveToExcelx(){}  //CONSTRUCTOR
	
	saveProfile save = new saveProfile();
	
	//create thick borders
	public void createHeaderBorders(BorderStyle style, Workbook wb, Sheet sheet) {
		List<CellRangeAddress> mergedRegions = sheet.getMergedRegions();
		for(CellRangeAddress rangeAddress: mergedRegions) {
			RegionUtil.setBorderBottom(style, rangeAddress, sheet);
			RegionUtil.setBorderRight(style, rangeAddress, sheet);
			RegionUtil.setBorderTop(style, rangeAddress, sheet);
			RegionUtil.setBorderLeft(style, rangeAddress, sheet);
			headerCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		}
	}
	
	//Create thin Borders
	void createThinBorders(Workbook wb) {
		HSSFCellStyle border = (HSSFCellStyle) wb.createCellStyle();
		border.setBorderBottom(BorderStyle.THIN);
		border.setBorderTop(BorderStyle.THIN);
		border.setBorderLeft(BorderStyle.THIN);
		border.setBorderRight(BorderStyle.THIN);
	}
	
	//Accepting entries from user to populate form.
	public void export() throws Exception {
//		
		CustomerDetails details = new CustomerDetails();
		customer.add(details); //add all customer details
		
		Cell cell = null;
		sheet = workbook.createSheet(save.filename.toUpperCase());
		Row headerRow, row1 = sheet.createRow((short) 1), row2 = sheet.createRow((short) 2);
		CellRangeAddress mergeCell; //merge cells
		
//		headerRow.
		for(int j=0; j<6; j++) {
			sheet.addMergedRegion(mergeCell = new CellRangeAddress(0,1,j,j)); //Merged for first 6 columns
			sheet.autoSizeColumn(j);
		}
		
		sheet.addMergedRegion(mergeCell = new CellRangeAddress(0,0,6,10)); //Merged for "Location"
		
		Cell subHeaderCells; 
		for(int j=6; j<11; j++) { //Create CElls for BHUBs, SHUBs, ....
			if(row1 != null) {
				subHeaderCells = row1.createCell(j);
				if(subHeaderCells != null) {
					subHeaderCells = row1.createCell(j);
					subHeaderCells.setCellValue(subHeaderColumn[j-6]);
					Font subHeaderCellFont = workbook.createFont();
					subHeaderCellFont.setBold(true);
//					createThinBorders(workbook);
				}
			}
			
			if(row2 != null) {
				Cell subColCelValue = row2.createCell(j);
				if(subColCelValue == null) {
					subColCelValue.setCellValue(txtSubHeaderColumnInput[j-6]);
				}
			}
			sheet.autoSizeColumn(j); //Auto size column width
		}
		
		for(int j=11; j<headerColumns.length; j++) { //other column elements as headers
			sheet.addMergedRegion(mergeCell = new CellRangeAddress(0,1,j,j));
		}
		
		//CREATE AND SET FONT STYLE
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setFontHeight((short) (11*20));
		
		//create cell style
		HSSFCellStyle headerCellStyle = (HSSFCellStyle) workbook.createCellStyle();
		headerCellStyle.setFont(headerFont);
		
		
		//create row
		headerRow = sheet.createRow(0);
		for(int i=0; i<headerColumns.length; i++) { //creates header cells and sets the column values
			cell = headerRow.createCell(i);
			cell.setCellValue(headerColumns[i]);
			headerCellStyle.setWrapText(true);
			createHeaderBorders(BorderStyle.MEDIUM, workbook, sheet);
			cell.setCellStyle(headerCellStyle);
			sheet.autoSizeColumn(i);
		}
		
		//othera
		int rowNum = 2;
//		Font customerFont = workbook.createFont();
		for(CustomerDetails customer: customer) {
			Row row = sheet.createRow(rowNum++);
//			createHeaderBorders(BorderStyle.MEDIUM, workbook, sheet);
			row.createCell(0).setCellValue(++customer.serialNumber);
			row.createCell(1).setCellValue(customer.customerName);
			row.createCell(2).setCellValue(customer.customerAddress);
			row.createCell(3).setCellValue(customer.acctNo);
			row.createCell(4).setCellValue(customer.phone);
			row.createCell(5).setCellValue(customer.email);
			row.createCell(6).setCellValue(customer.bHub);
			row.createCell(7).setCellValue(customer.serviceHub);
			row.createCell(8).setCellValue(customer.feeder);
			row.createCell(9).setCellValue(customer.transformer);
			row.createCell(10).setCellValue(customer.coordinates);
			row.createCell(11).setCellValue(customer.presentMeterTypeRating);
			row.createCell(12).setCellValue(customer.presentMeterNo);
			row.createCell(13).setCellValue(customer.presentMeterStatus);
			row.createCell(14).setCellValue(customer.peakLoad);
			row.createCell(15).setCellValue(customer.business);
			row.createCell(16).setCellValue(customer.requestedMeter);
			row.createCell(17).setCellValue(customer.tariffInUse);
			row.createCell(18).setCellValue(customer.recommendedTariff);
			row.createCell(19).setCellValue(customer.recommendedMeter);
			row.createCell(20).setCellValue(customer.remark);
			row.getSheet().autoSizeColumn(cell.getColumnIndex());
			createThinBorders(workbook);
//			sheet.autoSizeColumn(cell.getColumnIndex());
		}
		
		FileOutputStream filSave = new FileOutputStream(save.report+".xls");
		workbook.write(filSave);
		workbook.close();
		filSave.close();
	}
}

class CustomerDetails{
	public String customerName, customerAddress, acctNo, phone, email, location, bHub, serviceHub, feeder, transformer, coordinates, presentMeterTypeRating, presentMeterNo,presentMeterStatus, peakLoad, business, requestedMeter, tariffInUse,  recommendedTariff, recommendedMeter, remark;
	int serialNumber = 0;
	
//	public String[] setLocation = {"Business Hub", "Service Hub", "Feeder Name", "Distribution S/S", "Coordniates"};
	
	public CustomerDetails() {
		customerName = MeterSuitability.txtName.getText();
		customerAddress = MeterSuitability.txtAddress.getText();
		acctNo = MeterSuitability.txtAcctNo.getText();
		phone = MeterSuitability.txtPhone.getText();
		email = MeterSuitability.txtEmail.getText();
		bHub = MeterSuitability.txtBhub.getText();
		serviceHub = MeterSuitability.txtServiceHub.getText();
		feeder = MeterSuitability.txtFeeder.getText();
		transformer = MeterSuitability.txtTransformer.getText();
		coordinates = MeterSuitability.txtCoordinates.getText();
		presentMeterTypeRating = MeterSuitability.txtOldMeter.getText(); 
		presentMeterNo = MeterSuitability.txtOldMeterNo.getText();
		presentMeterStatus = MeterSuitability.txtOldMeterStatus.getText();
		peakLoad = MeterSuitability.txtPeakLoad.getText();
		business = MeterSuitability.txtBusiness.getText();
		requestedMeter = MeterSuitability.txtRequestedMeter.getText();
		tariffInUse = MeterSuitability.txtTariffInUse.getText();
		recommendedTariff = MeterSuitability.txtRecommendedTariff.getText();
		recommendedMeter = MeterSuitability.txtRecommendedMeter.getText();
		remark = MeterSuitability.txtRemark.getText();
//		new SaveToExcelx().createThinBorders(SaveToExcelx.workbook);
		
		new SaveToExcelx().sheet.autoSizeColumn(0);
		new SaveToExcelx();
	}
	
	public CustomerDetails(String customerName, String customerAddress, String acctNo, String phone, String email, String BHub, String serviceHub,
			String feeder, String transformer, String coordinates, String presentMeter, String presentMeterNo, String presMeterStatus, String peakLoad, String business,
			String requestedMeter, String tariffInUse, String recommendedTariff, String recommendedMeter, String remark) { // String bHub, String serviceHub, String feeder, String transformer) {
		super();
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.acctNo = acctNo;
		this.phone = phone;
		this.email = email;
		this.bHub = BHub;
		this.serviceHub = serviceHub;
		this.feeder = feeder;
		this.transformer = transformer;
		this.coordinates = coordinates;
		this.presentMeterTypeRating = presentMeter;
		this.presentMeterNo = presentMeterNo;
		this.presentMeterStatus = presMeterStatus;
		this.peakLoad = peakLoad;
		this.business = business;
		this.requestedMeter = requestedMeter;
		this.tariffInUse = tariffInUse;
		this.recommendedTariff = recommendedTariff;
		this.recommendedMeter = recommendedMeter;
		this.remark = remark;
	}
}
