package recursion;

import java.util.Scanner;

public class xPowerN {
	
	static int x;
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a positive base integer: ");
		x = input.nextInt();
		
		System.out.print("Enter a nonnegative power integer: ");
		int n = input.nextInt();
		
		System.out.println( x + " to power " + n + " is " + xPower(n));
	}

	private static long xPower(int n) {
		if(n==0) return 1;
		else return x * xPower(n-1);
	}

}
