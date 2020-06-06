/**
 * Title: Hexagon.
 * @author Xi Chen
 * Andrew ID: xc4
 * Lecturer's Name: Terry Lee
 * Lab Section: HW4
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
     * Returns double representation of hexagon area.
     * @return double representation of hexagon area
     */
    @Override
    public double getArea() {
        // TODO Auto-generated method stub
        return (3 * Math.sqrt(3)) / 2 * Math.pow(side, 2);
    }
    /**
     * Returns perimeter value of shape object.
     * @return perimeter value in double
     */
    @Override
    public double getPerimeter() {
        // TODO Auto-generated method stub
        return 6 * side;
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
