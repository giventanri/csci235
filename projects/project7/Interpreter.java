/**
 * Interpreter.java
 *
 * Class to generate ExprNode trees based on a given
 * input.
 *
 * @author Given Tanri
 * CSCI 235, Wheaton College, Spring 2020
 * Project 7
 * 20200502
 */

public class Interpreter {

    /**
     * Turn a string into an ExprNode tree.
     * @param input The string to parse
     * @return The root of the ExprNode tree
     * PRECONDITION: valid operators and expressions are inputted
     * using the paranthesis format, e.g. "(((0 - 3) * (x ^ 2)) + 5)"
     */
    public static ExprNode parse(String input) {
        
            // slice input to smaller String objects
            String nodes[] = ExprStringSlicer.slice(input);
            
            ExprNode out = null; // store ExprNode to be returned
        
            /*
              Base cases:
                If the length is one, 
              the expression must be a variable or a constant.
              
              Recursive case:
                Else,
              the expresssion must be an operation: 
              (left expression) operation (right expression)
             */
            if (nodes.length == 1) {  //base case
                if (nodes[0].equals("x")) out = new Variable(nodes[0]);
                else out = new Number(nodes[0]);

            } else {	      	//recursive case
                ExprNode left = parse(nodes[0]);
                ExprNode right = parse(nodes[2]);
                out = new Operation(nodes[1], left, right);
            }
            
            return out;
    }

    /**
     * For testing project 7 (Part A).
     */

    public static void main(String[] args) {
      ExprNode tree = parse(args[0]);
      System.out.println(tree.evaluate(Double.parseDouble(args[1])));
    }

}