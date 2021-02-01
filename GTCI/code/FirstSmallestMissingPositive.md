# Find the Smallest Missing Positive Number (medium)

## problem statement

Given an unsorted array containing numbers, find the smallest missing positive number in it.

Example 1:

```java
Input: [-3, 1, 5, 4, 2]
Output: 3
Explanation: The smallest missing positive number is '3'
```

Example 2:

```java
Input: [3, -2, 0, 1, 2]
Output: 4
```

Example 3:

```java
Input: [3, 2, 5, 1]
Output: 4
```

## my solution (perfect)

```java
class FirstSmallestMissingPositive {

  public static int findNumber(int[] nums) {
    int i = 0;
    while (i < nums.length) {
      int j = nums[i] - 1;
      if (!(nums[i] <= 0 || nums[i] > nums.length) && nums[i] != nums[j]) {
        swap(nums, i, j);
      } else {
        i++;
      }
    }

    for (i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1)
        return i + 1;
    }
    return nums.length;
  }

  public static void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
```
