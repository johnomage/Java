package binary_IO;

import java.io.*;

public class TestBufferedStream {

	public static void main(String[] args) throws Exception {
		try {
			DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Test.cmd")));
			output.writeUTF("Edus is great!");
			output.writeDouble(10.5);
			output.writeUTF(" times");
			
			DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream("Test.cmd")));
			System.out.print( " " + input.readDouble());
		} catch (EOFException eof) {
			System.out.print("End of file.");
		}
		
	}

}
