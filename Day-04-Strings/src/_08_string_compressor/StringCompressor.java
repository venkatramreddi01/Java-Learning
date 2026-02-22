package _08_string_compressor;

import java.util.Scanner;

public class StringCompressor {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String input = scanner.nextLine();

        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for(int i = 0; i < input.length(); i++){
            // If next character is same, increment count
            if(i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)){
                count++;
            } else {
                // Append character and count
                compressed.append(input.charAt(i)).append(count);
                count = 1;
            }
        }

        String result = compressed.toString();

        // Only use compressed if it's shorter
        if(result.length() < input.length()){
            System.out.println("Compressed: " + result);
        } else {
            System.out.println("Original is shorter: " + input);
        }

        scanner.close();
    }
}
