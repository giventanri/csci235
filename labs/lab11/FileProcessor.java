/**
 * FileProcessor.java
 *
 * Program to count the word frequencies in a file.
 *
 * @author TVD/CGG and Given Tanri
 * CSCI 235, Wheaton College, Spring 2020
 * Lab 11
 * 20200421
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collections;

public class FileProcessor {


    public static void main(String[] args) {

	// the list of words in the file
	ArrayList<String> words = FileAux.fileToWords(args[0]);


	// word tally
	HashMap<String, Integer> tally = new HashMap<String, Integer>();

	for (Iterator<String> it = words.iterator(); it.hasNext(); ) {
	    String word = it.next().toLowerCase(); // extract word from it
	    Integer count = tally.get(word); // store current word count

	    // set count to 0 if word is not yet in tally
	    if (count == null) count = 0; 

	    // remove the mapping and put an updated mapping
	    tally.remove(word);
	    tally.put(word, count + 1);
	}

	// create ArrayList to store pairs
	ArrayList<SIPair> pairs = new ArrayList<SIPair>();

	// print word tally, one line per unique word
	for (Iterator<String> it = tally.keySet().iterator(); it.hasNext(); ) {
		
	    // Code for Step 3
	    /* 
	       String word = it.next().toLowerCase(); // extract word from it
	       Integer count = tally.get(word); // store current word count

	       System.out.println(word + ": " + count);
	    */

	    // Code for Step 4
	    String word = it.next().toLowerCase(); // extract word from it
	    Integer count = tally.get(word); // store current word count
	    SIPair pair = new SIPair(word, count);
	    pairs.add(pair);
	}

	// sort pairs
	Collections.sort(pairs);

	// Code for Step 4
	// System.out.println(pairs);

	// print tally
	for (int i = 0; i < pairs.size(); i++) {
	    System.out.println(pairs.get(i) );
	}	
    }
    
}
