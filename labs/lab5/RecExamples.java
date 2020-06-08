/**
 * RecExamples.java
 *
 * This program exercises recursive method calls.
 *
 * @author CGG, HK, and Micaela Van Meter, Given Tanri
 * CSCI 235, Wheaton College
 * Lab 5
 * 20200225
 */

public class RecExamples {

    public static void rPrint(int n) {
	if (n <= 0) {
	    System.out.println("That's all, folks!");
	} else {
	    System.out.print(n+"... ");
	    rPrint(n-1);
	}
    }

    public static void countDown(int n, String indent) {
        System.out.println(indent+"start countDown("+n+", ...)");
        if (n <= 0) {
            System.out.println(indent+"base case");
        } else {
            countDown(n-1, indent+"|  ");
        }
        System.out.println(indent+"end   countDown("+n+", ...)");
    }

    public static int rProduct(int a, int b) {
	if (b == 0) {
	    return 0;
	} else if (b == 1) {
	    return a;
	} else {
	    return a + rProduct(a, b-1);
	}
    }

    public static int rProductT(int a, int b, String indentBy, String indent) {
	int result;

	if (!indentBy.isEmpty()) {
	    System.out.println(indent+"start rProductT("+a+", "+b+", "+indentBy+", ...)");
	}
	if (b == 0) {
	    result = 0;
	} else if (b == 1) {
	    result = a;
	} else {
	    result = a + rProductT(a, b-1, indentBy, indent+indentBy);
	}

	if (!indentBy.isEmpty()) {
	    System.out.println (indent+"returns "+result);
	}
	return result;
	
    }
   
    public static void showRPrint() {
	System.out.println("----- rPrint:");
	rPrint(0);
	System.out.println("\n---------------------");
	rPrint(3);
	System.out.println("\n---------------------");
	rPrint(4);
    }

    public static void showCountDown() {
        System.out.println("----- countDown:");
        countDown(0, "");
        System.out.println("\n---------------------");
        countDown(2, "");
        System.out.println("\n---------------------");
        countDown(4, "");
    }
   
    public static void showRProduct() {
	System.out.println("----- rProduct(2, 0):");
	int k = rProduct(2, 0);
	System.out.println(k);
	System.out.println("\n----- rProduct(3, 1):");
	k = rProduct(3, 1);
	System.out.println(k);
	System.out.println("\n----- rProduct(4, 5):");
	k = rProduct(4, 5);
	System.out.println(k);
    }
   
    public static void showRProductT(String indentBy) {
	System.out.println("----- rProductT(2, 0, \""+indentBy+"\", ...):");
        int k = rProductT(2, 0, indentBy, "");
        System.out.println(k);
        System.out.println("\n----- rProductT(3, 1, \""+indentBy+"\", ...):");
        k = rProductT(3, 1, indentBy, "");
        System.out.println(k);
        System.out.println("\n----- rProductT(2, 3, \""+indentBy+"\", ...):");
        k = rProductT(2, 3, indentBy, "");
        System.out.println(k);
    }

    /**
     * Find the Greatest Common Denominator of two positive integers.
     * @param a first integer
     * @param b second integer
     * @return the Greatest Common Denominator
     */
    public static int findGCD(int a, int b) {
	    if (a % b == 0) {
		return b;
	    } else { 
		return findGCD(b, a % b);
	}
    }




    
    public static void main(String[] args) {
	showRPrint();
	System.out.println();
	showCountDown();
	System.out.println();
	showRProduct();
	System.out.println();
	showRProductT("");
	System.out.println();
	showRProductT("|  ");
	System.out.println();	

	System.out.println("GCD of 5 and 10: " + findGCD(5,10));
	System.out.println("GCD of 54 and 24: " + findGCD(54,24));



    }
}
