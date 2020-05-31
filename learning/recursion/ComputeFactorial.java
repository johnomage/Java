package recursion;

import java.math.BigInteger;
import java.util.Scanner;

public class ComputeFactorial {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a nonnegative integer: ");
		BigInteger n = input.nextBigInteger();
		
		System.out.println(n + "! is " + factorial(n));
	}

	private static BigInteger factorial(BigInteger n) {
		if(n == BigInteger.ZERO) {
			return BigInteger.ONE;
		}
		else return n.multiply(factorial(n.subtract(BigInteger.ONE)));
	}
}