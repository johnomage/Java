package recursion;

import java.util.Scanner;

public class Exercise18040506_SumSeries {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number: ");
		int number = scan.nextInt();
		System.out.println("sumSeries18_4: " + sumSeries18_4(number) + "\nsumSeries18_5: " + sumSeries18_5(number) + "\nsumSeries18_6: " + sumSeries18_6(number));
		
		System.out.println("\ni     sumSeries18_4(i)\n-----------");
		for(int i=1; i<=number; i++) {
			System.out.printf("%2d%8.2f\n", i, sumSeries18_4(i));
		}
		
		System.out.println("\ni     sumSeries18_5(i)\n-----------");
		for(int i=1; i<=number; i++) {
			System.out.printf("%2d%8.2f\n", i, sumSeries18_5(i));
		}
		
		System.out.println("\ni     sumSeries18_6(i)\n-----------");
		for(int i=1; i<=number; i++) {
			System.out.printf("%2d%8.2f\n", i, sumSeries18_6(i));
		}
		
	}

	private static double sumSeries18_4(double n) {
		if(n == 1)
			return 1;
		else {
			return 1/n + sumSeries18_4(n-1);
		}
	}
	
	private static double sumSeries18_5(double n) {
		if(n == 0)
			return 0;
		else {
			return n/(2*n+1) + sumSeries18_5(n-1);
		}
	}
	
	private static double sumSeries18_6(double n) {
		if(n == 0)
			return 0;
		else {
			return n/(n+1) + sumSeries18_6(n-1);
		}
	}

}
