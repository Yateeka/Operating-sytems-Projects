import java.util.*;

/**
 * This class generates a textual Gantt chart by calling the existing scheduling methods.
 * It reads processes from the `processes.txt` file and creates a textual Gantt chart output.
 */
public class TextualGanttChart {

    public static void main(String[] args) {
        // Read the processes from the file
        List<Process> processes = ProcessReader.readProcesses("processes.txt");
        
        generateTextualGanttChart(processes, "FCFS");

        // Run Priority Scheduling and generate textual Gantt chart
        generateTextualGanttChart(processes, "Priority");
    }

    /**
     * This method generates a textual Gantt chart based on the scheduling results.
     * @param processes List of processes to display in the Gantt chart
     * @param schedulingType The type of scheduling algorithm used ("FCFS" or "Priority")
     */
    public static void generateTextualGanttChart(List<Process> processes, String schedulingType) {
        // Sort processes based on arrival time or priority depending on the scheduling algorithm
        if ("FCFS".equals(schedulingType)) {
            processes.sort(Comparator.comparingInt(p -> p.arrivalTime));
        } else if ("Priority".equals(schedulingType)) {
            processes.sort(Comparator.comparingInt((Process p) -> p.priority)
                    .thenComparingInt(p -> p.arrivalTime));
        }

        int currentTime = 0;

        // StringBuilders to create the textual Gantt chart
        StringBuilder ganttChart = new StringBuilder();
        StringBuilder ganttTimes = new StringBuilder();

        // Generate the Gantt chart by iterating over the processes
        for (Process p : processes) {
            if (currentTime < p.arrivalTime) {
                currentTime = p.arrivalTime; // CPU is idle, move to arrival time
            }
            int completionTime = currentTime + p.burstTime;
            currentTime = completionTime;

            // Building the Gantt chart as text
            ganttChart.append("| P").append(p.pid).append(" ");
            ganttTimes.append("  ").append(completionTime).append("  ");
        }

        // Print the textual Gantt chart
        System.out.println("\nTextual Gantt Chart Representation (" + schedulingType + "):");
        System.out.println(ganttChart.toString());
        System.out.println(ganttTimes.toString());

    }
}
