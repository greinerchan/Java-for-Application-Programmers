/**
 * Title: Square.
 * @author Xi Chen
 * Andrew ID: xc4
 * Lecturer's Name: Terry Lee
 * Lab Section: HW4
 */
public class Square extends Rectangle {
    /**
     * Instance variable for side.
     */
    private double side;
    /**
     * Constructor with side parameter.
     * @param  newSide side of Square
     */
    public Square(double newSide) {
        super(newSide, newSide);
        side = newSide;
    }
    /**
     * Returns side value of Square object.
     * @return side value in double
     */
    public double getSide() {
        return side;
    }
    /**
     * Returns String representation of Square object.
     * @return String representation of Square object
     */
    @Override
    public String toString() {
        return "Square " + String.format("%1.3f", getArea()) + " "
                + String.format("%1.3f", getPerimeter());
    }

}
