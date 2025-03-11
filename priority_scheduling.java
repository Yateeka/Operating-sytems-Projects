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
public class priority_scheduling {

    public static void priorityScheduling(List<Process> processes) {
        // Sort by priority, then by arrival time for tie-breaking (lower priority number is higher priority)
        processes.sort(Comparator.comparingInt((Process p) -> p.priority)
                                 .thenComparingInt(p -> p.arrivalTime));

        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int currentTime = 0;

        for (Process currentProcess : processes) {
            // If current time is less than the process arrival time, move time to arrival time
            currentTime = Math.max(currentTime, currentProcess.arrivalTime) + currentProcess.burstTime;
            int turnaroundTime = currentTime - currentProcess.arrivalTime;
            int waitingTime = turnaroundTime - currentProcess.burstTime;

            totalWaitingTime += waitingTime;
            totalTurnaroundTime += turnaroundTime;

            // Print the result in the desired format
            System.out.println(currentProcess + " | Completion Time: " + currentTime +
                    " | Turnaround Time: " + turnaroundTime + " | Waiting Time: " + waitingTime);
        }

        int n = processes.size();
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / n);
        System.out.println("Average Waiting Time: " + (double) totalWaitingTime / n);
    }

    public static void main(String[] args) {
        List<Process> processes = ProcessReader.readProcesses("processes.txt");
        
        priorityScheduling(processes); // Call the priority scheduling method
    }
}
