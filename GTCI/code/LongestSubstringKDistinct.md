# longest substring with k distinct characters (medium)

```java
import java.util.*;

class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
    if (str == null || str.length == 0 || str.length() < k) return 0;

    int i = 0; // window start
    int maxLen = 0; // result - max length of string with k unique characters
    Map<Character, Integer> mp = new HashMap<>();

    for (int j = 0; j < str.length(); j++) {
      char endChr = str.charAt(j);
      mp.put(endChr, mp.getOrDefault(endChr, 0) + 1);

      while (mp.size() > k) {
        char startChr = str.charAt(i);
        mp.put(startChr, mp.get(startChr) - 1);
        if (mp.get(startChr) == 0) mp.remove(startChr);
        i += 1;
      }

      maxLen = Math.max(j - i + 1, maxLen);
    }
    return maxLen;
  }
}
```
