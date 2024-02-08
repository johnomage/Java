package binary_IO;

import java.io.*;

public class TestObjectStreamForArray {

	public static void main(String[] args) throws IOException {
		int[] studentID = {1232, 3321, 0012, 3323, 5505};
		String[] studentName = {"John", "Seyi", "Praise", "Four", "Max"};
		String[] role = {"President", "Vice President", "Director", "Head Department", "Finance"};
		int[] year = {2020, 2012, 2014, 2016, 2015};
		
		try (
				ObjectOutputStream output = new ObjectOutputStream((new FileOutputStream("StudentFile.dat", true)));
				ObjectInputStream input = new ObjectInputStream((new FileInputStream("StudentFile.dat")));
					){
			output.writeObject(studentID);
			output.writeObject(studentName);
			output.writeObject(role);
			output.writeObject(year);
		
		int[] id = (int[]) (input.readObject());
		String[] name = (String[]) (input.readObject());
		String[] roles = (String[])(input.readObject());
		int activeYear[] = (int[])(input.readObject());
		
		System.out.println("Student Profile\n-----------------------\nID\tName\tRole\tYear\n");
		for(int i=0; i<id.length; i++) {
			System.out.println(id[i] + "\t" + name[i] + "\t" + roles[i] + "\t" + activeYear[i]);
			}
		}
		
		catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}

}
