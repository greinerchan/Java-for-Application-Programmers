/**
 * Title: Circle.
 * @author Xi Chen
 * Andrew ID: xc4
 * Lecturer's Name: Terry Lee
 * Lab Section: HW3
 */
public class Circle extends Shape {
    /**
     * Instance variable for radius.
     */
    private double radius;
    /**
     * Constructor with radius parameter.
     * @param  newRadius radius of circle
     */
    public Circle(double newRadius) {
        super(Math.PI * newRadius * newRadius, 2 * Math.PI * newRadius);
        radius = newRadius;
    }
    /**
     * Returns radius value of Circle object.
     * @return radius value in double
     */
    public double getRadius() {
        return radius;
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
