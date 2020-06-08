/**
 * PrintNumbers.java
 *
 * Program to print numbers between two integers.
 *
 * @author @giventanri @christiankim01 @nathanmarbella
 * Wheaton College, CSCI 235, Spring 2020
 * Lab 1
 * Date? 1 21 2020
 */

import java.util.Scanner;
 
public class PrintNumbers {
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
		    System.out.println (m);
		    sum=sum+m;
		    m=m+1;
		}
		
		System.out.println (sum);
		
		
		
		
    } 
}
