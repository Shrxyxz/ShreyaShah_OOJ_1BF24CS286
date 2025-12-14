import java.util.Scanner;

abstract class Shape {
    protected int dim1;
    protected int dim2;

    public abstract void printArea();
}


class Rectangle extends Shape {

     public Rectangle(int length, int width) {
        this.dim1 = length;
        this.dim2 = width;
    }

    
    @Override
    public void printArea() {
        int area = dim1 * dim2;
        System.out.println("Area of Rectangle: " + area);
    }
}

class Triangle extends Shape {

    public Triangle(int base, int height) {
        this.dim1 = base;
        this.dim2 = height;
    }

    
    @Override
    public void printArea() {
        // Use 0.5 to ensure floating-point calculation
        double area = 0.5 * dim1 * dim2;
        System.out.println("Area of Triangle: " + area);
    }
}


class Circle extends Shape {

     public Circle(int radius) {
        this.dim1 = radius;
    }

   
    @Override
    public void printArea() {
       
        double area = Math.PI * dim1 * dim1;
        
        
        System.out.printf("Area of Circle: %.2f\n", area);
    }
}


public class Shapes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Rectangle input
        System.out.println("Enter dimensions for Rectangle:");
        System.out.print("Enter length: ");
        int length = sc.nextInt();
        System.out.print("Enter width: ");
        int width = sc.nextInt();
        Shape rectangle = new Rectangle(length, width);

        // Triangle input
        System.out.println("\nEnter dimensions for Triangle:");
        System.out.print("Enter base: ");
        int base = sc.nextInt();
        System.out.print("Enter height: ");
        int height = sc.nextInt();
        Shape triangle = new Triangle(base, height);

        // Circle input
        System.out.println("\nEnter dimensions for Circle:");
        System.out.print("Enter radius: ");
        int radius = sc.nextInt();
        Shape circle = new Circle(radius);

        System.out.println("\n--- Areas of Shapes ---");
        rectangle.printArea();
        triangle.printArea();
        circle.printArea();

        sc.close();
    }
}
