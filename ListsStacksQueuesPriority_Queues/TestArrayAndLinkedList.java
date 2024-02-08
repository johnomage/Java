package ListsStacksQueuesPriority_Queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TestArrayAndLinkedList {

	public static void main(String[] args) {
		ArrayList<Object> arrayList = new ArrayList<>();
		arrayList.add(1);
		arrayList.add(3);
		arrayList.add(2);
		arrayList.add(1);
		arrayList.add(4);
		arrayList.add(0, 10);
		arrayList.add("Life");
		arrayList.add(3, 30);
		
		System.out.print("A list of integers in the array list: ");
		System.out.println(arrayList);
		
		LinkedList<Object> linkedList = new LinkedList<>(arrayList);
		linkedList.add(2, "Red");
		linkedList.removeLast();
		linkedList.addFirst("Green");
		
		System.out.println("Display the linked list forward:");
		
		ListIterator<Object> iterator = linkedList.listIterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		
		System.out.println();
		
		System.out.println("Display the linked list backward:");
			
		ListIterator<Object> counter = linkedList.listIterator(linkedList.size());
		
		while(counter.hasPrevious()) {
			System.out.print(counter.previous() + " ");
		}
		
		System.out.println();
		
		System.out.println("Testing another linkedliast:");
		
		List<Object> list = new LinkedList<>(arrayList);
		list.add("new object 1");
		list.add('Q');
		list.remove(3);
		
		list.forEach(e-> System.out.print(e.toString() + " "));

	}

}
