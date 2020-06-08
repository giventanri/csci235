/**
 * RecursiveString.java
 *
 * Driver program to test out recursive methods on Strings.
 *
 * @author TVD, HK and Given Tanri, Youyeon Chun, Willow vander Kooi
 * CSCI 235, Wheaton College, Spring 2020
 * Lab 6
 * Date 20200303
 */

public class RecursiveString {

    public static void main(String[] args) {
	/*
	 * Note: When you complete the lab, all of these tests should be
	 * present and not commented out.
	 */
		
	System.out.println("testing isAlphabetic: " + isAlphabetic(args[0]));
		
        System.out.println("testing length: " + length(args[0]));

        System.out.println("testing contains: " + contains(args[0], args[1].charAt(0)));

        System.out.println("testing equals: " + equals(args[0], args[1]));

        System.out.println("testing isPalindrome: " + isPalindrome(args[0]));

        System.out.println("testing reverse:  ." + reverse(args[0]) + ".");

        System.out.println("testing startsWith: " + startsWith(args[0], args[1]));

        System.out.println("testing areSemordnilap: " + areSemordnilap(args[0], args[1]));

    }

    /**
     * Determine whether this string is all alphabetic or not
     *
     * @param str The string we are testing
     * @return true if the string is all alphabetic, false otherwise
     */
    public static boolean isAlphabetic(String str) {
	// Base case is empty string, which counts as alphabetic
	if (length(str) == 0) { 
	    return true;
	// Recursively using isLetter method for the first char, then parse the string
	} else {
	    char first = str.charAt(0);
	    String cutstr = str.substring(1);
	    return Character.isLetter(first) && isAlphabetic(cutstr);
	}	
    } 
	
    /**
     * Compute the length of a given string.
     * 
     * @param str The string whose length we are computing
     * @return The (integer) length of the string
     */
    public static int length(String str) {
	// Recursively counts and cut the first char of the string
	if (str.isEmpty() ) {
	    return 0;
	} else { 
	    return 1 + length(str.substring(1) );
	}
    }

    /**
     * Determine whether or not a given character occurs in a given string
     *
     * @param str The string we are testing
     * @param c The character for which we are searching
     * @return true if c occurs in str, false otherwise
     */
    public static boolean contains(String str, char c) {   
       
	//  Recursively cuts the first character of str if it is not char c 
	
	// Base Case 1: all characters of str are discarded, 
	// meaning no char of str matches char c.
	if (str.isEmpty() ) {
	    return false;
	}
	// Base Case 2: once char c is found in str, return true
	if (str.charAt(0) == c) {
	    return true;

        // Recursively call method while cut the first char of str
	} else {
	    return contains(str.substring(1), c);
	}
    }
   

    /**
     * Determine whether or not two strings are equal
     *
     * @param str1 The first string
     * @param str2 The other string
     * @return true if the two strings are equal, false otherwise
     */
    public static boolean equals(String str1, String str2) {

	// Filters strings of inequal length
	if (str1.length() != str2.length() ) {
	    return false;
	}

	// Base case: after parsing, empty strings are equal
	if (str1.isEmpty() && str2.isEmpty() ) {
	    return true;
	    
	// Recursively cuts the first char of both str and check whether the next char matches
	} else {
	    String cutstr1 = str1.substring(1);
	    String cutstr2 = str2.substring(1);
	    boolean charEquals = str1.charAt(0) == str2.charAt(0);
	    return charEquals && equals(cutstr1, cutstr2); 
	}
    }

    /**
     * Determine whether this string is a palindrome.
     *
     * @param str The String to test 
     * @return true if it is a palindrome, false otherwise. 
     */
    public static boolean isPalindrome(String str) {
	int l = length(str);

	// Base case: empty string AND single character are palindromes
	if (l == 0 || l == 1) {
	    return true;

	// Recursively cuts both first and last char after comparing them
	} else {
	    String cutstr = str.substring(1, l-1);
	    boolean charEquals = str.charAt(0) == str.charAt(l-1); 
	    return charEquals && isPalindrome(cutstr);
	}	   
    }

    /**
     * Compute the reverse of the given string
     * 
     * @param str The string to reverse
     * @return A string, the revrse of the one given.
     */
    public static String reverse(String str) {   
	int l = length(str);

	// Base case: reversed single char is itself
	if (l == 1) {
	    return str;

	// Recursively return the last character of parsed strings
	} else {
	    return str.charAt(l-1) + reverse(str.substring(0, l-1) );
	}
 }

    /**
     * Compute whether a given string has another string as its prefix.
     *
     * @param str The string which may have a prefix
     * @param prefix The potential prefix of str
     * @return true if the potential prefix is indeed a prefix, false otherwise
     */
    public static boolean startsWith(String str, String prefix) {
	// Base case 1: all str starts with empty string
	if (prefix.isEmpty() ) {
	    return true;
	}

	// Base case 2: empty str does not start with any prefix
	if (str.isEmpty() ) {
	    return false;
	}
	
	// Recursively compares first char of both str and prefix, then cuts first char
	if (str.charAt(0) == prefix.charAt(0) ) {
	    return startsWith(str.substring(1), prefix.substring(1) );
	} else {
	    return false;
	}
}
    /**
     * Determine whether or not two strings are semordnilap
     *
     * @param str1 The first string
     * @param str2 The other string
     * @return true if the two strings are the reverse of each other
     */
    public static boolean areSemordnilap(String str1, String str2) {       
	// Filters str of inequal length
	if (str1.length() != str2.length() ) {
	    return false;
	}
	int l1 = length(str1);
	int l2 = length(str2);
	
	// charEquals indicates whether the first char of str1 is the last char of str2
	boolean charEquals = str1.charAt(0) == str2.charAt(l2-1);

	// Base case 1: empty strings are semordnilap
	if (str1.isEmpty() && str2.isEmpty() ) {
	    return true;

	// Base case 2: identical strings of single char are semordnilap 
	} else if (l1 == 1 && l2 == 1) {
	    return charEquals; 

	// Recursively checks for the first char of str1 and last char of str2, then cuts them
	} else {
	    String cutstr1 = str1.substring(1, l1-1);
	    String cutstr2 = str2.substring(1, l2-1);
	    return charEquals && areSemordnilap(cutstr1, cutstr2); 
	}    
    }


}
