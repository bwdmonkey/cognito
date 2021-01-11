# Triplet Sum to Zero (medium)

```java
import java.util.*;

class TripletSumToZero {
  public static List<List<Integer>> searchTriplets(int[] arr) {
    List<List<Integer>> triplets = new ArrayList<>();
    if (arr == null)
      return triplets;

    Arrays.sort(arr);
    for (int i = 0; i < arr.length - 2; i++) {
      findAndAddPairsWithSum(arr, i, triplets);
    }
    return triplets;
  }

  private static void findAndAddPairsWithSum(int[] arr, int targetIndex, List<List<Integer>> resultStore) {
    int l = targetIndex + 1;
    int r = arr.length - 1;
    int target = arr[targetIndex];
    while (l < r) {
      int sum = target + arr[l] + arr[r];
      // if the triplets add upto zero
      if (sum == 0) {
        resultStore.add(Arrays.asList(target, arr[l], arr[r]));
        l++; r--;
        while (l < r && arr[l - 1] == arr[l])
          l++;
        while (l < r && arr[r + 1] == arr[r])
          r--;
      } else if (sum < 0) {
        l++;
      } else {
        r--;
      }
    }
  }
}
```
