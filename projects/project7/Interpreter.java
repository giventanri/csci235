/**
 * Interpreter.java
 *
 * Class to generate ExprNode trees based on a given
 * input.
 *
 * @author
 * CSCI 235, Wheaton College, Spring 2020
 * Project 7
 * Date? 
 */

public class Interpreter {

    /**
     * Turn a string into an ExprNode tree.
     *
     * @param input The string to parse
     * @return The root of the ExprNode tree
     */
    public static ExprNode parse(String input) {
		
            String nodes[] = ExprStringSlicer.slice(input);
                
            ExprNode out = null;

            for (String node: nodes) System.out.println("parse node: "+node);
        
            /*
              If the length is one, 
              the expression must be a constant or a variable.
              Else, 
              the expresssion must be an operation: 
              (left expression) operation (right expression)
             */
            if (nodes.length == 1) {  //base case
                if (nodes[0] == "x") out = new Variable(nodes[0]);
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
        for (String arg: args) System.out.println("main arg: "+arg);
        ExprNode tree = parse(args[0]);
        System.out.println(tree.evaluate(Double.parseDouble(args[1])));
    }


}
