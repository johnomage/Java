package EventDrivenProgAndAnim;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ATMProgram {
	private static Scanner input = new Scanner(System.in);
	private static String name;
	private static String[] transaction;
	private static Date date = new Date();
	static ArrayList<String> customers = new ArrayList<>();
	private static double AnnualInterestRate;
	private static double withdraw, amount = 0, balance=1000, deposit;
	static LogIn login = new LogIn();
	
	//MAIN METHOD
	public static void Main(String[] args) {
//		System.out.print("\n");
//		System.out.print("Enter your name: ");
		name = LogIn.accountText.getText();
//		System.out.print("Enter an PIN: ");
		String pin = login.pinText.getText();
		if(!customers.contains(name)) {
			customers.add(name);
			new NewAccount().create(); //create new account if customer name does not exit.
		}
		
		else menu();
	}
	
	//DISPLAY MENU
	public static void menu() {
		// TODO Auto-generated method stub
			
			System.out.print("\nKindly select an option from the Main Menu:\n");
			System.out.println("\nMain Menu:\n1: Check Balance\n2: Withdraw\n3: Deposit\n4: Exit");
			
			try {
					int option = input.nextInt();
					switch(option) {
						case 1: System.out.printf("\nTransaction Type: Check Balance\n---------------------------\n"); break;
						case 2: System.out.printf("\nTransaction Type: Withdraw\n---------------------------\n"); break;
						case 3: System.out.printf("\nTransaction Type: Deposit\n---------------------------\n"); break;
						case 4: System.out.printf("\nTransaction Type: Exit\n---------------------------\n"); break;
					}
				
				switch(option) {
					case 1: checkBalance(); //check balance
							
							break;
					case 2: System.out.print("Enter withdraw amount: "); //withdraw
							withdraw = input.nextDouble();
							withdraw(); break;
					
					case 3: System.out.print("Enter deposit amount: "); //deposit
							deposit = input.nextDouble(); 
							deposit(); break;
					
					case 4: System.out.print("\nEnd transaction (y/n?) "); // exit
							char response = input.next().toLowerCase().charAt(0);
							if(response == 'y')
								exit(); break;
								
					default: System.out.println("Wrong option selected.");
							 anotherTransaction();
				}
			}
			
			catch (Exception e) {
				System.out.println("Please choose options 1 - 4:");
				anotherTransaction();
			}
	}
	

	public static String getName() { //get customer's name.
//		customers.add(name);
		return name;
	}

	public static String[] getTransaction() { // return transaction type
		
		return transaction;
	}

	public static Date getDate() { // get transaction date
		return date;
	}
	
	public static ArrayList<String> getCustomers() { // get customers count
		return customers;
	}

	public static double getAnnualInterestRate() { // get annual interest rate
		return AnnualInterestRate;
	}

	public static double getWithdraw() { // get withdrawal amount
		return withdraw;
	}

	public static double getAmount() { // amount
		return amount;
	}

	public static double getBalance() { // get balance after transaction
		return balance;
	}

	// EXIT METHOD
	private static void exit() {
		// TODO Auto-generated method stub
		System.out.println("Exiting...");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\nThank you for transacting with us.");
		System.exit(0);
	}

	// CHECK BALANCE
	public static void checkBalance() {
//		transaction = new Transaction();
		// TODO Auto-generated method stub
		System.out.printf("Balance: %.2f", balance);
		anotherTransaction();
	}

	// WITHDRAW METHOD
	public static double withdraw() {
		
		if(balance < withdraw) {
			System.out.printf("You have insufficient balance. Your balance is %.2f", balance);
			anotherTransaction();
		}
		else {
			balance = balance - withdraw;
			System.out.println("\nAmount withdrawn: " + withdraw);
			System.out.printf("New balance %.2f", balance);
			anotherTransaction();
		}
			
		return withdraw;
	}
	
	
	// DEPOSIT METHOD
		public static double deposit() { //DEPOSIT TRANSACTION
			
			balance = balance + deposit;
			System.out.println("\nDeposit amount: " + deposit);
			System.out.printf("New balance: %.2f", balance);
			anotherTransaction();
			return deposit;
		}
		
		
	private static void anotherTransaction() { // START ANOTHER TRANSACTION
		// TODO Auto-generated method stub
		System.out.print("\n\nPerform another transcation? (y/n): ");
		char response = input.next().toLowerCase().charAt(0);
		if(response == 'y')
			Main(null);
//			menu();
		else System.out.print("\nThank you for your time.."); 
			 exit();
	}

	
	private String[] customer(String name) { //CUSTOMER NAME
		for(String entry: customers) {
			if(customers.contains(entry))
				menu();
			else new NewAccount(entry);
		}
		return null;
	}

}
// CREATE NEW ACCOUNT CLASS
class NewAccount{
//	ATMProgram atm = new ATMProgram();
	public NewAccount(String name) {
		// TODO Auto-generated constructor stub
		name = ATMProgram.getName();
		ATMProgram.getDate().toGMTString();
		ATMProgram.customers.add(name);
	}
	public NewAccount() {}
	
	public void create() {
		String gender = "Male";
		int age = 22;
		String occupation = "Engineer";
		System.out.printf("\nNew Account Created:\nName: %s\nAge: %d\nGender: %s\nOccupation: %s\n", ATMProgram.getName(), age, gender, occupation);
		System.out.println("Date: " + ATMProgram.getDate().toString() + "\n");
		ATMProgram.menu();
	}
	
}

// TRANSACTION HISTORY CLASS
class Transaction{
	ATMProgram atm = new ATMProgram();
	NewAccount newAccount = new NewAccount();
	static Date[] date;
	String name;
	
	public Transaction() {}
	
	public void printDetails() {
		System.out.print("Account Holder Details: ");
		newAccount.create();
		System.out.println("Transaction Type: ");
	}
	
}

