package recursion;

import java.io.File;
import java.util.Scanner;

public class DirectorySize {
	static int count;
	static File[] content;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter a file or directory: ");
		String directory = input.nextLine();
		System.out.println(directory + " size is " + getSize(new File(directory)) + " Bytes.\nDirectory is "
				+ new File(directory).getAbsolutePath());
		System.out.println("Files count: " + count);
		System.out.println("\nView of files and/or folders\n-----------------------------\n");
		content();

	}

	private static long getSize(File file) {
		long size = 0;
		if (file.isDirectory()) {
			File[] subFiles = file.listFiles();
			for (int i = 0; i < subFiles.length; i++) {
				size += getSize(subFiles[i]); // recursion of getsize
				count++;
				content = subFiles;
			}
		}

		else
			size += file.length();
		
		return size;
	}
	
	protected static void content() {
		for(int i=0; i<content.length; i++) {
			System.out.println(content[i].getName());
		}
	}
}
