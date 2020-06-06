/**
 * Title: Rectangle.
 * @author Xi Chen
 * Andrew ID: xc4
 * Lecturer's Name: Terry Lee
 * Lab Section: HW3
 */
public class Rectangle extends Shape {
    /**
     * Instance variable for width.
     */
    private double width;
    /**
     * Instance variable for height.
     */
    private double height;
    /**
     * Constructor with width and height parameter.
     * @param  newWidth side of width
     * @param  newHeight side of height
     */
    public Rectangle(double newWidth, double newHeight) {
        super(newWidth * newHeight, 2 * (newWidth + newHeight));
        width = newWidth;
        height = newHeight;
    }
    /**
     * Returns width value of Rectangle object.
     * @return width value in double
     */
    public double getWidth() {
        return width;
    }
    /**
     * Returns height value of Rectangle object.
     * @return height value in double
     */
    public double getHeight() {
        return height;
    }
    /**
     * Returns String representation of Rectangle object.
     * @return String representation of Rectangle object
     */
    @Override
    public String toString() {
        return  "Rectangle " + String.format("%1.3f", getArea()) + " "
                + String.format("%1.3f", getPerimeter());
    }

}
