package ListsStacksQueuesPriority_Queues;

import java.util.ArrayList;

public class TestCollection {

	public static void main(String[] args) {
		ArrayList<String> city1 = new ArrayList<>();
		city1.add("New York");
		city1.add("Atlanta");
		city1.add("Dallas");
		city1.add("Madison");
		
		System.out.println("A list of cities in city1: " + city1);
		System.out.println("\nIs Dallas in city1: " + city1.contains("Dallas"));
		
		ArrayList<String> city2 = new ArrayList<>();
		city2.add("Seattle");
		city2.add("Portland");
		city2.add("Los Angeles");
		city2.add("Atlanta");
		System.out.println("\nA list of cities in city2: " + city2);
		
		ArrayList<String> clone1 = (ArrayList<String>) (city1.clone());
		clone1.addAll(city2);
		System.out.println("\nA list of cities in city1 or city2: " + clone1);
		
		clone1 = (ArrayList<String>) city1.clone();
		clone1.retainAll(city2);
		System.out.println("\nA list of cities in city1 and city2: " + clone1);
		
		clone1 = (ArrayList<String>) city1.clone();
		clone1.removeAll(city2);
		System.out.println("\nCities in city1, but not in city2: " + clone1);
	}

}
