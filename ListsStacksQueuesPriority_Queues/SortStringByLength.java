package ListsStacksQueuesPriority_Queues;

import java.util.*;

public class SortStringByLength {

	public static void main(String[] args) {
		List<String> cities = Arrays.asList("Atlanta", "Savannah123456", "New York", "Dallas");
//		Comparator.comparing(String::length);
//		cities.sort((s1, s2)->s1.length() - s2.length());
		
//		cities.sort((s1, s2) -> s1.compareTo(s2));
		
//		System.out.println("Sorting strings based on length:");
		
		for(String s: cities) {
			System.out.print(s + "(" + s.length() + ") " +  " ");
		}
		
		System.out.println();
		cities.sort(String::compareToIgnoreCase);
		System.out.println(cities);
//		cities.forEach(SortStringByLength()::new);
		cities.sort(Comparator.comparing(String::length));
		System.out.println(cities);
	}

}

class MyComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		return s1.length() - s2.length();
	}
	
}
