package csc402.week7;

import java.util.PriorityQueue;

public class HeapExample {
    public static void main(String[] args) {
        // Create a Min-Heap using PriorityQueue
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add elements to the Min-Heap
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(15);

        // Print the top element of the Min-Heap
        System.out.println("Top element of Min-Heap: " + minHeap.peek());

        // Create a Max-Heap using PriorityQueue with a custom comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Add elements to the Max-Heap
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(15);

        // Print the top element of the Max-Heap
        System.out.println("Top element of Max-Heap: " + maxHeap.peek());
    }
}
