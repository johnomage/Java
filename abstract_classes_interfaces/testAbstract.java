package chapter13;//package com.edus.Abstract.classes;
//package com.edus.abstract_classes;

public class testAbstract
	{
		public static void main(String[] edus){
		testRun test = new testRun();
		System.out.println( test.getValue());
		sentence seek = new testRun(); //wow
		System.out.println("Value set to " + seek.setValue(5));
		test.print("Main man");

			}
	}

abstract class sentence{
	private String string;
	private int value = 4;
	
	protected sentence(){
		}

	public int setValue(int value)
		{
			return this.value = value;
		}

	public int getValue()
		{
			return value;
		}
		public void print(String string){
			this.string = string;
				System.out.println(string);
			}
	}	
	
class testRun extends sentence{
	 testRun(){
		 //super();
	 }
}
