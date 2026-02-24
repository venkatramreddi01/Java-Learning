package _06_fibonacci_recursion;

import java.util.Scanner;

public class FibonacciRecursion {

    // Recursive Fibonacci
    public static int fibonacci(int n) {
        if(n <= 1){
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Print Fibonacci series
    public static void printFibonacciSeries(int count) {
        System.out.println("Fibonacci Series: ");
        for(int i = 0; i < count; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many Fibonacci numbers? ");
        int count = scanner.nextInt();

        printFibonacciSeries(count);

        System.out.print("\nEnter position to find Fibonacci number: ");
        int pos = scanner.nextInt();
        System.out.println("Fibonacci number at position " + pos + ": " + fibonacci(pos));
        scanner.close();
    }
}
