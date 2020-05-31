package Files_and_Exceptions;
/* **12.11 (Remove text) Write a program that removes all the occurrences of a specified 
string from a text file. For example, invoking
java Exercise12_11 John filename
 removes the string John from the specified file. Your program should get the 
arguments from the command line*/
import java.util.*;
import java.io.*;

public class RemoveText
{
	static ArrayList<String>list;
	static Scanner input = new Scanner(System.in);
	public static void main (String[] main) throws Exception{
		System.out.println("This program deletes a string from a file.\n");
		System.out.print("Enter file to import: ");
		String filename = input.nextLine();

		String path = "storage/emulated/0/AppProjects/com.edus.java/";
		File file = new File(path + filename);
		if(!file.exists()){
			Character respond= 'y';
			System.out.println(file.getName()+ " was not found.\nDo you want to create it? (y or yes) ");
			if(respond == input.next().charAt(0)){
				file.createNewFile();
				PrintWriter dump = new PrintWriter(file);
				dump.println("Abraham Bassey Collins Dave Jonathan Smart Earl Franklin Gold Hellen Ibelin John Kate Leo Nat Orlando Perez Queen Rex Stanley Tom Ugo Venesa Wale Xeon Yale Zeus");
				dump.close();
				System.out.println(file.getName() + " created and imported successfully!\n");
			}
			else {ReplaceText.end();}
		}
		else{
			System.out.println(file.getName() + " imported successfully!\n");
		}
		
		File tmpFile = new File(file.getAbsolutePath() + ".tmp");
		int count = 0;
		String text=null;
		String removeText = "";
		System.out.print("Enter text to remove: ");
		removeText = input.next();
		try(PrintWriter createTmp = new PrintWriter(tmpFile);
		//FileReader find = new FileReader(file);
		Scanner scan = new Scanner(file);){
			list = new ArrayList<>();
			while(scan.hasNext()){
				text = scan.next();
				list.add(text);
				count++;
				System.out.println(text);
				if(!text.equals(removeText)){
					createTmp.println(text);
				}
			}
			createTmp.println("\n\n"+removeText + " was deleted");
			createTmp.close();
			file.delete();
			tmpFile.renameTo(new File(path+filename));
			
			
			if(list.contains(removeText)){
				list.remove(removeText);
			}
			else{
				System.out.println(removeText + " not found");
				ReplaceText.end();
			}
			System.out.println(list);
			System.out.println(removeText + " removed.");
			ReplaceText.end();
		}
		
	}
}
