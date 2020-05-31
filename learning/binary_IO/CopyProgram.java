package binary_IO;
import java.io.*;
import java.util.*;

public class CopyProgram {

	public static void main(String[] args) {
		args = new String[2];
		args[0] = "C:\\Users\\Honeeks Inc\\Documents\\1million_factorial.txt";
		System.out.print("Enter target file name: ");
		Scanner scan = new Scanner(System.in);
		args[1] = scan.nextLine();
		if(args.length != 2) {
			System.out.println("Usage: java Copy sourceFile targetfile");
			System.exit(1);
		}
		
		File sourceFile = new File(args[0]);
		if(!sourceFile.exists()) {
			System.out.println("Source file " + args[0] + " does not exist");
			System.exit(2);
		}
		
		File targetFile = new File(args[1]);
		if(targetFile.exists()) {
			System.out.print("Target file \"" + args[1] + "\" already exists.");
			System.exit(3);
		}
		
		try (
			BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile));
			BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile));
				){
			int content, bytesCopied = 0;
			
			while((content = input.read()) != -1) {
				output.write((byte)content);
				bytesCopied++;
			}
			
			System.out.println(bytesCopied + " bytes copied");
			
		} catch (Exception e) {
			System.out.print("End of File");
		}
	}

}
