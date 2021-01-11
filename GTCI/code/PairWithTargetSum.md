# Pair with Target Sum (easy)

```java
class PairWithTargetSum {

  public static int[] search(int[] arr, int targetSum) {
    if (arr == null)
      return new int[] { -1, -1 };

    int i = 0;
    int j = arr.length - 1;

    while (i < j) {
      int curSum = arr[i] + arr[j];
      if (curSum == targetSum) {
        return new int[] { i, j };
      } else if (curSum > targetSum) {
        j -= 1;
      } else if (curSum < targetSum) {
        i += 1;
      }
    }

    return new int[] { -1, -1 };
  }
}
```
