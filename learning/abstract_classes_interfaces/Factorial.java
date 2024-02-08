package chapter13;
import java.math.*;//package com.edus.chapter13;
import java.util.*;
public class Factorial
{
	static boolean repeat = true;
	static Scanner input = new Scanner(System.in);
	public static void main(String[] edus){
		System.out.println("Calculate factorial of any integer:");
		while(repeat){
			try{
				System.out.print("\nEnter integer: ");
				BigInteger number = input.nextBigInteger();
				
				if(number.compareTo(BigInteger.ZERO)<0){
					System.out.println("\nError: Entry must be zero and above.");
				}
				
				else {
					System.out.println(number + "! is: " + factorial(number));
					System.out.println("Digit count: " + count(factorial(number)));
				}
			}
		
			catch(NumberFormatException | InputMismatchException er){
				System.out.println("\nError: Please enter an integer like 3, 8, 16, 90...");
				repeat = false;
			}
			
			//break;
		}
		
	}
	
	static long count (BigInteger value) {
		double factor = Math.log(2)/Math.log(10);
		int count = (int)(factor * value.bitLength() + 1);
		if(BigInteger.TEN.pow(count-1).compareTo(value) > 0) {
			return count-1;
		}
		
		return count;
	}
	
	static BigInteger factorial(BigInteger number){
		Integer i;
		BigInteger result = BigInteger.ONE;
		for(i=number.intValue(); i>=1; i--){
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}
}
