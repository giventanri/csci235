/**
 * GraphCalc.java
 *
 * Graphing calculator program (class with main method)
 *
 * @author Given Tanri
 * CSCI 235, Wheaton College, Spring 2020
 * Project 7
 * Date?
 */


import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;


public class GraphCalc {

    // constructor from old main()
    public GraphCalc() {
    JFrame window = new JFrame("Graphing calculator");
	window.setLayout(new FlowLayout());
	window.setSize(350, 600);
        
        PaintPanel graphPanel = new PaintPanel(350, 350);

        JTextField funcField = new JTextField(25);
        JTextField xminField = new JTextField(5);
        JTextField yminField = new JTextField(5);
        JTextField xmaxField = new JTextField(5);
        JTextField ymaxField = new JTextField(5);

        xminField.setText("-10");
        xminField.setText("-10");
        xmaxField.setText("10");
        ymaxField.setText("10");

        JButton go = new JButton("Go");

	window.add(graphPanel);
	JPanel panel2 = new JPanel();
	panel2.setLayout(new FlowLayout());
	panel2.add(go);
	window.add(panel2);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setVisible(true);
}

    public static void main(String[] args) {
        GraphCalc theWindow = new GraphCalc();
}
}