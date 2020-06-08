/**
 * PrintTens.java
 *
 * Program to print only multiples of 10 between two integers
 *
 * @author @giventanri @christiankim01 @nathanmarbella
 * Wheaton College, CSCI 235, Spring 2020
 * Lab 1
 * Date? 1 21 2020
 */

import java.util.Scanner;
 
public class PrintTens {
    public static void main(String[] args) {

		Scanner keyboard = new Scanner (System.in);	//to read numbers
		
		//read two integers from keyboard. 
		System.out.print ("Type the first integer: ");
		int m = keyboard.nextInt();
		keyboard.nextLine();
		
		System.out.print ("Type the second integer: ");
		int n = keyboard.nextInt();
		keyboard.nextLine();
		
		System.out.println ();
		
		int sum = 0;	//for adding integers 
		int i = 0; 		//for controlling the loop
		
		//add your code here.

		while(m<=n) {
		    if(m%10 == 0){
			System.out.println (m);
		    }
		    m=m+1;
		}
		
	     
		
		
		
		
    } 
}
