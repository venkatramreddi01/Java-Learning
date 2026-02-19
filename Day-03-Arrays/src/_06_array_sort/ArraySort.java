package _06_array_sort;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySort {
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

        // Bubble sort
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = 0; j < numbers.length - 1 - i; j++){
                if (numbers[j] > numbers[j + 1]){
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted array: " + Arrays.toString(numbers));
        scanner.close();
    }
}
