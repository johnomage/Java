package recursion;

import java.util.Scanner;

public class sumOfNIntegers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a nonnegative power integer: ");
		int n = input.nextInt();
		
		System.out.println("Sum of numbers from 0 to " + n +  " is " + sumToN(n));

	}

	private static int sumToN(int n) {
		if(n==1) return 1;
		else return n + sumToN(n-1);
	}

}	
