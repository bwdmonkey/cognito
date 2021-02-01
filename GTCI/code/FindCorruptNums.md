# Find the Corrupt Pair (easy)

## problem statement

We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’. The array originally contained all the numbers from 1 to ‘n’, but due to a data error, one of the numbers got duplicated which also resulted in one number going missing. Find both these numbers.

Example 1:

```java
Input: [3, 1, 2, 5, 2]
Output: [2, 4]
Explanation: '2' is duplicated and '4' is missing.
```

Example 2:

```java
Input: [3, 1, 2, 3, 6, 4]
Output: [3, 5]
Explanation: '3' is duplicated and '5' is missing.
```

## my solution (perfect)

```java
class FindCorruptNums {

  public static int[] findNumbers(int[] nums) {
    int duplicate = -1;
    int i = 0;
    // cyclic sort + find duplicate
    while (i < nums.length) {
      int j = nums[i] - 1;
      if (nums[i] != nums[j]) {
        swap(nums, i, j);
      } else {
        if (i != j)
          duplicate = nums[i];
        i++;
      }
    }

    // find the missing number
    for (i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1)
        return new int[] { duplicate, i + 1 };
    }
    return new int[] { -1, -1 };
  }

  public static void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}
```
