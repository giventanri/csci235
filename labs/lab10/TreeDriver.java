/**
 * TreeDriver.java
 *
 * A test driver for trees.
 *
 * @author CGG & the class
 * Wheaton College, CSCI 235, Spring 2020
 * Lab 10
 * 
 */

public class TreeDriver {

    public static void main(String[] args) {

        TreeNode tree = 
            new TreeNode(1, 
                         new TreeNode(2, 
                                      new TreeNode(4, null, null) ,
                                      new TreeNode(5, null, null)),
                         new TreeNode(3,
                                      null, //new TreeNode(6, null, null),
                                      new TreeNode(7, null, null)));

        System.out.println(tree.count());
	System.out.println("pre");
        System.out.println(tree.displayPreOrder() );
	System.out.println("in");
        System.out.println(tree.displayInOrder() );
	System.out.println("post");
        System.out.println(tree.displayPostOrder() );

        TreeNode leftTree = 
        new TreeNode(1, 
                     new TreeNode(2, 
                                  new TreeNode(3, null, null) ,
                                  null),
                     null);
                    
    System.out.println("\n leftTree");
    System.out.println(leftTree.count());
    System.out.println("pre");
    System.out.println(leftTree.displayPreOrder() );
    System.out.println("in");
    System.out.println(leftTree.displayInOrder() );
    System.out.println("post");
    System.out.println(leftTree.displayPostOrder() );

    TreeNode rightTree = 
    new TreeNode(1, 
                 null, 
                 new TreeNode(2,
                              null, //new TreeNode(6, null, null),
                              new TreeNode(3, null, null)));

                              System.out.println("\n rightTree");
System.out.println(rightTree.count());
System.out.println("pre");
System.out.println(rightTree.displayPreOrder() );
System.out.println("in");
System.out.println(rightTree.displayInOrder() );
System.out.println("post");
System.out.println(rightTree.displayPostOrder() );
    }
}
