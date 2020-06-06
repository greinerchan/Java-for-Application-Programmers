/**
 * Title: Hexagon.
 * @author Xi Chen
 * Andrew ID: xc4
 * Lecturer's Name: Terry Lee
 * Lab Section: HW3
 */
public class Hexagon extends Shape {
    /**
     * Instance variable for side.
     */
    private double side;
    /**
     * Constructor with side parameter.
     * @param  newSide side of Hexagon
     */
    public Hexagon(double newSide) {
        super((3 * Math.sqrt(3)) / 2 * Math.pow(newSide, 2), 6 * newSide);
        side = newSide;
    }
    /**
     * Returns side value of Hexagon object.
     * @return side value in double
     */
    public double getSide() {
        return side;
    }
    /**
     * Returns String representation of Hexagon object.
     * @return String representation of Hexagon object
     */
    @Override
    public String toString() {
        return "Hexagon " + String.format("%1.3f", getArea())
                + " " + String.format("%1.3f", getPerimeter());
    }
}
