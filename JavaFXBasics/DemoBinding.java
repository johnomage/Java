package chapter14_JavaFXBasics;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
 
public class DemoBinding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleProperty value1 = new SimpleDoubleProperty();
		DoubleProperty value2 = new SimpleDoubleProperty(7);
		
		value1.bind(value2.divide(2));
		System.out.println(value2.getValue() );
		System.out.println(value1.getValue() );
	}

}
