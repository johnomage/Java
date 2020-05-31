package Generics;

import java.util.ArrayList;

public class samllestInList<E> {
	ArrayList<E> integers, doubles, strings, characters;

	public static void main(String[] args) {
		ArrayList<Double> doubles = new ArrayList<>();
		for(int i=0; i<15; i++)
			doubles.add(Math.random()*8);
		
		ArrayList<Integer> integers = new ArrayList<>();
		for(int i=0; i<15; i++)
			integers.add((int)(Math.random()*138));
		
		ArrayList<String> strings = new ArrayList<>();
		strings.add("Love");
		strings.add("LOVE");
		strings.add("game");
		strings.add("Man2"+"Man");
		
		
		print(integers);
		
	}
	
	public static<E extends Comparable<E>> E min(ArrayList<E> list) {
		E min = list.get(0);
		for(int i=0; i<list.size(); i++) {
			if(min.compareTo(list.get(i)) > 0)
				min = list.get(i);
		}
		return min;
	}
	
	public static void print(ArrayList list) {
		System.out.println("List: "+ list + "\nMinimum value: "+ min(list));
	}
	
}