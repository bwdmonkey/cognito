# Squaring a Sorted Array (easy)

```java
class SortedArraySquares {

  public static int[] makeSquares(int[] arr) {
    if (arr == null)
      return arr;
    int[] squares = new int[arr.length];
    int l = 0; // start index
    int r = arr.length - 1; // end index
    int i = arr.length - 1; // copy index

    while (l < r) {
      if (Math.abs(arr[l]) < Math.abs(arr[r])) {
        squares[i--] = arr[r] * arr[r--];
      } else {
        squares[i--] = arr[l] * arr[l++];
      }
    }

    return squares;
  }
}
```
