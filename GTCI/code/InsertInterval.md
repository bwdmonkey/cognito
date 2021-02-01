# Insert Interval (medium)

## problem statement

Given a list of non-overlapping intervals sorted by their start time, insert a given interval at the correct position and merge all necessary intervals to produce a list that has only mutually exclusive intervals.

Example 1:

```java
Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
Output: [[1,3], [4,7], [8,12]]
Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].
```

## my solution (perfectish - different style)

```java
import java.util.*;

class Interval {
  int start;
  int end;

  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
};

class InsertInterval {

  public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    List<Interval> mergedIntervals = new ArrayList<>();

    Interval prev = intervals.get(0);
    for (int i = 1; i < intervals.size(); i++) {
      if ((prev.start <= newInterval.start && newInterval.start <= prev.end ) ||
        (prev.start <= newInterval.end && newInterval.end <= prev.end) ||
        (newInterval.start <= prev.start && prev.start <= newInterval.end) ||
        (newInterval.start <= prev.end && prev.end <= newInterval.end)) {
        prev.start = Math.min(prev.start, newInterval.start);
        prev.end = Math.max(prev.end, newInterval.end);
      }
      Interval cur = intervals.get(i);
      if (cur.start <= prev.end) {
        prev.end = Math.max(prev.end, cur.end);
      } else {
        mergedIntervals.add(prev);
        prev = cur;
      }
    }
    if ((prev.start <= newInterval.start && newInterval.start <= prev.end ) ||
        (prev.start <= newInterval.end && newInterval.end <= prev.end) ||
        (newInterval.start <= prev.start && prev.start <= newInterval.end) ||
        (newInterval.start <= prev.end && prev.end <= newInterval.end)) {
      prev.start = Math.min(prev.start, newInterval.start);
      prev.end = Math.max(prev.end, newInterval.end);
    }
    mergedIntervals.add(prev);

    return mergedIntervals;
  }

  public static void main(String[] args) {
      List<Interval> input = new ArrayList<Interval>();
    input.add(new Interval(1, 3));
    input.add(new Interval(5, 7));
    input.add(new Interval(8, 12));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(1, 3));
    input.add(new Interval(5, 7));
    input.add(new Interval(8, 12));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(2, 3));
    input.add(new Interval(5, 7));
    System.out.print("Intervals after inserting the new interval: ");
    for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();
  }
}
```
