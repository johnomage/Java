package binary_IO;

import java.io.*;

/*
 * *17.2 (Create a binary data file) Write a program to create a file named
Exercise17_02.dat if it does not exist. Append new data to it if it already exists.
Write 100 integers created randomly into the file using binary I/O.
 */

public class Exercise17_02_binarydatafile {

	public static void main(String[] args) throws IOException {
		
		try(DataOutputStream output = new DataOutputStream(new FileOutputStream("Exercise17_02.dat", true));
				){
			for(int i=0; i<100; i++)
				output.writeUTF((int) (Math.random()*100) + " ");
		}
		
		try(DataInputStream input = new DataInputStream(new FileInputStream("Exercise17_02.dat"));
				){
			for(int i=0; i<100; i++)
				System.out.print(input.readUTF());
		}
		
	}

}
