package Generics;

public class Exercise_19_11 {

	public static void main(String[] args) {
		ComplexNumber[][] z1 = new ComplexNumber[3][3];
		ComplexNumber[][] z2 = new ComplexNumber[3][3];
		
		for(int i=0; i<z1.length; i++) {
			for(int j=0; j<z1[0].length; j++) {
				z1[i][j] = new ComplexNumber(i + 1, j + 5);
				z2[i][j] = new ComplexNumber(i + 1, j + 6);
			}
		}
		
		ComplexMatrix complex = new ComplexMatrix();
		System.out.println("z1 + z2: ");
		GenericMatrix.printResult(z1, z2, complex.addMatrix(z1, z2), '+');
	}

}
