# Intervals Intersection (medium)

## problem statement

Given two lists of intervals, find the intersection of these two lists. Each list consists of disjoint intervals sorted on their start time.

Example 1:

```java
Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
Output: [2, 3], [5, 6], [7, 7]
Explanation: The output list contains the common intervals between the two lists.
```

Example 2:

```java
Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
Output: [5, 7], [9, 10]
Explanation: The output list contains the common intervals between the two lists.
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

class IntervalsIntersection {

  public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
    List<Interval> intervalsIntersection = new ArrayList<Interval>();
    int i = 0; // arr1 index
    int j = 0; // arr2 index

    while (i < arr1.length && j < arr2.length) {
      Interval i1 = arr1[i];
      Interval i2 = arr2[j];
      if ((i1.start <= i2.start && i2.start <= i1.end) || (i2.start <= i1.start && i1.start <= i2.end)) {
        Interval l = new Interval(Math.max(i1.start, i2.start), Math.min(i1.end, i2.end));
        intervalsIntersection.add(l);
      }
      if (i1.end < i2.end) {
        i++;
      } else {
        j++;
      }
    }
    return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
  }

  public static void main(String[] args) {
    Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
    Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
    Interval[] result = IntervalsIntersection.merge(input1, input2);
    System.out.print("Intervals Intersection: ");
    for (Interval interval : result)
      System.out.print("[" + interval.start + "," + interval.end + "] ");
    System.out.println();

    input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
    input2 = new Interval[] { new Interval(5, 10) };
    result = IntervalsIntersection.merge(input1, input2);
    System.out.print("Intervals Intersection: ");
    for (Interval interval : result)
      System.out.print("[" + interval.start + "," + interval.end + "] ");
  }
}
```
