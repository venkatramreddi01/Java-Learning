package _06_string_case_converter;

import java.util.Scanner;

public class StringCaseConverter {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("\nOriginal String: " + input);
        System.out.println("Uppercase: " + input.toUpperCase());
        System.out.println("Lowercase: " + input.toLowerCase());

        // Toggle case(swap upper to lower and vice versa)
        StringBuilder toggled = new StringBuilder();
        for(char c : input.toCharArray()){
            if(Character.isUpperCase(c)){
                toggled.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)){
                toggled.append(Character.toUpperCase(c));
            } else {
                toggled.append(c);
            }
        }
        System.out.println("Toggled case: " + toggled.toString().trim());

        // Title case (first letter of each word capitalized)
        String[] words = input.toLowerCase().split(" ");
        StringBuilder titleCase = new StringBuilder();
        for(String word : words){
            if(word.length() > 0){
                titleCase.append((Character.toUpperCase(word.charAt(0)))).append(word.substring(1)).append(" ");
            }
        }
        System.out.println("Title case: " +titleCase.toString().trim());

        scanner.close();


    }
}
