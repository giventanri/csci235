/**
 * Circle.java
 * 
 * Class to represent a circle
 *
 * @author Given Tanri
 * CSCI 235, Wheaton College, Spring 2020
 * Lab 8
 * Date 20200331
 */

public class Circle implements Shape {

    /**
     * The radius of this circle
     */
    private double radius;

    /**
     * Constructor for initializing a Circle's instance variables.
     * @param radius The value for radius
     */
    public Circle(double radius) {
        this.radius = radius; 
    }


    /**
     * Return the area of this circle.
     * @return The area of this circle
     */ 
    public double getArea() {
	return Math.PI * radius * radius;
    }

    /**
     * Return the perimeter of this circle.
     * @return The perimeter of this circle
     */ 
    public double getPerimeter() {
	return 2.0 * Math.PI * radius; 
    }
    
    /**
     * Return the information of this circle
     * @return The information of this circle
     */ 
    public String toString() {
	return "\n --CIRCLE-- \n" +	    
	    " Radius: " + radius + "\n" +
	    " Area: " + getArea() + "\n" +
	    " Perimeter: " + getPerimeter() + "\n";
	    
    }

}
