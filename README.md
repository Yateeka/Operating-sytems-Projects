
# Project 2: Thread-Based Process Simulation and Synchronization

## Description
Simulates CPU process scheduling using Java threads, with synchronization handled via semaphores and detailed execution logging.  
Each process runs as a thread, ensuring safe CPU access and structured output to verify proper scheduling behavior.

---

## Objective
The objective of this project is to simulate real-time process execution using threads and explore how operating systems manage synchronization among concurrent processes.  
We modeled process execution using threads, solved synchronization challenges with semaphores, and provided detailed, time-stamped logging for validation and analysis.

---

## Project Breakdown

| Part | Member           | Responsibilities |
|------|------------------|----------------|
| **A** | Dua Spall        | - Created `ProcessThread` class to simulate processes using `Thread.sleep()`  
- Read process data dynamically from `processes.txt`  
- Logged start and end of thread execution |
| **B** | Melanie          | - Implemented synchronization using Java `Semaphore`  
- Modeled CPU as a critical resource  
- Handled safe locking and unlocking to prevent deadlocks |
| **C** | Yateeka Goyal    | - Designed detailed logging format using timestamps  
- Verified thread execution order for correctness  
- Improved output formatting for readability |
| **D** | Khushi Mishra    | - Integrated all modules into a runnable program (`ProcessSimulationProject2_Logger.java`)  
- Added timestamped logs and final thread execution summary table  
- Conducted final testing and ensured smooth module integration |

---

## Input Format
The simulation expects a `processes.txt` file with the following format:

```
<ProcessID> <BurstTime> <ProcessID> <BurstTime> ...
```

Example:
```
1 3 2 2 3 1
```

- `ProcessID`: Unique identifier for the process.
- `BurstTime`: CPU time in seconds.

No header line required.

---

## How to Compile and Run

1. Open a terminal and navigate to the project directory.
2. Compile all Java files:
   ```bash
   javac *.java
   ```
3. Run the simulation:
   ```bash
   java ProcessSimulationProject2_Logger
   ```

---

## Example Output
```
[1745213041572 ms] Process 1 waiting to acquire CPU...
[1745213041575 ms] Process 1 acquired CPU.
[1745213041576 ms] Process 1 started.
[1745213044578 ms] Process 1 finished.
[1745213044579 ms] Process 1 released CPU.

=== Thread Execution Summary ===
PID 1 | Start: 1745213041576 ms | End: 1745213044578 ms | Duration: 2002 ms
```

---

## Features

- Thread Simulation: Each process executes as a separate Java thread.
- Synchronization: CPU access managed via Java Semaphore, ensuring only one process occupies the CPU at a time.
- Logging System: Each significant thread action (waiting, acquiring, starting, finishing, releasing) is timestamped.
- Bonus Feature (Integration): Final execution summary table showing each process's PID, start time, end time, and duration.

---

## Files Included

- `ProcessSimulationProject2_Logger.java` — Main class managing thread creation and execution
- `ProcessLogger.java` — Helper class for structured logging and summary generation
- `processes.txt` — Input file containing process information
- `README.md` — Project documentation

---

## Contributors

- Dua Spall — Thread simulation and input handling
- Melanie — Synchronization and deadlock prevention
- Yateeka Goyal — Logging design and output verification
- Khushi Mishra — Module integration and bonus feature implementation
