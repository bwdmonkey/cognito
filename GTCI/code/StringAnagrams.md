import java.util.*;

class StringAnagrams {
  public static List<Integer> findStringAnagrams(String str, String pattern) {
    int i = 0; // window start
    int matches = 0; // number of unique pattern character matches
    List<Integer> resultIndices = new ArrayList<Integer>(); // result
    Map<Character, Integer> patternMap = new HashMap<Character, Integer>(); // frequency map of pattern

    for (char c : pattern.toCharArray()) {
      patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
    }

    for (int j = 0; j < str.length(); j++) {
      char c = str.charAt(j);
      if (patternMap.containsKey(c)) {
        patternMap.put(c, patternMap.get(c) - 1);
        if (patternMap.get(c) == 0) {
          matches += 1;
        }
      }

      if (matches == patternMap.size()) {
        resultIndices.append(i);
      }

      if (j - i + 1 >= pattern.length()) {
        char startC = str.charAt(i);
        if (patternMap.containsKey(startC)) {
          patternMap.put(startC, patternMap.get(startC) + 1);
          if (patternMap.get(startC) == 1) {
            matches -= 1;
          }
        }
        i += 1;
      }
    }
    return resultIndices;
  }
}
