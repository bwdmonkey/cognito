# Find the Duplicate Number (easy)

## problem statement

We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’. The array has only one duplicate but it can be repeated multiple times. Find that duplicate number without using any extra space. You are, however, allowed to modify the input array.

Example 1:

```java
Input: [1, 4, 4, 3, 2]
Output: 4
```

Example 2:

```java
Input: [2, 1, 3, 3, 5, 4]
Output: 3
```

Example 3:

```java
Input: [2, 4, 1, 4, 4]
Output: 4
```

## my solution (perfect)

```java
class FindDuplicate {

  public static int findNumber(int[] nums) {
    int i = 0;
    while (i < nums.length) {
      int j = nums[i] - 1;
      if (nums[i] != nums[j]) {
        swap(nums, i, j);
      } else {
        if (i != j) {
          return nums[i];
        }
        i++;
      }
    }

    return -1;
  }

  public static void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}

```
