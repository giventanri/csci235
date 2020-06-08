/**
 * PuzzlePiece.java
 *
 * Class to listen for clicks on Fifteen-Puzzle buttons
 *
 * @author TVD, HK and ...
 * Wheaton College, CSCI 235, Spring 2020
 * Lab 12
 * Date?
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PuzzlePiece implements ActionListener {

    //Need to document these instance variables
	private JButton button;
	private int number;
	private int numOfNeighbors;
	private PuzzlePiece[] neighbors;


    /**
     * Constructor.
     * @param button The button this will listen to
     * @param number The number on the button
     * POSTCONDITION: sets the text on the button.
     */
    public PuzzlePiece(JButton button, int number) {
		// write the body of the constructor.
		
	button.setText(""+number);
    }

    /**
     * Perform the action.
     * If this button has a neighbor that is empty, then
     * make its own button empty and move its number to
     * the empty one.
     */
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * Inform this PuzzlePiece of the action listener 
     * controlling one of its neighbors.
     * @param neighbor The action listening controlling one
     * of the neighboring buttons.
     */
    public void addNeighbor(PuzzlePiece neighbor) {

    }

}
