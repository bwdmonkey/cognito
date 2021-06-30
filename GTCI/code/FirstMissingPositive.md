# First Missing Positive (hard)

## problem statement

Given an unsorted integer array nums, find the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses constant extra space.



Example 1:

```
Input: nums = [1,2,0]
Output: 3
```

Example 2:

```
Input: nums = [3,4,-1,1]
Output: 2
```

Example 3:

```
Input: nums = [7,8,9,11,12]
Output: 1
```

## my solution (corrected, 45 minutes)

```java
/**
 * [1,2,3] => 4
 * [0] => 1
 * [3,2,1] => 4
 * [4,2,1,0,-1,-2,-3] => 3
 * [0,1,2,4] => [1,1,1,0] (3)
 * [1,2,3,4] => [0,1,1,1] ()
 * [4,3,2,1] => [0,1,1,1] or [1,1,1,1]
 * [1,2,4,5] => [1,2,] ()
 * possible answer = (1, n)
 * ignore zero, negatives => translates values i dont care about into a zero
 * am i allowed to manipulate the input array?
 * can there be duplicate values? yes
 * option 1: create an array of equal size + 1 (for 1-index) as nums and check if each number exist and increment count then iterate the copied array to check if the number exist, if not return that number
 * option 2: first loop => check if n exist in the array (if so make note) second loop => manipulate the input array by translate the invalid values to zero (not positive or greater than n). third loop => for each number translate to frequency map in the array. fourth loop => iterate the frequency array to check if any of the index beside 0 is not 0, if so return i
 * option 3: cylic sort by swapping
 */

class Solution {
    public int firstMissingPositive(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; i++)
            if (nums[i] <= 0 || nums[i] > N)
                nums[i] = N + 1;
        // possible range: 1~N+1 (1-index to 0-index)
        for (int i = 0; i < N; i++) {
            int val = Math.abs(nums[i]);
            if (val <= N)
                nums[val - 1] = 0-Math.abs(nums[val - 1]);
        }
        for (int i = 0; i < N; i++)
            if (nums[i] >= 0)
                return i + 1;
       return N + 1;
    }
}
```

## my solution 2 (accepted, ashamed at least 4 hours)

```java
class Solution {
    public int firstMissingPositive(int[] nums) {
        int N = nums.length;
        boolean containsN = false;

        for (int i = 0; i < N; i++) {
            if (nums[i] == N)
                containsN = true;
            if (nums[i] <= 0 || nums[i] >= N) {
                nums[i] = 0;
                containsZero = true;
            }
        }

        for (int i = 0; i < N; i++)
            nums[nums[i] % N] += N;
        for (int i = 1; i < N; i++)
            if (nums[i] / N == 0)
                return i;

        return (containsN) ? N + 1 : N;
    }
}
```

## Possible Follow-ups

1. How would you modify your code to output the first two positive values?
A: Although the implementation off the top of my head wouldn't with the int array in Java, if I was able to append to expand the input array by size of K, where K is the number of first positive values to be found, I would do a similar operation of checking adding values to result if they do not exist and an extra while loop at the end to generate next k numbers.
