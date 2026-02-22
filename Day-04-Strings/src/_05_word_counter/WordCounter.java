package _05_word_counter;

import java.util.Scanner;

public class WordCounter {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        // Method 1: Using split()
        String[] words = input.trim().split("\\s+");

        System.out.println("\nWord count: " + words.length);

        System.out.println("\nWords in the sentence: ");
        for(int i = 0; i < words.length; i++){
            System.out.println((i + 1) + ". " + words[i]);
        }

        scanner.close();
    }
}
