import java.util.*;

public class ProcessLogger {
    private static final List<String> logs = new ArrayList<>();

    public static synchronized void log(int pid, long start, long end) {
        logs.add("PID " + pid + " | Start: " + start + " | End: " + end + " | Duration: " + (end - start) + " ms");
    }

    public static void printSummary() {
        System.out.println("\n=== Thread Execution Summary ===");
        for (String log : logs) {
            System.out.println(log);
        }
    }
}

