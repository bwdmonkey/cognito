# Quadruple Sum to Target (medium)

Given an array of unsorted numbers and a target number, find all unique quadruplets in it, whose sum is equal to the target number.

Example 1:

```java
Input: [4, 1, 2, -1, 1, -3], target=1
Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
Explanation: Both the quadruplets add up to the target.
```

Example 2:

```java
Input: [2, 0, -1, 1, -2, 2], target=2
Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
Explanation: Both the quadruplets add up to the target.
```

## my solution (not working)

```java
import java.util.*;

class QuadrupleSumToTarget {

  public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
    List<List<Integer>> quadruplets = new ArrayList<>();
    // TODO: Write your code here
    int l = 0;
    int r = arr.length - 1;
    Arrays.sort(arr);

    while (l < r) {
      int finalSum = pairWithSum(arr, l, r, target - arr[l] - arr[r], quadruplets);
      if (finalSum >= 0) {
        r--;
      } else {
        l++;
      }
    }

    return quadruplets;
  }

  private static int pairWithSum(int[] arr, int ll, int rr, int target, List<List<Integer>> store) {
    int curSum;
    int l = ll + 1;
    int r = rr - 1;
    while (l < r) {
      curSum = arr[l] + arr[r];
      if (target == curSum) {
        store.add(Arrays.asList(ll, l++, r--, rr));
        while (l < r && arr[l] == arr[l - 1])
          l++;
        while (l < r && arr[r] == arr[r + 1])
          r--;
      } else if (target > curSum) {
        l++;
      } else {
        r--;
      }
    }
    return target - curSum;
  }
}
```
