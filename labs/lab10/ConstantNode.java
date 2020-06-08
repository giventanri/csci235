/**
 * ConstantNode.java
 *
 * An class for Parse trees that stores a constant
 * in an Expression
 * 
 * @author Given Tanri
 * Wheaton College, CSCI 235, Spring 2020
 * Lab 10
 * Date 20200414
 */
public class ConstantNode implements ExprNode {
    /**
     * The integer value of the constant expression.
     */
    private int value;

    /**
     * Constructor with a String text provided
     * PRECONDITION: text can be parsed into an integer
     * @param text String to be parsed into a Constant value
     */
    public ConstantNode (String text) {
        this.value = Integer.parseInt(text);
    }

    /**
     * Evaluate the constant
     * @return value The value of the constant
     * PRECONDITION: value of this ConstantNode is a valid integer
     */
    public int evaluate() {
        return value;
    }
}
