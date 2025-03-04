package csc402.week7;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Stream;

class ProcessInfo implements Comparable<ProcessInfo> {
    long pid;
    int priority;

    public ProcessInfo(long pid, int priority) {
        this.pid = pid;
        this.priority = priority;
    }

    @Override
    public int compareTo(ProcessInfo other) {
        return Integer.compare(other.priority, this.priority); // Higher priority first
    }

    @Override
    public String toString() {
        return "Process ID: " + pid + ", Priority: " + priority;
    }
}

public class ProcessManager {
    public static void main(String[] args) {
        PriorityQueue<ProcessInfo> processQueue = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);
        // Get all processes and add them to the priority queue with custom priorities
        // ProcessHandle.allProcesses().forEach(ph -> {
        //     int priority = getPriority(ph); // Custom method to determine priority
        //     processQueue.add(new ProcessInfo(ph.pid(), priority));
        // });
        Stream<ProcessHandle> allProcs = ProcessHandle.allProcesses();
        for(ProcessHandle ph : allProcs.toList()) {
            int priority = getPriority(ph); // Custom method to determine priority
            processQueue.add(new ProcessInfo(ph.pid(), priority));
        }

        // Display processes to the user
        System.out.println("Processes:");
        processQueue.forEach(System.out::println);

        // Gather user input to select the process to terminate
        System.out.println("Enter the Process ID to terminate (or 'exit' to quit):");
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                long pidToTerminate = Long.parseLong(input);
                terminateProcess(pidToTerminate);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid Process ID.");
            }
            System.out.println("Enter the Process ID to terminate (or 'exit' to quit):");
        }

        scanner.close();
    }

    // Custom method to determine the priority of a process
    private static int getPriority(ProcessHandle ph) {
        // Example: Assign priority based on process CPU usage, memory usage, etc.
        // For simplicity, assigning random priority here
        return (int) (Math.random() * 10);
    }

    // Method to terminate a process by PID
    private static void terminateProcess(long pid) {
        ProcessHandle.of(pid).ifPresent(ph -> {
            System.out.println("Terminating Process ID: " + pid);
            ph.destroy();
        });
    }
}