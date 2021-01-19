# Comparing Strings containing Backspaces (medium)

Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.

Example 1:

```java
Input: str1="xy#z", str2="xzz#"
Output: true
Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
```

Example 2:

```java
Input: str1="xy#z", str2="xyz#"
Output: false
Explanation: After applying backspaces the strings become "xz" and "xy" respectively.
```

Example 3:

```java
Input: str1="xp#", str2="xyz##"
Output: true
Explanation: After applying backspaces the strings become "x" and "x" respectively.
In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.
```

Example 4:

```java
Input: str1="xywrrmp", str2="xywrrmu#p"
Output: true
Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.
```

## my solution (not space optimal)

```java
class BackspaceCompare {

  public static boolean compare(String str1, String str2) {
    String res1 = applyBackspaces(str1);
    String res2 = applyBackspaces(str2);
    return res1.equals(res2);
  }

  private static String applyBackspaces(String str) {
    String res = "";
    int backspaces = 0;
    for (int i = str.length() - 1; i >= 0; i--) {
      if (str.charAt(i) == '#') {
        backspaces++;
      } else {
        if (backspaces > 0) {
          backspaces--;
        } else {
          res = str.charAt(i) + res;
        }
      }
    }
    return res;
  }
}
```
