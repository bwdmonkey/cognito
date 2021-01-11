# Dutch National Flag Problem (medium)

```java
class DutchFlag {
  public static void sort(int[] arr) {
    int zeroIdx = 0;
    int twoIdx = arr.length - 1;

    for (int i = 0; i <= twoIdx; i++) {
      if (arr[i] == 2) {
        swap(arr, i--, twoIdx--); // could be 0,1,2 on i, so check again
      } else if (arr[i] == 0) {
        swap(arr, i, zeroIdx++); // could be only 1 on i
      }
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }
}
```
