# permutation in a string (hard)

```java
import java.util.*;

class StringPermutation {
  public static boolean findPermutation(String str, String pattern) {
    int i = 0; // window start
    Map<Character, Integer> mp = new HashMap<Character, Integer>();
    Map<Character, Integer> patternMp = new HashMap<Character, Integer>();
    for (int j = 0; j < pattern.length(); j++) {
      patternMp.put(pattern.charAt(j), patternMp.getOrDefault(pattern.charAt(j), 0) + 1);
    }
    for (int j = 0; j < str.length(); j++) {
      mp.put(str.charAt(j), mp.getOrDefault(str.charAt(j), 0) + 1);
      while (i < j && j - i + 1 > pattern.length()) {
        mp.put(str.charAt(i), mp.get(str.charAt(i)) - 1);
        if (mp.get(str.charAt(i)) == 0) {
          mp.remove(str.charAt(i));
        }
        i += 1;
      }
      boolean match = true;
      for (char c: patternMp.keySet()) {
        if (mp.getOrDefault(c, null) != patternMp.get(c)) {
          match = false;
        }
      }
      if (match && mp.size() == patternMp.size()) {
        return match;
      }
    }
    return false;
  }
}
```
