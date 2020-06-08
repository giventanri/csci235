/**
 * ArrayManip.java
 * 
 * Program description
 * 
 * @author  Given Tanri, Yeting Li
 * Wheaton College, CSCI 235, Spring 2020
 * Lab3
 * Feburary 11, 2020
 */

/*
ArrayManip allows user to create an array of a specified length,  
then find the average and minimum & maximum of the array values.
User can also view the arrray.  
*/

import java.util.Scanner; 

public class ArrayManip {
    public static void main(String[] args) {

        // For user input from the keyboard
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please enter the size of the array--> ");
	int size = keyboard.nextInt();	// for size of the array
	
	keyboard.nextLine();
	
	int[] a = new int[size];	// array to manipulate
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
	    case 1: //User input for array
		System.out.print("Index--> ");
		int loc = keyboard.nextInt();   // index for new value 
		keyboard.nextLine();
		
		System.out.print("Value--> ");
		int value = keyboard.nextInt();   // value to put there
		keyboard.nextLine();
		a[loc] = value;
		break;

            case 2: //Average of array values
		double sumOfArray = 0; //sum to update after loop
		double averageOfArray = 0.0; //average of array

		//loop to add every value to sum
                for(int i = 0; i < a.length; i++) {
		    sumOfArray = sumOfArray + a[i];     
		}
		//average taken, dividing sum by the length of array
                averageOfArray = sumOfArray/ (double) (a.length);

		//Display Average
		System.out.println("The average of the array is " + averageOfArray +". ");
                break;

            case 3: //Min and Max of array
		int smallest = a[0]; //min value of array
		int largest = a[0]; //max value of array

		//loop to check every value in array
                for(int i = 0; i < a.length; i++) {
		    if (a[i] < smallest) {
			smallest = a[i];
		    }
		    if (a[i] > largest) {
			largest = a[i];
		    }
		}
		
		//Display Min and Max
		System.out.println("The minimum of the array is " + smallest + ". ");
		System.out.println("The maximum of the array is " + largest + ". ");
		
		break;

            case 4: //Display array

		/*
		  Format:
		  a[0] = 0    a[1] = 10    a[2] = 20    a[3] = 30
		  a[4] = 40   a[5] = 50    ...
		  
		 */


		for(int i = 0; i < a.length; i++){
		    System.out.print("a[" + i + "] = " + a[i] + "\t");
		    if (i % 4 == 3) { //new line every four array values
			System.out.println();
		    }
		}
		System.out.println();
                    
                
                break;

                
            case 5: //Quit program
                quit = true;
                break;

            default:
                System.out.println("That wasn't even a choice.");
           }
        } while(!quit);

    }
}

