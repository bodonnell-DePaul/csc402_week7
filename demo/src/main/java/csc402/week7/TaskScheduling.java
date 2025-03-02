package csc402.week7;

import java.util.PriorityQueue;

class Process implements Comparable<Process> {
    int id;
    int priority;

    public Process(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }

    @Override
    public int compareTo(Process other) {
        return Integer.compare(other.priority, this.priority); // Higher priority first
    }

    @Override
    public String toString() {
        return "Process ID: " + id + ", Priority: " + priority;
    }
}

public class TaskScheduling {
    public static void main(String[] args) {
        PriorityQueue<Process> processQueue = new PriorityQueue<>();

        // Adding processes to the queue
        processQueue.add(new Process(1, 3));
        processQueue.add(new Process(2, 1));
        processQueue.add(new Process(3, 2));

        // Processing tasks based on priority
        while (!processQueue.isEmpty()) {
            System.out.println("Processing: " + processQueue.poll());
        }
    }
}

