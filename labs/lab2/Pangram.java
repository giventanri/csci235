/**
 * Pangram.java
 *
 * Program to test if a given string is a palindrome
 *
 * @author Given Tanri, John McCloskey
 * Wheaton College, CSCI 235, Spring 2020
 * Lab 2
 * Date 20200128
 */

import java.util.Scanner;

public class Pangram {

    public static void main(String[] args) {
      
	// for input from keyboard
	Scanner keyboard = new Scanner(System.in);

	System.out.print("Please enter a word for testing: ");

	// the string to test
	String str = keyboard.nextLine();

	System.out.println ("You entered: " + str);
	
	//Start of our code
	String letters = "abcdefghijklmnopqrstuvwxyz";
	String tempstr = str; //tempstr is original str to be printed 

	//Convert all to lowercase
	str = str.toLowerCase();

	//Remove non-letter, store to myStr
	String myStr = "";
	int i = 0;
	int n = str.length();

	while(i < n){
	    if(letters.indexOf(str.charAt(i)) > -1){
		myStr = myStr + str.charAt(i);
	    }
	    i++;
	}

	str = myStr;

	//Check for all 26 alphabet letters
	
	boolean isPangram = true;
	n = letters.length();
	i = 0;
      
	while(i < n){
	    if(str.indexOf(letters.charAt(i)) == -1){
		isPangram = false;
		i = n;
	    }
	    i++;
	}

	if(isPangram){
	    System.out.println(tempstr + " is a pangram.");
		} else {
	    System.out.println(tempstr + " is not a pangram.");
	}
		
	
	
    }
}
