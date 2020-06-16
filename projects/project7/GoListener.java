/**
 * GoListener.java
 * 
 * @author Given Tanri
 * Wheaton College, CSCI 235, Spring 2020
 * Project 7
 * 20200502
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GoListener implements ActionListener, Painter {


    private final Color AXIS_COLOR = Color.BLACK;
    private final Color FUNC_COLOR = Color.RED;

    /**
     * PaintPanel to which this corresponds. 
     */
    private PaintPanel panel;

    /**
     * GraphCalc to which this corresponds. 
     */
    private GraphCalc calc; 

    /**
     * The mathematical function to be graphed on the GraphCalc.
     */
    private ExprNode func; 

    /**
     * The boundaries of the associated Graphcalc. 
     */
    private double xmin, ymin, xmax, ymax; 

    /**
     * Constructor.
     * @param panel PaintPanel to which this corresponds.
     * @param calculator GraphCalc to which this corresponds.
     */
    public GoListener(PaintPanel panel, GraphCalc calc) {
        this.panel = panel;
        this.panel.setPainter(this);

        this.calc = calc; 

        this.getInput(calc); 
    } 



    /**
     * Update the graphPanel based on inputs on JTextField objects.
     * This method is inherited from ActionListener.
     * @param e ActionEvent object (unused)
     * PRECONDITION: No input error
     */
    public void actionPerformed(ActionEvent e) {

            calc.setErrorFlag(false);
            this.getInput(calc);

            if (xmin >= xmax || ymin >= ymax) {
                calc.setErrorFlag(true);
                calc.setErrorMsg("min must be smaller than max.");
            }

            if (!calc.hasError() ) {
                calc.setErrorMsg("");
                panel.repaint();
            }
    }
    
    /**
     * Update the display using the given graphics object.
     * @param g The graphics object to manipulate
     */
    public void paint(Graphics g) {
        g.setColor(AXIS_COLOR); 
        if (containsXAxis() ) drawXAxis(g);
        if (containsYAxis() ) drawYAxis(g);

        g.setColor(FUNC_COLOR); 

        for (int xPx = 0; xPx <= calc.GRAPH_WIDTH; xPx++) {
            double x = pixelToX(xPx); 
            double y = func.evaluate(x);

            if (isYOnPanel(y) ) {
                int yPx = yToPixel(y);
                g.drawRect(xPx, yPx, 1, 1);
            }
        }
        }
    
    public boolean containsXAxis() {
        boolean xAxis = (ymin <= 0) && (ymax >= 0); 
        return xAxis; 
    }

    public boolean containsYAxis() {
        boolean yAxis = (xmin <= 0) && (xmax >= 0); 
        return yAxis; 
    }

    public void drawXAxis(Graphics g) {
        int x1 = xToPixel(xmin);
        int y1 = yToPixel(0);
        int x2 = xToPixel(xmax);
        int y2 = yToPixel(0);
        g.drawLine(x1, y1, x2, y2);
    }

    public void drawYAxis(Graphics g) {
        int x1 = xToPixel(0);
        int y1 = yToPixel(ymin);
        int x2 = xToPixel(0);
        int y2 = yToPixel(ymax);
        g.drawLine(x1, y1, x2, y2);
    }

    public boolean isYOnPanel(double y) {
        boolean yOnPanel = (ymin <= y) && (y <= ymax);
        return yOnPanel; 
    }

    /*
    Algebraic manipulations based on the ratio:
    (pixel location/pixel range) = (var location/var range)
    */
    public int xToPixel(double x) { 
       
        double xRange = xmax - xmin; 
        double xPos = (x - xmin) / xRange;
        int xPx = (int)(xPos * calc.GRAPH_WIDTH);

        return xPx; 
    }

    public double pixelToX(int xPx) {
        double xRange = xmax - xmin; 
        double xPos = ( (double)xPx/calc.GRAPH_WIDTH) * xRange; 
        double x = xmin + xPos;

        return x; 
    }

    public int yToPixel(double y) {        
        double yRange = ymax - ymin; 
        double yPos = (y - ymin) / yRange;
        int yPx = (int)( (1.0 - yPos) * calc.GRAPH_HEIGHT);

        return yPx; 
    }

    public void getInput(GraphCalc calc) {
        func = calc.getFunc(func);
        xmin = calc.getXmin(xmin);
        ymin = calc.getYmin(ymin);
        xmax = calc.getXmax(xmax);
        ymax = calc.getYmax(ymax);
    }

    // Accessor methods
    /**
     * Get the associated PaintPanel.
     * @return panel PaintPanel to which this corresponds. 
     */
    public PaintPanel getPanel() {
        return this.panel;
    }

    /**
     * Get the associated GraphCalc. 
     * @return calc GraphCalc to which this corresponds.
     */
    public GraphCalc getCalc() {
        return this.calc; 
    }

    // Mutator methods
    
    /**
     * Set to which PaintPanel this corresponds. 
     * @param panel PaintPanel to which this will correspond
     * PRECONDITION: panel has to be a valid PaintPanel object
     */
    public void setPanel(PaintPanel panel) {
        this.panel = panel;
    }

    /**
     * Set to which GraphCalc this corresponds. 
     * @param calculator GraphCalc to which this will correspond
     * PRECONDITION: calculator must be a valid GraphCalc object
     */
    public void setCalc(GraphCalc calc) {
        this.calc = calc; 
    }

    public void prt(String s) {System.out.println(s);}

}