package binary_IO;
import java.io.*;

public class TestFileStream {

	public static void main(String[] args) throws IOException {
		FileOutputStream output = new FileOutputStream("File.dat");
		PrintWriter fileWriter = new PrintWriter(output, true);
		DataOutputStream data = new DataOutputStream(output);
		
		for(int i=0; i<11; i++) {
			output.write(i);
			data.writeUTF("ABeDC");
//			fileWriter.write(" value");
		}
		fileWriter.close();
		FileInputStream input = new FileInputStream("File.dat");
		FileReader fileReader = new FileReader("File.dat");
		DataInputStream dataRead = new DataInputStream(input);
		int value, count = 0;
		while(count != 11){
			System.out.println(input.read() + " " + fileReader.read() + " " + dataRead.readUTF().toUpperCase());
			count++;
		}
	}

}
