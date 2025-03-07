# CPU Scheduling Algorithms: Priority Scheduling and First-Come, First-Serve (FCFS)

## Overview
This project implements two popular CPU scheduling algorithms:
1. **Priority Scheduling**: Processes are scheduled based on priority. If two processes have the same priority, they follow **First-Come, First-Serve (FCFS)**.
2. **First-Come, First-Serve (FCFS)**: Processes are executed in the order they arrive.

Both algorithms compute:
- **Completion Time (CT)**: When the process finishes execution.
- **Turnaround Time (TAT)**: \( \text{TAT} = \text{CT} - \text{Arrival Time} \)
- **Waiting Time (WT)**: \( \text{WT} = \text{TAT} - \text{Burst Time} \)
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
