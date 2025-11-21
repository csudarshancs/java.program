import java.util.Scanner;


abstract class Shape {
    double dim1;
    double dim2;

    public Shape(double dim1,double dim2){
        this.dim1=dim1;
        this.dim2=dim2;
    }
    public abstract void printArea();
}

class Rectangle extends Shape{
    public Rectangle(double length,double width){
        super(length,width);
    }
    public void printArea(){
        double area=dim1*dim2;
        System.out.println("Area of Rectangle="+area);
    }
}
class Triangle extends Shape{
    public Triangle(double base,double height){
        super(base,height);
    }
    public void printArea(){
        double area= 0.5* dim1* dim2;
        System.out.println("Area of Triangle="+area);
    }
}

class Circle extends Shape{
    public Circle(double radius){
        super(radius,0);
    }
    public void printArea(){
        double area = 3.14*dim1*dim1;
        System.out.println("Area of circle="+area);
    }
}

public class ShapeDemo{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter Dimension of the rectangle");
        System.out.print("Enter Length:");
        double recLen=s.nextDouble();
        System.out.print("Enter Breadth:");
        double recWidt=s.nextDouble();
        Shape rect=new Rectangle(recLen,recWidt);
        

        System.out.println("\nEnter Dimension of the triangle(Base and Height):");
        System.out.print("Enter Base:");
        double triBase=s.nextDouble();
        System.out.print("Enter Height:");
        double triHeight=s.nextDouble();
        Shape tri=new Triangle(triBase,triHeight);

        System.out.println("\nEnter Dimension of the Circle(radius):");
        System.out.print("Enter Radius:");
        double r=s.nextDouble();
        Shape circle=new Circle(r);

        rect.printArea();
        tri.printArea();
        circle.printArea();

    }
}