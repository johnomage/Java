package binary_IO;
import java.io.*;
public class DetectEndOfFile {

	public static void main(String[] args) {
		
		try {
			try (DataOutputStream output = new DataOutputStream(new FileOutputStream("Edus.cmd"));) {
				output.writeDouble(5.55);
				output.writeDouble(3.33);
//				output.writeUTF("This are the values");
				output.writeDouble(1.0);
			} catch (IOException e) {
//				e.printStackTrace();
			}
			
			try (DataInputStream input = new DataInputStream(new FileInputStream("Edus.cmd"))){
				
				while(true) {
					System.out.println(input.readDouble());
				}
			}
			
			catch (EOFException e) {
				System.out.println("All files were read.");
			}
		
			catch (IOException eof) {
			eof.printStackTrace();
			}
		}
		
		finally {}
	}

}
