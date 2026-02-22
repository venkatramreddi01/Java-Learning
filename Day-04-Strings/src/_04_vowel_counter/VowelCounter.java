package _04_vowel_counter;

import java.util.Scanner;

public class VowelCounter {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        int vowels = 0;
        int consonants = 0;
        int spaces = 0;
        int others = 0;

        String vowelsList = "aeiouAEIOU";

        for(char c : input.toCharArray()){
            if(Character.isLetter(c)){
                if(vowelsList.indexOf(c) != -1){
                    vowels++;
                }else{
                    consonants++;
                }
            } else if(Character.isSpaceChar(c)){
                spaces++;
            } else {
                others++;
            }
        }

        System.out.println("\nAnalysis of '" + input + "':");
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Spaces: " + spaces);
        System.out.println("Others: " + others);

        scanner.close();
    }
}
