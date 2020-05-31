package Generics;

import java.util.Stack;

public class SuperWildCardDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer>  intStack = new Stack<>();
		Stack<Object> objects = new Stack<>();
		intStack.push(0);
		intStack.push(1);
		intStack.push(-1);
		
		objects.push("java");
		objects.push('M');
		objects.push(Math.PI);
		
		add(intStack, objects);
		AnyWildCardDemo.print(objects);

	}

	public static<T> void add(Stack<T> stack1, Stack<? super T> stack2) {
		// TODO Auto-generated method stub
		while(!stack1.isEmpty())
			stack2.push(stack1.pop());
	}
	
	public static <T extends Comparable<T>> void sort(Stack<T> array) {
		AnyWildCardDemo.print(array);
	}

}
