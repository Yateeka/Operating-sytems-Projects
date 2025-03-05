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