package _05_array_search;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySearch {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int[] numbers = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        System.out.println("Array: " + Arrays.toString(numbers));

        System.out.println("Enter number to search: ");
        int target = scanner.nextInt();

        // Linear Search
        boolean found = false;
        int position = -1;

        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] == target){
                found = true;
                position = i;
                break;
            }
        }

        if (found){
            System.out.println(target + " found at index " + position);
        } else {
            System.out.println(target + " not found in array");
        }

        scanner.close();
    }
}
