package _10_array_rotation;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter array size: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];

        System.out.println("Enter array elements: ");
        for(int i = 0; i < size; i++){
            numbers[i] = scanner.nextInt();
        }

        System.out.println("Enter the number of positions to rotate: ");
        int k = scanner.nextInt();

        System.out.println("Original array: " + Arrays.toString(numbers));

        // Rotate array to right by k positions
        k = k % numbers.length;     // Handle k > array length

        // Method: Reverse entire array, then reverse first k, then reverse rest
        reverse(numbers, 0, numbers.length - 1);
        reverse(numbers, 0, k-1);
        reverse(numbers, k, numbers.length - 1);

        System.out.println("Rotated array: " + Arrays.toString(numbers));

        scanner.close();

    }

    public static void reverse(int[] arr, int start, int end){
        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] =  temp;
            start++;
            end--;
        }
    }
}
