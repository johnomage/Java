package chapter14_JavaFXBasics;

import javax.swing.JOptionPane;
public class JPane {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String number1 = JOptionPane.showInputDialog("Enter first number");
		String number2 = JOptionPane.showInputDialog("Enter second number");
		
		int N1 = Integer.parseInt(number1);
		int N2 = Integer.parseInt(number2);
		int sum = N1 + N2;
		String title = "The sum of " + N1 + " and " + N2;
		JOptionPane.showMessageDialog(null, "The answer is " + sum, title, JOptionPane.OK_OPTION);
		
	}

}
