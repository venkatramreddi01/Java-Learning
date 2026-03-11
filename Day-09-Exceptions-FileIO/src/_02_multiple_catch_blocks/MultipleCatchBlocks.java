package _02_multiple_catch_blocks;

import java.util.Scanner;

public class MultipleCatchBlocks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter array size: ");
            int size = scanner.nextInt();

            int[] numbers = new int[size];

            System.out.print("Enter index to access: ");
            int index = scanner.nextInt();

            System.out.print("Enter value: ");
            int value = scanner.nextInt();

            numbers[index] = value;

            System.out.print("Enter divisor: ");
            int divisor = scanner.nextInt();

            int result = value / divisor;

            System.out.println("Result: " + result);
            System.out.println("Value at index " + index + ": " + numbers[index]);

        } catch (NegativeArraySizeException e) {
            System.out.println("Error: Array size cannot be negative!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bonds!");
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by Zero!");
        } catch (Exception e) {
            System.out.println("Error: Something went wrong!");
            System.out.println("Details: " + e.getMessage());
        } finally {
            System.out.println("\nFinally block always executes!");
            scanner.close();
        }

        System.out.println("Program ended gracefully.");
    }
}
