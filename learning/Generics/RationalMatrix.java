package Generics;

public class RationalMatrix extends GenericMatrix<Rational> {

	@Override
	protected Rational add(Rational object1, Rational object2) {
		return object1.add(object2);
	}

	@Override
	protected Rational multiply(Rational object1, Rational object2) {
		return object1.multiply(object2);
	}

	@Override
	protected Rational zero() {
		return new Rational(0, 1);
	}

}
