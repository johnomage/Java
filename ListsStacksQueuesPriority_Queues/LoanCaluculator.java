package ListsStacksQueuesPriority_Queues;

public class LoanCaluculator {
	
	private int numberOfYears;
	private double loanAmount, annualInterestRate, monthlyInterestRate;
	
	public LoanCaluculator() {}
	
	public LoanCaluculator(double loanAmount, int years, double interestRate) {
		this.loanAmount = loanAmount;
		this.numberOfYears = years;
		this.annualInterestRate = interestRate;
	}
	
	//Total loan payment after n years
	public double getTotalPayment() {
		return getMonthlyPayment() * numberOfYears * 12;
	}
	
	//get payment  every month
	public double getMonthlyPayment() {
		return loanAmount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
	}

	public int getNumberOfYears() {
		return numberOfYears;
	}

	public void setNumberOfYears(int numberOfYears) {
		this.numberOfYears = numberOfYears;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getMonthlyInterestRate() {
		return monthlyInterestRate = annualInterestRate * 1.0 / 1200;
	}
	
	@Override
	public String toString() {
		return String.format("Loan Amount: %.2f", getLoanAmount())  + String.format("\nAnnual Ineterest Rate: %.2f", annualInterestRate) + 
				String.format("\nYears: %d",  numberOfYears) + String.format("\nMonthly interest Rate: %.5f", getMonthlyInterestRate()) + 
				String.format("\nMonthly Payment: %.2f", getMonthlyPayment()) + String.format("\nTotal Payment: %.2f", getTotalPayment());
	}

}
