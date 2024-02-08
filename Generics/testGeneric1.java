package Generics;

import java.util.Date;
import java.util.Stack;

public class testGeneric1 {

	public static void main(String[] args) {

		Comparable<Date> c = new Date();
		Stack<Object> stack = new Stack<>();
		for(int i=0; i<30; i+=1.5) {
			stack.push(2*i + 1);
			stack.push("Man");
		}
		
		System.out.print(stack);
		stack.pop();
		stack.pop();
		System.out.println();
		System.out.print(stack);
	}

}
