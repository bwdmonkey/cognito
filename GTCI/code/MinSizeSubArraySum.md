# 
 
```java
class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr) {
    int i = 0; // window start
    int minLen = Integer.MAX_VALUE; // result - min length to get to S

    int curSum = 0;
    for (int j = 0; j < arr.length; j++) {
      curSum += arr[j];

      while (k <= curSum) {
        minLen = Math.min(j - i + 1, minLen);
        curSum -= arr[i++];
      }
    }

    return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
  }
}
```
