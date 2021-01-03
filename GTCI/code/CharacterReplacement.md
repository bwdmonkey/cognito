# longest substring with same letters after replacement (hard)

```java
class CharacterReplacement {
  public static int findLength(String str, int k) {
    int i = 0; // window start
    int maxLen = 0; // result - max length
    int repeatFrequency = 0; // most repeated character's frequency
    Map<Character, Integer> mp = new HashMap<Character, Integer>();
    for (int j = 0; j < str.length(); j++) {
      char cEnd = str.charAt(j); // char at end of window
      mp.put(cEnd, mp.getOrDefault(cEnd, 0) + 1);
      repeatFrequency = Math.max(mp.get(cEnd), repeatFrequency);
      // if or while..?
      if (j - i + 1 > k + repeatFrequency) {
        mp.put(str.charAt(i), mp.get(str.charAt(i)) - 1);
        i += 1;
      }
      maxLen = Math.max(j - i + 1, maxLen);
    }
    return maxLen;
  }
}
```
