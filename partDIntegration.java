import java.io.*;
import java.util.*;
import java.util.concurrent.Semaphore;

public class partDIntegration {

    private static final Semaphore cpu = new Semaphore(1);

    static class ProcessThread extends Thread {
        int pid, burstTime;

        public ProcessThread(int pid, int burstTime) {
            this.pid = pid;
            this.burstTime = burstTime;
        }

        @Override
        public void run() {
            try {
                System.out.println("[" + System.currentTimeMillis() + " ms] Process " + pid + " waiting for CPU...");
                cpu.acquire();
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
                cpu.release();
            }
        }
    }

    public static void main(String[] args) {
        List<ProcessThread> processes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("processes.txt"))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] parts = line.split("\\s+");
                int pid = Integer.parseInt(parts[0]);
                int burstTime = Integer.parseInt(parts[2]);
                processes.add(new ProcessThread(pid, burstTime));
            }
        } catch (IOException e) {
            System.out.println("Error reading processes.txt.");
            e.printStackTrace();
        }

        for (ProcessThread p : processes) {
            p.start();
        }

        for (ProcessThread p : processes) {
            try {
                p.join();
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted while waiting for process " + p.pid);
            }
        }

        ProcessLogger.printSummary();
    }
}

