package _08_array_frequency;

import java.util.Scanner;

public class ArrayFrequency {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter array size: ");
        int size = scanner.nextInt();

        int[] numbers = new int[size];

        System.out.println("Enter " + size + " elements: ");
        for (int i = 0; i < size; i++){
            numbers[i] = scanner.nextInt();
        }

        // Create frequency array
        boolean[] visited = new boolean[size];

        System.out.println("\nElement | Frequency");
        System.out.println("-----------------------");

        for(int i = 0; i < numbers.length; i++){
            if(visited[i]){
                continue;
            }

            int count = 1;
            for(int j = i + 1; j < numbers.length; j++){
                if(numbers[i] ==  numbers[j]){
                    count++;
                    visited[j] = true;
                }
            }
            System.out.println(numbers[i] + "       | " + count);
        }

        scanner.close();

    }
}
