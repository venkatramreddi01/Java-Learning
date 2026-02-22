package _07_anagram_checker;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramChecker {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first string: ");
        String str1 = scanner.nextLine();

        System.out.println("Enter second string: ");
        String str2 = scanner.nextLine();

        // Remove spaces and convert to lowercase
        str1 = str1.replace(" ", "").toLowerCase();
        str2 = str2.replace(" ", "").toLowerCase();

        // Check if lengths are different
        if(str1.length() != str2.length()){
            System.out.println("NOT anagrams (different lengths)");
        } else {
            // Sort both strings and compare
            char[] chars1 = str1.toCharArray();
            char[] chars2 = str2.toCharArray();

            Arrays.sort(chars1);
            Arrays.sort(chars2);

            if(Arrays.equals(chars1, chars2)){
                System.out.println("The strings ARE anagrams!");
            } else {
                System.out.println("The strings are NOT anagrams.");
            }

        }

        scanner.close();
    }
}
