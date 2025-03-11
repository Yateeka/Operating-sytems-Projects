import java.util.*;

/**
 * This class implements the Priority Scheduling algorithm.
 * 
 * The algorithm schedules processes based on their priority.
 * If there are multiple processes with the same priority, they are scheduled using First-Come-First-Serve (FCFS).
 * 
 * The key calculations involved are:
 * 1. Completion Time (CT): The time at which a process finishes execution.
 * 2. Turnaround Time (TAT): The time taken by a process from arrival to completion. 
 *    It is calculated as Completion Time (CT) minus Arrival Time (AT).
 * 3. Waiting Time (WT): The time a process spends waiting in the ready queue before execution.
 *    It is calculated as Turnaround Time (TAT) minus Burst Time (BT).
 * 
 * The average waiting time and turnaround time are calculated at the end of execution.
 */
public class PriorityScheduling {

    // Method to implement Priority Scheduling
    public static void priorityScheduling(List<Process> processes) {
        // Sort processes by priority, then by arrival time (for tie-breaking)
        processes.sort(Comparator.comparingInt((Process p) -> p.priority)
                                 .thenComparingInt(p -> p.arrivalTime));

        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int currentTime = 0;

        // Loop through each process to calculate their completion, turnaround, and waiting times
        for (Process currentProcess : processes) {
            // If current time is less than the process arrival time, move time to the process arrival time
            currentTime = Math.max(currentTime, currentProcess.arrivalTime) + currentProcess.burstTime;

            // Calculate turnaround time
            int turnaroundTime = currentTime - currentProcess.arrivalTime;

            // Calculate waiting time
            int waitingTime = turnaroundTime - currentProcess.burstTime;

            // Accumulate total waiting and turnaround times
            totalWaitingTime += waitingTime;
            totalTurnaroundTime += turnaroundTime;

            // Print out process information
            System.out.println("PID: " + currentProcess.pid +
                    " | Arrival: " + currentProcess.arrivalTime +
                    " | Burst: " + currentProcess.burstTime +
                    " | Priority: " + currentProcess.priority +
                    " | Completion Time: " + currentTime +
                    " | Turnaround Time: " + turnaroundTime +
                    " | Waiting Time: " + waitingTime);
        }

        // Calculate and print the average waiting and turnaround times
        int n = processes.size();
        System.out.printf("\nAverage Turnaround Time: %.2f%n", (double) totalTurnaroundTime / n);
        System.out.printf("Average Waiting Time: %.2f%n", (double) totalWaitingTime / n);
    }

    public static void main(String[] args) {
        // Ensure the correct path to the processes file
        List<Process> processes = ProcessReader.readProcesses("processes.txt");

        // Call the priority scheduling method
        priorityScheduling(processes);
    }
}
