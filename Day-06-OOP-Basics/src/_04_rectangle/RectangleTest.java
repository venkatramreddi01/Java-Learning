package _04_rectangle;

import org.w3c.dom.css.Rect;

import java.util.Scanner;

class Rectangle {
    private double length;
    private double width;

    // Constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Getters
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    // Setters
    public void setLength(double length) {
        if (length > 0) {
            this.length = length;
        } else {
            System.out.println("Length must be positive!");
        }
    }

    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        } else {
            System.out.println("Width must be positive!");
        }
    }

    // Calculate area
    public double calculateArea() {
        return length * width;
    }

    // Calculate perimeter
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    // Check if square
    public boolean isSquare() {
        return length == width;
    }

    // Display info
    public void displayInfo() {
        System.out.println("\n--- Rectangle Information ---");
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " +calculatePerimeter());
        System.out.println("Is Square? " + (isSquare() ? "Yes" : "No"));
        System.out.println("---------------------------\n");
    }
}

public class RectangleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length: ");
        double length = scanner.nextDouble();

        System.out.print("Enter width: ");
        double width = scanner.nextDouble();

        Rectangle rect = new Rectangle(length, width);
        rect.displayInfo();

        // Create a square
        Rectangle square = new Rectangle(5, 5);
        square.displayInfo();

        scanner.close();
    }
}



















