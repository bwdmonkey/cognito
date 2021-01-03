# 
 
```java
import java.util.*;

class MaxFruitCountOf2Types {
  public static int findLength(char[] arr) {
    int i = 0; // window start
    int maxLen = 0; // result - max length of consecutive trees of two types
    Map<Character, Integer> mp = new HashMap<>();
    char oldestChr = arr[0];
    mp.put(oldestChr, 0);

    for (int j = 0; j < arr.length; j++) {
      if (arr[j] != oldestChr) {
        mp.put(arr[j], j);
        i = Math.max(i, mp.get(oldestChr)); // not sure if max guard is needed
      }
      oldestChr = arr[j];
      maxLen = Math.max(j - i + 1, maxLen);
    }

    return maxLen;
  }
}
```
