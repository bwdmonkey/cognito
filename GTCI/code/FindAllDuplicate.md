# Find all Duplicate Numbers (easy)

## problem statement

We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’. The array has some numbers appearing twice, find all these duplicate numbers without using any extra space.

Example 1:

```java
Input: [3, 4, 4, 5, 5]
Output: [4, 5]
```

Example 2:

```java
Input: [5, 4, 7, 2, 3, 5, 3]
Output: [3, 5]
```

## my solution (optimal with different while loop)

```java
import java.util.*;

class FindAllDuplicate {

  public static List<Integer> findNumbers(int[] nums) {
    List<Integer> duplicateNumbers = new ArrayList<>();
    int i = 0;
    while (i < nums.length) {
      int j = nums[i] - 1;
      if (nums[i] != nums[j]) {
        swap(nums, i, j);
      } else {
        if (i != j) {
          duplicateNumbers.add(nums[i]);
        }
        i++;
      }
    }
    return duplicateNumbers;
  }

  public static void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
```
