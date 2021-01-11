# Triplets with Smaller Sum (medium)

```java
import java.util.*;

class TripletWithSmallerSum {
  public static int searchTriplets(int[] arr, int target) {
    int count = 0;
    Arrays.sort(arr);
    for (int i = 0; i < arr.length - 2; i++) {
      count += lessThanSumCount(arr, i, target - arr[i]);
    }
    return count;
  }

  private static int lessThanSumCount(int[] arr, int offset, int target) {
    int count = 0;
    int l = offset + 1;
    int r = arr.length - 1;

    while (l < r) {
      if (arr[l] + arr[r] < target) {
        count += r - l;
        l++;
      } else {
        r--;
      }
    }

    return count;
  }
}
```
