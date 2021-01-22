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

### p2.process

1.

### p2.tips

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

### p2.solutions

- easy: linkedlist cycle [code]()
