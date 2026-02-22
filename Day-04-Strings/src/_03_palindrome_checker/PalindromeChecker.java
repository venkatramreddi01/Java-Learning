package _03_palindrome_checker;

import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Remove spaces and convert to lowercase for accurate check
        String cleanedString = input.replace(" ", "").toLowerCase();

        // Reverse the string
        String reversed = new StringBuilder((cleanedString)).reverse().toString();

        // Check if palindrome
        if(cleanedString.equals(reversed)){
            System.out.println("'" + input + "' is a palindrome!");
        } else {
            System.out.println("'" + input + "' is NOT a palindrome.");
        }

        scanner.close();
    }
}
