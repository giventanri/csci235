/**
 * FractionsDriver.java
 * 
 * Driver program for a Fraction class.
 * Run this with four integer arguments: numerator1 denominator1 n2 d2
 *
 * @author TVD/CGG
 * CS 235, Wheaton College
 * Lab 8
 * 
 */

public class FractionsDriver {
    
    public static void main(String[] args) {
	
        // First fraction
        Fraction frac1 = 
            new Fraction(Integer.parseInt(args[0]), Integer.parseInt(args[1]));     

        // Second fraction
        Fraction frac2 = 
            new Fraction(Integer.parseInt(args[2]), Integer.parseInt(args[3]));

	System.out.println("f1 = "+frac1.toString()
			   +" ("+frac1.asDouble()+" as double)");
	System.out.println("f2 = "+frac2.toString()
			   +" ("+frac2.asDouble()+" as double)");
	
	// the sum of the two
        Fraction sum = frac1.sum(frac2);
        System.out.println("Sum: " + sum);

        // their difference
        Fraction diff = frac1.diff(frac2);
        System.out.println("Difference: " + diff);
        
        // their product
        Fraction product = frac1.product(frac2);
        System.out.println("Product: " + product);

        // their quotient
        Fraction quotient = frac1.quotient(frac2);
        System.out.println("Quotient: " + quotient);
    }
    
}
