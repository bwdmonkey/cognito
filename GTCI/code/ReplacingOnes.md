# longest subarray with ones after replacement (hard)

```java
class ReplacingOnes {
  public static int findLength(int[] arr, int k) {
    int i = 0; // window start
    int maxLen = 0; // result - max length
    int zeroCount = 0; // frequency of zeros in current window

    for (int j = 0; j < arr.length; j++) {
      if (arr[j] == 0) {
        zeroCount += 1;
      }
      while (zeroCount > k && i < j) {
        if (arr[i++] == 0) {
          zeroCount -= 1;
        }
      }
      maxLen = Math.max(j - i + 1, maxLen);
    }
    return maxLen;
  }
}
```
