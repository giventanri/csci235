/**
 * FifteenPuzzle.java
 *
 * Program to emulate a "Fifteen" sliding-block puzzle.
 *
 * @author TVD and Given Tanri
 * Wheaton College, CSCI 235, Spring 2020
 * Lab 12
 * 20200428
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FifteenPuzzle {

    public static void main(String[] args) {

        // Window containing the puzzle
        JFrame window = new JFrame("Fifteen puzzle");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500, 400);

        // Set to 4x4 GridLayout
        window.setLayout(new GridLayout(4, 4));

        // 4x4 matrix of puzzle pieces 
        PuzzlePiece[][] pieces = new PuzzlePiece[4][4];   

        // Set up each button
        int counter = 1;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                // current button
                JButton button = new JButton();

                pieces[i][j] = new PuzzlePiece(button, counter % 16);
                button.addActionListener(pieces[i][j]);

                window.add(button);
                counter++;
            }

        // addNeighbor based on row & column position
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                if (i - 1 >= 0)
                    pieces[i][j].addNeighbor(pieces[i-1][j]);
                if (j - 1 >= 0)
                    pieces[i][j].addNeighbor(pieces[i][j-1]);
                if (i + 1 < 4)
                    pieces[i][j].addNeighbor(pieces[i+1][j]);
                if (j + 1 < 4)
                    pieces[i][j].addNeighbor(pieces[i][j+1]);
            }

        window.setVisible(true);

    }

}