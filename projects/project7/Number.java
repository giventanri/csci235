/**
 * Number.java
 *
 * An class for Parse trees that stores a constant
 * in an Expression
 * 
 * @author Given Tanri
 * Wheaton College, CSCI 235, Spring 2020
 * Project 7
 * 20200502
 */
public class Number implements ExprNode {
    /**
     * The integer value of the Constant expression.
     */
    private double value;

    /**
     * Constructor with a String text provided
     * PRECONDITION: text can be parsed into an integer
     * @param text String to be parsed into a Constant value
     */
    public Number (String text) {
        this.value = Double.parseDouble(text);
    }

    /**
     * Evaluate the constant
     * @param d The value of a Variable (not used; artifact)
     * @return value The value of the constant
     * PRECONDITION: value of this Constant is a valid integer
     */
    public double evaluate(double d) {
        return this.value;
    }
}
