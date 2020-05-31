package Generics;

public class IntegerMatrix extends GenericMatrix<Integer> {

	@Override
	protected Integer add(Integer object1, Integer object2) {
		return object1 + object2;
	}

	@Override
	protected Integer multiply(Integer object1, Integer object2) {
		return object1 * object2;
	}

	@Override
	protected Integer zero() {
		return 0;
	}
	
}
