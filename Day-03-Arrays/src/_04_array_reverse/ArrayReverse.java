package _04_array_reverse;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayReverse {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter array size: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];

        System.out.println("Enter " + size + " numbers: ");
        for(int i = 0; i < size; i++){
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Original array: " + Arrays.toString(numbers));

        // Reverse the array
        for(int i = 0; i < numbers.length / 2; i++){
            // Swap elements
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[size - 1 - i] = temp;
        }

        System.out.println("Reversed array: " + Arrays.toString(numbers));

        scanner.close();
    }
}
