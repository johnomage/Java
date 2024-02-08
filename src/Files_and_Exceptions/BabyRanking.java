package Files_and_Exceptions;
/*
 *12.31 (Baby name popularity ranking) The popularity ranking of baby names from 
 years 2001 to 2010 is downloaded from www.ssa.gov/oact/babynames and stored 
 in files named babynameranking2001.txt, babynameranking2002.txt, . . . , 
 babynameranking2010.txt. Each file contains one thousand lines. Each line 
 contains a ranking, a boy’s name, number for the boy’s name, a girl’s name, 
 and number for the girl’s name. For example, the first two lines in the file 
 babynameranking2010.txt are as follows:
 So, the boy’s name Jacob and girl’s name Isabella are ranked #1 and the boy’s 
 name Ethan and girl’s name Sophia are ranked #2. 21,875 boys are named 
 Jacob and 22,731 girls are named Isabella. Write a program that prompts the 
 user to enter the year, gender, and followed by a name, and displays the ranking 
 of the name for the year. Here is a sample run:

 Enter the year: 2010
 Enter the gender: M
 Enter the name: Javier
 Javier is ranked #190 in year 2010
 Enter the year: 2010
 Enter the gender: F
 Enter the name: ABC
 The name ABC is not ranked in year 2010

 */
import java.util.*;
import java.io.*;
public class BabyRanking
	{
		//static File babyYear;
		static Scanner input = new Scanner(System.in);
		static ArrayList<String> listname;
		static String searchName;
		static int year;
		static String[] list;


		public static void main(String[] edus)
			{
				System.out.println("\nThis program lists top 10 baby popularity ranking from 2013-2017.\n");

				System.out.print("Enter year (2013-2017): ");
				year = input.nextInt();

				//System.out.print("Enter gender (m or f): ");
				//Character gender = input.next().charAt(0);
				System.out.print("Enter baby name: ");
				searchName = input.next();

				String babyfile = "Baby Ranking " + year + ".txt";
				String path = "/storage/emulated/0/AppProjects/com.edus.java/";
				File file = new File(path + babyfile);
				try
					{
						scanFile(file);
					}
				catch (Exception e)
					{
						//System.out.println(file.getName() + " not found or renamed.");
						e.printStackTrace();}
			}

		static File scanFile(File file) throws Exception
			{
				//String babyname = "";
				String rank="";
				String male="";
				String female="";
				try(Scanner scan = new Scanner(file)){
						listname = new ArrayList<>();
						while (scan.hasNext())
							{
								rank = scan.next();
								male = scan.next();
								female = scan.next();
								//System.out.printf("%s %s %s\n", rank, male, female);
						//scan.close();
								if (searchName.equals(male) || female.equals(searchName)|| rank.equals(searchName) )
									{
										System.out.println(searchName + " was ranked " + (searchName.indexOf(searchName) + 1));
										//break;
									}
								else{
										System.out.println("Sorry. " + searchName + " wasn't ranked in " + year);
										end();
									}
					}
					//scan.close();
						
						scan.close();
					}
				return file;
			}
	
		static void end() throws InterruptedException
			{
				System.out.println("Terminating...");
				Thread.sleep(2200);
				System.exit(1);
			}
	}
