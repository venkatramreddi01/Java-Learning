package _08_simplecalculator;

import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===> Simple Calculator <===");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");

            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= 4){
                System.out.println("Enter first number: ");
                double num1 = scanner.nextDouble();
                System.out.println("Enter second number: ");
                double num2 = scanner.nextDouble();

                switch (choice){
                    case 1:
                        System.out.println("Result: " + (num1 + num2));
                        break;
                    case 2:
                        System.out.println("Result: " + (num1 - num2));
                        break;
                    case 3:
                        System.out.println("Result: " + (num1 *num2));
                        break;
                    case 4:
                        if(num2 != 0){
                            System.out.println("Result: " + (num1/num2));
                        } else {
                            System.out.println("Error: Cannot divide by zero!");
                        }
                        break;
                }
            } else if (choice != 5) {
                System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        System.out.println("Thank you for using the Calculator!");
        scanner.close();




    }
}
