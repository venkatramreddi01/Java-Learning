package _04_linkedlist_basics;

import java.util.LinkedList;

public class LinkedListBasics {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        System.out.println("=== Adding Elements ===");
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("List: " + list);

        // LinkedList specific methods
        list.addFirst("Start");
        list.addLast("End");
        System.out.println("After addFirst/addLast: " + list);

        System.out.println("\n=== Accessing Elements ===");
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
        System.out.println("At index 2: " + list.get(2));

        System.out.println("\n=== Peeking (without removing) ===");
        System.out.println("Peek first: " + list.peekFirst());
        System.out.println("Peek last: " + list.peekLast());
        System.out.println("List unchanged: " + list);

        System.out.println("\n=== Stack Operations (LIFO) ===");
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack: " + stack);

        System.out.println("Pop: " + stack.pop());  // Removes 30
        System.out.println("After pop: " + stack);

        System.out.println("\n=== Queue Operations (FIFO) ===");
        LinkedList<String> queue = new LinkedList<>();
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");
        System.out.println("Queue: " + queue);

        System.out.println("Poll: " + queue.poll());    // Removes "First"
        System.out.println("After poll: " + queue);

        System.out.println("\n=== Removing ===");
        list.removeFirst();
        list.removeLast();
        System.out.println("After removing first/last: " + list);

        System.out.println("\n=== Iterating ===");
        for (String item : list) {
            System.out.println("- " + item);
        }
    }
}
