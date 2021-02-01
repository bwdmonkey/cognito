# Find the First K Missing Positive Numbers (hard)

## problem statement

Given an unsorted array containing numbers and a number ‘k’, find the first ‘k’ missing positive numbers in the array.

Example 1:

```java
Input: [3, -1, 4, 5, 5], k=3
Output: [1, 2, 6]
Explanation: The smallest missing positive numbers are 1, 2 and 6.
```

Example 2:

```java
Input: [2, 3, 4], k=3
Output: [1, 5, 6]
Explanation: The smallest missing positive numbers are 1, 5 and 6.
```
Example 3:

```java
Input: [-2, -3, 4], k=2
Output: [1, 2]
Explanation: The smallest missing positive numbers are 1 and 2.
```

## my solution (wrong)

```java
import java.util.*;

class FirstKMissingPositive {

  public static List<Integer> findNumbers(int[] nums, int k) {
    int i = 0;
    while (i < nums.length) {
      int j = nums[i] - 1;
      if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[j]) {
        swap(nums, i, j);
      } else {
        i++;
      }
    }

    int i = 0; // 1 to inf counter
    int j = 0; // nums positive number index
    List<Integer> missingNumbers = new ArrayList<>();
    while (missingNumbers.size() < k) {
      if (j < nums.length && nums[j] <= 0) {
        j++;
      }
      if (j < nums.length && nums[j] == i + 1) {
        i++;
        j++;
        continue;
      }
      if (i < nums.length && nums[i] != i + 1) {
        missingNumbers.add(i + 1);
      }
      i++;
    }
    return missingNumbers;
  }

  public static void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
```
