package projects;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SaveToExcel {
	private static String[] columns = {"Customer Name", "Customer Address","Account Number", "Phone Number", "E-Mail Address", "Location", "Present Meter Type & Rating",
			"Present Meter Number",  "Present Meter Status", "Peak Load (Amp)",  "Nature of Business", "Requested Meter Rating/Type", "Tariff in Use",
			"Recommended Tariff", "Recommended Meter", "Remark"};
	private static String[] location = {"Business Hub", "Service Hub", "Feeder Name",	"Distribution S/S"};
	private static List<Customer> customer = new ArrayList<Customer>();
	private static MeterSuitability meter = new MeterSuitability();
	static String newTariff = meter.mapTariffCode.get(meter.customerClass.getValue());
	
	public static void main(String[] edus) throws Exception {
		export();
	}
	
	

	public SaveToExcel(){}
	
	public static void export() throws Exception {
		customer.add(new Customer(meter.txtName.getText(), meter.txtAddress.getText(), meter.txtAcctNo.getText(), meter.txtPhone.getText(), meter.txtEmail.getText(),
				meter.txtOldMeter.getText(), meter.txtOldMeterNo.getText(), meter.txtOldMeterStatus.getText(), String.valueOf(meter.getCurrent()), 
				meter.txtBusiness.getText(), "meter Requested", "Present Tariff", newTariff, meter.txtRemark.getText(), meter.txtBhub.getText(),
				meter.txtServiceHub.getText(), meter.txtFeeder.getText(), meter.txtTransformer.getText()));
		
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet(meter.txtName.getText( )+" Report");
		
		//create row
		Row headerRow = sheet.createRow(0);
		
		for(int i=0; i<columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			
		}
		
		//othera
		int rowNum = 1;
		for(Customer customer: customer) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(customer.customerName);
			row.createCell(1).setCellValue(customer.customerAddress);
			row.createCell(2).setCellValue(customer.acctNo);
			row.createCell(3).setCellValue(customer.phone);
			row.createCell(4).setCellValue(customer.email);
			row.createCell(5).setCellValue(customer.presentMeter);
			row.createCell(6).setCellValue(customer.presentMeterNo);
			row.createCell(7).setCellValue(customer.presMeterStatus);
			row.createCell(8).setCellValue(customer.load);
			row.createCell(9).setCellValue(customer.business);
			row.createCell(10).setCellValue(customer.requestedMeter);
			row.createCell(11).setCellValue(customer.tariffInUse);
			row.createCell(12).setCellValue(customer.recommendedTariff);
			row.createCell(13).setCellValue(customer.remark);
//			row.createCell(0).setCellValue(customer.customerName);
		}
		
		//Resize columns
		for(int i=0; i<columns.length; i++) {
			sheet.autoSizeColumn(i);
		}
		
		FileOutputStream filSave = new FileOutputStream(meter.txtName.getText());
		workbook.write(filSave);
		filSave.close();
	}
	
	

}

class Customer{
	public String customerName, customerAddress, acctNo, phone, email, presentMeter, presentMeterNo, presMeterStatus, load, business, requestedMeter, tariffInUse,
				  recommendedTariff, remark;
	public String bHub, serviceHub, feeder, transformer;
	
	public Customer(String customerName, String customerAddress, String acctNo, String phone, String email,
			String presentMeter, String presentMeterNo, String presMeterStatus, String load, String business,
			String requestedMeter, String tariffInUse, String recommendedTariff, String remark, String bHub,
			String serviceHub, String feeder, String transformer) {
		super();
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.acctNo = acctNo;
		this.phone = phone;
		this.email = email;
		this.presentMeter = presentMeter;
		this.presentMeterNo = presentMeterNo;
		this.presMeterStatus = presMeterStatus;
		this.load = load;
		this.business = business;
		this.requestedMeter = requestedMeter;
		this.tariffInUse = tariffInUse;
		this.recommendedTariff = recommendedTariff;
		this.remark = remark;
		this.bHub = bHub;
		this.serviceHub = serviceHub;
		this.feeder = feeder;
		this.transformer = transformer;
	}
	
//	public Contact()
	
}
