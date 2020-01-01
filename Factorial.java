package chapter13;
import java.math.*;//package com.edus.chapter13;
import java.util.*;
public class Factorial
{
	static boolean repeat = true;
	static Scanner input = new Scanner(System.in);
	public static void main(String[] edus){
		System.out.println("Calculate factorial of any integer: \n");
		while(repeat){
			try{
				System.out.print("Enter integer: ");
				BigInteger number = input.nextBigInteger();
				System.out.println(number + "! is: " + factorial(number));
				if(number.compareTo(BigInteger.ZERO)<0){
					System.out.println("Entry must be zero and above.");
				}
			}
		
			catch(NumberFormatException | InputMismatchException er){
				System.out.println("Please enter an integer like 3, 8, 16, 90...");
				repeat= false;
			}
			
			//break;
		}
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
