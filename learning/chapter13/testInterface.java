package chapter13;//package com.edus.chapter13;

public class testInterface
{
	public static void main (String[] edus){
			Object[] object = {new Tiger(), new Chicken(), new Apple()};
				for(Object i: object){
					if(i instanceof Animal){
						System.out.println(((Animal)i).Sound());
					}
					
					if(i instanceof Fruits){
						System.out.println(((Edible)i).howToEat());
					}
			}
		}
}

abstract class Animal implements Edible{ //ANIMAL CLASS
	public abstract String Sound();
}

abstract class Fruits implements Edible { //FRUIT CLASS
	abstract public String howToEat();
}


class Tiger extends Animal{ //TIGER CLASS
	@Override
	public String Sound(){
	return "Tiger: RRRAAOOAAOOARR";
		}
	@Override
	public String howToEat(){
		return "To eat Tiger? No idea!";
	}
}

class Chicken extends Animal implements Edible{
	@Override
	public String Sound(){
		return "Chicken sound: koo koo ru kuuuuuuuu";
		}
	@Override
	public String howToEat(){
		return "Eating chicken: Fry it!";
	}
}

class Apple extends Fruits{ //APPLE CLASS
	@Override
	public String howToEat(){
		return "Eat apple: Slice and eat it";
	} 
}

