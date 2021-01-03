# 
 
```java
import java.util.*;

class WordConcatenation {
  public static List<Integer> findWordConcatenation(String str, String[] words) {
    List<Integer> resultIndices = new ArrayList<Integer>();
    if (str == "" || words.length == 0) {
      return resultIndices;
    }
    int i = 0; // window start
    int matches = 0; // word matches
    int k = words[0].length(); // word length
    int maxLength = k * words.length; // full length
    Map<String, Integer> wordsMap = new HashMap<String, Integer>();
    for (String word : words) {
      wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
    }

    for (int j = 0; j < str.length(); j += k) {
      String endStr = str.substring(j, j + k);
      if (wordsMap.containsKey(endStr)) {
        wordsMap.put(endStr, wordsMap.get(endStr) - 1);
        if (wordsMap.get(endStr) == 0) {
          matches += 1;
        }
      }
      if (j - i + 1 > maxLength) {
        String startStr = str.substring(i, i + k);
        if (wordsMap.containsKey(startStr)) {
          if (wordsMap.get(startStr) == 0) {
            matches -= 1;
          }
          wordsMap.put(startStr, wordsMap.get(startStr) + 1);
        }
        i += k;
      }
      if (matches == wordsMap.length) {
        resultIndices.add(i);
      }
    }

    // TODO: Write your code here
    return resultIndices;
  }
}
```
