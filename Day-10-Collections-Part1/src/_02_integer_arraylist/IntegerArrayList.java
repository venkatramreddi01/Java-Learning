package _02_integer_arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class IntegerArrayList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.print("How many numbers to enter? ");
        int n = scanner.nextInt();

        System.out.println("Enter " + n + " numbers: ");
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        System.out.println("\n=== Analysis ===");
        System.out.println("Numbers: " + numbers);

        // Sum
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        System.out.println("Sum: " + sum);

        // Average
        double average = (double) sum / numbers.size();
        System.out.println("Average: " + average);

        // Min and Max
        int min = Collections.min(numbers);
        int max = Collections.max(numbers);
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);

        // Count even and odd
        int even = 0, odd = 0;
        for (int num : numbers) {
            if (num % 2 == 0) even++;
            else odd++;
        }
        System.out.println("Even count: " + even);
        System.out.println("Odd count: " + odd);

        // Sort
        Collections.sort(numbers);
        System.out.println("Sorted: " + numbers);

        // Remove duplicates
        ArrayList<Integer> unique = new ArrayList<>();
        for (int num :  numbers) {
            if (!unique.contains(num)) {
                unique.add(num);
            }
        }
        System.out.println("Unique numbers: " + unique);

        scanner.close();
    }
}
