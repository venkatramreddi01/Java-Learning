package _03_method_overloading;

public class MethodOverloading {

    //Overloaded add methods
    public static int add(int a, int b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static double add(double a, double b) {
        return a + b;
    }

    // Overloaded display methods
    public static void display(int num) {
        System.out.println("Integer: " + num);
    }

    public static void display(String text) {
        System.out.println("String: " + text);
    }

    public static void display(int num, String text) {
        System.out.println("Number: " + num + ", Text: " + text);
    }

    public static void main(String[] args){
        // Java automatically picks the right method based on arguments

        System.out.println("2 + 3 = " + add(2, 3));
        System.out.println("2 + 3 + 4 = " + add(2,3, 4));
        System.out.println("2.5 + 3.7 = " + add(2.5, 3.7));

        System.out.println();
        display(100);
        display("Hello");
        display(42, "Answer");
    }

}
