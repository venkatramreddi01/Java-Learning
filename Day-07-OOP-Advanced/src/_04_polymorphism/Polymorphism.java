package _04_polymorphism;

class Shape {
    String color;

    Shape(String color) {
        this.color = color;
    }

    void draw() {
        System.out.println("Drawing a shape");
    }
    double getArea() {
        return 0;
    }

    double getPerimeter() {
        return 0;
    }
}

class Circle extends Shape {
    double radius;

    Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    void draw() {
        System.out.println("Drawing a " + color + " circle with radius " + radius);
    }

    double getArea() {
        return Math.PI * radius * radius;
    }

    double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    double length, width;

    Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    void draw() {
        System.out.println("Drawing a " + color + " rectangle " + length + "x" + width);
    }

    double getArea() {
        return length * width;
    }

    double getPerimeter() {
        return 2 * (length + width);
    }
}

class Triangle extends Shape {
    double base, height, side1, side2, side3;

    Triangle(String color, double base, double height, double side1, double side2, double side3) {
        super(color);
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    void draw() {
        System.out.println("Drawing a " + color + " triangle");
    }

    double getArea() {
        return 0.5 * base * height;
    }

    double getPerimeter() {
        return side1 + side2 + side3;
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        // Polymorphism - parent reference, child objects
        Shape[] shapes = new Shape[3];

        shapes[0] = new Circle("Red", 5);
        shapes[1] = new Rectangle("Blue", 4, 6);
        shapes[2] = new Triangle("Green", 3, 4, 3, 4, 5);

        System.out.print("=== Polymorphism in Action ===\n");

        for(Shape shape: shapes) {
            shape.draw();
            System.out.println("Area: " + shape.getArea());
            System.out.println("Perimeter: " + shape.getPerimeter());
            System.out.println();
        }
    }
}
