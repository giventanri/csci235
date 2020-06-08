
/**
 * VariableNode.java
 *
 * A class for a leaf node in expression.
 *
 * @author HK
 * Wheaton College, CSCI 235
 * Project #7
 * 
 */


// Need to document this class 
public class Variable implements ExprNode {

    private double value;
    private String x;

    public Variable (String text) {
	x = text;

    }

    public double evaluate(double n) {
	value = n;
	return value;
    }


}
