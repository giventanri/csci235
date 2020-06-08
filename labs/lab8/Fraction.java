/**
 * Fraction.java
 *
 * Class to model fractions as a type.
 * 
 * @author TVD/CGG/HK and Given Tanri
 * CS 235, Wheaton College, Spring 2020
 * Lab 8
 * 20200331
 */

public class Fraction {	
    /**
     * The numerator of the fraction
     */
    private int numer;
    
    /**
     * The denominator of the fraction
     */
    private int denom;
    
    /**
     * Constructor. Set up this Fraction object.
     * @param n The numerator value
     * @param d The denominator value
     * PRECONDITION: d != 0
     */
    public Fraction(int n, int d) {
        numer = n;
        denom = d;
	simplify();
    }

    /**
     * Convert this fraction to a string.
     * @return A string displaying this fraction.
     */
    public String toString() {
        return ("" + numer + "/" + denom);
    }

    /**
     * Convert a fraction to a double.
     * Cast and divide.
     * @return The double value closest to this fraction
     */
    public double asDouble() {
        return (double)numer/denom;
    }
    
    /**
     * Make a fraction equivalent but in simplest form.
     * Divide both numerator and denominator by their greatest common divisor;
     * also ensure that the denominator is positive (which looks better).
     */
    private void simplify() {
	int factor = gcd(numer, denom); 
	numer /= factor;
	denom /= factor;
	if (denom < 0) {
	    denom += 2 * denom; 
	    numer -= 2 * numer;
	} 
    }
    
    /**
     * Find the fraction that is the sum of these fractions.
     * @param other The other addend
     * @return The sum fraction.
     */
    public Fraction sum(Fraction other) {

	// a/b + c/d = ad/bd + bc/bd = (ad + bc)/bd

	int a = this.numer;
	int b = this.denom;
	int c = other.numer;
	int d = other.denom;
	
	int num = a*d + b*c;
	int den = b*d;
	
        return new Fraction(num, den); 
    }

    /**
     * Find the fraction that is the difference between these fractions.
     * @param other The subtrahend fraction.
     * @return Another fraction, the difference of this and other.
     */    
    public Fraction diff(Fraction other) {
	
	// a/b - c/d = ad/bd - bc/bd = (ad - bc)/bd
	
	int a = this.numer;
	int b = this.denom;
	int c = other.numer;
	int d = other.denom;
	
	int num = a*d - b*c;
	int den = b*d;
	
        return new Fraction(num, den); 
    }
    
    /**
     * Find the fraction that is the product of these fractions.
     * @param other The other factor fraction.
     * @return Another fraction, the product of the two given.
     */
    public Fraction product(Fraction other) {
		int n = this.numer * other.numer;
		int d = this.denom * other.denom;
		Fraction out = new Fraction(n, d);
		return out;
        //return new Fraction(this.numer * other.numer, this.denom * other.denom); 
    }
    
    /**
     * Find the reciprocal of this fraction.
     * @return The reciprocal.
     * PRECONDITION: this is not zero
     */
    private Fraction reciprocal() {
        return new Fraction(denom, numer); 
    }

    /**
     * Find the fraction that is the quotient of these fractions.
     * Compute the reciprocal of other, then call product().
     * @param other The divisor fraction
     * @return The quotient of this divided by other.
     * PRECONDITION: other is not zero
     */    
    public Fraction quotient(Fraction other) {
        return product(other.reciprocal());
    }



    /**
     * Find the greatest common divisor (gcd) of two integers.
     * Since this method does not make use of instance variables
     * (not directly, anyway), it may as well be static.
     * @param a The first int
     * @param b The second int
     * @return The gcd of a and b
     */
    private static int gcd(int a, int b) {
	// Note: this version of gcd works for all pairs of int values,
	//  not just positive;
	//  returns n for gcd(n, 0) or gcd(0, n)
	a = Math.abs(a);
	b = Math.abs(b);
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
