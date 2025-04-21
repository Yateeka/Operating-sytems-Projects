# Project 2 Thread-Based Process Simulation and Synchronization

###  Overview
This part of the project simulates process scheduling using **Java threads** and explores **synchronization, logging**, and **team-based integration**. It builds upon Part 1 by simulating the execution of each process as a thread, managing their interactions through synchronization primitives, and logging activity for testing and analysis.

---

###  Project Breakdown (Team Contributions)

| Part | Name             | Responsibility |
|------|------------------|----------------|
| **A** | Dua Spall        | **Thread Simulation & Input Handling**  
- Created `ProcessThread` to simulate each process using `Thread.sleep()`  
- Read process data from `processes.txt`  
- Ensured each thread logs start and end of execution |
| **B** | Melanie           | **Synchronization Implementation**  
- Implemented a classic sync problem (e.g., Producer-Consumer)  
- Used Java semaphores or locks for safe resource access  
- Handled potential deadlocks and race conditions |
| **C** | Yateeka Goyal     | **Logging & Output Verification**  
- Designed a consistent logging format for thread actions  
- Verified order of thread execution  
- Assisted with debugging and ensuring readable outputs |
| **D** | Khushi Mishra     | **Integration & Bonus Feature**  
- Integrated all modules into one runnable class (`ProcessSimulationProject2_Logger.java`)  
- Added a **bonus feature**: time-stamped logging + thread execution summary table  
- Participated in final testing and made sure all modules worked smoothly together |

---

###  Input Format
The simulation uses a simplified `processes.txt` file (without header), formatted as:

```
<ProcessID> <BurstTime>
```

Example:
```
1 3
2 2
3 1
```

---

###  How to Run

**1. Compile all source files:**
```bash
javac *.java
```

**2. Run the integrated thread simulation logger:**
```bash
java ProcessSimulationProject2_Logger
```

---

###  Sample Output
```text
[1745213041572] Process 1 started.
[1745213041599] Process 1 finished.
...

=== Thread Execution Summary ===
PID 1 | Start: 1745213041572 | End: 1745213041599 | Duration: 27 ms
...
```

---

###  Bonus Feature (Implemented by Khushi Mishra)
- **Timestamped Logs:** Threads log start and end times using `System.currentTimeMillis()`
- **Summary Table:** After all threads finish, a table is printed showing PID, start time, end time, and duration
