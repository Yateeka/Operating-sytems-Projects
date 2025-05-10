import java.io.*;
import java.util.*;

class ProcessThread extends Thread {
    int pid, burstTime;

    public ProcessThread(int pid, int burstTime) {
        this.pid = pid;
        this.burstTime = burstTime;
    }

    public void run() {
        System.out.println("Process " + pid + " started.");
        try {
            Thread.sleep(burstTime * 1000);
        } catch (InterruptedException e) {
            System.out.println("Process " + pid + " was interrupted.");
        }
        System.out.println("Process " + pid + " finished.");
    }
}

public class ProcessSimulationProject2 {
    public static void main(String[] args) {
        List<ProcessThread> processes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("processes.txt"))) {
            String line;
            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // skip empty lines

                String[] parts = line.trim().split("\\s+");
                int pid = Integer.parseInt(parts[0]);
                int burstTime = Integer.parseInt(parts[2]); // Column 3 = Burst_Time
                processes.add(new ProcessThread(pid, burstTime));
            }
        } catch (IOException e) {
            System.out.println("Error reading processes.txt: " + e.getMessage());
        }

        for (ProcessThread p : processes) {
            p.start();
        }
        for (ProcessThread p : processes) {
            try {
                p.join();
            } catch (InterruptedException e) {
                System.out.println("Error while waiting for process " + p.pid);
            }
        }

        System.out.println("All processes completed.");
    }
}
