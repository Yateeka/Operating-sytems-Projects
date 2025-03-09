import java.io.*;
import java.util.*;

class Process {
    int pid, arrivalTime, burstTime, completionTime, waitingTime, turnaroundTime;

    public Process(int pid, int arrivalTime, int burstTime) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}

public class FCFS_Scheduling {
    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();

        // Read process data from processes.txt
        try (BufferedReader br = new BufferedReader(new FileReader("processes.txt"))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\s+"); // Split by spaces
                int pid = Integer.parseInt(data[0]);
                int arrivalTime = Integer.parseInt(data[1]);
                int burstTime = Integer.parseInt(data[2]);
                processes.add(new Process(pid, arrivalTime, burstTime));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Sort processes by Arrival Time (FCFS Rule)
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));

        // Calculate Completion Time, Waiting Time, and Turnaround Time
        int currentTime = 0;
        for (Process p : processes) {
            if (currentTime < p.arrivalTime) {
                currentTime = p.arrivalTime; // CPU waits if idle
            }
            p.completionTime = currentTime + p.burstTime;
            p.turnaroundTime = p.completionTime - p.arrivalTime;
            p.waitingTime = p.turnaroundTime - p.burstTime;
            currentTime = p.completionTime;
        }

        // Print only necessary scheduling results
        System.out.println("PID  Arrival  Burst  Completion  Turnaround  Waiting");
        for (Process p : processes) {
            System.out.printf("%3d  %7d  %5d  %10d  %10d  %6d%n",
                    p.pid, p.arrivalTime, p.burstTime, p.completionTime, p.turnaroundTime, p.waitingTime);
        }

        // Calculate Average Waiting Time & Turnaround Time
        double avgWT = processes.stream().mapToInt(p -> p.waitingTime).average().orElse(0);
        double avgTAT = processes.stream().mapToInt(p -> p.turnaroundTime).average().orElse(0);
        System.out.printf("\nAverage Waiting Time: %.2f%n", avgWT);
        System.out.printf("Average Turnaround Time: %.2f%n", avgTAT);
    }
}

