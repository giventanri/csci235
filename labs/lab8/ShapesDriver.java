/**
 * ShapesDriver.java
 * 
 * Program to test Rectangle and Circle
 *
 * @author HK and Given Tanri
 * CSCI 235, Wheaton College, Spring 2020
 * Lab 8
 * Date 20200331
 */
public class ShapesDriver {

    public static void main(String[] args) {
		
		//Get three double values
		double d1 = Double.parseDouble(args[0]);
		double d2 = Double.parseDouble(args[1]);
		double d3 = Double.parseDouble(args[2]);
		
		//Create instances
		Shape s1 = new Circle(d1);
		Circle cir = new Circle(d2);
		Shape s2 = new Triangle(d1, d2, d3);
		Shape s3 = cir;
		Rectangle rect = new Rectangle(d2, d3);
		
		//Assign the five instances to the array of Shape interface type 
		Shape[] myShapes = new Shape[5];
		myShapes[0] = s1;
		myShapes[1] = cir;
		myShapes[2] = s2;
		myShapes[3] = s3;
		myShapes[4] = rect; 
		
		
		//Print areas and perimeters of the instances in the array
		for (int i = 0; i < myShapes.length; i++) {
			System.out.println("Area: " + myShapes[i].getArea() + "\tPerimeter: " + myShapes[i].getPerimeter());
		}
		
    }
}

