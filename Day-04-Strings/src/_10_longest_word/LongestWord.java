package _10_longest_word;

import java.util.Scanner;

public class LongestWord {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String[] words = input.split("\\s+");

        String longest = "";

        for(String word : words){
            if(word.length() > longest.length()){
                longest = word;
            }
        }

        System.out.println("\nLongest word: " +longest);
        System.out.println("Length: " + longest.length());

        // Show all words with their lengths
        System.out.println("\nAll words:");
        for (String word : words){
            System.out.println(word + " (" + word.length() + " chars)");
        }
        scanner.close();
    }
}
