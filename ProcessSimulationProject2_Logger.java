import java.io.*;
import java.util.*;

public class ProcessSimulationProject2_Logger {

    // Inner class to simulate a process as a thread
    static class ProcessThread extends Thread {
        int pid;
        int burstTime;

        public ProcessThread(int pid, int burstTime) {
            this.pid = pid;
            this.burstTime = burstTime;
        }

private static final Semaphore cpu = new Semaphore(1); // Shared among all threads

public void run() {
    long start = System.currentTimeMillis();
    try {
        cpu.acquire(); // Lock the CPU
        System.out.println("[" + start + "] Process " + pid + " started.");
        Thread.sleep(burstTime * 1000); // Simulate CPU burst
        long end = System.currentTimeMillis();
        System.out.println("[" + end + "] Process " + pid + " finished.");
        ProcessLogger.log(pid, start, end);
    } catch (InterruptedException e) {
        System.out.println("[" + System.currentTimeMillis() + "] Process " + pid + " was interrupted.");
    } finally {
        cpu.release(); // Unlock the CPU
    }
}


    public static void main(String[] args) {
        List<ProcessThread> processes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("processes.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split("\\s+");
                int pid = Integer.parseInt(parts[0]);
                int burstTime = Integer.parseInt(parts[1]);
                processes.add(new ProcessThread(pid, burstTime));
            }
        } catch (IOException e) {
            System.out.println("Error reading processes.txt");
            e.printStackTrace();
            return;
        }

        // Start all process threads
        for (ProcessThread p : processes) {
            p.start();
        }

        // Wait for all threads to finish
        for (ProcessThread p : processes) {
            try {
                p.join();
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted.");
            }
        }

        // Print execution summary (BONUS FEATURE)
        ProcessLogger.printSummary();
    }
}


