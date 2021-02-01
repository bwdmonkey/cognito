# Find all Missing Numbers (easy)

## problem statement

We are given an unsorted array containing numbers taken from the range 1 to ‘n’. The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.

Example 1:

```java
Input: [2, 3, 1, 8, 2, 3, 5, 1]
Output: 4, 6, 7
Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.
```

Example 2:

```java
Input: [2, 4, 1, 2]
Output: 3
```

Example 3:

```java
Input: [2, 3, 2, 1]
Output: 4
```

## my solution (perfect)

```java
import java.util.*;

class AllMissingNumbers {

  public static List<Integer> findNumbers(int[] nums) {
    // 1. cyclic sort
    int i = 0;
    while (i < nums.length) {
      int j = nums[i] - 1;
      if (nums[i] != nums[j]) {
        swap(nums, i, j);
      } else {
        i++;
      }
    }

    // 2. iterate and find all missing numbers
    List<Integer> missingNumbers = new ArrayList<>();
    for (i = 0; i < nums.length; i++) {
      if (nums[i] - 1 != i) {
        missingNumbers.add(i + 1);
      }
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
