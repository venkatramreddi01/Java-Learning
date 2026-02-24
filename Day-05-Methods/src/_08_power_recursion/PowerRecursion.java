package _08_power_recursion;

import java.util.Scanner;

public class PowerRecursion {

    // Calculate base^exp using recursion
    public static int power(int base, int exp) {
        // Base case
        if (exp == 0) {
            return 1;
        }

        // Recursive case
        return base * power(base, exp - 1);
    }

    // Optimized version (faster)
    public static int powerOptimized(int base, int exp) {
        if (exp == 0) return 1;

        int half = power(base, exp / 2);

        if (exp % 2 == 0) {
            return half * half;
        } else {
            return base * half * half;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter base: ");
        int base = scanner.nextInt();

        System.out.print("Enter exponent: ");
        int exp = scanner.nextInt();

        System.out.println(base + "^" + exp + " = " + power(base, exp));
        System.out.println("Optimized: " + powerOptimized(base, exp));

        scanner.close();
    }
}
