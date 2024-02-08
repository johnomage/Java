package recursion;

import java.util.Scanner;

public class twoPowerN {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a nonnegative integer: ");
		int n = input.nextInt();
		
		System.out.println("2 to power " + n + " is " + twoPower(n));
	}

	private static long twoPower(int n) {
		if(n==0)
			return 1;
		else return 2 * twoPower(n-1);
	}

}
