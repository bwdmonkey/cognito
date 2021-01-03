import java.util.*;

class NoRepeatSubstring {
  public static int findLength(String str) {
    if (str == null) return 0;

    int i = 0; // window start
    int maxLen = 0; // result - max unique character string
    Map<Character, Integer> mp = new HashMap<>();

    for (int j = 0; j < str.length(); j++) {
      char endChr = str.charAt(j);
      if (mp.containsKey(endChr))
        i = Math.max(i, mp.get(endChr) + 1);
      mp.put(endChr, j);
      maxLen = Math.max(j - i + 1, maxLen);
    }

    return maxLen;
  }
}
