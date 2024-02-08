package Generics;

public class ComplexMatrix extends GenericMatrix<ComplexNumber>  {

	@Override
	protected ComplexNumber add(ComplexNumber z1, ComplexNumber z2) {
		return z1.add(z2);
	}

	@Override
	protected ComplexNumber multiply(ComplexNumber z1, ComplexNumber z2) {
		return z1.multiply(z2);
	}
 
	@Override
	protected ComplexNumber zero() {
		return new ComplexNumber();
	}
	
} 