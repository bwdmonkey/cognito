# smallest window containing substring (hard)

```java
import java.util.*;

class MinimumWindowSubstring {
  public static String findSubstring(String str, String pattern) {
    int i = 0; // window start
    int matches = 0; // number of unique character in pattern
    int minLen = Integer.MAX_VALUE;
    Map<Character, Integer> patternMap = new HashMap<Character, Integer>();
    for (char chr : pattern.toCharArray()) {
      patternMap.put(chr, patternMap.getOrDefault(chr, 0) + 1);
    }

    for (int j = 0; j < str.length(); j++) {
      char endChr = str.charAt(j);
      if (patternMap.containsKey(endChr)) {
        patternMap.put(endChr, patternMap.get(endChr) - 1);
        if (patternMap.get(endChr) == 0)
          matches += 1;

        while (i <= j && matches == patternMap.size()) {
          char startChr = str.charAt(i);
          minLen = Math.min(j - i + 1, minLen);
          if (patternMap.containsKey(startChr)) {
            if (patternMap.get(startChr) == 0) {
              matches -= 1;
            }
            patternMap.put(startChr, patternMap.get(startChr) + 1);
          }
          i += 1;
        }
      }
    }

    return (minLen != Integer.MAX_VALUE) ? str.substring(i - 1, i - 1 + minLen) : "";
  }
}
```
