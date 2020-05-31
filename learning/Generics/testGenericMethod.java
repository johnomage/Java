package Generics;

public class testGenericMethod {

	public static void main(String[] args) {
		Integer[] integers = {1,2,3,4,5};
		String[] strings = {"London", "Paris", "New York", "Austin"};
		
		testGenericMethod.<Integer>print(integers);
		testGenericMethod.<String>print(strings);
		print(strings);
	}
	
	public static <E> void print(E[] list) {
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
			System.out.println();
	}

}
