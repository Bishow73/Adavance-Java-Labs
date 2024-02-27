package shape;


public class ShapeDemo {
    public static void main(String[] args) {
        circle c = new circle(2);
        System.out.println("the Area of circle is"+ c.getArea());
        Square s = new Square(3);
        System.out.println("the area of Square is"+ s.getArea());
        System.out.println("the side of a square is"+s.getSide());
    }
}

