/**
 * Title: Shape.
 * @author Xi Chen
 * Andrew ID: xc4
 * Lecturer's Name: Terry Lee
 * Lab Section: HW3
 */
public class Shape {
    /**
     * Instance variable for area.
     */
    private double area;
    /**
     * Instance variable for perimeter.
     */
    private double perimeter;
    /**
     * Constructor with area and height perimeter.
     * @param  newArea side of area
     * @param  newPerimeter side of perimeter
     */
    public Shape(double newArea, double newPerimeter) {
        area = newArea;
        perimeter = newPerimeter;
    }
    /**
     * Returns area value of shape object.
     * @return area value in double
     */
    public double getArea() {
        return area;
    }
    /**
     * Returns perimeter value of shape object.
     * @return perimeter value in double
     */
    public double getPerimeter() {
        return perimeter;
    }
    /**
     * Returns String representation of Shape object.
     * @return String representation of Shape object
     */
    @Override
    public String toString() {
        return "Shape " + String.format("%1.3f", getArea())
                + " " + String.format("%1.3f", getPerimeter());
    }
}
