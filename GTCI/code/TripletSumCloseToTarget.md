# Triplet Sum Close to Target (medium)

```java
import java.util.*;

class TripletSumCloseToTarget {
  public static int searchTriplet(int[] arr, int targetSum) {
    // if (arr == null || arr.length < 3) return "idk what"
    // smallest difference of the entire array
    int smallestDiff = Integer.MAX_VALUE;
    Arrays.sort(arr);
    for (int i = 0; i < arr.length - 2; i++) {
      int diff = closestPairWithSum(arr, i, targetSum - arr[i]); //  2
      if (Math.abs(diff) < Math.abs(smallestDiff) ||
          Math.abs(diff) == Math.abs(smallestDiff) && diff > smallestDiff) {
        smallestDiff = diff;
      }
    }
    return targetSum - smallestDiff;
  }

  private static int closestPairWithSum(int[] arr, int offset, int target) {
    int l = offset + 1;
    int r = arr.length - 1;
    int smallestDiff = Integer.MAX_VALUE; // smallest difference of one iteration

    while (l < r) {
      int sum = arr[l] + arr[r]; // 3
      if (sum == target) { // 2!=3
        return 0;
      } else if (Math.abs(target - sum) < Math.abs(smallestDiff) ||
          Math.abs(target - sum) == Math.abs(smallestDiff) && smallestDiff < target - sum) {
          // if (abs diff is smaller) or (equal but new diff results in smaller final sum)
        smallestDiff = target - sum;
      }

      if (sum < target) {
        l++;
      } else {
        r--;
      }
    }
    return smallestDiff;
  }
}
```
