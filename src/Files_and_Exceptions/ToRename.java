package Files_and_Exceptions;
import java.util.*;
import java.io.*;
public class ToRename
{
	public static void main(String[] args) throws Exception{
		Date date = new Date();
		long time = System.currentTimeMillis();
		long k = time/1000;
		long second=  k%60;
		long min = k/60;
		long minute = min%60;
		long hr = min/60;
		long hour = hr%24+1;
		
		Scanner input = new Scanner(System.in);
		System.out.println(hour+ ":" + minute + ":" +second);
		System.out.println(date.toString());
		
		int countWord=0;
		File path = new File("storage/emulated/0/AppProjects/MyJava/");
		path.mkdirs();
		File file = new File(path+"/file.txt");
		//file.mkdirs();
		Scanner scan = new Scanner(file);
		//PrintWriter output = new PrintWriter(file);
		System.out.print("Text to replace: ");
		String old = input.nextLine();
		System.out.print("Replacing text: ");
		String newt = input.nextLine();
		while(scan.hasNext()){
			String find = scan.nextLine();
			if(find.matches(old)){
				newt = old.replaceAll(old, newt);
				countWord++;
			}
			//countWord++;
		}
		//output.close();
		if(countWord==0){
			System.out.println(old + " not found in " + file.getName());
			//System.exit(0);
		}
		else{
			System.out.println("Word count: " + countWord);
		}
		
	}
}
