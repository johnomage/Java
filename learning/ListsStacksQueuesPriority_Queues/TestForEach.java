package ListsStacksQueuesPriority_Queues;

import java.util.ArrayList;

public class TestForEach {

	public static void main(String[] args) {
		ArrayList<String> city1 = new ArrayList<>();
		city1.add("New York");
		city1.add("Atlanta");
		city1.add("Dallas");
		city1.add("Madison");
		
		city1.forEach(e-> System.out.print(e.toUpperCase() + " "));
		
		System.out.println();
		
		ArrayList<StringBuilder> city2 = new ArrayList<>();
		city2.add(new StringBuilder("new York"));
		city2.add(new StringBuilder("atlanta"));
		city2.add(new StringBuilder("dallas"));
		city2.add(new StringBuilder("madison"));

		city2.forEach(e-> System.out.print(e.toString().replace(e.toString().charAt(0), e.toString().toUpperCase().charAt(0)) + " "));
		city2.forEach(e-> System.out.println(e.toString().toLowerCase()));
	}

}
