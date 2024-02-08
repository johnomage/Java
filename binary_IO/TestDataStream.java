package binary_IO;

import java.io.*;

public class TestDataStream {

	public static void main(String[] args) throws IOException {

		DataOutputStream output = new DataOutputStream(new FileOutputStream("Test.cmd"));
		output.writeUTF("Edus is great!");
		output.writeDouble(10.5);
		output.writeUTF(" times");
		
		DataInputStream input = new DataInputStream(new FileInputStream("Test.cmd"));
		System.out.print(input.readUTF() + " " + input.readDouble());
	}

}
