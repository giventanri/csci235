/**
 * Insertion.java
 *
 * A sort() method that implements insertion sort.
 *
 * @author Given Tanri
 * Wheaton College, CSCI 235, Spring 2020
 * Project 3
 * Date 20200405
 */

public class Insertion {

    public static void sort(int[] array) {
	
	int n = array.length; 

	// Nested loop.

	/* Loop 2:
	 * Repeat the operation of Loop 1 until all elements can be sorted.
	 * Number of repetitions assumes the worst case scenario, i.e.,
	 * the number of repetitions is the number of elements in array. 
	 */
	for (int j = 1; j < n; j++) {
	    int min = array[j];

	    /* Loop 1: Insertion sort algorithm. 
	     * Check every element, 
	     * descending from the last element, array[j],
	     * then compare the said element and the preceding element;
	     * then if the said element is smaller then the preceding element,
	     * then those elements are swapped. 
	     */
	    for (int i = j; i > 0; i--) {
		if (array[i] < array[i-1]) {
		    min = array[i];
		    array[i] = array[i-1];
		    array[i-1] = min; 
		}
	    }
	    
	}

	
    }


    
}
