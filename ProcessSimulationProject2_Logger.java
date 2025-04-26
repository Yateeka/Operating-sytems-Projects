import java.io.*;
import java.util.*;
import java.util.concurrent.Semaphore;

public class ProcessSimulationProject2_Logger {

    private static final Semaphore cpu = new Semaphore(1); // Moved HERE!

    // Inner class to simulate a process as a thread
    static class ProcessThread extends Thread {
        int pid;
        int burstTime;

        public ProcessThread(int pid, int burstTime) {
            this.pid = pid;
            this.burstTime = burstTime;
        }

        public void run() {
            try {
                System.out.println("[" + System.currentTimeMillis() + " ms] Process " + pid + " waiting to acquire CPU...");
                cpu.acquire(); // Lock the CPU
                System.out.println("[" + System.currentTimeMillis() + " ms] Process " + pid + " acquired CPU.");
                
                long start = System.currentTimeMillis();
                System.out.println("[" + start + " ms] Process " + pid + " started.");
                
                Thread.sleep(burstTime * 1000);
                
                long end = System.currentTimeMillis();
                System.out.println("[" + end + " ms] Process " + pid + " finished.");
                
                ProcessLogger.log(pid, start, end);
            } catch (InterruptedException e) {
                System.out.println("[" + System.currentTimeMillis() + " ms] Process " + pid + " was interrupted.");
            } finally {
                System.out.println("[" + System.currentTimeMillis() + " ms] Process " + pid + " released CPU.");
                cpu.release(); // Unlock the CPU
            }
        }
    }   


    public static void main(String[] args) {
        List<ProcessThread> processes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("processes.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue; // Skip empty lines

                String[] parts = line.split("\\s+");
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
                System.out.println("Main thread interrupted while waiting.");
            }
        }

        // Print execution summary after all threads complete
        ProcessLogger.printSummary();
    }
}
