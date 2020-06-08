/**
 * Sieve.java
 *
 * program description
 *
 * @author Given Tanri, Yeting Li
 * Wheaton College, CSCI 235, Spring 2020
 * Lab3
 * Feburary 11, 2020
 */

/*
Sieve is a program that prints prime numbers up to a maximum limit defined by SIEVE_LIMIT.

This program employs the Sieve of Eratosthenes algorithm to determine if a number is prime;
the algorithm checks if a number is divisible by a smaller divisor, 
then assign false to a divisible number.

This program uses a boolean array, with the index being the number checked. 
The array value corresponds whether the index number is prime (true) or not (false).
*/

public class Sieve {

    public static final int SIEVE_LIMIT = 100;

    public static void main(String[] args) {
		
		//initialize array, limit + 1 because index starts at 0
		boolean[] sieve = new boolean[SIEVE_LIMIT+1];
	
		//assume all numbers are prime
		for (int i = 0; i < sieve.length; i++) { //index loop
		    sieve[i] = true;
		}

		//Sieve algorithm: check if a number is divisible by any smaller number,
		//   then set array value to false if the above condition is true
		for (int i = 2; i < sieve.length; i++) { //index loop to check a number
		    for (int j = 2; j < i; j++) { //index loop for smaller divisor
			if (i % j == 0) {
			    sieve[i] = false; 
			}
		    }	
		}
		
		//Print prime numbers
		for (int i = 2; i < sieve.length; i++) {
		    if (sieve[i]) {
			System.out.print(i + " ");
		    }
		}
		System.out.println();
		
		

    }
}

