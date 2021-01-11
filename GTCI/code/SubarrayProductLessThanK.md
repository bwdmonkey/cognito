# Subarrays with Product Less than a Target (medium)

```java
import java.util.*;

class SubarrayProductLessThanK {

  public static List<List<Integer>> findSubarrays(int[] arr, int target) {
    List<List<Integer>> subarrays = new ArrayList<>();
    int i = 0;
    int curProduct = 1;
    for (int j = 0; j < arr.length; j++) {
      curProduct *= arr[j];
      while (curProduct >= target)
        curProduct /= arr[i++];
      List<Integer> tmp = new ArrayList<>();
      for (int k = j; k >= i; k--) {
        tmp.add(0, arr[k]);
        subarrays.add(new ArrayList<>(tmp));
      }
    }
    return subarrays;
  }
}
```
