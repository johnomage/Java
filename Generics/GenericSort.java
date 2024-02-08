package Generics;

public class GenericSort {

	public static void main(String[] args) {
		Integer[] intArray = {new Integer(5), new Integer(2), new Integer(6)};
		Double[] doubleArray = {new Double(3.4), new Double(1.3), new Double(-22.1)};
		Character[] charArray = {new Character('r'), new Character('a'), new Character('J'), new Character('j')};
		String[] stringArray = {"great", "Edupe", "Is"};
		Integer addInt[] = new Integer[5];
		
		sort(intArray);
		sort(doubleArray);
		sort(charArray);
		sort(stringArray);
		
		
		System.out.print("Sorted Integer objects: ");
		printlist(intArray);
		System.out.print("Sorted Double objects: ");
		printlist(doubleArray);
		System.out.print("Sorted Character objects: ");
		printlist(charArray);
		System.out.print("Sorted String objects: ");
		printlist(stringArray);
		

	}

	private static <E> void printlist(E[] array) {
		for(int i=0; i<array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println();
		
	}

	public static<E extends Comparable<E>> void sort(E[] array) {
		E currentMin;
		int currentMinIndex;
		
		for(int i=0; i<array.length; i++) {
			currentMin = array[i];
			currentMinIndex = i;
			
			for(int j=i+1; j<array.length; j++) {
				if(currentMin.compareTo(array[j]) > 0) {
					currentMin = array[j];
					currentMinIndex = j;
				}
			}
			
			if(currentMinIndex != i) {
				array[currentMinIndex] = array[i];
				array[i] = currentMin;
			}
			
		}
		
	}
	
	

}
