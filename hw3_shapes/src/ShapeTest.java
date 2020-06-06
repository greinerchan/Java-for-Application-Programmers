
public class ShapeTest {

    public static void main(String[] args) {
        Shape ccc = new Shape(2,5);
        Circle wwdw = new Circle(0.02);
        System.out.println(ccc);
        System.out.println(wwdw);
        Square eee = new Square(5);
        System.out.println(eee);
        Shape aaa = (Shape) eee;
        System.out.println(aaa);
        Shape cc = (Shape) wwdw;
        System.out.println(cc);
    }
}
