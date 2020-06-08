/**
 * ExprNode.java
 *
 * An interface to define the operation evaluate() on
 * nodes in an expression tree.
 * 
 * @author TVD
 * Wheaton College, CSCI 235
 * 
 * 
 */

public interface ExprNode {

    /**
     * Evaluate this expression tree.
     * @return The value of the expression of which this is the root.
     */
    int evaluate();
}
