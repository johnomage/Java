package ListsStacksQueuesPriority_Queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("red", "yellow", "green");
		List<String> list2 = Arrays.asList("red", "yellow", "blue");
		
		ArrayList<String> list = new ArrayList<>();
		for(String s: list1) {
			list.add(s);
		}
		
		System.out.println("list1: " + list + "\nlist2" + list2);
//		list.addAll(list2);
//		System.out.println("list1 addAll list2: " + list);
		
//		list.removeAll(list2);
//		System.out.println("list1 add All list2: " + list);
		
//		list.retainAll(list2);
//		System.out.println("list1 retainAll list2:  " + list);
		
//		list.add(list2);
//		System.out.println("list1 retainAll list2:  " + list);

	}

}
