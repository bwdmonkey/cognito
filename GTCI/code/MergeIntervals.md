# Merge Intervals (medium)

## problem statement

Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.

Example 1:

```java
Intervals: [[1,4], [2,5], [7,9]]
Output: [[1,5], [7,9]]
Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
one [1,5].
```

## my solution (perfect)

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

class SortInterval implements Comparator<Interval> {
  public int compare(Interval a, Interval b) {
    return a.start - b.start;
  }
}

class MergeIntervals {

  public static List<Interval> merge(List<Interval> intervals) {
    List<Interval> mergedIntervals = new LinkedList<Interval>();
    Collections.sort(intervals, new SortInterval());

    Interval prev = intervals.get(0);
    for (int i = 1; i < intervals.size(); i++) {
      Interval cur = intervals.get(i);
      if (cur.start <= prev.end) {
        prev.end = Math.max(cur.end, prev.end);
      } else {
        mergedIntervals.add(prev);
        prev = cur;
      }
    }
    mergedIntervals.add(prev);
    return mergedIntervals;
  }

  public static void main(String[] args) {
    List<Interval> input = new ArrayList<Interval>();
    input.add(new Interval(1, 4));
    input.add(new Interval(2, 5));
    input.add(new Interval(7, 9));
    System.out.print("Merged intervals: ");
    for (Interval interval : MergeIntervals.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(6, 7));
    input.add(new Interval(2, 4));
    input.add(new Interval(5, 9));
    System.out.print("Merged intervals: ");
    for (Interval interval : MergeIntervals.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input = new ArrayList<Interval>();
    input.add(new Interval(1, 4));
    input.add(new Interval(2, 6));
    input.add(new Interval(3, 5));
    System.out.print("Merged intervals: ");
    for (Interval interval : MergeIntervals.merge(input))
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();
  }
}
```
