package ListsStacksQueuesPriority_Queues;

import java.util.Arrays;
import java.util.Comparator;

public class LoanTest {

	public static void main(String[] args) {

		Loan[] loanList = {new Loan(5.5, 10, 2323), new Loan(5, 10, 1000)};
		
		Arrays.sort(loanList, Comparator.comparingDouble(Loan::getLoanAmount()));
	}

}

class Loan{
	private static double d, i, j;

	public Loan(double d, double i, double j) {
		Loan.d = d;
		Loan.i = i;
		Loan.j = j;
	}
	
	public static Loan annualInterestRate() {
		return new Loan(d*2.5*5/100, i*2.5*5/100, j*2.75*4.5/100);
	}
	
	public static Loan getLoanAmount(){
		return new Loan(d, i, j);
	}
	
}
