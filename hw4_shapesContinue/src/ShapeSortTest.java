/**
 * Title: ShapeSortTest.
 * @author Xi Chen
 * Andrew ID: xc4
 * Lecturer's Name: Terry Lee
 * Lab Section: HW4
 */
public class ShapeSortTest {
    /**
     * Compare the area in increasing order.
     * compare the perimeter in decreasing order.
     * @param args a string describes a kind of shape,
     * for example, C10 = circle with radius of 10.
     */

    public static void main(String[] args) {
        /**
         * parameter of shape, such like radius, sides, etc.
         */
        double pra;
        Shape[] shape = new Shape[args.length];
        for (int i = 0; i < args.length; i++) {
            char sha = args[i].charAt(0);
            /* From stackOverflow, Author: ConcurrentHashMap
             * Given a String "abcd1234";
                   String[] part = str.split("(?<=\\D)(?=\\d)");
                   System.out.println(part[0]);  abcd
                   System.out.println(part[1]);  1234
               Reason:
               \D matches all non-digit characters,
               while \d matches all digit characters.
               ?<= is a positive lookbehind
               (so everything before the current position
               is asserted to be a non-digit character),
               ?= is a positive lookahead
               (so everything after the current position is asserted as a digit)
             */
           /* String[] part = args[i].split("(?<=\\D)(?=\\d)");*/
            pra = Integer.parseInt(args[i].substring(1));
            /*
             * Choose a correct shape.
             */
            switch (sha) {
            case 'C' :
                shape[i] = new Circle(pra);
                break;
            case 'S' :
                shape[i] = new Square(pra);
                break;
            case 'H' :
                shape[i] = new Hexagon(pra);
                break;
            case 'O' :
                shape[i] = new Octagon(pra);
                break;
            default:
                break;
                }
            }
        /*
         * Sort shapes in increasing area order
         */
        for (int i = 0; i < shape.length; i++) {
            for (int j = i + 1; j < shape.length; j++) {
                if (shape[j].getArea() < shape[i].getArea()) {
                    Shape temp = shape[i];
                    shape[i] = shape[j];
                    shape[j] = temp;
                }
            }
        }
        for (Shape a : shape) {
            System.out.println(a);
        }
    System.out.println();
    /*
     * sort shapes in decreasing perimeter order.
     */
    for (int i = 0; i < shape.length; i++) {
        for (int j = i + 1; j < shape.length; j++) {
            if (shape[j].getPerimeter() > shape[i].getPerimeter()) {
                Shape temp = shape[i];
                shape[i] = shape[j];
                shape[j] = temp;
            }
        }
    }

    for (Shape a : shape) {
        System.out.println(a);
    }
    }
}

