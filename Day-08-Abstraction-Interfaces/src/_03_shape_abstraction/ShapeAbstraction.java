package _03_shape_abstraction;

abstract class Shape {
    String name;
    String color;

    Shape(String name, String color) {
        this.name = name;
        this.color = color;
    }

    // Abstract methods
    abstract double calculateArea();
    abstract double calculatePerimeter();

    // Concrete methods
    void displayInfo() {
        System.out.println("\n=== " + name + " ===");
        System.out.println("Color: " + color);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println();
    }

    void draw() {
        System.out.println("Drawing a " + color + " " + name);
    }
}

class Circle extends Shape {
    double radius;

    Circle(String color, double radius) {
        super("Circle", color);
        this.radius = radius;
    }
    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    double length, width;

    Rectangle(String color, double length, double width) {
        super("Rectangle", color);
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }

    @Override
    double calculatePerimeter() {
        return 2 * (length + width);
    }
}

class Triangle extends Shape {
    double side1, side2, side3;

    Triangle(String color, double side1, double side2, double side3) {
        super("Triangle", color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }


    @Override
    double calculateArea() {
        // Using Heron's formula
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    double calculatePerimeter() {
        return side1 + side2 + side3;
    }
}

public class ShapeAbstraction {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];

        shapes[0] = new Circle("Red", 5);
        shapes[1] = new Rectangle("Blue", 3, 6);
        shapes[2] = new Triangle("Green", 3, 4, 5);

        for(Shape shape : shapes) {
            shape.draw();
            shape.displayInfo();
        }
    }
}
