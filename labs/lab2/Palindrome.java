/**
 * Palindrome.java
 *
 * Program to test if a given string is a palindrome
 *
 * @author Given Tanri, John McCloskey
 * Wheaton College, CSCI 235, Spring 2020
 * Lab 2
 * Date 20200128
 */

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {
      
	// for input from keyboard
	Scanner keyboard = new Scanner(System.in);

	System.out.print("Please enter a word for testing: ");

	// the string to test
	String str = keyboard.nextLine();

	System.out.println ("You entered: " + str);

	// add your code here to tell whether the String str is a palindrome
	
	int i = 0;
	int n = str.length();
	boolean isPalindrome = true;
	
	while(i < n){
	    if( str.charAt(i) != str.charAt(n-1-i) ){
		isPalindrome = false;
		i = n;
	    }
	    i++;
	}

	if(isPalindrome){
	    System.out.println(str + " is a palindrome.");
		} else {
	    System.out.println(str + " is not a palindrome.");
	}
		
	
	
    }
}
