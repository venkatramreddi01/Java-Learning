package _04_throw_example;

import java.util.Scanner;

public class ThrowExample {

    public static void checkAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative!");
        }
        if (age < 18) {
            throw new IllegalArgumentException("Must be 18 or older!");
        }
        if (age > 120) {
            throw  new IllegalArgumentException("Invalid age!");
        }
        System.out.println("Age verified: " + age);
    }

    public static void withdraw(double balance, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive!");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds!");
        }
        System.out.println("Withdrawal successful: $" + amount);
        System.out.println("Remaining balance: $" + (balance - amount));
    }

    public static void validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty!");
        }
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters!");
        }
        System.out.println("Password accepted!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Test 1: Age validation
        System.out.println("=== Age Validation ===");
        try {
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            checkAge(age);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test 2: Withdrawal
        System.out.println("\n=== Bank Withdrawal ===");
        try {
            System.out.print("Enter balance: $");
            double balance = scanner.nextDouble();
            System.out.print("Enter withdrawal amount: $");
            double amount = scanner.nextDouble();
            withdraw(balance, amount);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test 3: Password validation
        System.out.println("\n=== Password Validation ===");
        try {
            scanner.nextLine();     // Consume newline
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            validatePassword(password);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
