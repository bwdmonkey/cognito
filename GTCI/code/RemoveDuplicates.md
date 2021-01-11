# Remove Duplicates (easy)

```java
class RemoveDuplicates {

  public static int remove(int[] arr) {
    if (arr == null)
      return 0;
    if (arr.length < 2)
      return arr.length;

    int i = 1; // unique number element index

    for (int j = 1; j < arr.length; j++) {
      if (arr[i - 1] != arr[j]) {
        arr[i] = arr[j];
        i += 1;
      }
    }

    return i;
  }
}
```
