
/**
 * PrintOdds.java
 *
 * Print positive odd numbers.
 *
 * @author Given Tanri
 * CSCI235, Spring 2020
 * Lab 0
 * 20200114
 *  
 */

public class PrintOdds { 

    public static void main(String[] args) {

	int limit = 10;     // for even numbers up to limit
	int n = 1; 	    // to control loop
	       

	System.out.println("Printing positive even numbers up to " + limit);

	while (2*n <= limit) {
	    
	    System.out.println(2*n-1);
	    n = n + 1;
		
	}
    }
	
    
}
