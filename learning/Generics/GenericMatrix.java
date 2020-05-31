package Generics;

public abstract class GenericMatrix <E> {

	protected abstract E add(E object1, E object2);

	protected abstract E multiply(E object1, E object2 );

	protected abstract E zero ();

	public E[][] addMatrix(E[][] matrix1, E[][] matrix2){
		if(matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
			throw new RuntimeException("The matrices do not have the same size");
		}

		E[][] result = (E[][]) new Object[matrix1.length][matrix1[0].length];

		for(int i=0; i<result.length; i++) {
			for(int j=0; j<result[0].length; j++)
				result[i][j] = add(matrix1[i][j], matrix2[i][j]);
		}

		return result;
	}

	//MULTIPLY MATRICES
	public E[][] multiplyMatrix(E[][] matrix1, E[][] matrix2){
		if(matrix1[0].length != matrix2.length) {
			throw new RuntimeException("The matrices do not have the same size");
		}

		E[][] result = (E[][]) new Number[matrix1.length][matrix2[0].length];

		for(int i=0; i<result.length; i++) {
			for(int j=0; j<result[0].length; j++) {
				result[i][j] = zero();

				for(int k=0; k<matrix1[0].length; k++) {
					result[i][j] = add(result[i][j], multiply(matrix1[i][k], matrix2[k][j])); //RECURSIVE, WHAT IS THIS?
				}
			}
		}

		return result;
	}

	//PRINT MATRICES OPERATIONS
	public static<E> void printResult(E[][] n1, E[][] n2, E[][] n3, char op) {
		for(int i=0; i<n1.length; i++) {
			for(int j=0; j<n1[0].length; j++)
				System.out.print("  " + n1[i][j]);
			if(i == n1.length/2)
				System.out.print("  " + op + "  ");
			else
				System.out.print("   ");

			for(int j=0; j<n2.length; j++)
				System.out.print(" " + n2[i][j]);

			if (i == n1.length/2)
				System.out.print(" = ");
			else
				System.out.print("       ");
			
			for(int j=0; j<n3.length; j++)
				System.out.print(n3[i][j] + " ");
			
			System.out.println();
		}
	}
}
