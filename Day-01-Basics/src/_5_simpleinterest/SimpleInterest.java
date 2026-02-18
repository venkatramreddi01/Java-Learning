package _5_simpleinterest;

import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the principal amount: ");
        int principalAmount = scanner.nextInt();

        System.out.print("Enter the interest rate: ");
        double interestRate = scanner.nextDouble();

        System.out.print("Enter the time period in years: ");
        int timePeriod = scanner.nextInt();

        double simpleInterest = (principalAmount * interestRate * timePeriod) / 100;

        System.out.println("The simple interest is: " + simpleInterest);

        scanner.close();
    }
}
