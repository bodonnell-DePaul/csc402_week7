package csc402.week7;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Create a PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add elements to the PriorityQueue
        pq.add(10);
        pq.add(20);
        pq.add(15);

        // Print the top element of the PriorityQueue
        System.out.println("Top element: " + pq.peek());

        // Remove the top element
        System.out.println("Removed element: " + pq.poll());

        // Print the top element again
        System.out.println("Top element after removal: " + pq.peek());
    }
}
