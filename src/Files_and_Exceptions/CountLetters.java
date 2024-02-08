package Files_and_Exceptions;
/* **12.30 (Occurrences of each letter) Write a program that prompts the user to enter 
a file name and displays the occurrences of each letter in the file. Letters are 
case-insensitive. Here is a sample run:
Enter a filename: Lincoln.txt
Number of A's: 56 
Number of B's: 134 
...
Number of Z's: 9 */
import java.util.*;
import java.io.*;

public class CountLetters
{	static String[] list ;
	public static void main(String[] edupe){
		System.out.println("This program counts the characters, words and lines in a file.\n--------------------------------------------------------------\n");
		String filename;
		System.out.print("Enter filemane: ");
		Scanner scanner = new Scanner(System.in);
		filename = scanner.nextLine();
		File file = new File("C:\\Users\\Honeeks Inc\\eclipse-workspace\\learning\\zzFiles\\" + filename);
		
		int count=0; //word count
		int characters = 0; //characters count
		int lines=0; //lines count
		String word = "", run;
		
		int A=0, B=0, C=0, D=0, E=0, F=0, G=0, H=0,I=0,J=0,K=0,L=0,M=0,N=0,O=0,P=0,Q=0,R=0,S=0,T=0,U=0,V=0,W=0,X=0,Y=0,Z=0, zero=0,one=0,two=0,three=0,four=0,five=0,six=0,seven=0,eight=0,nine=0;
		char[] array;// = new Character[200];
		ArrayList<String>letter = new ArrayList<>();
		try{
			if(!file.exists()) {
//				file.createNewFile();
//				System.out.println(file.getName() + " not found");
				
			}
			Scanner scan = new Scanner(file);
			while(scan.hasNext()){
				word = scan.nextLine().toUpperCase();
				characters +=word.length();
				//word.toUpperCase();
				letter.add(word);
				
				array = word.toCharArray();
				for(char CHAR: array){
					switch(CHAR){
						case 'A': A++; break;
						case 'B': B++; break;
						case 'C': C++; break;
						case 'D': D++; break;
						case 'E': E++; break;
						case 'F': F++; break;
						case 'G': G++; break;
						case 'H': H++; break;
						case 'I': I++; break;
						case 'J': J++; break;
						case 'K': K++; break;
						case 'L': L++; break;
						case 'M': M++; break;
						case 'N': N++; break;
						case 'O': O++; break;
						case 'P': P++; break;
						case 'Q': Q++; break;
						case 'R': R++; break;
						case 'S': S++; break;
						case 'T': T++; break;
						case 'U': U++; break;
						case 'V': V++; break;
						case 'W': W++; break;
						case 'X': X++; break;
						case 'Y': Y++; break;
						case 'Z': Z++; break;
						case '0': zero++; break;
						case '1': one++; break;
						case '2': two++; break;
						case '3': three++; break;
						case '4': four++; break;
						case '5': five++; break;
						case '6': six++; break;
						case '7': seven++; break;
						case '8': eight++; break;
						case '9': nine++; break;
//						default: System.out.println(file.getName() + " is empty, no characters found"); break;
					}
				}
			}
			
		    list = letter.toArray(new String[letter.size()]);
		    System.out.print("\nFile in use: "+file.getName());
			System.out.println("Content:");
//			System.out.println(letter);
			System.out.println("\nCharacters found\n");
			System.out.println("'A' count: " + A + "\n'B' count: " + B + "\n'C' count: " + C + "\n'D' count: " + D );
			System.out.println("'E' count: " + E + "\n'F' count: " + F + "\n'G' count: " + G + "\n'H' count: " + H );
			System.out.println("'I' count: " + I + "\n'J' count: " + J + "\n'K' count: " + K + "\n'L' count: " + L );
			System.out.println("'M' count: " + M + "\n'N' count: " + N + "\n'O' count: " + O + "\n'P' count: " + P );
			System.out.println("'Q' count: " + Q + "\n'R' count: " + R + "\n'S' count: " + S + "\n'T' count: " + T );
			System.out.println("'U' count: " + U + "\n'V' count: " + V + "\n'W' count: " + W + "\n'X' count: " + X );
			System.out.println("'Y' count: " + Y + "\n'Z' count: " + Z + "\n'0' count: " + zero+ "\n'1' count: " + one+ "\n'2' count: " + two);
			System.out.println("'3' count: " + three + "\n'4' count: " + four+ "\n'5' count: " + five+ "\n'6' count: " + six+ "\n'7' count: " + seven);
			System.out.println("'8' count: " + eight + "\n'9' count: " + nine);

			try{
				Scanner find = new Scanner(file);
				while(find.hasNext()){
					run = find.next();
					count++; //increment word count
				}
			}
			catch(Exception y){}
			ArrayList<Integer> maxDigit = new ArrayList<Integer>();
			maxDigit.add(zero);
			maxDigit.add(one);
			maxDigit.add(two);
			maxDigit.add(three);
			maxDigit.add(four);
			maxDigit.add(five);
			maxDigit.add(six);
			maxDigit.add(seven);
			maxDigit.add(eight);
			maxDigit.add(nine);
			
			int max = 0; //Max digit in list/file
			int digit=0;
			for(int i=0; i<maxDigit.size(); i++) {
				if(maxDigit.get(i)>max) {
					max = maxDigit.get(i);
					digit = i;
				}
			}
			System.out.println("\nWord count: " + count);
			System.out.println("Digits count: " + (zero+one+two+three+four+five+six+seven+eight+nine));
			System.out.println("Maximum digit count: " + max +"\nDigit: '" + digit + "'");
			System.out.println("Character count: " +characters + "\n"+ "Line count: " +lines);
			System.out.println();
		}
		
		catch(Exception error){
			error.printStackTrace();
			System.out.println("\n'" + file.getName() + "' not found in working directory: "+ file.getParent() + "\nCheck spelling or make sure the file extension is included (e.g .txt, .xls).");
		}
	}
}
