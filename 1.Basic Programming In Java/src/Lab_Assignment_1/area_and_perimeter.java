package Lab_Assignment_1;

public class area_and_perimeter{
    public double findPerimeter(double length, double breadth) {
        return 2 * (length + breadth);
    }

    public double findArea1(double length, double breadth) {
        return length * breadth;
    }

    public static void main(String[] args) {
        area_and_perimeter fa = new area_and_perimeter();
        double result = fa.findPerimeter(2, 3);
        double areaResult = fa.findArea1(2, 3);
        System.out.println("the result of perimeter is " + result);
        System.out.println("the result of area is " + areaResult);

    }

}
