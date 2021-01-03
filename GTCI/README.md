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

### process

1. track of window start (typ. additional pointer) and end (typ. loop index)
2. consider for things to track between different windows (frequency/index maps, sums, etc)
3. consider the condition for expanding the window (typ. expand while no reason to shrink; window size must be k after expanding so must be end at k-1 the previous loop, etc)
4. consider the condition for shrinking the window (window size must be K, unique chars, etc)

### tips

- window length = windowEnd - windowStart + 1
- use frequency map for overlapping windows
- use index map for non-overlapping windows

### solutions

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

### process

1. TODO

### tips

- TODO

### solutions

- easy: pair with target sums [code]()
