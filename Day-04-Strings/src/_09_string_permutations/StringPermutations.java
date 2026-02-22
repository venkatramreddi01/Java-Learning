package _09_string_permutations;

import java.util.Scanner;

public class StringPermutations {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("\nAll permutations:");
        permute(input, "");

        scanner.close();
    }

    public static void permute(String str, String prefix){
        int n =str.length();

        if(n == 0){
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++){
                permute(str.substring(0, i) + str.substring(i + 1, n), prefix + str.charAt(i));
            }
        }
    }
}
