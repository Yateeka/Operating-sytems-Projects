import java.io.*;
import java.util.*;

/**
 * This class reads process data from a text file and stores the information in a list of Process objects.
 * 
 * It performs the following tasks:
 * 1. Reads data from a file specified by the user.
 * 2. Skips the first line (which contains headers) and any empty lines.
 * 3. Processes each line to extract the PID, arrival time, burst time, and priority of each process.
 * 4. Handles invalid lines (e.g., non-integer values or lines with an incorrect number of values) and skips them.
 * 5. Returns a list of Process objects containing the data for each valid process.
 */
public class ProcessReader {

    /**
     * Reads process data from the specified file and returns a list of Process objects.
     * 
     * @param filename The name of the file containing the process data.
     * @return A list of Process objects representing the processes read from the file.
     */
    public static List<Process> readProcesses(String filename) {
        List<Process> processes = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean firstLine = true; // Flag to skip the header line
            
            while ((line = br.readLine()) != null) {
                // Skip the first line (header)
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] values = line.split("\\s+");
                
                // Check if the line contains exactly 4 values
                if (values.length == 4) {
                    try {
                        int pid = Integer.parseInt(values[0]);
                        int arrivalTime = Integer.parseInt(values[1]);
                        int burstTime = Integer.parseInt(values[2]);
                        int priority = Integer.parseInt(values[3]);
                        
                        // Add the process to the list
                        processes.add(new Process(pid, arrivalTime, burstTime, priority));
                    } catch (NumberFormatException e) {
                        // Handle the case where any value cannot be parsed
                        System.out.println("Invalid data on line: " + line);
                    }
                } else {
                    // Handle the case where the line doesn't have 4 values
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return processes;
    }

    public static void main(String[] args) {
        // Testing the process reading method
        List<Process> processes = readProcesses("/Users/yateekagoyal/Desktop/OS/Operating-sytems-Projects/processes.txt");
        
        for (Process p : processes) {
            System.out.println(p);
        }
    }
}
