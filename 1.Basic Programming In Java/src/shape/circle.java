package shape;


public class circle {
    private int radius;
    private static final double PI = 3.14;

    public circle(int radius) {
        this.radius = radius;
    }

    public double getArea (){
        return PI * radius * radius;
    }

}

