import java.io.*;
import java.util.*;

public class ProcessReader {
    public static List<Process> readProcesses(String filename){
        List<Process> processes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            while ((line = br.readLine()) !=null) {
                String[] values = line.split("\\s+");
                int pid = Integer.parseInt(values[0]);
                int arrivalTime = Integer.parseInt(values[1]);
                int burstTime = Integer.parseInt(values[2]);
                int priority = Integer.parseInt(values[3]);
                processes.add(new Process(pid, arrivalTime, burstTime, priority));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return processes;
    }

    public static void main(String[] args) {
        List<Process> processes = readProcesses("processes.txt");
        for (Process p : processes) {
            System.out.println(p);
        }
    }
}