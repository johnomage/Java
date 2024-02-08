package chapter13;//package com.edus.chapter13;

abstract class Shapes
{
	double length =4, width = 3, radius = 3.3, PI=22.0/7;
	abstract double getArea();
	abstract double getPerimeter();

		@Override
		public String toString()
			{
				// TODO: Implement this method
				return super.toString();
			}
	
	
}

public class TestShapes implements Cloneable{
	public static void main(String edus []){
		Shapes rectangle = new Rectangle();
		Shapes circle = new Circle();
		//Circle circle1 = (Circle)circle.clone();
		
		System.out.println();
		System.out.println(rectangle.getArea());
	}
}

class Rectangle extends Shapes implements Comparable <Rectangle>
	{

		@Override
		double getArea()
			{
				// TODO: Implement this method
				System.out.print("Reactangle area is: ");
				return length*width;
			}

		@Override
		double getPerimeter()
			{
				// TODO: Implement this method
				
				return 2*length*width;
			}

		@Override
		public int compareTo(Rectangle p1)
			{
				// TODO: Implement this method
				if(getArea() > new Circle().getArea())
					return 1;
		
				else if(getArea() < new Circle().getArea())
					return -1;
				
				else return 0;
			}

		@Override
		public String toString()
			{
				// TODO: Implement this method
				return "Testing things";
			}
		
		
}

class Circle extends Shapes implements Comparable<Circle>
	{

		@Override
		double getArea()
			{
				// TODO: Implement this method
				return PI*radius*radius;
			}

		@Override
		double getPerimeter()
			{
				// TODO: Implement this method
				return 2*PI*radius;
			}

		@Override
		public int compareTo(Circle p1)
			{
				// TODO: Implement this method
				if(getPerimeter()>new Rectangle().getPerimeter())
					return 1;
				else return 0;
			}
			
		public double compareTo(double d)
			{
				// TODO: Implement this method
				if(getPerimeter()>new Rectangle().getPerimeter())
					return 1;
				else return 0;
			}

}
