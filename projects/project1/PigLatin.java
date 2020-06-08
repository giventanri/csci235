/**
 * PigLatin.java
 *
 * Program to generate a Pig Latin expression 
 * consisting of up to four words
 *
 * @author Given Tanri
 * Wheaton College, CSCI 235, Spring 2020
 * Project 1
 * Date? 20190131
 */
import java.util.*;

public class PigLatin {

    public static void main(String[] args) {
      
		//for input from keyboard
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Please enter words: ");

		//store input to the variable, str
		String str = keyboard.nextLine();
		
		//remove leading and trailing spaces
		str = str.trim();  
		
		//hold pig latin expression up to this point
		String pig = "";

		//Avoid error when input is blank/space only
		if ( str.equals("") ) {
		    System.out.println("The Pig Latin expression: ");
		} else {
		    
		    //keep the last punctuation
		    String punctuation = "!?,.";
		    int lastIndex = str.length() - 1;
		    char lastChar = str.charAt(lastIndex);
		    if ( punctuation.indexOf(lastChar) > -1) {
			punctuation = "" + lastChar;
			str = str.substring(0, lastIndex);
		    } else {
			punctuation = "";
		    }

		    //String preparation
		    str = str.toLowerCase(); 
		    str = " " + str + " ";

		    //word-per-word processing
		    int spaceIndex = 0;
		    int nextWord = str.indexOf(" ", spaceIndex + 1);
		    boolean lastWord = false;

		    while (lastWord == false) {
			String word = str.substring(spaceIndex, nextWord);		  

			//Pig Latin algorithm
			word += word.charAt(1) + "ay";
			word = " " + word.substring(2);
			pig += word;

			//to next word
			spaceIndex = nextWord;
			nextWord = str.indexOf(" ", spaceIndex + 1);
		    
			if (nextWord == -1) {
			    lastWord = true;
			}   
		    }

		    //add punctuation and capitalize first char
		    pig = pig.trim() + punctuation;

		    String firstChar = "" + pig.charAt(0);
		    pig = firstChar.toUpperCase() + pig.substring(1);	       		
		
		    //print pig latin expression stored at pig
		    System.out.println("The Pig Latin expression: " + pig);
		}
    }
}

