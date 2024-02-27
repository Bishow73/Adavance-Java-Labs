package shape;


public class Square {
    private final double side;

    public Square(int side){
        this.side  = side;
    }

    public double getArea() {
        return this.side * this.side;
    }
    public double getSide() {
        return side;
    }
}

