package _05_custom_exception;


import java.util.Scanner;

// Custom exception for invalid email
class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}

// Custom exception for insufficient balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Custom exception for age validation
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class Validator {
    public static void validateEmail(String email) throws InvalidEmailException {
        if (email == null || email.isEmpty()) {
            throw new InvalidEmailException("Email cannot be empty!");
        }
        if (!email.contains("@")) {
            throw new InvalidEmailException("Email must contain @!");
        }
        if (!email.contains(".")) {
            throw new InvalidEmailException("Email must contain domain!");
        }
        System.out.println("Valid email: " + email);
    }

    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be negative!");
        }
        if (age < 18) {
            throw new InvalidAgeException("Must be 18 or older!");
        }
        if (age > 120) {
            throw new InvalidAgeException("Age seems invalid!");
        }
        System.out.println("Valid age: " + age);
    }

    public static void processPayment(double balance, double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance! Available: $" + balance + ", Required: $" + amount);
        }
        System.out.println("Payment processed: $" + amount);
    }
}

public class CustomException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Test email validation
        System.out.println("=== Email Validation ===");
        try {
            System.out.print("Enter email: ");
            String email = scanner.nextLine();
            Validator.validateEmail(email);
        } catch (InvalidEmailException e) {
            System.out.println("Custom Error: " + e.getMessage());
        }

        // Test age validation
        System.out.println("\n=== Age Validation ===");
        try {
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            Validator.validateAge(age);
        } catch (InvalidAgeException e) {
            System.out.println("Custom Error: " + e.getMessage());
        }

        // Test payment processing
        System.out.println("\n=== Payment Processing ===");
        try {
            System.out.print("Enter balance: $");
            double balance = scanner.nextDouble();
            System.out.print("Enter payment amount: $");
            double amount = scanner.nextDouble();
            Validator.processPayment(balance, amount);
        } catch (InsufficientBalanceException e) {
            System.out.println("Custom Error: " + e.getMessage());
        }

        scanner.close();
    }
}
