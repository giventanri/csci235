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

    //// FINAL CONSTANTS ////
    /**
     * Constants used to construct the default GraphCalc,
     * created for easier modifications of values.
     */

    // Title and size of the default JFrame window,
    public final String WINDOW_TITLE = "Graphing calculator";
    public final int WINDOW_WIDTH = 350; // px
    public final int WINDOW_HEIGHT = 550; // px

    // Size of the default graphPanel,
    public final int GRAPH_WIDTH = 350; // px  
    public final int GRAPH_HEIGHT = 350; // px 

    // Length of the text fields.
    public final int FUNCTION_FIELD_LENGTH = 15; // column
    public final int MINMAX_FIELD_LENGTH = 3; // column

    // Default values of objects.
    public final String BUTTON_TEXT = "Go";

    public final String FUNC_LABEL = "f(x) = ";
    public final String XMIN_LABEL = "x min: ";
    public final String YMIN_LABEL = "y min: ";
    public final String XMAX_LABEL = "x max: ";
    public final String YMAX_LABEL = "y max: ";

    public final String DEFAULT_FUNC = "(((0 - 3) * (x ^ 2)) + 5)";
    public final double DEFAULT_XMIN = -10;
    public final double DEFAULT_YMIN = -10; 
    public final double DEFAULT_XMAX = 10;
    public final double DEFAULT_YMAX = 10; 

    public final boolean DEFAULT_FLAG = false;

    //// INSTANCE VARIABLES ////
    /**
     * JFrame window for this GraphCalc.
     */
    private JFrame window;

    /**
     * PaintPanel for the graph.
     */
    private PaintPanel graphPanel; 

    // inputPanel 
    /**
     * JPanel objects for input.
     */
    private JPanel inputPanel, funcPanel, minMaxPanel;

    /**
     * JTextField objects for input fields,
     * which include function and graph max and min.
     */
    private JTextField funcField, xminField, yminField, xmaxField, ymaxField; 

    /**
     * JLabel objects for input.
     */
    private JLabel funcLabel, xminLabel, yminLabel, xmaxLabel, ymaxLabel;

    /**
     * goButton to repaint graphPanel based on the input fields.
     */
    private JButton goButton; 

    // errorMsg
    /**
     * JLabel to display error message.
     */
    private JLabel errorMsg;

    /**
     * Error flag whether to display errorMsg;
     */
    private boolean errorFlag; 

    //// CONSTRUCTOR ////
    /**
     * Constructor for GraphCalc object
     */
    public GraphCalc() {

        // Initialize the JFrame of this GraphCalc
        window = new JFrame(WINDOW_TITLE);
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new FlowLayout());
            
        // MAIN PANEL 1: Initialize outputPanel and its objects.
        graphPanel = new PaintPanel(GRAPH_WIDTH, GRAPH_HEIGHT);
        
        // MAIN PANEL 2: Initialize inputPanel and its objects.
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2,1));

        funcPanel = new JPanel();
        funcPanel.setLayout(new FlowLayout());

        minMaxPanel = new JPanel();
        minMaxPanel.setLayout(new GridLayout(2,4));

        errorMsg = new JLabel("");

        // Initialize objects for user input.
        funcLabel = new JLabel(FUNC_LABEL);
        xminLabel = new JLabel(XMIN_LABEL);
        yminLabel = new JLabel(YMIN_LABEL);
        xmaxLabel = new JLabel(XMAX_LABEL); 
        ymaxLabel = new JLabel(YMAX_LABEL);

        funcField = new JTextField(DEFAULT_FUNC, FUNCTION_FIELD_LENGTH);
        xminField = new JTextField("" + DEFAULT_XMIN, MINMAX_FIELD_LENGTH);
        yminField = new JTextField("" + DEFAULT_YMIN, MINMAX_FIELD_LENGTH);
        xmaxField = new JTextField("" + DEFAULT_XMAX, MINMAX_FIELD_LENGTH);
        ymaxField = new JTextField("" + DEFAULT_YMAX, MINMAX_FIELD_LENGTH);

        errorFlag = DEFAULT_FLAG;

        // Initialize goButton and its ActionListener.
        goButton = new JButton(BUTTON_TEXT);
        GoListener goClick = new GoListener(graphPanel, this);  
        goButton.addActionListener(goClick);

        // Set goClick as the Painter of the graphpanel.
        graphPanel.setPainter(goClick); 

        // Add relevant objects to funcPanel.
        funcPanel.add(funcLabel);
        funcPanel.add(funcField);
        funcPanel.add(goButton);

        // Add relevant objects to minMaxPanel.
        minMaxPanel.add(xminLabel);
        minMaxPanel.add(xmaxLabel);
        minMaxPanel.add(yminLabel);
        minMaxPanel.add(ymaxLabel);

        minMaxPanel.add(xminField);
        minMaxPanel.add(xmaxField);
        minMaxPanel.add(yminField);
        minMaxPanel.add(ymaxField);

        // Add funcPanel and minMaxPanel to inputPanel.
        inputPanel.add(funcPanel);
        inputPanel.add(minMaxPanel);        

        // Add objects to window
        window.add(graphPanel);
        window.add(inputPanel);
        window.add(errorMsg);
        
        // Set window to be visible
        window.setVisible(true);
    }

    //// ACCESSOR HELPER METHODS ////
    /**
     * Get the mathematical function from JTextField.
     * @return funcNode The mathematical function to draw
     * PRECONDITION: function must be inputted with the prescribed format.
     */
    public ExprNode getFunc(ExprNode oldFuncNode) {
        try {
        ExprNode funcNode = Interpreter.parse(funcField.getText() ); 
        return funcNode; 
        } catch (Exception e) {
            errorFlag = true;
            setErrorMsg("Please enter a function with a valid ExprNode format.");
            return oldFuncNode;
        }
    }

    /**
     * Get the value of xmin from JTextField.
     * @return xmin The integer value of xmin 
     */
    public double getXmin(double oldXmin) {
        try {
        double xmin = Double.parseDouble(xminField.getText() );
        return xmin;
        } catch (Exception e) {
            errorFlag = true;
            setErrorMsg("Please enter a double value for xmin.");
            return oldXmin; 
        }

    }

    /**
     * Get the integer value of ymin from JTextField.
     * @return ymin The integer value of ymin 
     */
    public double getYmin(double oldYmin) {
        try {
        double ymin = Double.parseDouble(yminField.getText() );
        return ymin;
    } catch (Exception e) {
        errorFlag = true;
        setErrorMsg("Please enter a double value for ymin.");
        return oldYmin; 
    }
    }

    /**
     * Get the integer value of xmax from JTextField.
     * @return xmax The integer value of xmax 
     */
    public double getXmax(double oldXmax) {
        try {
        double xmax = Double.parseDouble(xmaxField.getText() );
        return xmax;
        } catch (Exception e) {
            errorFlag = true;
            setErrorMsg("Please enter a double value for xmax.");
            return oldXmax; 
    }
}

    /**
     * Get the integer value of ymax from JTextField.
     * @return ymax The integer value of ymax 
     */
    public double getYmax(double oldYmax) {
        try {
        double ymax = Double.parseDouble(ymaxField.getText() );
        return ymax;
        } catch (Exception e) {
            errorFlag = true;
            setErrorMsg("Please enter a double value for ymax.");
        } return oldYmax; 
    }
   
    public String getErrorMsg() {
        return errorMsg.getText();
    }

    public boolean hasError() {
        return errorFlag;
    }

    //// MUTATOR METHODS ////

    public void setErrorMsg(String errorText) {
        errorMsg.setText(errorText);
    }

    public void setErrorFlag(boolean hasError) {
        errorFlag = hasError;
    }

    public void prt(String s) {System.out.println(s);}


    /**
     * main method to build this GraphCalc
     */
    public static void main(String[] args) {
        GraphCalc theWindow = new GraphCalc();
}

}