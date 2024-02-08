package Generics;

public class Rational extends Number implements Comparable<Rational>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long numerator = 0;
	private long denominator = 1;
	
	public Rational() {
		this(0,1);
	}
	
	public Rational(long i, long j) {
		long gcd = gcd(numerator, denominator);
		this.numerator = ((denominator>0) ? 1 : -1) * numerator/gcd;
		this.denominator = Math.abs(denominator)/gcd;
	}

	private long gcd(long num, long den) {
		long n = Math.abs(num);
		long d = Math.abs(den);
		int gcd = 1;
		
		for(int i=1; i<=n/2 && i<=d/2; i++) {
			if(n%i == 0 && d%i == 0)
				gcd = i;
		}
		return gcd;
	}
	
	

	public long getNumerator() {
		return numerator;
	}

	public long getDenominator() {
		return denominator;
	}
	
	/** Add a rational number to this rational */
	public Rational add(Rational secondRational) {
		long n = numerator * secondRational.getDenominator() + denominator * secondRational.getNumerator();
		long d = denominator * secondRational.getDenominator();
		return new Rational(n, d);
	}
	
	/** Subtract a rational number from this rational */
	public Rational subtract(Rational secondRational) {
		long n = numerator * secondRational.getDenominator() - denominator * secondRational.getNumerator();
		long d = denominator * secondRational.getDenominator();
		return new Rational(n, d);
	}
	
	/** Multiply a rational number by this rational */
	public Rational multiply(Rational secondRational) {
		long n = numerator * secondRational.getNumerator();
		long d = denominator * secondRational.getDenominator();
		return new Rational(n, d);
	}
	
	/** Divide a rational number by this rational */
	public Rational divide(Rational secondRational) {
		long n = numerator * secondRational.getDenominator();
		long d = denominator * secondRational.numerator;
		return new Rational(n, d);
	}
	
	@Override
	public String toString() {
		if (denominator == 1)
			return numerator + "";
		else
			return numerator + "/" + denominator;
	}
	
	@Override // Override the equals method in the Object class
	public boolean equals(Object other) {
		if ((this.subtract((Rational)(other))).getNumerator() == 0)
			return true;
		else
			return false;
	}
	
	@Override // Implement the abstract intValue method in Number
	public int intValue() {
		return (int)doubleValue();
	}
	
	@Override // Implement the abstract floatValue method in Number
	public float floatValue() {
		return (float)doubleValue();
	}
	
	@Override // Implement the doubleValue method in Number
	public double doubleValue() {
		return numerator * 1.0 / denominator;
	}
	
	@Override // Implement the abstract longValue method in Number
	public long longValue() {
		return (long)doubleValue();
	}
	
	@Override // Implement the compareTo method in Comparable
	public int compareTo(Rational o) {
		if (this.subtract(o).getNumerator() > 0)
			return 1;
		else if (this.subtract(o).getNumerator() < 0)
			return -1;
		else
			return 0;
	}
}