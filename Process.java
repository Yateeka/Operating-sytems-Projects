/*
 * This class defines a `Process` that represents a process in a scheduling system 
 * with four key attributes: PID aka Process ID, arrival time, burst time, and priority.
 * 
 * Attributes:
 * - `pid`: The unique identifier for the process. This integer allows the system 
 *   to track and differentiate processes.
 * - `arrivalTime`: The time at which the process arrives in the system. This value 
 *   helps determine the order in which processes are handled in scheduling algorithms. 
 * - `burstTime`: The total CPU time required by the process for execution. This 
 *   determines how long the process will run in the CPU.
 * - `priority`: A value representing the importance of the process. Higher priority 
 *   values usually indicate that the process should be executed first, compared 
 *   to other processes with lower priority.
 * 
 * Constructor:
 * - The constructor `Process(int pid, int arrivalTime, int burstTime, int priority)` 
 *   initializes a new instance of the `Process` class with the given values for 
 *   `pid`, `arrivalTime`, `burstTime`, and `priority`.
 * 
 * toString() Method:
 * - This method is overridden from the `Object` class to provide a custom string 
 *   representation of the `Process` object. When calling `toString()` on a `Process` 
 *   object, it returns a formatted string containing the process details (PID, arrival 
 *   time, burst time, and priority) in a human-readable format. 
 * 
 * Example:
 * - A `Process` object with PID 1, arrival time 0, burst time 5, and priority 3 
 *   would return the string: 
 *   "PID: 1, Arrival: 0, Burst: 5, Priority: 3".
 */

 public class Process { 
    int pid, arrivalTime, burstTime, priority;

    public Process(int pid, int arrivalTime, int burstTime, int priority) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
}
    @Override 
    public String toString() {
        return "PID: " + pid + ", Arrival: " + arrivalTime + ", Burst: " + burstTime + ", Priority: " + priority;
    }
}
