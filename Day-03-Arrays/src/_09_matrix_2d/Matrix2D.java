package _09_matrix_2d;

import java.util.Scanner;

public class Matrix2D {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of rows: ");
        int rows = scanner.nextInt();

        System.out.println("Enter number of columns: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        // Input matrix
        System.out.println("Enter matrix elements:");
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Print matrix
        System.out.println("\nMatrix:");
        for (int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Calculate sum of all elements
        int sum = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j <  cols; j++){
                sum += matrix[i][j];
            }
        }

        System.out.println("\nSum of all elements: " + sum);

        scanner.close();
    }
}
