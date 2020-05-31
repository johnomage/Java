package ListsStacksQueuesPriority_Queues;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Loan {

	public static void main(String[] args) {
		// Create a Scanner
		
		LoanCaluculator[] loans = {new LoanCaluculator(1000, 5, 7.5), new LoanCaluculator(900, 7, 5), new LoanCaluculator(1200, 7, 4.3), new LoanCaluculator(1300, 8, 1.3)};
		LoanCaluculator[] xloans = {new LoanCaluculator(1000, 5, 7.5), new LoanCaluculator(900, 7, 5), new LoanCaluculator(1200, 7, 4.3), new LoanCaluculator(1300, 8, 1.3)};
		Scanner input = new Scanner(System.in);
//		for(LoanCaluculator loan: loans)
//			System.out.print(loan.toString() + "\n\n");
//		System.out.println("\n\n");
		
//		Arrays.sort(loans, Comparator.comparing(LoanCaluculator::getTotalPayment).thenComparing(LoanCaluculator::getMonthlyInterestRate).then);
		Arrays.sort(loans, Comparator.comparing(LoanCaluculator::getMonthlyPayment));
//		Arrays.sort(xloans, Comparator.comparing(e-> e.))
		List<LoanCaluculator>loanList = Arrays.asList(xloans);
		loanList.sort((loan1, loan2) -> (int)(loan1.getTotalPayment() - loan2.getTotalPayment()));
		
		for(LoanCaluculator loan: loans)
			System.out.print(loan.toString() + "\n\n");
		
		System.out.println("Second: \n\n");
		
		for(LoanCaluculator loan: loanList)
			System.out.print(loan.toString() + "\n\n");
	}
}
