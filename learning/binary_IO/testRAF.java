package binary_IO;

//to read name, street, area, state, zip code
import java.io.*;
import java.util.Scanner;

public class testRAF {
	
	private static RandomAccessFile raf ;
	static final int NAME = 32, STREET = 32, AREA = 10, STATE = 7, ZIP = 4;
	static String[] details =  {"name", "street", "area", "state", "zip"};
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		raf = new RandomAccessFile("User Details.txt", "rw");
		System.out.print("This Program generates and registers users on User Details.txt\n\n");
		
		for(int i=0; i<details.length; i++) {
			System.out.print("Enter " + details[i] + ": ");
//			details[i] = input.nextLine();
//			raf.read(input.nextLine().getBytes());
			raf.writeUTF(input.nextLine());
		}
		System.out.println();
		if(raf.length() >0)
			raf.seek(0);
		read(raf);
		
	}
	
	public static void next() throws IOException {
		System.out.print("\nEnter next details (y/n)? ");
		String response = input.next().toLowerCase();
		if(response.startsWith("y") )
			main(null);
		else System.out.print("Program terminated.");
	}

	void write(RandomAccessFile file) throws IOException {
		file.write(size(details[0].getBytes(), NAME));
		file.write(size(details[1].getBytes(), STREET));
		file.write(size(details[2].getBytes(), AREA));
		file.write(size(details[3].getBytes(), STATE));
		file.write(size(details[4].getBytes(), ZIP));
		file.close();
	}
	
	static void read(RandomAccessFile file) throws IOException  {
		int pos;
		
		byte[] name = new byte[NAME];
		pos = file.read(name);
		System.out.println(new String(name));
		
		byte[] street = new byte[STREET];
		pos += file.read(street);
		System.out.println(new String(street));
		for(int i=0; i<street.length; i++) {
			System.out.print(street[i] + " ");
		}
		
		byte[] area = new byte[AREA];
		pos += file.read(area);
		System.out.println(new String(area));
		
		byte[] state = new byte[STATE];
		pos += file.read(state);
		System.out.println(new String(state));
		
		byte[] zip = new byte[ZIP];
		pos += file.read(zip);
		System.out.println(new String(zip));
		
		file.close();
				
	}
	
	@SuppressWarnings("unused")
	private byte[] size(byte[] array, int n) {
		byte[] temp = new byte[n];
		for(int i=0; i<array.length; i++)
			temp[i] = array[i];
		return temp;
	}

}
