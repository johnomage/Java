package EventDrivenProgAndAnim;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class ObservablePropertyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleProperty balance = new SimpleDoubleProperty();
		balance.addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				// TODO Auto-generated method stub
				System.out.println("The new balance is "+ balance.doubleValue());
			}
		});
		
		balance.set(4.5);
	}

}
