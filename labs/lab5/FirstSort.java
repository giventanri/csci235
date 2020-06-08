/** FirstSort.java
 *
 * This program creates a random array of size defined by the user and 
 * exercises a Bubble sort algorithm and method calls.
 *
 * @author TVD and Micaela Van Meter and Given Tanri
 * Wheaton College, CSCI 235
 * Lab 5
 * Date 2/25/20
 */
import java.util.Scanner; 

public class FirstSort {
    public static void main (String[] args) {

	/* Prompts user, create an array, print an array, 
	 * sort the array, print the sorted array.
	 */

	Scanner key = new Scanner(System.in);

	System.out.print("Please enter array length: ");
	int size = key.nextInt();
	key.nextLine();
	System.out.print("Please enter array name: ");
	String label = key.nextLine();
	
	int[] a = createRandomArray(size);

	printArray(label, a);

	a = bubbleSort(a);

	printArray(label + " [sorted]", a);
	
    }

    /**
     * Create an array filled with random values from 0 to 99.
     * Math.random() returns a random double in [0, 1). 
     * Multiply by 100 and cast to int to get an integer from 0 to 99.
     * @param size The size of the array to create.
     * @return The randomly filled array.
     */
    static int[] createRandomArray(int size){

	int[] a = new int[size]; // a is the randomly created array
	for(int i=0; i<a.length; i++){
	    a[i]=(int)(Math.random()*100);
	}
	return a;
	
    }
	

    /** 
     * Print an array with an initial label.
     * @param label A message to print before the array.
     * @param a     The array to print.
     * POSTCONDITION: label and the array are printed on the display.
     */
    static void printArray(String label, int[] a) {

	System.out.println(label); 
	for(int i=0; i<a.length; i++){
	    System.out.print(a[i]+"\t");
	}
	System.out.println();
    }

    /**
     *  Write the comment for bubbleSort.
     *  Write the heading and body.
     */ 
    static int[] bubbleSort(int[] a) {
	int n=a.length-1; //n is the last index of array

        for(int j=0; j<=n; j++){ //iterate until the length of array

	    for(int i=n; i>0; i--){ //iterate for each element
	
		//swap elements if thepreceeding element is smaller
		if(a[i]<a[i-1]){ 
		    int temp=a[i];
		    a[i]=a[i-1];
		    a[i-1]=temp;
		}
	    }
	}
	return a;
    }

	

	
}
