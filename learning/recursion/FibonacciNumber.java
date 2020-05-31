package recursion;

import java.util.Scanner;

public class FibonacciNumber {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a positive integer: ");
		int n = Math.abs(input.nextInt());
		
		System.out.println("Fibonacci number at index " + n +  " is " + fib(n));
	}

	private static long fib(int index) {
		if(index<=0 || index == 1) return 0;
		else if (index==2) return 1;
		else return fib(index-2) + fib(index-1);
	}
}

//0 1 1 2 3 5 8 13 21
//1 2 3 4 5 6 7 8  9