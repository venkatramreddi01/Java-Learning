package _01_exception_basics;

import java.util.Scanner;

public class ExceptionBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example 1: Divide by zero
        System.out.println("=== Division Example ===");
        try {
            System.out.print("Enter first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter second number: ");
            int num2 = scanner.nextInt();

            int result = num1 / num2;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
            System.out.println("Details: " + e.getMessage());
        }

        // Example 2: Array index out of bounds
        System.out.println("\n=== Array Example ===");
        try {
            int[] numbers = {10, 20, 30, 40, 50};
            System.out.print("Enter index (0-4): ");
            int index = scanner.nextInt();

            System.out.println("Value: " + numbers[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid index!");
            System.out.println("Details: " + e.getMessage());
        }

        // Example 3: Number format exception
        System.out.println("\n=== String to Number Example ===");
        try {
            scanner.nextLine();     // Consume newLine
            System.out.print("Enter a number: ");
            String input = scanner.nextLine();

            int number = Integer.parseInt(input);
            System.out.println("Number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format!");
            System.out.println("Details: " + e.getMessage());
        }

        System.out.println("\nProgram continues normally!");
        scanner.close();
    }
}
