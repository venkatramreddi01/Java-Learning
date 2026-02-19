package _01_array_basics;

import java.util.Arrays;

public class ArrayBasics {
    public static void main(String[] args) {
        // Different ways to create arrays

        // Method 1: Declare then initialize
        int[] numbers1 = new int[5];
        numbers1[0] = 10;
        numbers1[1] = 20;
        numbers1[2] = 30;
        numbers1[3] = 40;
        numbers1[4] = 50;

        System.out.println("Array 1: " + Arrays.toString(numbers1));

        // Method 2: Initialize with values
        int[] numbers2 = {100, 200, 300, 400, 500};
        System.out.println("Array 2: " + Arrays.toString(numbers2));

        // Method 3: String array
        String[] names = {"Alice", "Bob", "Charlie"};
        System.out.println("Names: " + Arrays.toString(names));

        // Print array length
        System.out.println("Length of numbers1: " + numbers1.length);

        // Access specific elements
        System.out.println("First element: " + numbers1[0]);
        System.out.println("Last element: " + numbers1[numbers1.length - 1]);
    }
}