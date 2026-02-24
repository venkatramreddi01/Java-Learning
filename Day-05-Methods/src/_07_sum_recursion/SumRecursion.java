package _07_sum_recursion;

import java.util.Scanner;

public class SumRecursion {

    // Sum from 1 to n
    public static int sumToN(int n) {
        if(n <= 0){
            return 0;
        }
        return n + sumToN(n-1);
    }

    // Sum of digits in a number
    public static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return (n % 10) + sumOfDigits(n / 10);
    }

    // Sum of array elements (recursion)
    public static int sumArray(int[] arr, int index){
        if (index >= arr.length) {
            return 0;
        }
        return arr[index] + sumArray(arr, index + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        System.out.println("Sum from 1 to " + num + ": " + sumToN(num));
        System.out.println("Sum of digits in " + num + ": " + sumOfDigits(num));

        int[] arr = {10, 20, 30, 40, 50};
        System.out.println("Sum of array elements: " + sumArray(arr, 0));

        scanner.close();
    }
}
