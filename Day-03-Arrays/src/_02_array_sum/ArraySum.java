package _02_array_sum;

import java.util.Scanner;

public class ArraySum {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter array size: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];

        System.out.println("Enter " + size + " numbers:");
        for(int i = 0; i < size; i++){
            numbers[i] = scanner.nextInt();
        }

        // Calculate sum
        int sum = 0;
        for (int num : numbers){
            sum += num;
        }

        System.out.println("Sum of array elements: " + sum);

        scanner.close();
    }
}
