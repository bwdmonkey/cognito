# Maximum CPU Load (hard)

## problem statement

We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load when it is running. Our goal is to find the maximum CPU load at any time if all the jobs are running on the same machine.

Example 1:

```java
Jobs: [[1,4,3], [2,5,4], [7,9,6]]
Output: 7
Explanation: Since [1,4,3] and [2,5,4] overlap, their maximum CPU load (3+4=7) will be when both the
jobs are running at the same time i.e., during the time interval (2,4).
```

Example 2:

```java
Jobs: [[6,7,10], [2,4,11], [8,12,15]]
Output: 15
Explanation: None of the jobs overlap, therefore we will take the maximum load of any job which is 15.
```

Example 3:

```java
Jobs: [[1,4,2], [2,4,1], [3,6,5]]
Output: 8
Explanation: Maximum CPU load will be 8 as all jobs overlap during the time interval [3,4].
```

## my solution (perfect)

```java
import java.util.*;

class Job {
  int start;
  int end;
  int cpuLoad;

  public Job(int start, int end, int cpuLoad) {
    this.start = start;
    this.end = end;
    this.cpuLoad = cpuLoad;
  }
};

class MaximumCPULoad {

  public static int findMaxCPULoad(List<Job> jobs) {
    // 1. sort by start time
    // 2-0. track maxcpuload
    // 2. set up priority queue for comparator a.end - b.end
    // 3. iterate jobs
    // 4. while cur.start >= pq.peak().end, curload -= pq.poll().load
    // 5. curload += cur.load
    // 6. maxLoad = max(curload, maxload)
    Collections.sort(jobs, (a, b) -> a.start - b.start);
    PriorityQueue<Job> pq = new PriorityQueue<>(jobs.size(), (a, b) -> a.end - b.end);
    int peakCpuLoad = 0;
    int curLoad = 0;
    for (int i = 0; i < jobs.size(); i++) {
      while (pq.size() > 0 && jobs.get(i).start >= pq.peek().end) {
        curLoad -= pq.poll().cpuLoad;
      }
      curLoad += jobs.get(i).cpuLoad;
      peakCpuLoad = Math.max(curLoad, peakCpuLoad);
      pq.offer(jobs.get(i));
    }
    return peakCpuLoad;
  }

  public static void main(String[] args) {
    List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
    System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

    input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
    System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

    input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
    System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
  }
}
```
