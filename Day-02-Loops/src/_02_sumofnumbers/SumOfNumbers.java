package _02_sumofnumbers;

import java.util.Scanner;

public class SumOfNumbers {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        int sum = 0;
        int i = 1;

        while(i <= n){
            sum += i;
            i++;
        }
        System.out.println("The sum of 1 to " + n + "  numbers is " + sum);
        scanner.close();
    }
}
