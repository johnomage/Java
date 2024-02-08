package Generics;

import java.util.Stack;

import javafx.scene.shape.Rectangle;

public class AnyWildCardDemo {

	public static void main(String[] args) {
//		GenericStack<String> a = new GenericStack<>();
		Stack<Integer>  intStack = new Stack<>();
		Stack<Rectangle> rectangles = new Stack<>();
		intStack.push(0);
		intStack.push(1);
		intStack.push(-1);
		
		rectangles.push(new Rectangle(3, 4));
		rectangles.push(new Rectangle(12,13, 4,5));
		rectangles.push(new Rectangle(7, 8));
		
		print(intStack);
		System.out.println();
		print(rectangles);

	}

	static void print(Stack<?> array) {
		// TODO Auto-generated method stub
		System.out.println(array);
		
		while(!array.isEmpty())
			System.out.print(array.pop() + " ");
		
	}

}
