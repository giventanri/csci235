/**
 * TwoDArrayManip.java
 * 
 * Prompts user to create a two-dimensional array, then shows the average,
 * maximum and minimum, and/or the array itself. 
 * 
 * @author Given Tanri, Joanna Larson
 * Wheaton College, CSCI 235, Spring 2020
 * Lab 4
 * Date 20200218
 */

import java.util.Scanner; 

public class TwoDArrayManip {
    public static void main(String[] args) {

        // For user input from the keyboard
	Scanner keyboard = new Scanner(System.in);

	System.out.print("Please enter the size of rows--> ");
	int row = keyboard.nextInt();
	keyboard.nextLine();

	System.out.print("Please enter the size of columns--> ");
	int col = keyboard.nextInt();
	keyboard.nextLine();

	int[][] a = new int[row][col];


	boolean quit = false;          // flag for quitting the do-while loop

        do {
            System.out.println("1. Set a value in the array\n" +
                               "2. Find the average\n" +
                               "3. Find the minimum and maximum\n" +
                               "4. Display the contents\n" +
                               "5. Quit");
            System.out.print("Your choice--> ");
            int query = keyboard.nextInt();   // user's menu choice
            keyboard.nextLine();

            switch(query) {
	    case 1: // Array input
		System.out.print("Index for row--> ");
		int rowIndex = keyboard.nextInt();    
		keyboard.nextLine();
		System.out.print("Index for column--> ");
		int colIndex = keyboard.nextInt();
		keyboard.nextLine();
		System.out.print("Value--> ");
		int value = keyboard.nextInt();   // value to put there
		keyboard.nextLine();
		a[rowIndex][colIndex] = value;
		break;

	    case 2: //Display average
		double sumOfArray = 0; //sum to update after loop
		double averageOfArray = 0.0; //average of array
		int divisor = 0; // number of elements in array

		//loop to add every value to sum
                for(int i = 0; i < a.length; i++) {
		    for(int j = 0; j < a[i].length; j++) {
			sumOfArray = sumOfArray + a[i][j];
			divisor++;
		    }
		}

		//average taken, dividing sum by the length of array
		averageOfArray = sumOfArray / divisor;

		//Display Average
		System.out.println("The average of the array is " + averageOfArray +". ");
                break;

	    case 3: //min and max of array
		int smallest = a[0][0]; //min value of array
		int largest = a[0][0]; //max value of array

		//loop to check every value in array
                for(int i = 0; i < a.length; i++) {
		    for(int j = 0; j < a[i].length; j++) {
 
			if (a[i][j] < smallest) {
			    smallest = a[i][j];
			}
			if (a[i][j] > largest) {
			    largest = a[i][j];
			}
		    }
		}
		
		//Display Min and Max
		System.out.println("The minimum of the array is " + smallest + ". ");
		System.out.println("The maximum of the array is " + largest + ". ");
		break;

	    case 4: //Display array    

		/*
		  Format:
		  a[0][0] = 0    a[0][1] = 10    a[0][2] = 20    a[0][3] = 30
		  a[1][0] = 40   a[1][1] = 50    ...
	  
		*/

		int totalIter = 0; //number of elements so far in the loop
		for(int i = 0; i < a.length; i++){
		    for(int j = 0; j < a[i].length; j++) { 

			System.out.print("a[" + i + "][" + j + "] = " + a[i][j] + "\t");
			totalIter++;
			if (totalIter % 4 == 0) { //new line every four elements
			    System.out.println();
			}
		    }
		}
		System.out.println();
		break;
                
	    case 5:
		quit = true;
		break;

	    default:
		System.out.println("That wasn't even a choice.");
            }
        } while(!quit);

    }
}

