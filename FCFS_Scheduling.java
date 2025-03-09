import java.util.*;

/**
 * This class implements the First-Come, First-Served (FCFS) Scheduling algorithm.
 * 
 * FCFS is one of the easiest CPU scheduling algorithms. It schedules processes 
 * in the order they arrive, meaning the first process that arrives gets executed first.
 * 
 * The key calculations involved are:
 * 1. Completion Time (CT): The time when a process finishes execution.
 * 2. Turnaround Time (TAT): The total time a process spends in the system.
 *    It is calculated as Completion Time (CT) - Arrival Time (AT).
 * 3. Waiting Time (WT): The time a process spends waiting before execution.
 *    It is calculated as Turnaround Time (TAT) - Burst Time (BT).
 * 
 * The program also calculates the average waiting time and turnaround time
 */

public class FCFS_Scheduling {

    public static void fcfsScheduling(List<Process> processes) {
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));

        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int currentTime = 0;

        for (Process p : processes) {
            if (currentTime < p.arrivalTime) {
                currentTime = p.arrivalTime; // If CPU is idle, move time to process arrival
            }
            p.completionTime = currentTime + p.burstTime;
            p.turnaroundTime = p.completionTime - p.arrivalTime;
            p.waitingTime = p.turnaroundTime - p.burstTime;
            currentTime = p.completionTime;

            totalWaitingTime += p.waitingTime;
            totalTurnaroundTime += p.turnaroundTime;

            // Matching print format with priority scheduling
            System.out.println("PID: " + p.pid + 
                    " | Arrival: " + p.arrivalTime + 
                    " | Burst: " + p.burstTime + 
                    " | Completion: " + p.completionTime + 
                    " | Turnaround: " + p.turnaroundTime + 
                    " | Waiting: " + p.waitingTime);
        }

        int n = processes.size();
        System.out.printf("\nAverage Turnaround Time: %.2f%n", (double) totalTurnaroundTime / n);
        System.out.printf("Average Waiting Time: %.2f%n", (double) totalWaitingTime / n);
    }

    public static void main(String[] args) {
        List<Process> processes = ProcessReader.readProcesses("processes.txt");
        
        System.out.println("Running FCFS Scheduling...");
        fcfsScheduling(processes);
    }
}

