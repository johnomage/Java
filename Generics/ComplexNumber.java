package Generics;

import java.util.HashSet;
import java.util.Set;

public class ComplexNumber implements Cloneable {
	private double real, img;
	protected final String root1 = "i";
	
	public ComplexNumber() {
		this(0,0);
	}
	
	public ComplexNumber(double a){
		this(a,0);
	}
	
	public ComplexNumber(double a, double b){
		this.real = a;
		this.img = b; //a + bi;
	}
	
	public ComplexNumber(ComplexNumber c) {
		copy(c);
	}
	
	
	//COMPARE COMPLEX NUMBERS
	public boolean compareComplex(Object obj) {
		try {
			ComplexNumber complex = (ComplexNumber) obj;
			return complex.real == real && complex.img == img;
		} catch (Exception e) {
			return false;
		}
	}
	
	//COPY COMPLEX NUMBER TO ANOTHER
	public void copy(ComplexNumber c) {
		if(c == null)
			real = img = 0;
		else {
			real = c.real;
			img = c.img;
		}
	}

	//RETURN REAL PART
	public double getReal() {
		return real;
	}
	
	//RETURN IMMAGINARY PART
	public double getImaginary() {
		return img;
	}
	
	//GET CONJUGATE
	public ComplexNumber conjugate() {
		return new ComplexNumber(real, -img);
	}
	
	//ADD MATRICES A+B
	public ComplexNumber add(ComplexNumber c) {
		return new ComplexNumber(real + c.real, img + c.img);
	}
	
	//add to real number
	public ComplexNumber add(double r) {
		return new ComplexNumber(real + r, img);
	}
	
	//add complex(r,i)
	public ComplexNumber add(double r, double i) {
		return new ComplexNumber(real + r, img + i);
	}
	
	//subtract from real number
	public ComplexNumber subtract(double r) {
		return new ComplexNumber(real - r, img);
	}
	
	//subtract from complex(r,i)
	public ComplexNumber subtract(double r, double i) {
		return new ComplexNumber(real - r, img - i);
	}
	
	//subtract complex c
	public ComplexNumber subtract(ComplexNumber c) {
		return new ComplexNumber(real - c.real, img - c.img);
	}
	
	//MULTIPLY MATRICES A*B
	public ComplexNumber multiply(ComplexNumber c) {
		return new ComplexNumber(c.real*real - c.img*img, c.real*img + c.img*real);
	}
	
	//multiply complex number by a double
	public ComplexNumber multiply(Double n) {
		return new ComplexNumber(n*real, n*img);
	}
	
	
	//ABSOLUTE VALUE OF MATRIX A
	public static double abs(ComplexNumber c) {
		return Math.sqrt(c.real*c.real + c.img*c.img);
	}
	
	//RETURN ABSOLUTE VALUE/MODULUS OF COMPLEX NUMBER
	public double abs() {
		return Math.sqrt(real*real + img*img);
	}
	
	//DIVIDE MATRICES A/B
	public ComplexNumber divide(ComplexNumber c) {
		double denominator = Math.pow(abs(c), 2);
		if(denominator == 0)
			return new ComplexNumber(1/0, 1/0);
		else {
			return new ComplexNumber((real*c.real + img*c.img)/denominator, (real*c.img - img*c.real)/denominator);
		}
	}
	
	//DIVIDE BY A REAL NUMBER
	public ComplexNumber divide(double n) {
		if(n == 0)
			return new ComplexNumber(real/0, img/0);
		else {
			return new ComplexNumber(real/n, img/n);
		}
	}
	
	//GET POLAR VALUE
	public static ComplexNumber polar(double r, double theta) {
		return new ComplexNumber(r*Math.cos(theta), r*Math.sin(theta));
	}
	
	//converting from polar form
	public ComplexNumber polar() {
		return new ComplexNumber(real*Math.cos(theta()), real*Math.sin(theta()));
	}
	
	//convert to polar
	public Set<Double> toPolar() {
		Set<Double> set = new HashSet<>();
		set.add(abs());
		set.add(theta());
		return set;
	}
	
	//GET CARTHESIAN ANGLE
	public double theta() {
		return Math.atan2(img, real);
	}
	
	//argument (angle) of a complex number
	public static double theta(ComplexNumber z) {
		return Math.atan2(z.real, z.img);
	}
	
	//exponential form of a complex number
	public ComplexNumber exponential() {
		double exp = Math.exp(real);
		return new ComplexNumber(exp*Math.cos(img), exp*Math.sin(img));
	}
	
	//RETURN INVERSE OF MATRIX A
	public ComplexNumber inverse() {
		return new ComplexNumber(real/abs(), -img/abs());
	}
	
	//inverse of a complex number
	public static ComplexNumber inverse(ComplexNumber c) {
		return new ComplexNumber(c.real/abs(c), -c.img/abs(c));
	}
	
	//logarithm of a complex number
	public ComplexNumber log() {
		return new ComplexNumber(Math.log(abs()), theta());
	}
	
	//complex number power
	public  ComplexNumber power(double n) {
		double re = Math.pow(abs(), n);
		double arg = n*theta();
		return new ComplexNumber(re*Math.cos(arg), re*Math.sin(arg));
	}
	
	//return string of cmplex number
	public String toString() {
		return img == 0 ? real + "" : real + " + " + img + root1;
	}

}
