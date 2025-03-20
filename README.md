# CPU Scheduling Algorithms: Priority Scheduling and First-Come, First-Serve (FCFS)

## Overview
This project implements two popular CPU scheduling algorithms:
1. **Priority Scheduling**: Processes are scheduled based on priority. If two processes have the same priority, they follow **First-Come, First-Serve (FCFS)**.
2. **First-Come, First-Serve (FCFS)**: Processes are executed in the order they arrive.

Both algorithms compute:
- **Completion Time (CT)**: When the process finishes execution.
- **Turnaround Time (TAT)**: TAT = CT - Arrival Time
- **Waiting Time (WT)**: WT = TAT - Burst Time
- **Gantt Chart**: A visual representation of the process execution order.

## Features
- Reads process data from a file (`processes.txt`).
- Implements **Priority Scheduling** and **FCFS**.
- Computes **waiting time**, **turnaround time**, and **completion time**.
- Displays a **Gantt Chart** for both scheduling algorithms.

## Input File Format (`processes.txt`)
The file should contain process data in the following format:

| **PID** | **Arrival Time** | **Burst Time** | **Priority** |
|---------|------------------|----------------|--------------|
| 1       | 0                | 5              | 2            |
| 2       | 2                | 3              | 1            |
| 3       | 4                | 2              | 3            |
| 4       | 5                | 1              | 4            |
| 5       | 6                | 4              | 2            |
| 6       | 7                | 2              | 2            |
| 7       | 8                | 3              | 1            |
| 8       | 9                | 2              | 3            |

- **PID**: Process ID
- **Arrival Time**: When the process enters the system.
- **Burst Time**: Execution time required by the process.
- **Priority**: Lower number indicates higher priority.

## Running the Program

### Compilation:
To compile the program, run the following command:
```bash
javac priority_scheduling.java ProcessReader.java Process.java FCFS.java
```
## Running the FCFS Scheduling Algorithm
The **First-Come, First-Serve (FCFS) Scheduling** algorithm executes processes in the order they arrive.

### **Compiling FCFS Scheduling**
To compile the **FCFS Scheduling** program, run:

```bash
javac FCFS_Scheduling.java ProcessReader.java Process.java
```

## Textual Gantt Chart Representation
This program generates a textual Gantt chart for both **FCFS** and **Priority Scheduling** algorithms. The chart is displayed with the process execution order and completion times.

### Example of Gantt Chart Output:

**Textual Gantt Chart Representation (FCFS):*
 ```bash
| P1 | P2 | P3 | P4 | P5 | P6 | P7 | P8 
    5   8   10  11  15  17  20  22
```

**Textual Gantt Chart Representation (Priority):**
```bash
| P2 | P1 | P5 | P6 | P3 | P7 | P8 | P4
    3   5   9   11  13  16  18  19
```



