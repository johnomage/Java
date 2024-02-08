package binary_IO;

import java.io.*;
public class TestRandomAccessFile {

	public static void main(String[] args) {
		try	(RandomAccessFile raf = new RandomAccessFile("StudentFile.cmd", "rw");)
		{
			raf.setLength(0);
			for(int i=0; i<500; i++) {
				raf.writeInt(i);
			}
			
			System.out.println("Current file length is " + raf.length());
			
			raf.seek(0);
			System.out.println("First number is " + raf.readInt());
			
			raf.seek(4*1);
			System.out.println("Second number is " + raf.readInt());
			
			raf.seek(4*9);
			System.out.println("Tenth number is " + raf.readInt());
			
			raf.writeUTF("Ten");
			
			raf.seek(raf.length());
			raf.writeInt(500);
			
			System.out.println("New length is " + raf.length());
			
			raf.seek(10*4);
			System.out.println("Eleventh value is " + raf.readUTF());
		}
		
		catch (Exception e) {
			// TODO: handle exception
		}
	}

}
