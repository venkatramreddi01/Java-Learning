package _10_largestofthree;

import java.util.Scanner;

public class LargestOfThree {
    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number: ");
        int firstNumber = scanner.nextInt();

        System.out.println("Enter the second number: ");
        int secondNumber = scanner.nextInt();

        System.out.println("Enter the third number: ");
        int thirdNumber = scanner.nextInt();

        if(firstNumber > secondNumber && firstNumber > thirdNumber){
            System.out.println("The largest number is " + firstNumber);
        } else if (secondNumber > thirdNumber) {
            System.out.println("The largest number is " + secondNumber);
        } else if (thirdNumber > secondNumber){
            System.out.println("The largest number is " + thirdNumber);
        }
    }
}
