# Find the Missing Number (easy)

## problem statement

We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’. Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.

Example 1:

```java
Input: [4, 0, 3, 1]
Output: 2
```

Example 2:

```java
Input: [8, 3, 5, 2, 4, 6, 0, 1]
Output: 7
```

## my solution (perfect with different missing number check condition)

```java
class MissingNumber {

  public static int findMissingNumber(int[] nums) {
    // TODO: Write your code here
    int i = 0;
    while (i < nums.length) {
      if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
        swap(nums, i, nums[i]);
      } else {
        i++;
      }
    }

    for (i = 0; i < nums.length; i++) {
      if (nums[i] >= nums.length || nums[i] != nums[nums[i]]) {
        return i;
      }
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
