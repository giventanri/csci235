/**
 * ATMdriver.java
 * 
 * Program to test ATM Class
 *
 * @author Given Tanri
 * CSCI 235, Wheaton College, Spring 2020
 * Project 5
 * Date 20200408
 */

import java.io.*;
import java.util.*;

public class ATMdriver {

    public static void main(String[] args) {

	// Create a new ATM object
	ATM thisATM = new ATM();
	System.out.print(thisATM);
	
	// Allow user input via keyboard
	Scanner keyboard = new Scanner(System.in);

	// Boolean to control Quit condition
	boolean isTransaction = true;

	/* Main Operations */ 
	while(isTransaction) {

	    // Prompt user to input then reformats the input
	    System.out.print(inputDisplay);	
	    String userInput = keyboard.nextLine();
	    userInput = inputFormat(userInput);

	    // Allow for only String input of length of 1
	    if (userInput.length() > 1) {
	        System.out.print(invalidInput);
	    } else {

		// Cast userInput to char type
		char uI = userInput.charAt(0); 
	    
		/* ATM operations:
		 * case 'w': withdraw money from the ATM
		 * case 't': add twenties to the ATM
		 * case 'f': add fives to the ATM
		 * case 'q': quit"
		 */
		switch (uI) {
		
		    /* Withdraw */
		case 'w':

		    // Boolean to allow valid user input
		    boolean isWithdrawing = true;
		    while (isWithdrawing) {
			
			// Prompt user, check for error
			System.out.print(toWithdraw);
			int amountToWithdraw = 0;
			try { 
			    amountToWithdraw = keyboard.nextInt();
			} catch (InputMismatchException e) {
			    keyboard.nextLine();
			    System.out.print(invalidInput);
			    break;
			}

			// Invalid case #1:
			// Negative amount or not a multiple of 5
			if (amountToWithdraw < 0 || amountToWithdraw % 5 != 0) {
			    System.out.print(invalidInput);
			}
			// Invalid case #2:
			// Insufficient funds
			else if (amountToWithdraw > thisATM.getAmount() ) {
			    System.out.print(invalidTransaction + insufficientFunds);
			}
			// Invalid case #3:
			// Insufficient USD 5 bills
			else if (amountToWithdraw % 20
				 > ATM.billsToUSD(thisATM.getFives(),0) ) {
			    System.out.print(invalidTransaction +
					     insufficientFives);	    
			}

			else {
			    // Check if the withdrawn amount
			    // equals the requested withdrawal
			    int withdrawn = thisATM.withdraw(amountToWithdraw);
			    if (withdrawn != amountToWithdraw) {
				System.out.print(incompleteTransaction);
			    }

			    // Display transaction, exit loop
			    System.out.print(">> $" + amountToWithdraw
					     + " withdrawn." + "\n");
			    System.out.print(thisATM);
			    keyboard.nextLine();
			    isWithdrawing = false;
			}
		    }
		    break;

		    
		    /* Add twenties */
		case 't':
		    
		    // Boolean to allow valid user input
		    boolean isAddingTwenties = true;
		    while (isAddingTwenties) {

			// Prompt user, check error
			System.out.print(toAddTwenties);
			int twentiesToAdd = 0;
			try { 
			    twentiesToAdd = keyboard.nextInt();
			} catch (InputMismatchException e) {
			    keyboard.nextLine();
			    System.out.print(invalidInput);
			    break;
			}
			
			// Invalid case:
			// Negative amount
			if (twentiesToAdd < 0) {
			    System.out.print(invalidInput);
			    
			} else {
			    // Display transaction, exit loop
			    thisATM.addTwenties(twentiesToAdd);
			    System.out.print(thisATM);
			    keyboard.nextLine();
			    isAddingTwenties = false;
			}
		    }
		    break;

		    
		    /* Add fives */
		case 'f':
		    
		    // Boolean to allow valid user input
		    boolean isAddingFives = true;
		    while (isAddingFives) {

			// Prompt user, catch error
			System.out.print(toAddFives);
			int fivesToAdd = 0;
			try { 
			    fivesToAdd = keyboard.nextInt();
			} catch (InputMismatchException e) {
			    keyboard.nextLine();
			    System.out.print(invalidInput);
			    break;
			}

			// Invalid case:
			// Negative Amount
			if (fivesToAdd < 0) {
			    System.out.print(invalidInput);
			    
			} else {
			    // Display transaction, exit loop
			    thisATM.addFives(fivesToAdd);
			    System.out.print(thisATM);
			    keyboard.nextLine();
			    isAddingFives = false; 
			}
		    }
		    break;

		    
		    /* Quit */ 
		case 'q':

		    // Display funds, exit loop
		    isTransaction = false;
		    System.out.print(thisATM);
		    break;

		    // Invalid inputs
		default:
		    System.out.print(invalidInput);
		    break;
		}
	    }
	}
    }    
    
    // Other helper methods
    /**
     * Reformat input: 
     * Removes trailing spaces and converts input to lower case. 
     * @param input String to be reformatted
     * @return The reformatted input
     */
    public static String inputFormat(String input) {
	return input.trim().toLowerCase();
    }

    // String objects to be displayed to user
    static String inputDisplay = "\n" +
	">>--------------------" + "\n" +
	">> Please select an option." + "\n" +
	">> " + "\n" +
	">> W: withdraw money from the ATM" + "\n" +
	">> T: add twenties to the ATM" + "\n" +
	">> F: add fives to the ATM" + "\n" +
	">> Q: quit" + "\n" +
	">>--------------------" + "\n";

    static String toAddTwenties = "\n" +
	">> How many twenties do you want to add?" + "\n";

    static String toAddFives = "\n" +
	">> How many fives do you want to add?" + "\n";

    static String toWithdraw = "\n" +
	">> How much do you want to withdraw? Please enter a multiple of 5." + "\n";

    static String invalidTransaction = "\n" +
	">> Sorry, the transaction cannot be made." + "\n";

    static String insufficientFunds = "\t" +
	">> This ATM has insufficient funds." + "\n";

    static String insufficientFives = "\t" +
	">> This ATM has insufficient bills." + "\n";

    static String invalidInput = "\n" +
	">> Please enter a valid input." + "\n";

    static String incompleteTransaction = "\t" +
	">> WARNING: This transaction is incomplete.";     

        
}

