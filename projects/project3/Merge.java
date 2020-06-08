/**
 * Merge.java
 *
 * This program implements Merge sort.
 *
 * @author Given Tanri
 * Wheaton College, CSCI 235, Spring 2020
 * Project 3
 * Date 20200405
 */

public class Merge {

    
    /**
     * Sort an array, in-place, using merging.
     * @param array The array to be sorted.
     * POSTCONDITION: The elements of array are in ascending order.
     */
    public static void sort(int[] array) {

	// localArray for in-place sorting
	int[] localArray = new int[array.length];
	localArray = mergeSort(array);
	for (int i = 0; i < array.length; i++) {
	    array[i] = localArray[i];
	}
	    
    }

    
    /**
     * Extract the portion of an array from start up to (excluding) stop.
     * @param array The source array.
     * @param start The starting index (inclusive).
     * @param stop  The ending index (exclusive).
     * @return An array containing the same elements the portion of array.
     * PRECONDITION: 0 <= start <= stop <= array.length
     */
    private static int[] subarray(int[] array, int start, int stop) {

	// Initialize subArray
	int size = stop - start; // Size of the new subArray
	int[] subArray = new int[size];

	// Assign values to the subArray
	for (int i = 0; i < size; i++) {
	    subArray[i] = array[start + i]; 
	}
        return subArray;
    }

   
    /**
     * Merge two sorted arrays into one new array.
     * @param first The first array, already sorted.
     * @param second The second array, already sorted.
     * @return A new array containing the elements of first and second,
     *         in order.
     */
    private static int[] merge(int[] first, int[] second) {

	// Initialize mergedArray
	int size = first.length + second.length; // Size of the mergedArray
	int[] mergedArray = new int[size];

	// Index counters: f for the first array, and s for the second array
	int f = 0;
	int s = 0;

	// Loop for assigning sorted value to every element of mergedArray
	for (int i = 0; i < size; i++) {

	    // Limiters of the counters to avoid out-of-bounds errors
	    boolean fMax = (f == first.length);
	    boolean sMax = (s == second.length);

	    /* Case 1:
	     * Compare unassigned values of both arrays,
	     * then assign the smaller value to mergedArray[i]
	     */
	    if (!fMax && !sMax) {
		if (first[f] < second[s]) {
		    mergedArray[i] = first[f++];
		} else {
		    mergedArray[i] = second[s++];
		}

	    /* Case 2:
	     * When all elements of the other array are assigned,
	     * assign values of only one array 
	     */
	    } else if (fMax) {
		mergedArray[i] = second[s++];
	    } else if (sMax) {
		mergedArray[i] = first[f++];
	    }
	    
    	}
	return mergedArray;
    }

    
    /**
     * Sort an array by merging.
     * @param array The array to sort.
     * @return A new array containing the elements of array, in order.
     */
    private static int[] mergeSort(int[] array) {
	
	// Base Case: Array of size 0 or 1 is already sorted
	if (array.length <= 1) {  
	    return array;

	/* Recursion:
	 * Split the array, then
	 * apply mergeSort recursively to the split arrays, then
	 * sort and combine the split arrays using merge().   
	 */  
	} else {

	    // Splits the array splited into the first and the second arrays
	    int midpoint = array.length / 2;
	    int[] first = subarray(array, 0, midpoint);
	    int[] second = subarray(array, midpoint, array.length);

	    // Recursive algorithm to sort both split arrays
	    first = mergeSort(first);
	    second = mergeSort(second);

	    // Sorts and merges both arrays using merge()
	    array = merge(first, second);

	    return array;
	}
    }


    
}



