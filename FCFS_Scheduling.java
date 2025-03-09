import java.util.*;

/**
 * This class implements the First-Come, First-Served (FCFS) Scheduling algorithm.
 * 
 * FCFS schedules processes in the order they arrive, meaning the first process that 
 * arrives gets executed first.
 * 
 * The key calculations involved are:
 * 1. Completion Time (CT): The time when a process finishes execution.
 * 2. Turnaround Time (TAT): The total time a process spends in the system.
 *    It is calculated as Completion Time (CT) - Arrival Time (AT).
 * 3. Waiting Time (WT): The time a process spends waiting before execution.
 *    It is calculated as Turnaround Time (TAT) - Burst Time (BT).
 * 
 * The program also calculates the average waiting time and turnaround time.
 */

public class FCFS_Scheduling {

    public static void fcfsScheduling(List<Process> processes) {
        // Sort processes by arrival time (since FCFS executes them in order of arrival)
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));

        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int currentTime = 0;

        // Store completion, turnaround, and waiting times separately
        Map<Integer, Integer> completionTimes = new HashMap<>();
        Map<Integer, Integer> turnaroundTimes = new HashMap<>();
        Map<Integer, Integer> waitingTimes = new HashMap<>();

        for (Process p : processes) {
            if (currentTime < p.arrivalTime) {
                currentTime = p.arrivalTime; // If CPU is idle, move time to process arrival
            }
            int completionTime = currentTime + p.burstTime;
            int turnaroundTime = completionTime - p.arrivalTime;
            int waitingTime = turnaroundTime - p.burstTime;
            currentTime = completionTime;

            // Store computed values
            completionTimes.put(p.pid, completionTime);
            turnaroundTimes.put(p.pid, turnaroundTime);
            waitingTimes.put(p.pid, waitingTime);

            totalWaitingTime += waitingTime;
            totalTurnaroundTime += turnaroundTime;

            // Matching print format with priority scheduling
            System.out.println("PID: " + p.pid + 
                    " | Arrival: " + p.arrivalTime + 
                    " | Burst: " + p.burstTime + 
                    " | Completion: " + completionTime + 
                    " | Turnaround: " + turnaroundTime + 
                    " | Waiting: " + waitingTime);
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
