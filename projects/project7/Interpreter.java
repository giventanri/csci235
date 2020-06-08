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

        return null;   // delete this line

    }

    /**
     * For testing project 7 (Part A).
     */
    public static void main(String[] args) {
        ExprNode tree = parse(args[0]);
        System.out.println(tree.evaluate(Double.parseDouble(args[1])));
    }


}
