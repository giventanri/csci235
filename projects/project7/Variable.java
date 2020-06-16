/**
 * Variable.java
 *
 * An class for Parse trees that stores a variable
 * in an Expression
 * 
 * @author Given Tanri
 * Wheaton College, CSCI 235, Spring 2020
 * Project 7
 * 20200502
 */
public class Variable implements ExprNode {

    /**
     * The String value of the Variable
     */
    private String name;
    
    /**
     * The double value of the Variable expression.
     */
    private double value;

    /**
     * Constructor with a String text provided
     * PRECONDITION: text can be parsed into an integer
     * @param name String to be parsed into the Variable name
     */
    public Variable (String name) {
        this.name = name;
    }

    /**
     * Evaluate the Variable
     * @param x The value assigned to the Variable
     * @return value The double value of the Variable
     * PRECONDITION: value of this Variable is a valid double
     */
    public double evaluate(double x) {
        this.value = x;
        return this.value;
    }

}