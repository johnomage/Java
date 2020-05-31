package Generics;

import java.util.ArrayList;

public class ShuffleArrayLIst<E> {

	public static void main(String[] args) {
		//create doubles arraylist
		ArrayList<Double> doubles = new ArrayList<>();
		for(int i=0; i<15; i++)
			doubles.add(Math.random()*8);
		
		//create integers arraylist
		ArrayList<Integer> integers = new ArrayList<>();
		for(int i=0; i<15; i++)
			integers.add((int)(Math.random()*138));
		
		//create strings arraylist
		ArrayList<String> strings = new ArrayList<>();
		strings.add("Love");
		strings.add("LOVE");
		strings.add("game");
		strings.add("Man2"+"Man");
		
		print(strings);
		shuffle(strings);
		
	}
	
	public static<E> void shuffle(ArrayList<E> list) {
		E min = list.get(0);
		for(int i=0; i<list.size(); i++) {
			int index = (int) (Math.random()*list.size());
			E temp = list.get(i);
			list.set(i, list.get(index));
			list.set(index, temp);
		}
		print(list);
	}
	
	public static <E> void print(ArrayList<E> list) {
		for (int i = 0; i < list.size(); i++)
		System.out.print(list.get(i) + " ");
		System.out.println();
		}
	
}