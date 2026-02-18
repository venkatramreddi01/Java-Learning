package _9_positivenegative;

import java.util.Scanner;

public class PositiveNegative {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number : ");
        int number = scanner.nextInt();

        if(number < 0){
            System.out.println("The given number is negative");
        } else if (number > 0) {
            System.out.println("The given number is positive");
        } else {
            System.out.println("The given number is zero");
        }

        scanner.close();
    }
}
