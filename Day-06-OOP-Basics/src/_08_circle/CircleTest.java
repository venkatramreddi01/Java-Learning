package _08_circle;

import java.util.Scanner;

class Circle {
    private double radius;
    private static final double PI = 3.14159;   // Static constant

    // Constructor
    public Circle(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            System.out.println("Radius must be positive! Setting to 1.");
            this.radius = 1;
        }
    }

    // Getter
    public double getRadius() {
        return radius;
    }

    // Setter
    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        } else {
            System.out.println("Radius must be positive!");
        }
    }

    // Calculate area
    public double calculateArea() {
        return PI * radius * radius;
    }

    // Calculate circumference
    public double calculateCircumference() {
        return 2 * PI * radius;
    }

    // Calculate diameter
    public double calculateDiameter() {
        return 2 * radius;
    }

    // Display info
    public void displayInfo() {
        System.out.println("\n--- Circle Information ---");
        System.out.println("Radius: " + radius);
        System.out.println("Diameter: " +calculateDiameter());
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + calculateCircumference());
        System.out.println("------------------------\n");
    }
}

public class CircleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter radius: ");
        double radius = scanner.nextDouble();

        Circle circle = new Circle(radius);
        circle.displayInfo();

        System.out.print("Enter new radius: ");
        double newRadius = scanner.nextDouble();
        circle.setRadius(newRadius);
        circle.displayInfo();

        scanner.close();
    }
}
