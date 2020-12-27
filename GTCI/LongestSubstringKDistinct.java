import java.util.*;

class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
    Map<String, Integer> mp = new HashMap<String, Integer>();
    int i = 0; // window start
    int maxLen = 0; // max length
    for (int j = 0; j < str.length(); j++) {
      if (mp.containsKey(str.charAt(j))) {
        mp.put(str.charAt(j), mp.get(str.charAt(j)) + 1);
      } else {
        mp.put(str[j], 1);
      }
      while (mp.size() > k) {
        if (mp.get(str[i]) <= 1) {
          mp.remove(str[i]);
        } else {
          mp.put(str[i], mp.get(str[i]) - 1);
        }
        i += 1;
      }
      int len = 0;
      for (String key : mp.keySet()) {
        len += mp.get(key);
      }
      maxLen = Math.max(len, maxLen);
    }

    return maxLen;
  }
}
