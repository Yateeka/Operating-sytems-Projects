# Operating-sytems-Projects 
CPU Scheduling Algorithms
This project implements two CPU scheduling algorithms:

Priority Scheduling: Processes are scheduled based on priority. If two processes have the same priority, they follow First-Come, First-Serve (FCFS).
First-Come, First-Serve (FCFS): Processes are executed in the order they arrive.
Key Metrics
Completion Time (CT): When the process finishes execution.
Turnaround Time (TAT): CT - Arrival Time
Waiting Time (WT): TAT - Burst Time
Gantt Chart
A visual representation of the process execution order.

Input File Format (processes.txt)
The file should contain process data as follows:

nginx
COPY
PID Arrival_Time Burst_Time Priority
1 0 5 2
2 2 3 1
3 4 2 3
4 5 1 4
5 6 4 2
6 7 2 2
7 8 3 1
8 9 2 3
Program Execution
Compilation:
bash
COPY
javac priority_scheduling.java ProcessReader.java Process.java FCFS.java
Execution:
bash
COPY
java priority_scheduling
Expected Output
The program outputs:

Completion Time
Turnaround Time
Waiting Time
Gantt Chart
Average Turnaround and Waiting Time
Example Output for FCFS:
yaml
COPY
PID: 1, Arrival: 0, Burst: 5, Priority: 2 | Completion Time: 5 | Turnaround Time: 5 | Waiting Time: 0
PID: 2, Arrival: 2, Burst: 3, Priority: 1 | Completion Time: 8 | Turnaround Time: 6 | Waiting Time: 3
...
Gantt Chart: | P1 P2 P3 P4 P5 P6 P7 P8 |
Average Turnaround Time: 8.375
Average Waiting Time: 5.625
Conclusion
This project compares Priority Scheduling and FCFS, showing how different strategies impact process execution and overall system performance.

