package _01_string_basics;

public class StringBasics {
    public static void main(String[] args){
        // Different ways to create strings
        String s1 = "Hello";
        String s2 = new String("World");
        char[] chars = {'J', 'a', 'v', 'a'};
        String s3 = new String(chars);

        System.out.println("String 1: " + s1);
        System.out.println("String 2: " + s2);
        System.out.println("String 3: " + s3);

        // String methods
        String text = "Hello World";

        System.out.println("\nString Methods Demo:");
        System.out.println("Length: " + text.length());
        System.out.println("Character at index 0: " + text.charAt(0));
        System.out.println("Substring (0, 5): " + text.substring(0, 5));
        System.out.println("Contains 'World': " + text.contains("World"));
        System.out.println("Index of 'W': " + text.indexOf('W'));
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Lowercase: " + text.toLowerCase());
        System.out.println("Replace 'World' with 'Java': "+ text.replace("World", "Java"));

        // String comparison
        String a = "hello";
        String b = "hello";
        String c = "HELLO";

        System.out.println("\nString Comparison:");
        System.out.println("a equals b: " + a.equals(b));
        System.out.println("a equals c: " + a.equals(c));
        System.out.println("a equalsIgnoreCase c: " + a.equalsIgnoreCase(c));


    }
}
