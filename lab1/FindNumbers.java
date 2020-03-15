/**
 * FindNumbers.java
 *
 * Program to exercise if and while statements. 
 *
 * @author @giventanri @christiankim01 @nathanmarbella
 * Wheaton College, CSCI 235, Spring 2020
 * Lab 1
 * Date? 1 21 2020
 */

 
public class FindNumbers {
    public static void main(String[] args) {

		//create an array of random integers.
		int[] a = new int[20];
		
		for (int j = 0; j < a.length; j++) {
			a[j] = (int) (100 * Math.random());
		}
		
		//print integers to the screen.  
		System.out.println ("The array has: ");
		System.out.print ("[");
		for (int j = 0; j < a.length; j++) {
			System.out.print(a[j] + " ");
		}
		System.out.print ("]\n\n");
	
		// use the following variables if necessary
		int i = 0; 	//for controlling loop
		int evens = 0;  //for the number of evens
		int odds = 0; 	//for the number of odds
		int smallest = a[0]; 	//for the smallest
		int largest = a[0]; 	//for the largest
		int sum = 0; 	//for the sum
		
		
		//add your code here. 
		//varible a refers to the array.
		
		while(i<20){
		    if(a[i]%2==0){
			evens=evens+1;
		    }else{
			odds=odds+1;
		    }
		    if(a[i]<smallest){
			smallest=a[i];
		    }
		    if(a[i]>largest){
			largest=a[i];
		    }
		    sum=sum+a[i];
		    i=i+1;
		}
	    
		
		
		
		
		
		
		// print statements to print the integers
		System.out.println ("The number of evens: " + evens);
		System.out.println ("The number of odds: " + odds);
		System.out.println ("The smallest: " + smallest);
		System.out.println ("The largest: " + largest);
		System.out.println ("The sum: " + sum);
		
		
    } 
}
