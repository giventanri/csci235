/**
 * Rectangle.java
 * 
 * Class to represent a rectangle
 *
 * @author HK and Given Tanri, Emily Ray, Youyeon Chun
 * CSCI 235, Wheaton College, Spring 2020
 * Lab 7
 * Date 20200324
 */

public class Rectangle {

    /**
     * The width of this rectangle
     */
    private double width;

    /**
     * The height of this rectangle
     */
    private double height;


    /**
     * Constructor for initializing a Rectangle's instance variables.
     * @param width The value for width
     * @param height The value for height 
     */
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }


    /**
     * Return the area of this rectangle.
     * @return The area of this rectangle
     */ 
    public double getArea() {
	return width * height;
    }

    /**
     * Return the perimeter of this rectangle.
     * @return The perimeter of this rectangle
     */ 
    public double getPerimeter() {
	return 2.0 * (width + height);	
    }
    
}
