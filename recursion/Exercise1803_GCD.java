package recursion;

import java.util.Scanner;

public class Exercise1803_GCD {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int gcd = 1;
		System.out.print("Enter number 1: ");
		int n1 = scan.nextInt();
		System.out.print("Enter number 2: ");
		int n2 = scan.nextInt();
		
		System.out.print("GCD is " + gcd(n1, n2));
	}

	public static int gcd(long numerator, long denominator) {
		if(numerator%denominator == 0)
			return (int) denominator;
		else return gcd(numerator, numerator%denominator);
	}
}
