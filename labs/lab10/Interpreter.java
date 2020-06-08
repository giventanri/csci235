/**
 * Interpreter.java
 *
 * A parser/interpreter for expressions.
 * 
 * @author TVD, CGG, HK, and Given Tanri
 * Wheaton College, CSCI 235, Spring 2020
 * Lab 10
 * Date 20200414
 */

public class Interpreter {

    public static void main(String[] args) {

        ExprNode expr = parse(args[0]);

        System.out.println(expr.evaluate());
    }

    /**
     * Parse an expression.
     * @param expr The string to parse.
     * @return The root of a tree corresponding to the expression.
     * PRECONDITION: expr is a properly formed expression
     */
    public static ExprNode parse(String expr) {
		
	String nodes[] = ExprStringSlicer.slice(expr);
		
	ExprNode out = null;

	/*
	  If the length is one, 
	  the expression must be a constant.
	  Else, 
	  the expresssion must be an operation: 
	  (left expression) operation (right expression)
	 */
	if(nodes.length == 1) {  //base case
	    out = new ConstantNode(nodes[0]);
	} else {	      	//recursive case
	    ExprNode left = parse(nodes[0]);
	    ExprNode right = parse(nodes[2]);
	    out = new OperatorNode(nodes[1], left, right);
	}
		
	return out;
    }
}
