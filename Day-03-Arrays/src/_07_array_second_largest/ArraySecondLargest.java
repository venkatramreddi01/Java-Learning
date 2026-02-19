package _07_array_second_largest;

import java.util.Scanner;

public class ArraySecondLargest {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter array size: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];

        System.out.println("Enter " + size + " numbers: ");
        for(int i = 0; i < size; i++){
            numbers[i] = scanner.nextInt();
        }

        // Find first and second largest
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int num : numbers){
            if(num > first){
                second = first;
                first = num;
            } else if(num > second && num != first){
                second = num;
            }
        }

        if(second == Integer.MIN_VALUE){
            System.out.println("No second largest element");
        } else {
            System.out.println("second largest: " +  second);
        }

        scanner.close();

    }
}
