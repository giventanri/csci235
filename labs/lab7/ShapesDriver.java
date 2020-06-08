/**
 * ShapesDriver.java
 * 
 * Program to test Rectangle and Circle
 *
 * @author HK and Given Tanri, Emily Ray, Youyeon Chun
 * CSCI 235, Wheaton College, Spring 2020
 * Lab 7
 * Date 20200324
 */
public class ShapesDriver {

    public static void main(String[] args) {
		
		//Get two double values
		double d1 = Double.parseDouble(args[0]);
		double d2 = Double.parseDouble(args[1]);
		
		
		//Create an instance of Rectangle
		Rectangle rec = new Rectangle(d1, d2);
		
		//Print the area and the perimeter of the rectangle
		System.out.println ("The area of rectangle: " + rec.getArea());
		System.out.println ("The perimeter of rectangle: " + rec.getPerimeter());
		
		
		//Create an instance of Circle
		Circle cir = new Circle(d1);

		//Print the area, the perimeter, and toString output of the circle
		System.out.println ("The area of circle: " + cir.getArea());
		System.out.println ("The perimeter of circle: " + cir.getPerimeter());
		System.out.println ("The output of toString(): " + cir.toString());
	       
        
    }
}

