/**
 * Operation.java
 *
 * An class for Parse trees that stores a Operator
 * in an Expression
 * 
 * @author Given Tanri
 * Wheaton College, CSCI 235, Spring 2020
 * Project 7
 * 20200502
 */
public class Operation implements ExprNode {

    /**
     * The operator.
     */
    private String operator;

    /**
     * The expression left to the operator.
     */
    private ExprNode left;

    /**
     * The expression right to the operator.
     */
    private ExprNode right;
    
    /**
     * Constructor to complete and expression involving
     * an expression, an operator, and another expression.
     * PRECONDITION: valid operators and expressions are inputted
     * @param operator String to be parsed into an operator
     * @param leftOperand Expression to the left of the operator
     * @param rightOperand Expression to the right of the operator
     */
    public Operation (String operator, ExprNode leftOperand, ExprNode rightOperand) {
        this.operator = operator;
        this.left = leftOperand;
        this.right = rightOperand;
    }

    /**
     * Evaluate the expression
     * @param d The value of a Variable (not used; artifact)
     * @return The value of the expression
     * PRECONDITION: all instance variables of this OperatorNode are valid
     */
    public double evaluate(double d) {
        double x = left.evaluate();
        double y = right.evaluate();
        String op = operator; 

        if (op.equals("+") ) return x + y;
        if (op.equals("-") ) return x - y;
        if (op.equals("*") ) return x * y;
        if (op.equals("/") ) return x / y;
        if (op.equals("^") ) return Math.pow(x, y);
        else return 0;
    }
}
