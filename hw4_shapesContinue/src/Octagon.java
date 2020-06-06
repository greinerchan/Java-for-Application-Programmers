/**
 * Title: Octagon.
 * @author Xi Chen
 * Andrew ID: xc4
 * Lecturer's Name: Terry Lee
 * Lab Section: HW4
 */
public class Octagon extends Shape {
    /**
     * Instance variable for side.
     */
    private double side;
    /**
     * Constructor with side parameter.
     * @param  newSide side of Octagon
     */
    public Octagon(double newSide) {
        side = newSide;
    }
    /**
     * Returns side value of Octagon object.
     * @return side value in double
     */
    public double getSide() {
        return side;
    }
    /**
     * Returns double representation of octagon area.
     * @return double representation of octagon area
     */
    @Override
    public double getArea() {
        // TODO Auto-generated method stub
        return 2 * (1 + Math.sqrt(2)) * Math.pow(side, 2);
    }
    /**
     * Returns perimeter value of shape object.
     * @return perimeter value in double
     */
    @Override
    public double getPerimeter() {
        // TODO Auto-generated method stub
        return 8 * side;
    }
    /**
     * Returns String representation of Octagon object.
     * @return String representation of Octagon object
     */
    @Override
    public String toString() {
        return "Octagon " + String.format("%1.3f", getArea())
                + " " + String.format("%1.3f", getPerimeter());
    }
}
