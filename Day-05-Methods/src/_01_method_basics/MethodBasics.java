package _01_method_basics;

public class MethodBasics {

    // Method with no parameters, no return
    public static void printWelcome() {
        System.out.println("Welcome to Java Methods!");
    }

    // Method with parameters, no return
    public static void greetUser(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // Method with return value
    public static int square(int num) {
        return num * num;
    }

    // Method with multiple parameters
    public static double calculatorArea(double length, double height) {
        return length * height;
    }

    // Method returning boolean
    public static boolean isPositive(int num) {
        return num > 0;
    }

    public static void main(String[] args){
        // Calling methods
        printWelcome();

        greetUser("Venkatram");

        int result = square(5);
        System.out.println("Square of 5: " + result);

        double area = calculatorArea(10.5, 5.2);
        System.out.println("Area: " + area);

        boolean check = isPositive(-5);
        System.out.println("Is -5 positive? " + check);
    }

}
