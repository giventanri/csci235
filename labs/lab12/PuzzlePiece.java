/**
 * PuzzlePiece.java
 *
 * Class to listen for clicks on Fifteen-Puzzle buttons
 *
 * @author TVD, HK and Given Tanri
 * Wheaton College, CSCI 235, Spring 2020
 * Lab 12
 * 20200428
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PuzzlePiece implements ActionListener {

    /**
     * JButton object of this PuzzlePiece that 
     * calls for actionPerformed when clicked.
     */
    private JButton button;
    
    /**
     * The number displayed on the button.
     */
    private int number;
    
    /**
     * Number of neighbors adjacent to this.
     */
    private int numOfNeighbors;
    
    /**
     * Array storing the neighboring PuzzlePiece objects adjecent to this.
     */
	private PuzzlePiece[] neighbors;


    /**
     * Constructor.
     * @param button The button this will listen to
     * @param number The number on the button
     * POSTCONDITION: The number is displayed on the button.
     */
    public PuzzlePiece(JButton button, int number) {
        this.button = button; 
        this.number = number;
        this.numOfNeighbors = 0; 
        this.neighbors = new PuzzlePiece[4]; // 4 is max numOfNeighbors
        this.updateText();
    }

    /**
     * Perform the action.
     * If this button has a neighbor that is empty, then
     * make its own button empty and move its number to
     * the empty one.
     */
    public void actionPerformed(ActionEvent e) {
        for (PuzzlePiece neighbor: this.neighbors) {
            
            // ignore null values when numOfNeighbors < 4
            if (neighbor == null) break; 

            if (neighbor.number == 0) this.swapNeighbors(neighbor);
        }
    }

    /**
     * Inform this PuzzlePiece of the action listener 
     * controlling one of its neighbors.
     * @param neighbor The action listening controlling one
     * of the neighboring buttons.
     * POSTCONDITION: neighbors now contains neighbor
     */
    public void addNeighbor(PuzzlePiece neighbor) {
        for (int i = 0; i < 4; i++) {

            // neighbor is added to the next null array element
            if (neighbors[i] == null) {
                neighbors[i] = neighbor; 
                
                // Updated when neighbor is added to neighbors
                numOfNeighbors++; 
                break;
            }
        }
    }

    /**
     * Swap the numbers of this and neighbor,
     * then update the displayed text on button.
     * @param neighbor The extracted PuzzlePiece 
     */
    public void swapNeighbors(PuzzlePiece neighbor) {
        
        // swap the number objects
        int tempNumber = this.number;
        this.number = neighbor.number; 
        neighbor.number = tempNumber; 

        // Update the displayed text on the button objects
        this.updateText();
        neighbor.updateText();
    }
    
        /**
         * Update the text on the button according to
         * the current number of this PuzzlePiece
         * POSTCONDITION: Text are updated. Number 0 creates a blank button.
         */
    public void updateText() {
        if (number == 0) button.setText("");
        else button.setText(""+number);
    }

}