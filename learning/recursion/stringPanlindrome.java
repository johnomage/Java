package recursion;

import java.util.Scanner;

public class stringPanlindrome {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a text string: ");
		String text = input.next();
		
		System.out.println(text +  " is palindrome? " + isPalindrome(text));
	}
	
	private static boolean isPalindrome(String text) {
		return isPalindrome(text, 0, text.length());
	}

	private static boolean isPalindrome(String text, int low, int high) { //recursive helper method
		if(high <= low) return true;
		else if(text.charAt(low) != text.charAt(high-1)) return false;
		else return isPalindrome(text, low+1, high-1);
	}

}
