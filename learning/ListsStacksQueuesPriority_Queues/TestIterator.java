package ListsStacksQueuesPriority_Queues;

import java.util.ArrayList;
import java.util.Iterator;

public class TestIterator {

	public static void main(String[] args) {
		ArrayList<String> city1 = new ArrayList<>();
		city1.add("New York");
		city1.add("Atlanta");
		city1.add("Dallas");
		city1.add("Madison");
		
		Iterator<String> iterator = city1.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next().toUpperCase() + " ");
		}
		System.out.println();
		
		for(String city : city1) {
			System.out.print(city.toUpperCase() + " ");
		}
	}

}
