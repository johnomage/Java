package binary_IO;

/*
 * *17.1 (Create a text file) Write a program to create a file named Exercise17_01.txt if
it does not exist. Append new data to it if it already exists. Write 100 integers
created randomly into the file using text I/O. Integers are separated by a space.
 */

import java.io.*;
import java.util.Scanner;

public class Exercise17_01_CreateTextFile {
	
	public static void main(String[] args) throws FileNotFoundException, Exception {
		System.out.print("Enter file name: ");
		createTextFile(new Scanner(System.in).nextLine() + ".txt");
	}

	public static void createTextFile(String filename) throws FileNotFoundException, Exception {
		DataOutputStream output = new DataOutputStream(new FileOutputStream(filename, true));
		for(int i=0; i<filename.length(); i++) {
			output.writeUTF(i + " ");
		}
		
		DataInputStream input = new DataInputStream(new FileInputStream(filename));
		for(int i=0; i<filename.length(); i++)
			System.out.print(input.readUTF());
	}
}
