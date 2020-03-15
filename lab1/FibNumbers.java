/**
 * FibNumbers.java
 *
 * Program to exercise while statements. 
 *
 * @author @giventanri
 * Wheaton College, CSCI 235, Spring 2020
 * Lab 1
 * Date? 20200121
 */

 
public class FibNumbers {
    public static void main(String[] args) {

		//create an array of random integers.
		int[] a = new int[10];
		
		for (int j = 0; j < a.length; j++) {
			a[j] = 0;
		}
		
		//print the initial array.  
		System.out.println ("The array has: ");
		System.out.print ("[");
		for (int j = 0; j < a.length; j++) {
			System.out.print(a[j] + " ");
		}
		System.out.print ("]\n\n");
	
		// use the following variables if necessary
		int i = 0;  //for controlling loop
		int temp = 0; 	//for any use
				
		//add your code here. 
		//varible a refers to the array.
		

		while(i < 10){
		    if(i < 2){
			a[0] = 0;
			a[1] = 1;
		    }else{
			a[i] = a[i-1] + a[i-2];
		    }
		    i++;
		}
		
		
	    	
		
		
		
		//print the array with Fibonacci numbers.  
		System.out.println ("The array with Fibonacci numbers: ");
		System.out.print ("[");
		for (int j = 0; j < a.length; j++) {
			System.out.print(a[j] + " ");
		}
		System.out.print ("]\n\n");
		
		
    } 
}
