/**
 * Selection.java
 *
 * A sort() method that implements selection sort.
 *
 * @author Given Tanri
 * Wheaton College, CSCI 235, Spring 2020
 * Project 3
 * Date 20200305
 */

public class Selection {

    public static void sort(int[] array) {

	int n = array.length; 

	// Nested loop.
	
	/* Loop 2:
	 * Scan each element in array in ascending order,
	 * then swap the element with the next smallest element
	 */
	for (int j = 0; j < n; j++) {
	    // Initialize the next smallest element,
	    // assuming array[j] is the current smallest
	    int min = array[j];
	    int minIndex = j; 

	    /* Loop 1:
	     * Look for the actual next smallest element 
	     * after array[j]
	     */
	    for (int i = j; i < n; i++) {
		if (array[i] < min) {
		    min = array[i];
		    minIndex = i;
		}
	    }
	    // Swap the scanned element with
	    // the next smallest element
	    array[minIndex] = array[j];
	    array[j] = min;
	}
	    
    }

       
}
