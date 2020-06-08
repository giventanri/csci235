/**
 * Triangle.java
 * 
 * Class to represent a rectangle
 *
 * @author HK and Given Tanri
 * CSCI 235, Wheaton College, Spring 2020
 * Lab 8
 * Date 20200331
 */

public class Triangle implements Shape {

    /**
     * The length of side A of this Triangle 
     */
    private double sideA;
    
    /**
     * The length of side B of this Triangle 
     */
    private double sideB;
    /**

     * The length of side C of this Triangle 
     */
    private double sideC;

    /**
     * Constructor for initializing a Rectangle's instance variables.
     * @param sideA The value for side A length
     * @param sideB The value for side B length
     * @param sideC The value for side C length
     */
    public Triangle(double sideA, double sideB, double sideC) {
	this.sideA = sideA;
	this.sideB = sideB;
	this.sideC = sideC;	    
    }


    /**
     * Return the area of this Triangle.
     * @return area The area of this Triangle
     */
    // Area = sqrt( s * (s-a) * (s-b) * (s-c) )
    // where s = (a + b + c)/2    
    public double getArea() {
	double s = (this.sideA + this.sideB + this.sideC) / 2;
	double sqrtParam = s * (s - sideA) * (s - sideB) * (s - sideC);
	double area = Math.sqrt(sqrtParam);
	return area;
    }

    /**
     * Return the perimeter of this Triangle.
     * @return The perimeter of this Triangle
     */ 
    public double getPerimeter() {
	return this.sideA + this.sideB + this.sideC;
    }
    
}
