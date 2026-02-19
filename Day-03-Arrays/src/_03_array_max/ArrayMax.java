package _03_array_max;

import java.util.Scanner;

public class ArrayMax {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter array size: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];

        System.out.println("Enter " + size + " numbers: ");
        for(int i = 0; i < size; i++){
            numbers[i] = scanner.nextInt();
        }

        // Find max
        int max = numbers[0];   // Assume first element in max

        for(int i = 0; i < numbers.length; i++){
            if (numbers[i] > max){
                max = numbers[i];
            }
        }

        System.out.println("Largest element: " + max);
        scanner.close();
    }
}
