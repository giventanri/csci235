
/**
 * PrintEvens.java
 *
 * Print positive even numbers.
 *
 * @author HK
 * CSCI235, Spring 2020
 * Lab #0
 *
 * Test 
 */

public class PrintEvens { 

    public static void main(String[] args) {

	int limit = 100;     // for even numbers up to limit
	int n = 1; 	    // to control loop
	       

	System.out.println("Printing positive even numbers up to " + limit);

	while (2*n <= limit) {
	    
	    System.out.println(2*n);
	    n = n + 1;
		
	}
    }
	
    
}
