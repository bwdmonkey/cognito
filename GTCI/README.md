# grokking the coding interview

## question type complexities

| O(N)           | question types     |
| :------------- | :----------: |
| > N! | DP, variations of permutation/subset |
| N!   | permutation |
| 2^n | subset, recursion, sliding window(variant), nested operations |
| n log(n) | sorting, heaps, sliding window (variant) |
| n | linear scan, sliding window, array, hash maps, last index store, peaks and valleys |
| log(n) | binary tree, binary search |
| 1 | - |

## steps

1. what are my inputs? what is the domain?
2. what are my outputs? what is the range?
3. what are the edge cases?
4. should I aim for the optimal solution?
5. analyze the sample cases
    - can you simplify the problem?
    - **what are the patterns you may be able to use?**

6. define the function
7. address bottlenecks
8. test your function
9. analyze time/space complexity

## pattern one: sliding window

### p1.process

1. track of window start (typ. additional pointer) and end (typ. loop index)
2. consider for things to track between different windows (frequency/index maps, sums, etc)
3. consider the condition for expanding the window (typ. expand while no reason to shrink; window size must be k after expanding so must be end at k-1 the previous loop, etc)
4. consider the condition for shrinking the window (window size must be K, unique chars, etc)

### p1.tips

- window length = windowEnd - windowStart + 1
- use frequency map for overlapping windows
- use index map for non-overlapping windows

### p1.solutions

- easy: maximum sum subarray of size K [code](code/MaxSumSubArrayOfSizeK.md)
- easy: smallest subarray with a given sum [code](code/MinSizeSubArraySum.md)
- medium: longest substring with k distinct characters [code](code/LongestSubstringKDistinct.md)
- medium: fruits into baskets [code](code/MaxFruitCountOf2Types.md)
- hard: no-repeat substring [code](code/NoRepeatSubstring.md)
- hard: longest substring with same letters after replacement [code](code/CharacterReplacement.md)
- hard: longest subarray with ones after replacement [code](code/ReplacingOnes.md)
- hard: permutation in a string [code](code/StringPermutation.md)
- hard: string anagrams [code](code/StringAnagrams.md)
- hard: smallest window containing substring [code](code/MinimumWindowSubstring.md)
- hard: words concatenation [code](code/WordConcatenation.md)

## pattern two: two pointers

### p2.process

1. check if the input array should be sorted or not
2. if finding triplets, find out if sub-iterations are needed

  2.1. if sub-iterations are needed, figure out how it connects to the original loop
  2.2. consider the conditions to be met between sub-loops
  2.3. merge sub-loop after iteration
3. consider effect of previous loops

### p2.tips

- very useful when the input array is sorted

### p2.solutions

- easy: pair with target sums [code](code/PairWithTargetSum.md)
- easy: remove duplicates [code](code/RemoveDuplicates.md)
- easy: sorted array squares [code](code/SortedArraySquares.md)
- medium: triplet sum to zero [code](code/TripletSumToZero.md)
- medium: triplet sum close to target [code](code/TripletSumCloseToTarget.md)
- medium: triplets with smaller sum [code](code/TripletWithSmallerSum.md)
- medium: dutch national flag problem [code](code/DutchFlag.md)
- medium: quadruple sum to target [code](code/QuadrupleSumToTarget.md)
- medium: comparing strings containing backsapces [code](code/BackspaceCompare.md)
- medium: minimum window sort [code](code/MinimumWindowSubstring.md)

## pattern three: fast and slow pointers

### p3.process

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
  slow = slow.next;
  fast = fast.next.next;
}
```

### p3.tips

- `while (fast != null && fast.next != null) {}`
- reversing LinkedList

  ```java
  private static ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }
  ```

### p3.solutions

- easy: linkedlist cycle [code](code/LinkedListCycle.md)
- medium: start of linkedlist cycle [code](code/LinkedListCycleStart.md)
- medium: happy number [code](code/HappyNumber.md)
- easy: middle of the linkedlist [code](code/MiddleOfLinkedList.md)
- medium: palindrome linkedlist [code](code/PalindromicLinkedList.md)
- medium: rearrange a linkedlist [code](code/RearrangeList.md)
- hard: cycle in a circular array [code](code/CircularArrayLoop.md)

## pattern four: merge intervals

### p4.process

- sort the intervals by start time `Collections.sort(x, () -> -1)`
- compare prev and curr intervals

  - ```java
      for (int i = 1; i < intervals.size(); i++) {
        Interval prev = intervals.get(i-1);
        Interval curr = intervals.get(i);
        // care for inclusive or exclusive
        if (curr.start <= prev.end) {
          // these meetings overlap
        } else {
          // these meetings does not overlap
        }
      }
      ```

### p4.tips

- use min heap (PriorityQueue) for tracking the earliest interval start time if input is `List<List<Interval>>` ie. multiple employee's schedule

### p4.solutions

- medium: merge intervals [code](code/MergeIntervals.md)
- medium: insert interval [code](code/InsertInterval.md)
- medium: intervals intersection [code](code/IntervalsIntersection.md)
- medium: conflicting appointments [code](code/ConflictingAppointments.md)
- hard: minimum meeting rooms [code](code/MinimumMeetingRooms.md)
- hard: maximum CPU load [code](code/MaximumCPULoad.md)
- hard: employee free time [code](code/EmployeeFreeTime.md)

## pattern five: cyclic sorts

### p5.process

0. array must contain elements that are naturally indexable (`[1,2,3,4]`)
1. cyclic sort
    - note: unsortable numbers (out of range or negative index) will fill empty indexes or go to the end

    - ```java
      int i = 0;
      while (i < nums.length) {
        // if (condition to include in sort       && cur_num != expected_num)
        if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
          swap(nums, i, nums[i] - 1);
        else
          i++;
      }
      ```

2. iterate the 'sorted array'

    - ```java
      List<Integer> missingNumbers = new ArrayList<>();
      Set<Integer> extraNumbers = new HashSet<>();
      for (i = 0; i < nums.length && missingNumbers.size() < k; i++)
        if (nums[i] != i + 1) {
          missingNumbers.add(i + 1);
          extraNumbers.add(nums[i]);
        }
      ```

### p5.solutions

- easy: cyclic sort [code](code/CyclicSort.md)
- easy: find the missing number [code](code/MissingNumber.md)
- easy: find all missing numbers [code](code/AllMissingNumbers.md)
- easy: find the duplicate number [code](code/FindDuplicate.md)
- easy: find all duplicate numbers [code](code/FindAllDuplicate.md)
- easy: find the corrupt pair [code](code/FindCorruptNums.md)
- medium: find the smallest missing positive number [code](code/FirstSmallestMissingPositive.md)
- hard: find the first K missing positive numbers [code](code/FirstKMissingPositive.md)
