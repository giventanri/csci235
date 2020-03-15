/**
 * Cipher.java
 * 
 * Program to decipher messages encoded using a Caesar cipher.
 * 
 * @author TVD, CGG, and Given Tanri
 * Wheaton College, CSCI 235, Spring 2020
 * Project 12
 * Date 20200221
 */

import java.util.Scanner;
import java.io.*;

public class Cipher {

    public static void main(String[] args) {

        String ciphertext; // Encrypted text        
        Scanner keyboard = new Scanner(System.in); // Input from keyboard

        // Read input file, or otherwise prompt user to type encrypted text
        if (args.length > 0) {
            ciphertext = "";
            try {
                Scanner inputFile = new Scanner(new File(args[0]));
                while(inputFile.hasNext()) 
                    ciphertext += inputFile.nextLine();
            } catch(IOException ioe) {
                System.out.println("File not found: " + args[0]);
                System.exit(-1);
            }
        }
        else {
            System.out.print("Please enter text--> ");
            ciphertext = keyboard.nextLine(); 
        }

	// Return encrypted text input
	System.out.println("\t Input: ");
	System.out.println(ciphertext);
	System.out.println();

	int distance = 0;  // How far the ciphertext should be shifted
	String next = "";  // User input after viewing
        
	// Caesar cipher algorithm, loop until input "quit"
	while(!next.equals("quit")) { 
	    
	    distance += 1; // Distance increases at every iteration
	    
	    String plaintext = ""; // Decrypted message to be updated

	    /*
	      The following code does the following:
	      1) Intialize array a for character storage
	      2) Assign character of cipher text at position i to a[i]
	      3) Filter alphabetic characters A-Z and a-z, 
	         then add the distance of the cipher
	      4) Store the updated character in plaintext
	      
	      The algorithm depends on the fact that 
	      ASCII characters correspond to specific integers.
	     */

	    // Initialize array
	    int[] a  = new int[ciphertext.length()]; 
	    
	    // Loop to scan every character of ciphertext
	    for (int i = 0; i < ciphertext.length(); i++) {	
	
		// Assign character at position i to a[i]
		a[i] = ciphertext.charAt(i); 

		// Filter A-Z, a-z; Cipher shift;
		// then mod to go back and start with 
		// 'A' or 'a' if shifts after 'Z' or 'z'

		if ('A' <=  a[i] && a[i] <= 'Z') { 
		    a[i] = a[i] + distance - 'A';
		    a[i] = a[i] % 26 + 'A'; 
		} else if ('a' <=  a[i] && a[i] <= 'z') { 
		    a[i] = a[i] + distance - 'a';
		    a[i] = a[i] % 26 + 'a';
		}

		// Store modified character to plaintext
		plaintext += (char) a[i]; 			
	    }

	    // Return plaintext, prompt user for next action
	    System.out.println("\t Distance " + distance);
	    System.out.println(plaintext);
	    System.out.println();
	    System.out.println("\t Press enter to see the next option,"
			       + "type 'quit' to quit.");
	    next = keyboard.nextLine().trim();
	}

	// Return final shift distance after user quits
	System.out.println("\t Final shift distance was " + distance + " places.");

    }
}
