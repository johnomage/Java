package chapter13;//package com.edus.chapter13;
import java.util.*;
import java.io.*;
import java.nio.file.*;
public class MobilePhone implements ITelephone{
	static Scanner input = new Scanner(System.in);
	private boolean isOn = false;
	private static long myNumber;
	private static Integer Mcounter = 0;
	private static Calendar calendar;
	private static List<Long> phoneNumbers = new ArrayList();
	static File callHistory, SMSList, contactsList;
	static String directory = "C:\\Users\\Honeeks Inc\\eclipse-workspace\\learning\\zzFiles\\";

	public void powerOn(){ //SWITCH PHONE ON
		isOn = true;
		System.out.println("Edus Corp.");
		delay(1.5);
		System.out.println("Powered by Edus Corp.\n");
		delay(2.5);
		System.out.println("Welcome, Edus\n");
		delay(1.7);
	}

	@Override//TO DIAL NUMBER
	public void dial(long number)
		{
			this.myNumber = number;
			if(!phoneNumbers.contains(number)){
				phoneNumbers.add(number);
				}
			System.out.println("Calling " + number + "...");
		}

	@Override //ANSWER OR REJECT CALL
	public void answer()
		{
			Character response;
			try{
				if(isRinging()){
					Thread.sleep(3000);
					System.out.println("Answer call from " + myNumber + "? Y or N: ");
					response = input.next().charAt(0);
					if(response=='y' || response== 'Y'){
					System.out.println("Hello " + myNumber);
				}
				else{
					System.out.println("Call from " + myNumber + " rejected!");
					
					}
				}
			}
			catch(Exception et){}
			
		}
	
	@Override//IS THE PHONE RINGING?
	public boolean isRinging()
		{
			return true;
		}
			
	@Override//SWITCH OFF PHONE
	public void powerOff()
		{
			try{
				if(this.isOn=true){
					System.out.print("Mobile phone is shutting down...\n");
					Thread.sleep(2000);
					System.out.println("Goodbye!");
					Thread.sleep(1500);
					System.exit(0);
				}
			}
			
			catch(InterruptedException ie){
				System.out.println("Network error or time out");
			}
		}
	
	//message composition
	@Override
	public void message(String compose)
		{
			// TODO: Implement this method
			System.out.println("\nCompose text message: ");
			compose = input.nextLine();
			SMSVault(compose);
		}
	
	//delay
	void delay(double timer){
		try{
			Thread.sleep((long)(timer * 1000));
		}
			
		catch(InterruptedException ie){
			System.out.println("Network error or Time out");
		}
	}
	
	//SAVE DIALED NUMBERS OR CALL HISTORY
	public static File callHistory (long number){
		int Ccounter = 1;
		try
		{
			String location = directory + ".callHistory.txt"; 
			FileWriter write = new FileWriter(location, true);
			callHistory = new File(location);
			if(!callHistory.exists()){
				callHistory.createNewFile();
			}
			String dials = new String().valueOf(number);
			calendar = new GregorianCalendar();
			if(Ccounter==Ccounter){
				Ccounter++;
			}
			write.write(Ccounter + " " +dials+ "\t" + calendar.getTime() + "\n");
			write.close();
		}
		
		catch(FileNotFoundException ex){
			System.out.println(callHistory.getName() + " not found");
		}
		
		catch(InputMismatchException | NumberFormatException er){
			System.out.println("Wrong number format entered!");
		}
		
		catch(Exception e){
			e.getCause();
		}
		
		return callHistory;
	}
	
	//SAVE SENT MESSAGES
	public static File SMSVault(String message){
//		Mcounter;
		String location = directory + ".SMSList.txt";
		try
			{
				FileWriter write = new FileWriter(location, true);
				SMSList = new File(location); //CREATE SMS LIST OBJECT TO STORE SMSes
				if(!SMSList.exists()){
					SMSList.createNewFile();
			}
				
				calendar = new GregorianCalendar();
				write.write(Mcounter + " " + message + "\n" + calendar.getTime() + "\n\n");
				write.close();
				Scanner scan = new Scanner(SMSList);
				while(scan.hasNextInt(Mcounter)){
					if((scan.next().charAt(0)) == Mcounter)
						Mcounter++;
				}
		}

		catch(Exception ex){
			System.out.println(SMSList.getName() + " not found");
	}
		return SMSList;
		}

	@Override
	public String contactList (long contact)
		{
			// TODO: Implement this method
			try{
					FileWriter write = new FileWriter(directory + ".contactsList.txt", true);
					contactsList = new File(directory + ".contactsList.txt");
					if(!contactsList.exists()){
						contactsList.createNewFile();
					}
				
					else{
						write.write(contact + "\n");
						write.close();
					}
				}
			
			catch(Exception fnf){
				System.out.println(contactsList.getName() + " not found or renamed or moved.");
			}
			
			return null;
		}
		
}
