package src.chapter13;
import java.util.*;//package com.edus.chapter13

public class RunPhone
{
		static ITelephone phone = new MobilePhone();
		static long number;
		static String compose;
		//phone.dial(number);
		//phone.answer();
		//phone.powerOff();
	static Scanner input = new Scanner(System.in);
	
	//MAIN METHOD
	public static void main(String[] edus){
		//ITelephone phone;
		//phone = new DeskPhone();
		//phone.dial(123456);
		//phone.powerOn();
		
		//phone.powerOn();
		System.out.println("What do you want to do?");
		menu();
		function();
	}
	
	//menu method to list what to do
	static void menu(){
		System.out.println("1. Call a contact.\n2. Send a message.\n3. Switch off mobile.\n");
	}
	
	static void function(){
		System.out.println("Choose 1, 2 or 3");
		try{
			switch(input.nextInt()){
				case 1: System.out.print("Enter dial number: ");
						
						
					    number = input.nextLong();
						phone.dial(number);
						new MobilePhone().callHistory(number);
						phone.answer();	
						phone.contactList(number);
						break;
				case 2: System.out.print("Enter contact or number: ");
						number = input.nextLong();
						phone.message(input.nextLine());
						System.out.println("Sending SMS...");
						new MobilePhone().delay(1.7);
						System.out.println("SMS sent ✓");
						phone.contactList(number);
						break;
				case 3: phone.powerOff(); break;
				default: function(); break;
			}
		}
			
		catch(InputMismatchException er){
				System.out.println("Please enter number: 1, 2 or 3");
				//function();
			}
	}
	
}
