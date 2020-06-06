/**
 * Title: Circle.
 * @author Xi Chen
 * Andrew ID: xc4
 * Lecturer's Name: Terry Lee
 * Lab Section: HW4
 */
public class Circle extends Shape {
    /**
     * Constructor with radius parameter.
     * @param  newRadius radius of circle
     */
    public Circle(double newRadius) {
        radius = newRadius;
    }
    /**
     * Instance variable for radius.
     */
    private double radius;
    /**
     * Returns radius value of Circle object.
     * @return radius value in double
     */
    public double getRadius() {
        return radius;
    }
    /**
     * Returns double representation of circle area.
     * @return double representation of circle area
     */
    @Override
    public double getArea() {
        // TODO Auto-generated method stub
        return Math.PI * radius * radius;
    }
    /**
     * Returns perimeter value of shape object.
     * @return perimeter value in double
     */
    @Override
    public double getPerimeter() {
        // TODO Auto-generated method stub
        return 2 * Math.PI * radius;
    }
    /**
     * Returns String representation of Circle object.
     * @return String representation of Circle object
     */
    @Override
    public String toString() {
        return "Circle " + String.format("%1.3f", getArea())
            + " " + String.format("%1.3f", getPerimeter());
    }
}
