import java.util.*;

public class ProcessLogger {
    private static final List<String> logs = new ArrayList<>();

    public static synchronized void log(int pid, long start, long end) {
        logs.add("Process " + pid + ": Started at " + start + " ms, Finished at " + end + " ms");
    }

    public static void printSummary() {
        System.out.println("\n=== Execution Summary ===");
        for (String log : logs) {
            System.out.println(log);
        }
    }
}
