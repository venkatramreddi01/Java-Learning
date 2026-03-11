package _03_finally_block;

public class FinallyBlock {

    public static int testFinally() {
        try {
            System.out.println("Try block!");
            return 1;
        } catch (Exception e) {
            System.out.println("Catch block");
            return 2;
        } finally {
            System.out.println("Finally block - executes even with return!");
            // This doesn't affect return value
        }
    }

    public static void divideNumber(int a, int b){
        try {
            System.out.println("Trying to divide " + a + " by " + b);
            int result = a / b;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Cleanup operations in finally");
            System.out.println("This run regardless of exception\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Test 1: Normal execution ===");
        divideNumber(6, 3);

        System.out.println("=== Test 2: Exception occurs ===");
        divideNumber(10, 0);

        System.out.println("=== Test 3: Finally with return ===");
        int result = testFinally();
        System.out.println("Returned value: " + result);
    }
}
