package Files_and_Exceptions;
import java.util.*;
import java.io.*;

public class ReplaceText
{
	public static void main(String[] args) throws Exception
	{
		System.out.println("Hello Edupe!");
		File file = new File("storage/emulated/0/AppProjects/MyJava/file.txt");
		//file.getParentFile().mkdirs();
		Scanner input = new Scanner(System.in);
		System.out.println(file.getAbsolutePath());
		
		File tmpFile = new File(file + ".tmp"); //temporary file
		tmpFile.createNewFile(); //create a temporary file
		
		PrintWriter output = new PrintWriter(file);
		output.print("Welcome!\nI am a mountain\nI'm the world's greatest.\nThe best of the best of the best.");
		output.close();
		PrintWriter tmp = new PrintWriter(tmpFile);

		if(file.exists()){
			System.out.println("File " + file.getName() + " created");
		}
		
		System.out.print("Enter old text: ");
		String old = input.nextLine();
		
		//System.out.println("Yess");
		int count=0;
		System.out.print("To replace with: ");
		String new1 = input.nextLine();
		
		int line=0;
		Scanner scan = new Scanner(file);
		while(scan.hasNext()){
			String find = scan.nextLine();
			if(!find.equals(old)){
				//tmp.print(
				System.out.println(old +" not found");
				end();
			}
			else{
				new1 = old.replace(old, new1);
				//String find = scan.next();
				tmp.print(find);
				count++;
				//old = new1;
				line++;
			}
			
		}
		System.out.println(count + " replacement found\nLine: " + line);
		output.close();
		//System.out.print(count);
		System.out.println();
	}
	static void end() throws Exception{
		System.out.println("Program terminated!\nExiting...");
		Thread.sleep(2000);
		System.exit(2);
	}
}
