package Homework2;

public class Shape {

    public Shape(int length){
        calculateSquareArea(length);
    }
    public Shape(int length, int width){
        calculateRectangleArea(length,width);
    }
    public Shape(double radius){
        System.out.println("The area of the circle is :" + radius*radius*Math.PI);
    }

    public void calculateSquareArea(int length){
        System.out.println("The area of the square is :" + length*length);
    }

    public void  calculateRectangleArea(int length, int width){
        System.out.println("The area of the rectangle is :" + length*width);
    }
}
