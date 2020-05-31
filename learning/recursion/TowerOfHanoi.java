package recursion;

import java.util.Scanner;

public class TowerOfHanoi {
	static int count;
	public static void main(String[] args) {
		System.out.print("Enter number of disks: ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		System.out.println("Honai Moves for " + n + " disks\n-------------------------\n");
		
		move(n, 'A', 'B', 'C');
		System.out.print("Moves: " + count);
	}

	private static void move(int n, char fromTower, char toTower, char auxTower) {
		if(n == 1) {
			System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
			count++;
		}
		
		else {
			move(n-1, fromTower, auxTower, toTower);
			System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
			move(n-1, auxTower, toTower, fromTower);
			count++;
			
		}
	}

}
