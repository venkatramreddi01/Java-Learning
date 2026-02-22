package _02_string_reverse;

import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Method 1: Using StringBuilder
        String reversed1 = new StringBuilder(input).reverse().toString();
        System.out.println("Reversed (StringBuilder): " + reversed1);

        // Method 2: Using loop
        String reversed2 = "";
        for(int i = input.length() - 1; i >= 0; i--){
            reversed2 += input.charAt(i);
        }
        System.out.println("Reversed (Loop): " + reversed2);

        //Method 3: Using character array
        char[] chars = input.toCharArray();
        String reversed3 = "";
        for(int i = chars.length - 1; i >= 0; i--){
            reversed3 += chars[i];
        }
        System.out.println("Reversed (Char Array): " + reversed3 );

        scanner.close();
    }
}
