package _05_factorial_recursion;

import java.util.Scanner;

public class FactorialRecursion {

    // Recursive method
    public static int factorialRecursive(int n) {
        // Base case
        if (n == 0 || n == 1) {
            return 1;
        }

        // Recursive case
        return n * factorialRecursive(n-1);
    }

    // Iterative method (for comparison)
    public static int factorialIteration(int n) {
        int result = 1;
        for(int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        System.out.println("\nFactorial of " + num + ":");
        System.out.println("Using Recursion: " + factorialRecursive(num));
        System.out.println("Using Iteration: " + factorialIteration(num));

        scanner.close();
    }

}
