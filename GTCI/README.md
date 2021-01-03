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

- window length = windowEnd - windowStart + 1
- use frequency map for overlapping windows
- use index map for non-overlapping windows

### solutions

- easy: maximum sum subarray of size K [java](java/MaxSumSubArrayOfSizeK.java)
- easy: smallest subarray with a given sum [java](java/MinSizeSubArraySum.java)
- medium: longest substring with k distinct characters [java](java/LongestSubstringKDistinct.java)
- medium: fruits into baskets [java](java/MaxFruitCountOf2Types.java)
- hard: no-repeat substring [java](java/NoRepeatSubstring.java)
- hard: longest substring with same letters after replacement [java](java/CharacterReplacement.java)
- hard: longest subarray with ones after replacement [java](java/ReplacingOnes.java)
- hard: permutation in a string [java](java/StringPermutation.java)
- hard: string anagrams [java](java/StringAnagrams.java)
- hard: smallest window containing substring [java](java/MinimumWindowSubstring.java)
- hard: words concatenation [java](java/WordConcatenation.java)
